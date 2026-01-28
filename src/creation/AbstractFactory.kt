package creation

abstract class ComputerFactory {
    abstract fun createRam(): Ram
    abstract fun createCpu(): Cpu
}

class WindowsFactory: ComputerFactory() {
    override fun createRam(): Ram {
        return KinstonRam()
    }

    override fun createCpu(): Cpu {
        return IntelCpu()
    }
}

class MacFactory: ComputerFactory() {
    override fun createRam(): Ram {
        return SumsungRam()
    }

    override fun createCpu(): Cpu {
        return AMDCpu()
    }
}

interface Ram {
}

class KinstonRam: Ram {
    init {
        println("KinstonRam")
    }
}

class SumsungRam: Ram {
    init {
        println("SuamsungRam")
    }
}

interface Cpu

class IntelCpu: Cpu {
    init {
        println("IntelCpu")
    }
}

class AMDCpu: Cpu {
    init {
        println("AMDCpu")
    }
}

fun main() {
    val factory = WindowsFactory()
    factory.createCpu()
    factory.createRam()
    val factory2 = MacFactory()
    factory2.createCpu()
    factory2.createRam()
}