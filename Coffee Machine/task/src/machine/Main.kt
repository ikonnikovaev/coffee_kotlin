package machine

enum class Coffee(val id: String, val water: Int, val milk: Int, val beans: Int, val price: Int) {
    ESPRESSO("1", 250, 0, 16, 4),
    LATTE("2", 350, 75, 20, 7),
    CAPPUCCINO("3", 200, 100, 12, 6),
    NULL("0", 0, 0,0, 0)
}



enum class Action(val action: String) {
    BUY("buy"),
    FILL("fill"),
    TAKE("take"),
    REMAINING("remaining"),
    EXIT("exit"),
    NULL("")
}




class CoffeeMachine {
    var money = 550
    var water = 400
    var milk = 540
    var beans = 120
    var cups = 9

    fun findCoffee(id: String): Coffee {
        for (enum in Coffee.values()) {
            if (id == enum.id) return enum
        }
        return Coffee.NULL
    }
    fun buy() {
        println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:")
        val choice = readln()

        make_coffee(findCoffee(choice))
    }

    fun make_coffee(coffee: Coffee): Boolean {
        if (coffee == Coffee.NULL) {
            return true
        }
        if (water < coffee.water) {
            println("Sorry, not enough water!")
            return false
        }
        if (milk < coffee.milk) {
            println("Sorry, not enough milk!")
            return false
        }
        if (beans < coffee.beans) {
            println("Sorry, not enough beans!")
            return false
        }
        if (cups < 1) {
            println("Sorry, not enough cups!")
            return false
        }
        println("I have enough resources, making you a coffee!")
        water -= coffee.water
        milk -= coffee.milk
        beans -= coffee.beans
        cups -= 1
        money += coffee.price
        return true

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

    fun printRemaining() {
        println(
            "The coffee machine has:\n" +
                    "$water ml of water\n" +
                    "$milk ml of milk\n" +
                    "$beans of coffee beans\n" +
                    "$cups disposable cups\n" +
                    "\$$money of money"
        )
    }

    fun take() {
        println("I gave you \$$money")
        money = 0
    }

    fun findAction(action: String): Action {
        for (enum in Action.values()) {
            if (action == enum.action) return enum
        }
        return Action.NULL
    }

    fun chooseAction(): Boolean {
        println("Write action (buy, fill, take, remaining, exit):")
        val action = findAction(readln())
        when (action) {
            Action.BUY -> buy()
            Action.FILL -> fill()
            Action.TAKE -> take()
            Action.REMAINING -> printRemaining()
            Action.EXIT -> return false
            else -> {}
        }
        return true
    }

}


fun main() {
    val machine = CoffeeMachine()
    while (machine.chooseAction()) {}

}