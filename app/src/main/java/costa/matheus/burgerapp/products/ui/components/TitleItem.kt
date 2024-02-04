package costa.matheus.burgerapp.products.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import costa.matheus.burgerapp.products.ui.UiObject
import costa.matheus.burgerapp.ui.font.Jost

@Composable
fun TitleItem(title: UiObject.Title) {
    Surface(
        modifier = Modifier
            .background(color = Color.White)
            .fillMaxWidth()
    ) {
        Text(
            fontFamily = Jost,
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
@Preview
fun TitleItemPreview() {
    TitleItem(UiObject.Title("Titulo"))
}