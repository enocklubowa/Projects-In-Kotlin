import java.math.BigDecimal
import java.math.RoundingMode
import java.util.*
import kotlin.math.PI
import kotlin.math.round

var count = 0;
val inputReader = Scanner(System.`in`)
val decimal = BigDecimal(3.53185).setScale(2,RoundingMode.HALF_EVEN)

while (count < 100){
    println("Enter number of decimal places: ")
    var n = readLine();
    if(isValidNumber(n)){
        val number = n?.toInt()!!
        if (isWithInRange(n)){
            println(BigDecimal(PI).setScale(number,RoundingMode.HALF_EVEN))
        }
        else{
            println("The entered number is out of range\nPlease enter a number between 0 and 10")
        }
    }
    else{
        println("Invalid number")
    }
    count++
}

fun isValidNumber(input: String?): Boolean{
    if (input != null){
        try {
            input.toInt()
            return true
        }
        catch (ex: NumberFormatException){
            return false
        }
    }
    return false
}

fun isWithInRange(input: String?): Boolean{
    if(input != null){
        if(input.toInt() >= 0 && input.toInt() <= 10){
            return true
        }
        else{
            return false
        }
    }
    return false
}



