package machine

const val ESPRESSO_WATER_PER_CUP = 250
const val ESPRESSO_MILK_PER_CUP = 0
const val ESPRESSO_BEANS_PER_CUP = 16
const val ESPRESSO_PRICE = 4

const val LATTE_WATER_PER_CUP = 350
const val LATTE_MILK_PER_CUP = 75
const val LATTE_BEANS_PER_CUP = 20
const val LATTE_PRICE = 7

const val CAPPUCCINO_WATER_PER_CUP = 200
const val CAPPUCCINO_MILK_PER_CUP = 100
const val CAPPUCCINO_BEANS_PER_CUP = 12
const val CAPPUCCINO_PRICE = 6

var money = 550
var water = 400
var milk = 540
var beans = 120
var cups = 9

fun chooseAction() {
    print("Write action (buy, fill, take):")
    val action = readln()
    when (action) {
        "buy" -> buy()
        "fill" -> fill()
        "take" -> take()
    }
}

fun buy() {
    println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:")
    val choice = readln().toInt()
    when (choice) {
        1 -> {
            water -= ESPRESSO_WATER_PER_CUP
            milk -= ESPRESSO_MILK_PER_CUP
            beans -= ESPRESSO_BEANS_PER_CUP
            cups -= 1
            money += ESPRESSO_PRICE
        }
        2 -> {
            water -= LATTE_WATER_PER_CUP
            milk -= LATTE_MILK_PER_CUP
            beans -= LATTE_BEANS_PER_CUP
            cups -= 1
            money += LATTE_PRICE
        }
        3 -> {
            water -= CAPPUCCINO_WATER_PER_CUP
            milk -= CAPPUCCINO_MILK_PER_CUP
            beans -= CAPPUCCINO_BEANS_PER_CUP
            cups -= 1
            money += CAPPUCCINO_PRICE
        }
    }
}

fun fill() {
    println("Write how many ml of water you want to add:")
    water += readln().toInt()
    println("Write how many ml of nilk you want to add:")
    milk += readln().toInt()
    println("Write how many grams of coffee beans you want to add:")
    beans += readln().toInt()
    println("Write how many disposable cups you want to add:")
    cups += readln().toInt()
}

fun printSupply() {
    println("The coffee machine has:\n" +
            "$water ml of water\n" +
            "$milk ml of milk\n" +
            "$beans of coffee beans\n" +
            "$cups disposable cups\n" +
            "\$$money of money")
}

fun take() {
    println("I gave you \$$money")
    money = 0
}

/*
fun calcPossibleCups(supplyWater: Int, supplyMilk: Int, supplyBeans: Int): Int {
    val w = supplyWater / WATER_PER_CUP
    val m = supplyMilk / MILK_PER_CUP
    val b = supplyBeans / BEANS_PER_CUP
    return minOf(w, m, b)
}
 */

fun main() {
    printSupply()
    chooseAction()
    printSupply()

}