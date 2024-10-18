package com.example.projetcarteville

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.projetcarteville.ui.theme.ProjetCarteVilleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProjetCarteVilleTheme {
                CarteVisite(

                )
            }
        }
    }
}

@Composable
fun CarteVisite( modifier: Modifier = Modifier) {
    var option by remember { mutableIntStateOf(1) }
    val titre = stringResource(R.string.titre)
   
    val image = when (option) {
        1 -> R.drawable.taounate
        2 -> R.drawable.environnement
        3 -> R.drawable.tourisme
        4 -> R.drawable.huileolive
        else -> R.drawable.taounate
    }

    val subtitle = when (option) {
        1 -> R.string.sousTitre1
        2 -> R.string.sousTitre2
        3 -> R.string.sousTitre3
        4 -> R.string.sousTitre4
        else -> R.string.sousTitre1
    }

    val descriptionText = when (option) {
        1 -> R.string.text1
        2 -> R.string.text2
        3 -> R.string.text3
        4 -> R.string.text4
        else -> R.string.text1
    }

    Box {

        val backgroundImg = painterResource(R.drawable.pexels_eberhardgross_2086351)
        Image(
            painter = backgroundImg,
            contentDescription = null,
            alpha = 0.5f,
            contentScale = ContentScale.Crop,
            modifier = modifier.fillMaxSize()
        )

        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Text(
                text = titre,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .border(2.dp, Color(0xFF5D7052))
                    .padding(16.dp)
                    .shadow(4.dp, shape = RoundedCornerShape(8.dp))
            )


            Button(onClick = {

                option = if (option in 1.. 4) option ++ else 1
            }) {
                Image(
                    painter = painterResource(image),
                    contentDescription = null,
                    modifier = modifier.size(100.dp) // Ajuste la taille de l'image si nécessaire
                )
            }


            Text(
                text = stringResource(subtitle),
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(vertical = 8.dp)
            )


            Text(
                text = stringResource(descriptionText),
                fontSize = 14.sp,
                modifier = Modifier.padding(start = 20.dp, end = 20.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CarteVisitePreview() {
    ProjetCarteVilleTheme {
        CarteVisite(
        )




    }
}
