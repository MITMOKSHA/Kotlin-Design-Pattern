package structure

interface Coffee {
    fun cost(): Double
    fun description(): String
}

class SimpleCoffee: Coffee {
    override fun cost(): Double = 1.0
    override fun description(): String = "普通咖啡"
}

abstract class CoffeeDecorator(
    protected val coffee: Coffee,
): Coffee {
    override fun cost(): Double = coffee.cost()
    override fun description(): String = coffee.description()
}

class MilkDecorator(
    coffee: Coffee,
): CoffeeDecorator(coffee) {
    override fun cost(): Double {
        return coffee.cost() + 3.0
    }
    override fun description(): String  {
        return coffee.description() + "(加牛奶)"
    }
}

class SugarDecorator(
    coffee: Coffee,
): CoffeeDecorator(coffee) {
    override fun cost(): Double {
        return super.cost() + 2.0
    }

    override fun description(): String {
        return coffee.description() + "(加糖)"
    }
}

fun main() {
    val coffee = SimpleCoffee()
    val milkCoffee = MilkDecorator(coffee)
    val milkSugarCoffee = SugarDecorator(milkCoffee)
    println("${milkCoffee.description()} ${milkCoffee.cost()}")
    println("${milkSugarCoffee.description()} ${milkSugarCoffee.cost()}")
}