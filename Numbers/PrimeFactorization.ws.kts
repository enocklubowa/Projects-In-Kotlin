import java.lang.NumberFormatException
var count = 0
while (count < 100){
    println("Enter a number: ")
    val input = readLine()
    if(isValidInput(input)){
        var number = input?.toInt()!!
        var allFactors = getAllFactors(number)
        //println(allFactors)
        println(extractPrimeFactors(allFactors))
    }
    count++
}

fun getAllFactors(input: Int): MutableSet<Int>{
    val allFactors = mutableSetOf<Int>()
    for (i in 1..input/2){
        for (j in i..input/2){
            if(i*j == input){
                allFactors.add(i)
                allFactors.add(j)
            }
        }
    }
    return allFactors
}

fun extractPrimeFactors(factors: MutableSet<Int>): MutableSet<Int>{
    val iterator = factors.iterator()
    while (iterator.hasNext()){
        if(getAllFactors(iterator.next()).size > 0){
            factors.remove(iterator.next())
        }
    }
    return factors
}

fun isValidInput(input: String?): Boolean{
    if(input != null){
        if(isInteger(input)){
            if (isInRange(input)){
                return true
            }
            else{
                println("Input is out of range. " +
                        "\n Enter a number between 0 and 100")
                return false
            }
        }
        else{
            println("Input can only be an integer")
            return false
        }
    }
    else{
        println("Input can't be empty")
        return false
    }
}

fun isInteger(input: String): Boolean{
    try {
        input.toInt()
        return true
    }
    catch (ex: NumberFormatException){
        return false
    }
}

fun isInRange(input: String): Boolean{
    if(input.toInt() <= 100){
        return true
    }
    return false
}