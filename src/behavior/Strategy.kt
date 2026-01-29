package behavior

interface Strategy {
    fun forward()
}

class WalkStrategy : Strategy {
    override fun forward() {
        println("走路")
    }
}

class RunStrategy : Strategy {
    override fun forward() {
        println("跑步")
    }
}

class Ctx(
    private var strategy: Strategy?
) {
    fun setStrategy(strategy: Strategy) {
        this.strategy = strategy
    }

    fun exec() {
        strategy?.forward()
    }
}

fun main() {
    val ctx = Ctx(WalkStrategy())
    ctx.exec()
    ctx.setStrategy(RunStrategy())
    ctx.exec()
}