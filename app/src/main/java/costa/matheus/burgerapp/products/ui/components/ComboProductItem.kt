package costa.matheus.burgerapp.products.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
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
fun ComboProductItem(
    product: Product,
    color: Color,
    onEvent: (ProductsPageEvent) -> Unit
) {
    Surface(
        onClick = { onEvent(OnProductClick(product)) },
        shadowElevation = 4.dp,
        shape = RoundedCornerShape(4.dp),
        modifier = Modifier
            .height(240.dp)
            .width(180.dp)
    ) {
        Column(
            modifier = Modifier
                .background(color = color)
        ) {
            Column(
                modifier = Modifier
                    .weight(5f)
            ) {
                Text(
                    fontFamily = Jost,
                    text = product.name,
                    fontSize = 16.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                )

                Text(
                    fontFamily = Jost,
                    text = product.description,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 2,
                    fontSize = 14.sp,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 8.dp, end = 8.dp)
                )

                AsyncImage(
                    model = product.image,
                    placeholder = painterResource(id = R.drawable.burger_placeholder),
                    error = painterResource(id = R.drawable.burger_placeholder),
                    contentScale = ContentScale.Fit,
                    contentDescription = "",
                    modifier = Modifier
                        .size(130.dp)
                        .align(Alignment.CenterHorizontally)
                )
            }

            Text(
                fontFamily = Jost,
                text = product.price,
                fontSize = 16.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(2.dp)
                    .weight(1f)
            )
        }
    }
}

@Composable
@Preview
fun ComboProductItemPreview() {
    ComboProductItem(fakeProduct, Color(0xffE95555), {})
}