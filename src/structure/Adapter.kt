package structure

interface TypeCCharger {
    fun chargingWithTypeC()
}

class TypeCChargerAdapter(
    private val lightningCharger: LightningCharger
): TypeCCharger {
    override fun chargingWithTypeC() {
        lightningCharger.chargingWithLightning()
        println("适配器：${lightningCharger.chargingWithLightning()} 转换为 type-c")
    }
}

class LightningCharger {
    fun chargingWithLightning(): String {
        return "使用Lightning充电"
    }
}

fun main() {
    val typeCharger = TypeCChargerAdapter(LightningCharger())
    typeCharger.chargingWithTypeC()
}