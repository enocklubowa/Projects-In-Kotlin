var cardNumber = "79927398713"
val numberList = mutableListOf<Int>()
for(character in cardNumber){
    numberList.add(character.toString().toInt())
}
numberList.reverse()
for (x in 1..numberList.size step 2){
    try {
        var newNumber = numberList[x] * 2
        if(newNumber > 9){

        }
        numberList[x] = numberList[x] * 2
        println(numberList[x])
    }
    catch (ex: IndexOutOfBoundsException){}
}

print(numberList)