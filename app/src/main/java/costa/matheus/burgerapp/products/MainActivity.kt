package costa.matheus.burgerapp.products

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import costa.matheus.burgerapp.details.DetailsActivity
import costa.matheus.burgerapp.products.ui.MainScreen
import costa.matheus.burgerapp.products.ui.OnProductClick
import costa.matheus.burgerapp.products.ui.ProductsPageEvent
import costa.matheus.burgerapp.ui.theme.BurgerAppTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val viewState = viewModel.allProductsState.collectAsState().value
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
        }
    }

}

/*BurgerAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }*/