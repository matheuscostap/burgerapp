package costa.matheus.burgerapp.products.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import costa.matheus.burgerapp.R
import costa.matheus.burgerapp.products.ui.pages.OnProductClick
import costa.matheus.burgerapp.products.ui.pages.ProductsPageEvent
import costa.matheus.burgerapp.products.ui.pages.fakeProduct
import costa.matheus.burgerapp.ui.font.Jost
import costa.matheus.domain.entities.Product

@Composable
fun ProductItem(
    product: Product,
    onEvent: (ProductsPageEvent) -> Unit
) {
    Surface(
        onClick = { onEvent(OnProductClick(product)) } ,
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.White)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.White)
                .padding(horizontal = 16.dp)
        ) {
            AsyncImage(
                model = product.image,
                placeholder = painterResource(id = R.drawable.burger_placeholder),
                error = painterResource(id = R.drawable.burger_placeholder),
                contentDescription = "Burger photo",
                modifier = Modifier.
                size(80.dp)
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Text(
                        fontFamily = Jost,
                        fontSize = 16.sp,
                        color = Color.Black,
                        text = product.name,
                        modifier = Modifier
                            .weight(3f)
                    )
                    Text(
                        fontFamily = Jost,
                        fontSize = 16.sp,
                        color = Color.Black,
                        text = product.price,
                        textAlign = TextAlign.End,
                        modifier = Modifier
                            .weight(1.5f)
                    )
                }

                Text(
                    fontFamily = Jost,
                    text = product.description,
                    fontSize = 14.sp,
                    color = Color.Gray,
                    modifier = Modifier.
                    padding(top = 8.dp)
                )

            }
        }
    }
}

@Composable
@Preview
fun ProductItemPreview() {
    ProductItem(
        product = fakeProduct,
        onEvent = {}
    )
}