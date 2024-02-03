package costa.matheus.burgerapp.products.ui

import androidx.compose.ui.graphics.Color
import costa.matheus.domain.entities.DayOfferEntity
import costa.matheus.domain.entities.Product

sealed class UiObject {

    data class Title(
        val title: String
    ): UiObject()

    data class Offer(
        val product: Product
    ): UiObject()

    data class Highlighted(
        val products: List<Product>,
        val colors: List<Color>
    ): UiObject()

    data class DayOffer(
        val entity: DayOfferEntity
    ): UiObject()

}