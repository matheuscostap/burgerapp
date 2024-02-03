package costa.matheus.burgerapp.details.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
@Preview
fun DetailsTopAppBarPreview() {
    DetailsTopAppBar({})
}

@Composable
@Preview
fun DetailsScreenPreview() {
    DetailsScreen(fakeProduct, {})
}