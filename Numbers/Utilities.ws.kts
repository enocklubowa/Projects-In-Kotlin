
class Utilities{
    fun isValidInteger(input: String?): Boolean{
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
}

