import java.util.ArrayDeque
import kotlin.math.pow

println(decimalToBinary(1009000))
println(binaryToDecimal("1010"))

fun decimalToBinary(decimal: Int): String{

    var changingDecimal = decimal
    //ArrayDeque operates as a stack
    val binaryDigits = ArrayDeque<Int>()

    if(decimal == 0){
        binaryDigits.push(0)
        return binaryDigits.joinToString("")
    }

    while (changingDecimal >= 2){
        binaryDigits.push(changingDecimal % 2)
        changingDecimal = (changingDecimal/2).toInt()
    }

    binaryDigits.push(1)
    return binaryDigits.joinToString("")
}

fun binaryToDecimal(binary: String): Int{
    val reversedBinary = binary.reversed()
    var sum = 0
    for(index in reversedBinary.indices){
        sum += (reversedBinary[index].toString().toInt() * 2.0.pow(index)).toInt()
    }
    return sum
}