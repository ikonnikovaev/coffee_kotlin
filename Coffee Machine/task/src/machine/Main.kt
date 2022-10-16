package machine

const val WATER_PER_CUP = 200
const val MILK_PER_CUP = 50
const val BEANS_PER_CUP = 15

fun calcPossibleCups(supplyWater: Int, supplyMilk: Int, supplyBeans: Int): Int {
    val w = supplyWater / WATER_PER_CUP
    val m = supplyMilk / MILK_PER_CUP
    val b = supplyBeans / BEANS_PER_CUP
    return minOf(w, m, b)
}

fun main() {
    println("Write how many ml of water the coffee machine has:")
    val supplyWater = readln().toInt()
    println("Write how many ml of milk the coffee machine has:")
    val supplyMilk = readln().toInt()
    println("Write how many grams of coffee beans the coffee machine has:")
    val supplyBeans = readln().toInt()
    val possibleCups = calcPossibleCups(supplyWater, supplyMilk, supplyBeans)
    println("Write how many cups of coffee you will need:")
    val requiredCups = readln().toInt()
    if (possibleCups >= requiredCups) {
        print("Yes, I can make that amount of coffee")
        if (possibleCups > requiredCups) {
            println(" (and even ${possibleCups - requiredCups} more than that)")
        } else {
            println()
        }
    } else {
        println("No, I can make only $possibleCups cups of coffee")
    }

    /*
    println("For $nCups cups of coffee you will need:\n" +
            "${nCups * WATER_PER_CUP} ml of water\n" +
            "${nCups * MILK_PER_CUP} ml of milk\n" +
            "${nCups * BEANS_PER_CUP} g of coffee beans")
    */
}