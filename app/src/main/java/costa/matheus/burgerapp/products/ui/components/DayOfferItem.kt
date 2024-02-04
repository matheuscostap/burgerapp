package costa.matheus.burgerapp.products.ui.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import costa.matheus.burgerapp.R
import costa.matheus.domain.entities.DayOfferEntity

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
            placeholder = painterResource(id = R.drawable.burger_placeholder),
            error = painterResource(id = R.drawable.burger_placeholder),
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
