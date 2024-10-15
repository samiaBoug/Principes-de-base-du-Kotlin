package com.example.myapplication

fun main (){
   /* val trickFunction = trick
    trick()
    trickFunction()
    treat()

    */
    /* val coins: (Int) -> String = {
        "$it quarters"
    } */

    /*val cupcake: (Int) -> String = {
        "Have a cupcake!"
    }*/

    val treatFunction = trickOrTreat(false) { "$it quarter" }
    val trickFunction = trickOrTreat(true, null)
    treatFunction()

    repeat(5){
        trickFunction()

    }


}
 val trick = {
    println("no treats!")
}
val  treat: () -> Unit = {
    println("have a treat")
}
/*fun treatOrTrick(isTrick: Boolean): ()->Unit {
    return if(isTrick){
        trick
    }else {
        treat
    }


}
*/
fun trickOrTreat(isTrick: Boolean , extraTreat: ((Int)-> String)?) : ()-> Unit{
     if(isTrick){
      return  trick
    }else{
        if(extraTreat != null) {
            print(extraTreat(5))
        }
       return treat
    }
}

