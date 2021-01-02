import java.lang.NumberFormatException

var count = 0
while(count<100){
    println("Enter Fibonacci sequence limit: ")
    var input = readLine()

    if(isValidInput(input)){
        var sequenceLimit = input?.toInt()!!

        println(calculateFibonacciSequence(sequenceLimit))
    }

    count++
}

fun calculateFibonacciSequence(sequenceLimit: Int): List<Int>{
    val fibonacciSequence = mutableListOf(0,1)
    while (fibonacciSequence.size < sequenceLimit){
        var lastNumber = fibonacciSequence.get(fibonacciSequence.size-1)
        var secondLastNumber = fibonacciSequence
            .get(fibonacciSequence.size-2)
        var nextNumber = lastNumber + secondLastNumber
        fibonacciSequence.add(nextNumber)
    }
    return fibonacciSequence
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