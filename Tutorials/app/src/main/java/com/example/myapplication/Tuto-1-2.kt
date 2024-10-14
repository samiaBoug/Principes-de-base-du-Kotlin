package com.example.myapplication

fun main(){
    /*var favoriteColor = "Red" ;
    favoriteColor = null
    println(favoriteColor) */
    var number : Int? = 10
    number = null
    println(number)

    var color = "Red"
    println(color.length)

    var name : String? = "Samia"
    println(name?.length)
    println(name!!.length)

}