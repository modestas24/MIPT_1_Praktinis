package com.example.mipt_1_praktinis

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Refresh
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.mipt_1_praktinis.ui.theme.CustomTheme
import kotlin.random.Random

val RANDOM_WORDS = arrayOf(
    "apple", "banana", "cherry", "date", "elderberry", "fig", "grape", "honeydew",
    "kiwi", "lemon", "mango", "nectarine", "orange", "papaya", "quince", "raspberry",
    "strawberry", "tangerine", "ugli", "vanilla", "watermelon", "xigua", "yam", "zucchini"
)

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
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(innerPadding)
                .padding(horizontal = 32.dp)
                .widthIn(max = 350.dp)
        ) {
            val size = RANDOM_WORDS.size
            var index by remember { mutableStateOf(Random.nextInt(0, size)) }

            CustomText(RANDOM_WORDS[index])
            Spacer(modifier = Modifier.height(32.dp))
            CustomButton(
                text = "Change text",
                imageVector = Icons.Rounded.Refresh,
                onClick = { index = Random.nextInt(0, size) }
            )
        }
    }
}

@Composable
fun CustomText(
    text: String,
) {
    Text(
        text = text,
        textAlign = TextAlign.Center,
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.primaryContainer)
            .padding(horizontal = 16.dp, vertical = 16.dp)
            .fillMaxWidth()

    )
}

@Composable
fun CustomButton(
    text: String,
    imageVector: ImageVector,
    onClick: () -> Unit,
    spacerWidth: Dp = 8.dp
) {
    OutlinedButton(
        onClick = onClick,
        contentPadding = PaddingValues(
            horizontal = 24.dp,
            vertical = 16.dp
        ),
    ) {
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

