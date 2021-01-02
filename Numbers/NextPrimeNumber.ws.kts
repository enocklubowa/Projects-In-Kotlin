var count = 0
var lastPrimeNumber = 1;


while(count < 100){
    println("Type \"Y\" to print the next prime number or \"N\" to stop");
    var input = readLine()
    if(input == "Y"){
        printTheNextPrimeNumber()
    }
    else if (input == "N"){
        break
    }
    else{
        println("Invalid input")
    }
    count++
}

fun printTheNextPrimeNumber(){
    var nextCountingNumber = lastPrimeNumber + 1
    while(true){
        if (getAllFactors(nextCountingNumber).size == 0){
            println("Next prime number is $nextCountingNumber")
            lastPrimeNumber = nextCountingNumber
            break
        }
        nextCountingNumber++
    }
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