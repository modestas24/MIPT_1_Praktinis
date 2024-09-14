package com.example.mipt_1_praktinis

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.mipt_1_praktinis.ui.theme.CustomTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CustomTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CustomBanner(innerPadding)
                }
            }
        }
    }
}

@Composable
fun CustomBanner(
    innerPadding: PaddingValues
) {
    Column(
        modifier = Modifier.padding(innerPadding)
    ) {

    }
}

@Composable
fun CustomButton(
    text: String,
    imageVector: ImageVector,
    onClick: () -> Unit,
    spacerWidth: Dp = 8.dp
) {
    OutlinedButton(onClick = onClick) {
        Icon(imageVector = imageVector, contentDescription = null)
        Spacer(modifier = Modifier.width(spacerWidth))
        Text(text)
    }
}

@Preview(showBackground = true)
@Composable
fun CustomBannerPreview() {
    CustomTheme {
        CustomBanner(PaddingValues())
    }
}