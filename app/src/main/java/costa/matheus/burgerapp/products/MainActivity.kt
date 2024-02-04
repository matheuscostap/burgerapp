package costa.matheus.burgerapp.products

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import costa.matheus.burgerapp.details.DetailsActivity
import costa.matheus.burgerapp.products.ui.MainScreen
import costa.matheus.burgerapp.products.ui.pages.OnProductClick
import costa.matheus.burgerapp.products.ui.pages.OnTryAgainClick
import costa.matheus.burgerapp.products.ui.pages.ProductsPageEvent
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val viewState = viewModel.state.collectAsState().value
            MainScreen(
                state = viewState,
                onEvent = { event ->
                    handleEvent(event)
                }
            )
        }

        viewModel.getAllProducts()
    }

    private fun handleEvent(event: ProductsPageEvent) {
        when(event) {
            is OnProductClick -> {
                val intent = Intent(this, DetailsActivity::class.java)
                intent.putExtra(DetailsActivity.PRODUCT_EXTRA, event.product)
                startActivity(intent)
            }

            is OnTryAgainClick -> {
                viewModel.getAllProducts()
            }
        }
    }

}