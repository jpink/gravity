package dom.svg

import org.w3c.dom.Element
import org.w3c.dom.svg.SVGCircleElement
import org.w3c.dom.svg.SVGElement
import org.w3c.dom.svg.SVGGElement
import org.w3c.dom.svg.SVGLineElement
import org.w3c.dom.svg.SVGSVGElement

sealed class AbstractContext<E : SVGElement>(val element: E)

sealed class Drawer<E : SVGElement, C : AbstractContext<E>> {
    abstract val tag: Tag<E>

    protected lateinit var draft: C

    protected var show = false

    protected fun create() = tag.create().create()

    abstract fun E.create(): C

    open fun show(parent: Element) {
        if (!::draft.isInitialized) draft = create()
        val element = draft.element
        element.update(draft)
        parent.append(element)
        show = true
    }

    fun hide() {
        show = false
        update()
    }

    open fun E.update(context: C) {}

    open fun update() {
        if (show) draft.element.update(draft)
        else draft.element.remove()
    }
}

sealed class Buffered<E : SVGElement, C : AbstractContext<E>> : Drawer<E, C>() {
    /** Previously drawn context */
    private lateinit var drawn: C

    final override fun show(parent: Element) {
        if (!::drawn.isInitialized) drawn = create()
        super.show(parent)
    }

    final override fun update() {
        if (show) {
            val previous = drawn
            val currentElement = draft.element
            currentElement.update(draft)
            val previousElement = previous.element
            previousElement.parentElement!!.replaceChild(currentElement, previousElement)
            // Swap elements for next draw
            drawn = draft
            draft = previous
        } else drawn.element.remove()
    }
}


abstract class Circle<C : Circle.Context> : Drawer<SVGCircleElement, C>() {
    abstract class Context(element: SVGCircleElement) : AbstractContext<SVGCircleElement>(element)
    override val tag = Tag.circle
}
abstract class BufferedGroup<C : Group.Context> : Buffered<SVGGElement, C>() {
    override val tag = Tag.group
}
abstract class Graphics<C : Graphics.Context> : Drawer<SVGSVGElement, C>() {
    abstract class Context(element: SVGSVGElement) : AbstractContext<SVGSVGElement>(element)
    override val tag = Tag.graphics
}
abstract class Group<C : Group.Context> : Drawer<SVGGElement, C>() {
    abstract class Context(element: SVGGElement) : AbstractContext<SVGGElement>(element)
    override val tag = Tag.group
}
abstract class Line<C : Line.Context> : Drawer<SVGLineElement, C>() {
    abstract class Context(element: SVGLineElement) : AbstractContext<SVGLineElement>(element)
    override val tag = Tag.line
}
