package costa.matheus.burgerapp.products.ui.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import costa.matheus.burgerapp.products.ui.UiObject
import costa.matheus.burgerapp.products.ui.components.ComboSectionItem
import costa.matheus.burgerapp.products.ui.components.DayOfferItem
import costa.matheus.burgerapp.products.ui.components.ProductItem
import costa.matheus.burgerapp.products.ui.components.TitleItem
import costa.matheus.domain.entities.Allergen
import costa.matheus.domain.entities.Product

@Composable
fun ProductsPage(
    allProducts: List<UiObject>,
    onEvent: (ProductsPageEvent) -> Unit
) {
    LazyColumn(
        contentPadding = PaddingValues(vertical = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier
            .background(color = Color.White)
    ) {
        items(allProducts) { uiObject ->
            when(uiObject) {
                is UiObject.Title -> TitleItem(title = uiObject)

                is UiObject.Highlighted -> {
                    ComboSectionItem(
                        products = uiObject.products,
                        colors = uiObject.colors,
                        onEvent = onEvent
                    )
                }

                is UiObject.Offer -> {
                    ProductItem(
                        product = uiObject.product,
                        onEvent = onEvent
                    )
                    Divider(
                        color = Color.LightGray,
                        thickness = 1.dp,
                        modifier = Modifier.padding(
                            start = 16.dp,
                            end = 16.dp,
                            top = 16.dp
                        )
                    )
                }

                is UiObject.DayOffer -> DayOfferItem(dayOfferEntity = uiObject.entity)
            }
        }
    }
}

@Composable
@Preview
fun ProductListPreview() {
    ProductsPage(
        listOf(
            UiObject.Title("Titulo"),
            UiObject.Offer(fakeProduct),
            UiObject.Offer(fakeProduct)
        ),
        {}
    )
}

val fakeProduct = Product(
    name = "Quarterão com Queijo",
    image = "",
    description = "Três hambúrgueres (100% carne bovina), queijo sabor cheddar, cebola, picles, ketchup, mostarda e pão com gergelim.",
    price = "R$32.00",
    promotionalPrice = null,
    calories = "1000kcal",
    totalFat = "100g",
    carbohydrates = "100g",
    proteins = "100g",
    allergen = Allergen(
        egg = true,
        milk = true,
        gluten = true,
        soy = true
    )

)