package costa.matheus.burgerapp.products.ui.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ErrorPage(
    onEvent: (ProductsPageEvent) -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize()
    ) {
        Text(
            text = "Ocorreu um erro...",
            fontSize = 20.sp
        )

        OutlinedButton(
            onClick = { onEvent(OnTryAgainClick) },
            modifier = Modifier
                .padding(top = 24.dp)
        ) {
            Text(text = "Tentar novamente")
        }
    }
}

@Composable
@Preview
fun ErrorPagePreview() {
    ErrorPage({})
}