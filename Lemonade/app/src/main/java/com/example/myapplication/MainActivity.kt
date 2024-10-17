package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

                LemonApp()

        }
    }
}

@Composable
fun Lemon(modifier : Modifier = Modifier){

    var option by remember { mutableIntStateOf(1) }

    val lemonImage = when(option){
        2 -> R.drawable.lemon_squeeze
        3 -> R.drawable.lemon_drink
        4 -> R.drawable.lemon_restart
        else-> R.drawable.lemon_tree
    }
    val lemonText = when(option){
        2 -> R.string.lemon
        3 -> R.string.glassOfLemon
        4 -> R.string.emptyGlass
        else-> R.string.lemonTree
    }
    Column (
        modifier = modifier ,
        horizontalAlignment = Alignment.CenterHorizontally ,
        verticalArrangement = Arrangement.Center

        ){
        Text(
            text = "Lemonade" ,
            modifier = modifier.background(Color.Yellow)
        )
        Spacer(modifier= modifier.height(26.dp))

        Button(
            onClick = {
                if(option in 1..3){
                   option++
                }else{
                    option = 1
                }

                } ,
            modifier = Modifier.border(width = 1.dp , color = Color.White ,shape = RoundedCornerShape(16.dp)
            )
                .background(Color.Green)) {
            Image(
                painter = painterResource(lemonImage),
                contentDescription = null  ,
                modifier = Modifier.background(Color.Transparent)
            )
        }
        Spacer(modifier= Modifier.height(16.dp))

         Text (
            text = stringResource(lemonText) ,
             fontSize = 16.sp )


    }
}

@Preview(showBackground = true)
@Composable
 fun LemonApp(){
    Lemon()
 }

