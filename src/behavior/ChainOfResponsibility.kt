package behavior

abstract class Handler(
    protected val next: Handler?
) {
    abstract fun canHandle(request: Request): Boolean
    fun handle(request: Request) {
        if (!canHandle(request)) {
            next?.handle(request)
        }
    }
}

class CEO(handler: Handler? = null): Handler(handler) {
    override fun canHandle(request: Request): Boolean {
        println("CEO审批")
        return true
    }
}

class Boss(handler: Handler? = null): Handler(handler) {
    override fun canHandle(request: Request): Boolean {
        println("部门主管审批")
        return request.days in 3..5
    }
}

class Manager(handler: Handler? = null): Handler(handler) {
    override fun canHandle(request: Request): Boolean {
        println("经理审批")
        return request.days < 3
    }
}


class Request(
    val days: Int
)

fun main() {
    val ceo = CEO()
    val boss = Boss(ceo)
    val manager = Manager(boss)
    // 员工请假
    val request = Request(7)
    manager.handle(request)
}
