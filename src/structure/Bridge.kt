package structure

interface Color {
    fun apply(): String
}

class Blue: Color {
    override fun apply(): String {
        return "蓝色"
    }

}

class Red: Color {
    override fun apply(): String {
        return "红色"
    }
}

abstract class Shape(
    protected val color: Color
) {
    abstract fun draw()
}

class Rectangle(color: Color): Shape(color) {
    override fun draw() {
        println("绘制${color.apply()}的正方形")
    }
}

class Triangle(color: Color): Shape(color) {
    override fun draw() {
        println("绘制${color.apply()}的三角形")
    }
}


fun main() {
    val redRectangle = Rectangle(Red())
    val blueRectangle = Rectangle(Blue())
    val blueTriangle = Triangle(Blue())
    redRectangle.draw()
    blueRectangle.draw()
    blueTriangle.draw()
}