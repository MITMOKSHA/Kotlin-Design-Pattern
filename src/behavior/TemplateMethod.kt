package behavior

abstract class Beverage {

    // 定义了算法骨架，决定子类执行的步骤。子类决定具体步骤的实现
    fun prepareRecipe() {
        boilWater()
        brew()
        poulWater()
        if (isCustomerNeededCondiments()) {
            addCondiments()
        }
    }

    private fun boilWater() {
        println("煮水")
    }

    abstract fun brew()

    private fun poulWater() {
        println("倒水")
    }


    // 注意open的作用
    protected open fun isCustomerNeededCondiments(): Boolean = true
    protected abstract fun addCondiments()
}

class Tea: Beverage() {
    override fun brew() {
        println("用90度的水煮茶")
    }

    override fun addCondiments() {
        println("添加龙眼")
    }

    override fun isCustomerNeededCondiments() = false
}

class Coffee: Beverage() {
    override fun brew() {
        println("手冲咖啡")
    }

    override fun addCondiments() {
        println("添加牛奶")
    }
}

fun main() {
    println("===泡茶===")
    val tea = Tea()
    tea.prepareRecipe()

    println("===泡咖啡===")
    val coffee = Coffee()
    coffee.prepareRecipe()
}