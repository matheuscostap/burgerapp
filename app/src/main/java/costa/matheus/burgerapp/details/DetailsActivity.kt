package costa.matheus.burgerapp.details

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import costa.matheus.burgerapp.details.ui.DetailsScreen
import costa.matheus.burgerapp.details.ui.DetailsScreenEvent
import costa.matheus.burgerapp.details.ui.OnBackPress
import costa.matheus.domain.entities.Product

class DetailsActivity : ComponentActivity() {

    companion object {
        const val PRODUCT_EXTRA = "product"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val product = intent.getSerializableExtra(PRODUCT_EXTRA) as Product

        setContent {
            DetailsScreen(
                product = product,
                onEvent = { event ->
                    handleEvent(event)
                }
            )
        }
    }

    private fun handleEvent(event: DetailsScreenEvent) {
        when(event) {
            is OnBackPress -> {
                super.onBackPressed()
            }
        }
    }
}