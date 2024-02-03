package costa.matheus.burgerapp.products

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import costa.matheus.burgerapp.ViewState
import costa.matheus.burgerapp.products.ui.UiObject
import costa.matheus.burgerapp.products.ui.UiObjectMapper
import costa.matheus.domain.usecases.GetAllProductsUseCase
import costa.matheus.domain.usecases.GetDayOfferUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getAllProductsUseCase: GetAllProductsUseCase,
    private val getDayOfferUseCase: GetDayOfferUseCase
): ViewModel() {

    private val _state = MutableStateFlow<ViewState<List<UiObject>>>(ViewState.Loading)
    val state: StateFlow<ViewState<List<UiObject>>> get() = _state


    fun getAllProducts() {
        viewModelScope.launch {
            _state.value = ViewState.Loading
            try {
                val mapper = UiObjectMapper()

                val dayOffer = getDayOfferUseCase.call().await()
                val sections = getAllProductsUseCase.call().await()

                val page = mapper.mapSections(sections).toMutableList()
                page.add(0, mapper.mapDayOffer(dayOffer))

                _state.value = ViewState.Success(page)
            } catch (t: Throwable) {
                _state.value = ViewState.Error(t, false)
            }
        }
    }

}