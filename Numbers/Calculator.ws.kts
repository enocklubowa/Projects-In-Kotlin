/*
Solves an expression of integers with basic operations of "+,-,/,*"
 */
while(true){
    val operators = mutableListOf<Operator>()
    println("Enter an expression")
    var input = readLine()!!
    for(index in input.indices){
        if (input[index] == '+' || input[index] == '*' || input[index] == '/' || input[index] == '-'){
            operators.add(Operator(input[index], index))
        }
    }
    //println(operators)

    var startIndex = 0
    var endIndex : Int
    val operands = mutableListOf<Int>()
    var subString : Int
    for(index in operators.indices){
        endIndex = operators[index].index
        subString = input.substring(startIndex, endIndex).toInt()
        operands.add(subString)
        startIndex = operators[index].index + 1
    }
    subString = input.substring(startIndex).toInt()
    operands.add(subString)
    println(operands)


    var operandTwoIndex = 1
    var operandOne = operands[0]
    var operandTwo = operands[operandTwoIndex]
    for(operator in operators){
        if(operator.operator == '+'){
            //println("Added $operandOne and $operandTwo")
            operandOne = operandOne + operandTwo
            try {
                operandTwo = operands[operandTwoIndex + 1]
            }
            catch (ex: IndexOutOfBoundsException){
                break
            }
        }
        else if(operator.operator == '-'){
            //println("Subtracted $operandOne and $operandTwo")
            operandOne = operandOne - operandTwo
            try {
                operandTwo = operands[operandTwoIndex + 1]
            }
            catch (ex: IndexOutOfBoundsException){
                break
            }
        }
        else if(operator.operator == '/'){
            //println("Divided $operandOne and $operandTwo")
            operandOne = (operandOne / operandTwo).toInt()
            try {
                operandTwo = operands[operandTwoIndex + 1]
            }
            catch (ex: IndexOutOfBoundsException){
                break
            }
        }
        else if(operator.operator == '*'){
            //println("Multiplied $operandOne and $operandTwo")
            operandOne = operandOne * operandTwo
            try {
                operandTwo = operands[operandTwoIndex + 1]
            }
            catch (ex: IndexOutOfBoundsException){
                break
            }
        }
        operandTwoIndex++
    }
    println("Answer is $operandOne")
}


class Operator(var operator: Char, var index: Int){}