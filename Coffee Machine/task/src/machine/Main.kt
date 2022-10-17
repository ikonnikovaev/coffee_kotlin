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

fun chooseAction(): Boolean {
    print("Write action (buy, fill, take, remaining, exit):")
    val action = readln()
    when (action) {
        "buy" -> buy()
        "fill" -> fill()
        "take" -> take()
        "remaining" -> printSupply()
    }
    return action != "exit"
}

fun make_espresso(): Boolean {
    if (water < ESPRESSO_WATER_PER_CUP) {
        println("Sorry, not enough water!")
        return false
    }
    if (milk < ESPRESSO_MILK_PER_CUP) {
        println("Sorry, not enough milk!")
        return false
    }
    if (beans < ESPRESSO_BEANS_PER_CUP) {
        println("Sorry, not enough beans!")
        return false
    }
    if (cups < 1) {
        println("Sorry, not enough cups!")
        return false
    }
    println("I have enough resources, making you a coffee!")
    water -= ESPRESSO_WATER_PER_CUP
    milk -= ESPRESSO_MILK_PER_CUP
    beans -= ESPRESSO_BEANS_PER_CUP
    cups -= 1
    money += ESPRESSO_PRICE
    return true
}

fun make_latte(): Boolean {
    if (water < LATTE_WATER_PER_CUP) {
        println("Sorry, not enough water!")
        return false
    }
    if (milk < LATTE_MILK_PER_CUP) {
        println("Sorry, not enough milk!")
        return false
    }
    if (beans < LATTE_BEANS_PER_CUP) {
        println("Sorry, not enough beans!")
        return false
    }
    if (cups < 1) {
        println("Sorry, not enough cups!")
        return false
    }
    println("I have enough resources, making you a coffee!")
    water -= LATTE_WATER_PER_CUP
    milk -= LATTE_MILK_PER_CUP
    beans -= LATTE_BEANS_PER_CUP
    cups -= 1
    money += LATTE_PRICE
    return true
}

fun make_cappuccino(): Boolean {
    if (water < CAPPUCCINO_WATER_PER_CUP) {
        println("Sorry, not enough water!")
        return false
    }
    if (milk < CAPPUCCINO_MILK_PER_CUP) {
        println("Sorry, not enough milk!")
        return false
    }
    if (beans < CAPPUCCINO_BEANS_PER_CUP) {
        println("Sorry, not enough beans!")
        return false
    }
    if (cups < 1) {
        println("Sorry, not enough cups!")
        return false
    }
    println("I have enough resources, making you a coffee!")
    water -= CAPPUCCINO_WATER_PER_CUP
    milk -= CAPPUCCINO_MILK_PER_CUP
    beans -= CAPPUCCINO_BEANS_PER_CUP
    cups -= 1
    money += CAPPUCCINO_PRICE
    return true
}

fun buy() {
    println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:")
    val choice = readln()
    when (choice) {
        "1" -> make_espresso()
        "2" -> make_latte()
        "3" -> make_cappuccino()
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



fun main() {
    while (chooseAction()) {}

}