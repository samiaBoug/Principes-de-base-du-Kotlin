package com.example.myapplication



// 1 - Notifications mobiles
/*
fun main() {
    val morningNotification = 51
    val eveningNotification = 135

    printNotificationSummary(morningNotification)
    printNotificationSummary(eveningNotification)
}

fun printNotificationSummary(numberOfMessages: Int) {
    if(numberOfMessages < 100){
        println("You have $numberOfMessages notifications")
    }else{
        println("Your phone is blowing up! You have 99+ notifications.")
    }
}
// output : You have 51 notifications.
//          Your phone is blowing up! You have 99+ notifications.
*/
// 2 - Prix du billet de cinéma
/*
fun main() {
    val child = 5
    val adult = 28
    val senior = 87

    val isMonday = true

    println("The movie ticket price for a person aged $child is \$${ticketPrice(child, isMonday)}.")
    println("The movie ticket price for a person aged $adult is \$${ticketPrice(adult, isMonday)}.")
    println("The movie ticket price for a person aged $senior is \$${ticketPrice(senior, isMonday)}.")
}

fun ticketPrice(age: Int, isMonday: Boolean): Int {
    // Fill in the code.
   return when(age){
        in 1..12 -> 15
        in 13..60 -> 25
        in 61..100 -> 20
        else -> -1
    }


}
*/
// 3- Convertisseur de température
/*
fun main() {
    // Fill in the code.
    fun CelesiustoFarenheit(initialMeasurement: Double): Double {
        return (9.0 / 5.0) * initialMeasurement + 32
    }

    fun KelvinToCelesius(initialMeasurement: Double): Double{
        return initialMeasurement - 273.15
    }
    fun FahrenheitToKelvin(initialMeasurement: Double): Double{
        return 5.0/9.0  * ( initialMeasurement - 32)+ 273.15
    }

    printFinalTemperature(27.0 , "Celecius" , "Fahrenheit" , ::CelesiustoFarenheit){(9.0 / 5.0) * it + 32}
    printFinalTemperature(350.0 , "Kelvin" , "Celesius" , ::KelvinToCelesius){it - 273.15}
    printFinalTemperature(10.0 , "Fahrenheit" , "Kelvin" , ::FahrenheitToKelvin){5.0/9.0  * ( it - 32)+ 273.15}


}



fun printFinalTemperature(
    initialMeasurement: Double,
    initialUnit: String,
    finalUnit: String,
    conversionFormula: (Double) -> Double
) {
    val finalMeasurement = String.format("%.2f", conversionFormula(initialMeasurement)) // two decimal places
    println("$initialMeasurement degrees $initialUnit is $finalMeasurement degrees $finalUnit.")
}


// output : 27.0 degrees Celsius is 80.60 degrees Fahrenheit.
//          350.0 degrees Kelvin is 76.85 degrees Celsius.
//          10.0 degrees Fahrenheit is 260.93 degrees Kelvin.

 */

//Catalogue de chansons
/*
fun main(){
    val song = song("Lama Bada Yatathana" , "Lana Chamalyane" , 2000 , 1000000)
    song.printSong()
}
class song (
    val titre: String ,
     val artiste: String ,
     val anneePublication: Int
     val playCount: Int){
     val isPopular: Boolean
     get()= playCount >= 1000
    fun printSong(){
        println("$titre , interprété par $artiste , est sorti en $anneePublication")
    }

}

 */

//Profil Internet
/*
fun main() {
    val amanda = Person("Amanda", 33, "play tennis", null)
    val atiqah = Person("Atiqah", 28, "climb", amanda)

    amanda.showProfile()
    atiqah.showProfile()
}

class Person(val name: String, val age: Int, val hobby: String?, val referrer: Person?) {
    fun showProfile() {
        // Fill in code
        val message: String = if (referrer == null) {
            "Doesn't have a referrer"
        } else {

            "Has a referrer named ${referrer.name} who likes to  ${referrer.hobby}"
        }
        println("Name : $name \n Age: $age ")

        if (hobby != null) {
            println("Likes to  $hobby .")

        }
        println("$message \n")
    }
}

*/

//Téléphones pliables
/*
open class Phone(var isScreenLightOn: Boolean = false){
    open fun switchOn() {
        isScreenLightOn = true
    }

    fun switchOff() {
        isScreenLightOn = false
    }

    fun checkPhoneScreenLight() {
        val phoneScreenLight = if (isScreenLightOn) "on" else "off"
        println("The phone screen's light is $phoneScreenLight.")
    }
}
class FoldablePhone(var floade : Boolean = true) : Phone(){
    //methode switchOn override
    override fun switchOn(){
        if(!floade){
            isScreenLightOn = true
        }
    }
    //methode etatPilier
    fun pilierOn(){
        floade = true
        println("telephone est pilié")
    }
    fun pilierOff(){
        floade = false
        println("telephone non pilié ")
    }
}
fun main() {
    val newFoldablePhone = FoldablePhone()

    newFoldablePhone.switchOn()
    newFoldablePhone.checkPhoneScreenLight()
    newFoldablePhone.pilierOff()
    newFoldablePhone.switchOn()
    newFoldablePhone.checkPhoneScreenLight()
}
*/

// Enchère spéciale

fun main() {
    val winningBid = Bid(5000, "Private Collector") // creation d'un objet

    println("Item A is sold at ${auctionPrice(winningBid, 2000)}.")
    println("Item B is sold at ${auctionPrice(null, 3000)}.")
}

class Bid(val amount: Int, val bidder: String)

fun auctionPrice(bid: Bid?, minimumPrice: Int): Int {
    // Fill in the code.
    return bid?.amount ?: minimumPrice

}
//output : Item A is sold at 5000.
//         Item B is sold at 3000.


