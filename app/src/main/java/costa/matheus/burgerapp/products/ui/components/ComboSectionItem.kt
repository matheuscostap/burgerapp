package costa.matheus.burgerapp.products.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import costa.matheus.burgerapp.products.ui.pages.ProductsPageEvent
import costa.matheus.burgerapp.products.ui.pages.fakeProduct
import costa.matheus.domain.entities.Product

@Composable
fun ComboSectionItem(
    products: List<Product>,
    colors: List<Color>,
    onEvent: (ProductsPageEvent) -> Unit
) {
    LazyRow(
        contentPadding = PaddingValues(vertical = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier
            .background(color = Color.White)
            .fillMaxWidth()

    ) {
        item {
            Spacer(modifier = Modifier.width(0.dp))
        }

        itemsIndexed(products) { index, product ->
            ComboProductItem(
                product = product,
                color = colors[index],
                onEvent = onEvent
            )
        }

        item {
            Spacer(modifier = Modifier.width(0.dp))
        }
    }
}

@Composable
@Preview
fun ComboSectionItemPreview() {
    ComboSectionItem(
        listOf(fakeProduct, fakeProduct),
        listOf(Color(0xffE95555), Color(0xffE95555)),
        {}
    )
}