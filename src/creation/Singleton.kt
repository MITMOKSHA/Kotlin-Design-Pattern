package creation

class Singleton private constructor() {
    companion object {
        val instance = Singleton()
        fun doSomething() {}
    }

    init {
        println("饿汉式")
    }

}

class LazySingleton private constructor() {
    companion object {
        @Volatile
        private var instance: LazySingleton? = null

        fun getInstance() {
            if (instance == null) {
                synchronized(this) {
                    if (instance == null) {
                        instance = LazySingleton()
                    }
                }
            }
        }
        fun doSomething() {}
    }

    init {
        println("双重检查线程安全的懒汉式")
    }
}

object KtSingleton {
    init {
        println("kt版本的饿汉式")
    }
    fun doSomething() {}
}

class KtLazySingleton private constructor() {
    companion object {
        val instance by lazy { KtLazySingleton()}
        fun doSomething() {}
    }

    init {
        println("kt版本的懒汉式")
    }
}

fun main() {
    val singleton = Singleton.doSomething()
    val ktSingleton = KtSingleton.doSomething()

    // 懒汉式没有访问实例，所以不会走创建链路
    val lazySingleton = LazySingleton.doSomething()
    val ktLazySingleton = KtLazySingleton.doSomething()

    // 下面才会打印日志
    LazySingleton.getInstance()
    KtLazySingleton.instance
}