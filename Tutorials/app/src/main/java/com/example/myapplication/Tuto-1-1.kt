package com.example.myapplication
/* fun main(){
    val traficLihtColor = "Green"
    if(traficLihtColor == "Red"){
        println("Stop")
    }else{
        println("Go")
    }

} */
/*fun main(){
    //
    val traficLightColor = "Gren"
    when(traficLightColor){
        "Red" -> println("Stop")
        "Green" -> println("Go")
        else -> println("Invalid light color")
    }

    //


}*/
fun main(){

    val trafficLightColor = "Black"

      val message = when (trafficLightColor ) {
          "Red" -> "Stop"
          "Yellow" -> "Slow"
          "Green" -> "Go"
          else ->
              "Invalid traffic-light color"

      }

    println(message)
}