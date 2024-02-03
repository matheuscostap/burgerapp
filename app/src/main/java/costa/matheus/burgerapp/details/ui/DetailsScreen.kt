package costa.matheus.burgerapp.details.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
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
import costa.matheus.burgerapp.products.ui.fakeProduct
import costa.matheus.domain.entities.Product
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@Composable
fun DetailsScreen(
    product: Product,
    onEvent: (DetailsScreenEvent) -> Unit
) {
    Scaffold(
        topBar = { DetailsTopAppBar(onEvent = onEvent) }
    ) {
        Column(
            modifier = Modifier
                .background(Color(0XFFFFB08F))
                .padding(it)
                .fillMaxSize()
        ) {
            Row(
                modifier = Modifier
                    .weight(1f)
            ) {
                AsyncImage(
                    model = product.image,
                    placeholder = painterResource(id = R.drawable.ic_launcher_foreground),
                    fallback = painterResource(id = R.drawable.ic_launcher_foreground),
                    contentDescription = "Foto do hamburguer",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .fillMaxSize()
                )
            }

            Row(
                modifier = Modifier
                    .weight(2f)
            ) {
                Surface(
                    shape = RoundedCornerShape(25.dp, 25.dp, 0.dp, 0.dp),
                    modifier = Modifier
                        .background(Color(0XFFFFB08F))
                        .fillMaxSize()
                ) {
                    Column(
                        modifier = Modifier
                            .background(Color.White)
                            .padding(24.dp)
                            .fillMaxSize()
                    ) {
                        Text(
                            text = product.name,
                            fontWeight = FontWeight.Bold,
                            fontSize = 22.sp,
                            color = Color.Black,
                            modifier = Modifier
                                .fillMaxWidth()
                        )

                        Text(
                            text = product.description,
                            overflow = TextOverflow.Ellipsis,
                            fontSize = 16.sp,
                            color = Color.Gray,
                            modifier = Modifier
                                .padding(top = 8.dp)
                        )

                        NutritionFactsBlock(product = product)

                        AllergenBlock(product = product)

                        Text(
                            text = product.price,
                            fontSize = 20.sp,
                            color = Color.Black,
                            textAlign = TextAlign.End,
                            modifier = Modifier
                                .fillMaxWidth()
                        )
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsTopAppBar(
    onEvent: (DetailsScreenEvent) -> Unit
) {
    TopAppBar(
        title = {},
        navigationIcon = {
            IconButton(
                onClick = { onEvent(OnBackPress) }
            ) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Voltar"
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color(0XFFFFB08F)
        )
    )
}

@Composable
fun NutritionFactsBlock(product: Product) {
    Row (
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .background(Color.White)
            .fillMaxWidth()
            .padding(top = 16.dp)
    ){
        NutritionFactsItem(
            name = "Calorias",
            value = product.calories
        )
        NutritionFactsItem(
            name = "Gordura Total",
            value = product.totalFat
        )
        NutritionFactsItem(
            name = "Carboidratos",
            value = product.carbohydrates
        )
        NutritionFactsItem(
            name = "Proteínas",
            value = product.proteins
        )
    }
}

@Composable
@Preview
fun NutritionFactsBlockPreview() {
    NutritionFactsBlock(fakeProduct)
}

@Composable
fun NutritionFactsItem(
    name: String,
    value: String
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .background(Color.White)
    ) {
        Text(
            text = value,
            fontSize = 18.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = name,
            fontSize = 16.sp,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
@Preview
fun NutritionFactsItemPreview() {
    NutritionFactsItem(
        name = "Calorias",
        value = "1000kcal"
    )
}

@Composable
fun AllergenBlock(product: Product) {
    Row (
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .background(Color.White)
            .fillMaxWidth()
            .padding(top = 16.dp)
    ){
        if (product.allergen.egg) {
            AllergenItem(
                name = "Ovo",
                imageDrawable = R.drawable.egg
            )
        }

        if (product.allergen.gluten) {
            AllergenItem(
                name = "Gluten",
                imageDrawable = R.drawable.gluten
            )
        }

        if (product.allergen.milk) {
            AllergenItem(
                name = "Leite",
                imageDrawable = R.drawable.milk
            )
        }

        if (product.allergen.soy) {
            AllergenItem(
                name = "Soja",
                imageDrawable = R.drawable.soy
            )
        }
    }
}

@Composable
@Preview
fun AllergenBlockPreview() {
    AllergenBlock(fakeProduct)
}

@Composable
fun AllergenItem(
    name: String,
    imageDrawable: Int
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .background(Color.White)
    ) {
        Image(
            painter = painterResource(id = imageDrawable),
            contentDescription = name
        )

        Text(
            text = name,
            fontSize = 16.sp,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
@Preview
fun AllergenItemPreview() {
    AllergenItem(
        name = "Ovo",
        imageDrawable = R.drawable.egg
    )
}

@Composable
@Preview
fun DetailsTopAppBarPreview() {
    DetailsTopAppBar({})
}

@Composable
@Preview
fun DetailsScreenPreview() {
    DetailsScreen(fakeProduct, {})
}