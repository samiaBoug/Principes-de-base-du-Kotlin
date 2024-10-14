package com.example.myapplication

fun main(){
  /*val name = "Samia"
    if(name == "Samia") {
        println("True")
    }else {
        println("False")
    } */
    val traficLightColor = "Green"

    val message = when(traficLightColor){
        "Red" -> "Stop"
        "Green" -> "Go"
        else -> "Invalid color"
    }
    println(message)
    }
