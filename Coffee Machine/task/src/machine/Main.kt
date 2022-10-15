package machine

const val WATER_PER_CUP = 200
const val MILK_PER_CUP = 50
const val BEANS_PER_UP = 15



fun main() {
    println("Write how many cups of coffee you will need:")
    val nCups = readln().toInt()
    println("For $nCups cups of coffee you will need:\n" +
            "${nCups * WATER_PER_CUP} ml of water\n" +
            "${nCups * MILK_PER_CUP} ml of milk\n" +
            "${nCups * BEANS_PER_UP} g of coffee beans")

    /*
    println("Starting to make a coffee")
    println("Grinding coffee beans")
    println("Boiling water")
    println("Mixing boiled water with crushed coffee beans")
    println("Pouring coffee into the cup")
    println("Pouring some milk into the cup")
    println("Coffee is ready!") */
}