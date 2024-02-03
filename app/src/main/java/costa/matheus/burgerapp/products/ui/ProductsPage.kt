package costa.matheus.burgerapp.products.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
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
import costa.matheus.domain.entities.DayOfferEntity
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
                placeholder = painterResource(id = R.drawable.ic_launcher_foreground),
                fallback = painterResource(id = R.drawable.ic_launcher_foreground),
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
                        fontSize = 16.sp,
                        color = Color.Black,
                        text = product.name,
                        modifier = Modifier
                            .weight(3f)
                    )
                    Text(
                        fontSize = 16.sp,
                        color = Color.Black,
                        text = product.price,
                        textAlign = TextAlign.End,
                        modifier = Modifier
                            .weight(1f)
                    )
                }

                Text(
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
fun TitleItem(title: UiObject.Title) {
    Surface(
        modifier = Modifier
            .background(color = Color.White)
            .fillMaxWidth()
    ) {
        Text(
            text = title.title,
            fontSize = 20.sp,
            color = Color(0XFFFF611d),
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .background(color = Color.White)
                .padding(
                    bottom = 8.dp,
                    start = 16.dp,
                    end = 16.dp
                )
        )
    }
}

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
                    placeholder = painterResource(id = R.drawable.ic_launcher_foreground),
                    fallback = painterResource(id = R.drawable.ic_launcher_foreground),
                    contentScale = ContentScale.Fit,
                    contentDescription = "",
                    modifier = Modifier
                        .size(130.dp)
                        .align(Alignment.CenterHorizontally)
                )
            }

            Text(
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
fun DayOfferItem(
    dayOfferEntity: DayOfferEntity
) {
    Surface(
        shadowElevation = 4.dp,
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .height(220.dp)
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        AsyncImage(
            model = dayOfferEntity.image,
            placeholder = painterResource(id = R.drawable.ic_launcher_foreground),
            fallback = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .fillMaxSize()
        )
    }
}

@Composable
@Preview
fun DayOfferItemPreview() {
    DayOfferItem(DayOfferEntity(""))
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

@Composable
@Preview
fun ComboProductItemPreview() {
    ComboProductItem(fakeProduct, Color(0xffE95555), {})
}

@Composable
@Preview
fun TitleItemPreview() {
    TitleItem(UiObject.Title("Titulo"))
}

@Composable
@Preview
fun ProductItemPreview() {
    ProductItem(
        product = fakeProduct,
        onEvent = {}
    )
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
    name = "BigMac",
    image = "",
    description = "Três hambúrgueres (100% carne bovina), queijo sabor cheddar, cebola, picles, ketchup, mostarda e pão com gergelim.",
    price = "R$32.00",
    promotional_price = null
)