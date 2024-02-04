package costa.matheus.burgerapp.products.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import costa.matheus.burgerapp.ViewState
import costa.matheus.burgerapp.ui.font.Jost


@Composable
fun MainScreen(
    state: ViewState<List<UiObject>>,
    onEvent: (ProductsPageEvent) -> Unit
) {
    Scaffold(
        topBar = { BurgerAppBar() }
    ) {
        Surface(
            modifier = Modifier.
                padding(it)
        ) {
            when(state) {
                is ViewState.Loading -> {
                    LoadingPage()
                }

                is ViewState.Success -> {
                    ProductsPage(
                        allProducts = state.data ?: listOf(),
                        onEvent = onEvent
                    )
                }

                is ViewState.Error -> {
                    ErrorPage(onEvent = onEvent)
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BurgerAppBar() {
    CenterAlignedTopAppBar(
        title = {
            Text(
                fontFamily = Jost,
                text = "\uD83C\uDF54 Burger App",
                textAlign = TextAlign.Center,
                fontSize = 20.sp,
                color = Color(0xFF982121),
                fontWeight = FontWeight.Bold
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.White
        )
    )
}

@Composable
@Preview
fun BurgerAppBarPreview() {
    BurgerAppBar()
}

@Composable
@Preview
fun MainScreenPreview() {
    MainScreen(
        state = ViewState.Success(null),
        onEvent = {}
    )
}