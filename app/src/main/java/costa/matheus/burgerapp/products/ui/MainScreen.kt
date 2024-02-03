package costa.matheus.burgerapp.products.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import costa.matheus.burgerapp.ViewState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    state: ViewState<List<UiObject>>,
    onEvent: (ProductsPageEvent) -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Burger") })
        }
    ) {
        Surface(
            modifier = Modifier.
                padding(it)
        ) {
            when(state) {
                is ViewState.Loading -> {
                    Column {
                        Text(text = "Carregando...")
                    }
                }

                is ViewState.Success -> {
                    ProductsPage(
                        allProducts = state.data ?: listOf(),
                        onEvent = onEvent
                    )
                }

                is ViewState.Error -> {
                    Column {
                        Text(text = "Erro!")
                    }
                }
            }
        }
    }
}

@Composable
@Preview
fun MainScreenPreview() {
    MainScreen(
        state = ViewState.Success(null),
        onEvent = {}
    )
}