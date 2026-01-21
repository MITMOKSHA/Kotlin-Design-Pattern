package behavior

interface Visitor {
    fun visitMonkey(monkey: Monkey)
    fun visitElephant(elephant: Elephant)
}

class Feeder: Visitor {
    override fun visitMonkey(monkey: Monkey) {
        println("饲养员给${monkey.name}喂香蕉")
    }

    override fun visitElephant(elephant: Elephant) {
        println("饲养员给${elephant.name}喂西瓜")
    }
}

class Recorder: Visitor {
    override fun visitMonkey(monkey: Monkey) {
        println("记录员记录${monkey.name}的体重")
    }

    override fun visitElephant(elephant: Elephant) {
        println("记录员记录${elephant.name}的身高")
    }
}

// Element
abstract class Animal(
    val name: String
) {
    abstract fun accept(visitor: Visitor)
}

class Monkey(name: String): Animal(name) {
    override fun accept(visitor: Visitor) {
        visitor.visitMonkey(this)
    }
}

class Elephant(name: String): Animal(name) {
    override fun accept(visitor: Visitor) {
        visitor.visitElephant(this)
    }
}

fun main() {
    val feeder = Feeder()
    val recorder = Recorder()
    val monkey = Monkey("猴子")
    val elephant = Monkey("大象")
    val animals = listOf(monkey, elephant)
    for (animal in animals) {
        animal.accept(feeder)
        animal.accept(recorder)
    }
}