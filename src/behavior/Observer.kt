package behavior

interface Observer {
    fun onNotify()
}

class ConcreteObserverA: Observer {
    override fun onNotify() {
        println("A收到通知")
    }
}

class ConcreteObserverB: Observer {
    override fun onNotify() {
        println("B收到通知")
    }
}


class Observable {
    private val observers = ArrayList<Observer>()

    fun notifyMsg() {
        println("发送通知")
        for (observer in observers) {
            observer.onNotify()
        }
    }

    fun subscribe(observer: Observer) {
        println("${observer.javaClass.name}开始订阅消息")
        observers.add(observer)
    }

    fun unsubscribe(observer: Observer) {
        if (!observers.contains(observer)) {
            return
        }
        observers.remove(observer)
        println("${observer.javaClass.name}解除订阅")
    }
}

fun main() {
    val observerA = ConcreteObserverA()
    val observerB = ConcreteObserverB()
    val observable = Observable()
    observable.subscribe(observerA)
    observable.subscribe(observerB)
    observable.notifyMsg()
    observable.unsubscribe(observerA)
    observable.unsubscribe(observerB)
}