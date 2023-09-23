package dom.svg

import kotlinx.browser.document
import org.w3c.dom.svg.SVGCircleElement
import org.w3c.dom.svg.SVGElement
import org.w3c.dom.svg.SVGGElement
import org.w3c.dom.svg.SVGLineElement
import org.w3c.dom.svg.SVGSVGElement

value class Tag<E : SVGElement>(private val name: String) {
    @Suppress("UNCHECKED_CAST")
    fun create() = document.createElementNS("http://www.w3.org/2000/svg", name) as E

    fun create(builder: E.() -> Unit) = create().apply(builder)

    companion object {
        val circle = Tag<SVGCircleElement>("circle")
        val graphics = Tag<SVGSVGElement>("svg")
        val group = Tag<SVGGElement>("g")
        val line = Tag<SVGLineElement>("line")
    }
}