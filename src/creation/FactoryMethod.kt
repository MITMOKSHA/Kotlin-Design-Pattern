package creation

interface Document {
    fun open()
}

class Pdf: Document {
    override fun open() {
        println("open Pdf")
    }
}

class Doc: Document {
    override fun open() {
        println("open Doc")
    }
}

// creator
/**
 * 为什么要Creator？
 *
 * 封装对象创建逻辑：将对象的创建和使用分离，客户端不关心具体创建细节。
 *
 * 提供灵活性和可扩展性：通过继承Creator，可以很容易地扩展新的产品类型。
 *
 * 符合开闭原则：对扩展开放，对修改封闭。新增产品时，只需添加新的具体Creator，无需修改现有代码。
 */
abstract class Editor {
    abstract fun create(): Document
    fun launch() {
        create().open()
    }
}

class PdfEditor : Editor() {
    override fun create() = Pdf()
}

class DocEditor : Editor() {
    override fun create() = Doc()
}

fun main() {
    // 客户端不关心具体的创建细节
    val pdfEditor = PdfEditor()
    val docEditor = DocEditor()
    pdfEditor.launch()
    docEditor.launch()
}