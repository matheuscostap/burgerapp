package costa.matheus.burgerapp.products.ui

import costa.matheus.domain.entities.Product

abstract class ProductsPageEvent

data class OnProductClick(
    val product: Product
): ProductsPageEvent()