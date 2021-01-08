
println("Enter floor length")
val floorLength = readLine()!!
println("Enter floor width")
val floorWidth = readLine()!!
println("Enter tile side length")
val tileLength = readLine()!!
println("Enter tile cost")
val tileCost = readLine()!!
if(isValidDouble(floorLength) && isValidDouble(floorWidth) && isValidDouble(tileLength) && isValidDouble(tileCost)){
    println("Total cost: ${totalCost(tileCost.toDouble(), Tile(tileLength.toDouble()), floorLength.toDouble(), floorWidth.toDouble())}")
}
else{
    println("All entries should be numbers")
}


fun tilesRequiredForWidth(tile: Tile, floorWidth: Double): Int{
    return (floorWidth/tile.length).toInt()
}


fun tilesRequiredForLength(tile: Tile, floorLength: Double): Int{
    return (floorLength/tile.length).toInt()
}


fun totalTilesRequired(tile: Tile, floorLength: Double, floorWidth: Double): Int{
    return tilesRequiredForLength(tile, floorLength)*tilesRequiredForWidth(tile, floorWidth)
}

fun totalCost(tilePrice: Double, tile: Tile, floorLength: Double, floorWidth: Double): Double{
    return (totalTilesRequired(tile, floorLength, floorWidth).toDouble())*tilePrice
}

class Tile(var length: Double){}


fun isValidDouble(input: String): Boolean{
    try {
        input.toDouble()
        return true
    }
    catch (ex: NumberFormatException){
        return false
    }
}