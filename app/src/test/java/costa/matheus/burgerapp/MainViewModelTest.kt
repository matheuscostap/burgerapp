package costa.matheus.burgerapp

import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.doThrow
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import costa.matheus.burgerapp.products.MainViewModel
import costa.matheus.burgerapp.products.ui.UiObject
import costa.matheus.domain.entities.Allergen
import costa.matheus.domain.entities.DayOfferEntity
import costa.matheus.domain.entities.Product
import costa.matheus.domain.entities.Section
import costa.matheus.domain.entities.SectionType
import costa.matheus.domain.usecases.GetAllProductsUseCase
import costa.matheus.domain.usecases.GetDayOfferUseCase
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runCurrent
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test


@OptIn(ExperimentalCoroutinesApi::class)
class MainViewModelTest {

    @get:Rule
    val rule = MainCoroutineRule()

    private lateinit var viewModel: MainViewModel

    private val getAllProductsUseCase: GetAllProductsUseCase = mock()
    private val getDayOfferUseCase: GetDayOfferUseCase = mock()

    @Before
    fun setup() {
        viewModel = MainViewModel(
            getAllProductsUseCase,
            getDayOfferUseCase
        )
    }

    @Test
    fun `viewmodel initial state`() {
        // Act
        val currentState = viewModel.state.value

        // Assert
        Assert.assertTrue(currentState is ViewState.Loading)
    }

    @Test
    fun `viewmodel success state test`() = rule.runTest {
        // Arrange
        val productsApiReturn = getStubProductsApiReturn()
        val dayOfferApiReturn = DayOfferEntity("")

        whenever(getAllProductsUseCase.call()) doReturn CompletableDeferred(productsApiReturn)
        whenever(getDayOfferUseCase.call()) doReturn CompletableDeferred(dayOfferApiReturn)

        // Act
        viewModel.getAllProducts()
        runCurrent()
        val currentState = viewModel.state.value

        // Assert
        Assert.assertTrue(currentState is ViewState.Success && currentState.data != null)
    }

    @Test
    fun `viewmodel error state test`() = rule.runTest {
        // Arrange
        val dayOfferApiReturn = DayOfferEntity("")

        whenever(getAllProductsUseCase.call()) doThrow RuntimeException()
        whenever(getDayOfferUseCase.call()) doReturn CompletableDeferred(dayOfferApiReturn)

        // Act
        viewModel.getAllProducts()
        runCurrent()
        val currentState = viewModel.state.value

        // Assert
        Assert.assertTrue(currentState is ViewState.Error)
    }

    @Test
    fun `viewmodel loading state to success state test`() = rule.runTest {
        // Arrange
        val statesHistory = mutableListOf<ViewState<List<UiObject>>>()

        val job = launch(UnconfinedTestDispatcher()) {
            viewModel.state.toList(statesHistory)
        }

        val productsApiReturn = getStubProductsApiReturn()
        val dayOfferApiReturn = DayOfferEntity("")

        whenever(getAllProductsUseCase.call()) doReturn CompletableDeferred(productsApiReturn)
        whenever(getDayOfferUseCase.call()) doReturn CompletableDeferred(dayOfferApiReturn)

        // Act
        viewModel.getAllProducts()
        runCurrent()

        // Assert
        Assert.assertTrue(statesHistory.isNotEmpty())

        statesHistory.forEachIndexed { index, viewState ->
            when(index) {
                0 -> {
                    Assert.assertTrue(viewState is ViewState.Loading)
                }

                1 -> {
                    Assert.assertTrue(viewState is ViewState.Success && viewState.data != null)
                }
            }
        }

        job.cancel()
    }

    @Test
    fun `viewmodel loading state to error state test`() = rule.runTest {
        // Arrange
        val statesHistory = mutableListOf<ViewState<List<UiObject>>>()

        val job = launch(UnconfinedTestDispatcher()) {
            viewModel.state.toList(statesHistory)
        }

        val dayOfferApiReturn = DayOfferEntity("")

        whenever(getAllProductsUseCase.call()) doThrow RuntimeException()
        whenever(getDayOfferUseCase.call()) doReturn CompletableDeferred(dayOfferApiReturn)

        // Act
        viewModel.getAllProducts()
        runCurrent()

        // Assert
        Assert.assertTrue(statesHistory.isNotEmpty())

        statesHistory.forEachIndexed { index, viewState ->
            when(index) {
                0 -> {
                    Assert.assertTrue(viewState is ViewState.Loading)
                }

                1 -> {
                    Assert.assertTrue(viewState is ViewState.Error)
                }
            }
        }

        job.cancel()
    }

    private fun getStubProductsApiReturn(): List<Section> {
        return listOf(
            Section(
                title = "title",
                products = listOf(Product(
                    name = "name",
                    description = "description",
                    image = "image",
                    price = "price",
                    promotionalPrice = "promotional_price",
                    calories = "calories",
                    totalFat = "total_fat",
                    carbohydrates = "carbohydrates",
                    proteins = "proteins",
                    allergen = Allergen(
                        egg = true,
                        milk = true,
                        gluten = true,
                        soy = true
                    )
                )),
                sectionType = SectionType.NORMAL
            )
        )
    }
}