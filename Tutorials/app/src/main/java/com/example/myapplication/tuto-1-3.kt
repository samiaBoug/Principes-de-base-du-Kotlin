package com.example.myapplication

class SmartDevice(val name: String , val category: String ){

   /* val name = "Android TV"
    val category = "Entertainment" */
    var deviceStatus = "online"

    fun turnOn(){
        println("Smart device is turned on.")
    }
    fun turnOff(){
        println("Smart device is turned off.")
    }
}
fun main(){

    val smartTvDevice = SmartDevice("Android TV" , "Entertainment")
    smartTvDevice.turnOff()
    smartTvDevice.turnOn()
   // println("name of device : "+ smartTvDevice.name)

}