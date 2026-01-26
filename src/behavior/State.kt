package behavior

interface State {
    fun handle(context: Context)
}

class InitState : State {
    override fun handle(context: Context) {
        println("onDestroy -> onInit")
        context.setState(StartState())
    }
}

class StartState : State {
    override fun handle(context: Context) {
        println("onInit -> onStart")
        context.setState(StopState())
    }
}

class StopState : State {
    override fun handle(context: Context) {
        println("onStart -> onStop")
        context.setState(DestroyState())
    }
}

class DestroyState : State {
    override fun handle(context: Context) {
        println("onStop -> onDestroy")
        context.setState(InitState())
    }
}

class Context(
    private var currentState: State
) {
    fun request() {
        currentState.handle(this)
    }

    fun setState(state: State) {
        currentState = state
    }
}

fun main() {
    val context = Context(StartState())
    context.request()
    context.request()
    context.request()
    context.request()
}
