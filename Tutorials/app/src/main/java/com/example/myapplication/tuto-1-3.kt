package com.example.myapplication

// Relations entre les classes : Relations HAS-A - Relations IS-A
// Réutiliser du code de super-classe dans des sous-classes avec le mot clé super
// Remplacer les propriétés de super-classe à partir de sous-classes

/* open class SmartDevice(val name: String, val category: String ){
   private var deviceStatus = "online"
    open val deviceType = "unknown"

    constructor(name: String , category: String , statusCode: Int): this(name , category)
    {
        deviceStatus = when(statusCode){
            0 -> "offline"
            1 -> "online"
            else -> "unknow"

        }
    }

   /* val name = "Android TV"
    val category = "Entertainment" */

    open fun turnOn(){
        deviceStatus = "on"
    }
    open fun turnOff(){
        deviceStatus = "off"
    }
}

class SmartTvDevice(deviceName: String , deviceCategory: String): SmartDevice(name = deviceName , category = deviceCategory){
    override val deviceType = "Smart TV"

    var speakerVolume = 2
        set(value ) {
            if (value in 1..100) {
                field = value
            }
        }

    var channelNumber = 3
        set(value ) {
            if (value in 1..100) {
                field = value
            }
        }
    fun increaseSpeakerVolume(){
        speakerVolume++
        println("Speaker volume increased to $speakerVolume")
    }

    fun nextChannel(){
        channelNumber++
        println("channel number increase to $channelNumber")
    }

    override fun turnOn(){
        super.turnOn()
        println(" \"$name is turned on. Speaker volume is set to $speakerVolume and channel number is \" + \"set to $channelNumber.\"")
    }
    override fun turnOff(){
        super.turnOff()
        println("$name is turned off")
    }
}

class smartLightDevice(deviceName: String , deviceCategory: String): SmartDevice(name =deviceName , category= deviceCategory){
    override val deviceType = "Smart TV"

    var brightness = 0
        set(value){
          if(value in 0..100){
              field = value
          }
        }
    fun increaseBrightness(){
        brightness++
        println("brightness increse to $brightness")
    }
     override fun turnOn(){
        super.turnOn()
        brightness = 2
        println("$name turned on. The brightness level is $brightness.")
    }
    override fun turnOff(){
        super.turnOff()
        brightness =0
        println("Smart Light turned off")
    }
}

class SmartHome(
    val smartTvDevice: SmartTvDevice ,
    val smartLightDevice: smartLightDevice){
    fun turnOn(){
        smartTvDevice.turnOn()
    }

    fun turnOff(){
        smartTvDevice.turnOff()
    }
    fun increaseTvVolume(){
        smartTvDevice.increaseSpeakerVolume()
    }
    fun changeTvChannelToNext(){
        smartTvDevice.nextChannel()
    }
    fun turnOnLight(){
        smartLightDevice.turnOn()
    }
    fun turnOffLight(){
        smartLightDevice.turnOff()
    }
    fun increaseLightBrightness(){
        smartLightDevice.increaseBrightness()
    }
    fun turnOffAllDevices(){
        smartLightDevice.turnOff()
        smartTvDevice.turnOff()
    }
}
fun main(){

    //val smartTvDevice = SmartDevice("Android TV" , "Entertainment")
    //smartTvDevice.turnOff()
    //smartTvDevice.turnOn()
   // println("name of device : "+ smartTvDevice.name)
    var smartDevice : SmartDevice = SmartTvDevice("Android TV" , "Entairtement" )
    smartDevice.turnOff()
    smartDevice.turnOn()



} */
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

open class SmartDevice(val name: String, val category: String) {

    var deviceStatus = "online"
        protected set

    open val deviceType = "unknown"

    open fun turnOn() {
        deviceStatus = "on"
    }

    open fun turnOff() {
        deviceStatus = "off"
    }
}

class SmartTvDevice(deviceName: String, deviceCategory: String) :
    SmartDevice(name = deviceName, category = deviceCategory) {

    override val deviceType = "Smart TV"

    private var speakerVolume by RangeRegulator(initialValue = 2, minValue = 0, maxValue = 100)

    private var channelNumber by RangeRegulator(initialValue = 1, minValue = 0, maxValue = 200)

    fun increaseSpeakerVolume() {
        speakerVolume++
        println("Speaker volume increased to $speakerVolume.")
    }

    fun nextChannel() {
        channelNumber++
        println("Channel number increased to $channelNumber.")
    }

    override fun turnOn() {
        super.turnOn()
        println(
            "$name is turned on. Speaker volume is set to $speakerVolume and channel number is " +
                    "set to $channelNumber."
        )
    }

    override fun turnOff() {
        super.turnOff()
        println("$name turned off")
    }
}

class SmartLightDevice(deviceName: String, deviceCategory: String) :
    SmartDevice(name = deviceName, category = deviceCategory) {

    override val deviceType = "Smart Light"

    private var brightnessLevel by RangeRegulator(initialValue = 0, minValue = 0, maxValue = 100)

    fun increaseBrightness() {
        brightnessLevel++
        println("Brightness increased to $brightnessLevel.")
    }

    override fun turnOn() {
        super.turnOn()
        brightnessLevel = 2
        println("$name turned on. The brightness level is $brightnessLevel.")
    }

    override fun turnOff() {
        super.turnOff()
        brightnessLevel = 0
        println("Smart Light turned off")
    }
}

class SmartHome(
    val smartTvDevice: SmartTvDevice,
    val smartLightDevice: SmartLightDevice
) {

    var deviceTurnOnCount = 0
        private set

    fun turnOnTv() {
        deviceTurnOnCount++
        smartTvDevice.turnOn()
    }

    fun turnOffTv() {
        deviceTurnOnCount--
        smartTvDevice.turnOff()
    }

    fun increaseTvVolume() {
        smartTvDevice.increaseSpeakerVolume()
    }

    fun changeTvChannelToNext() {
        smartTvDevice.nextChannel()
    }

    fun turnOnLight() {
        deviceTurnOnCount++
        smartLightDevice.turnOn()
    }

    fun turnOffLight() {
        deviceTurnOnCount--
        smartLightDevice.turnOff()
    }

    fun increaseLightBrightness() {
        smartLightDevice.increaseBrightness()
    }

    fun turnOffAllDevices() {
        turnOffTv()
        turnOffLight()
    }
}

class RangeRegulator(
    initialValue: Int,
    private val minValue: Int,
    private val maxValue: Int
) : ReadWriteProperty<Any?, Int> {

    var fieldData = initialValue

    override fun getValue(thisRef: Any?, property: KProperty<*>): Int {
        return fieldData
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: Int) {
        if (value in minValue..maxValue) {
            fieldData = value
        }
    }
}

fun main() {
    var smartDevice: SmartDevice = SmartTvDevice("Android TV", "Entertainment")
    smartDevice.turnOn()

    smartDevice = SmartLightDevice("Google Light", "Utility")
    smartDevice.turnOn()
}