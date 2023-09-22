package dom.svg

import dom.*
import kotlinx.browser.document
import org.w3c.dom.Element
import org.w3c.dom.svg.SVGCircleElement
import org.w3c.dom.svg.SVGElement
import org.w3c.dom.svg.SVGGeometryElement
import org.w3c.dom.svg.SVGLineElement
import org.w3c.dom.svg.SVGSVGElement

@Suppress("UNCHECKED_CAST")
private fun <E : SVGElement> Element.svgElement(name: String, builder: (E.() -> Unit)? = null) =
    (document.createElementNS("http://www.w3.org/2000/svg", name) as E).also {
        builder?.invoke(it)
        append(it)
    }

fun Element.svg(builder: SVGSVGElement.() -> Unit) = svgElement("svg", builder)
fun SVGSVGElement.width(lengthOrPercentage: Any) = setAttribute("width", lengthOrPercentage)
fun SVGSVGElement.height(lengthOrPercentage: Any) = setAttribute("height", lengthOrPercentage)
fun SVGSVGElement.viewBox(radius: Double) = viewBox(-radius, -radius, 2 * radius, 2 * radius)
fun SVGSVGElement.viewBox(minX: Any, minY: Any, width: Any, height: Any) =
    setAttribute("viewBox", "$minX $minY $width $height")

fun SVGGeometryElement.fill(paint: Any) = setAttribute("fill", paint)
fun SVGGeometryElement.stroke(paint: Any) = setAttribute("stroke", paint)
fun SVGGeometryElement.strokeWidth(lengthOrPercentage: Any) = setAttribute("stroke-width", lengthOrPercentage)

fun SVGSVGElement.circle(cx: Any, cy: Any, r: Any, builder: (SVGCircleElement.() -> Unit)? = null) =
    svgElement<SVGCircleElement>("circle") {
        c(cx, cy)
        r(r)
        builder?.invoke(this)
    }
fun SVGCircleElement.c(lengthOrPercentageX: Any, lengthOrPercentageY: Any) =
    setAttributes("cx" to lengthOrPercentageX, "cy" to lengthOrPercentageY)
fun SVGCircleElement.r(lengthOrPercentage: Any) = setAttribute("r", lengthOrPercentage)

fun SVGSVGElement.line(x1: Any, y1: Any, x2: Any, y2: Any, builder: (SVGLineElement.() -> Unit)? = null) =
    svgElement<SVGLineElement>("line") {
        position(x1, y1, x2, y2)
        builder?.invoke(this)
    }
fun SVGLineElement.position(
    lengthOrPercentageX1: Any, lengthOrPercentageY1: Any,
    lengthOrPercentageX2: Any, lengthOrPercentageY2: Any
) = setAttributes(
    "x1" to lengthOrPercentageX1, "y1" to lengthOrPercentageY1,
    "x2" to lengthOrPercentageX2, "y2" to lengthOrPercentageY2)
