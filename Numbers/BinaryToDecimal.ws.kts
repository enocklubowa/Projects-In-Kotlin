import java.util.ArrayDeque
import kotlin.math.pow

println("Enter decimal number to convert to binary")
val decimalInput = readLine()!!
if(isValidNumber(decimalInput)){
    println(decimalToBinary(decimalInput.toInt()))
}
else{
    println("Invalid decimal number entered")
}


println("Enter binary number to convert to decimal")
val binaryInput = readLine()!!
if(isValidBinaryNumber(binaryInput)){
    println(binaryToDecimal(binaryInput))
}
else{
    println("Invalid binary number entered")
}


fun isValidBinaryNumber(binary: String): Boolean {
    var valid = true
    for (character in binary) {
        if (character != '1' && character != '0') {
            valid = false
        }
    }
    return valid
}


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


fun isValidNumber(input: String): Boolean{
    try {
        input.toInt()
        return true
    }
    catch (ex: NumberFormatException){
        return false
    }
}