package dom.svg

import dom.*
import math.Point
import math.Vector
import org.w3c.dom.svg.*

/** Length or percentage */
typealias LenPct = Any

fun SVGElement.className(name: String) = setAttribute("class", name)
fun <E : SVGElement> SVGElement.add(tag: Tag<E>) = tag.create().also { append(it) }
fun <E : SVGElement, C : AbstractContext<E>, D : Drawer<E, C>> SVGElement.add(drawer: D) =
    drawer.also { it.show(this) }

fun SVGSVGElement.x(x: Any) = setAttribute("x", x)
fun SVGSVGElement.y(y: Any) = setAttribute("y", y)
fun SVGSVGElement.viewBox(minX: Any, minY: Any, width: Any, height: Any) =
    setAttribute("viewBox", "$minX $minY $width $height")

fun SVGGeometryElement.strokeWidth(width: LenPct) = setAttribute("stroke-width", width)

fun SVGCircleElement.cx(centerX: LenPct) = setAttribute("cx", centerX)
fun SVGCircleElement.cy(centerY: LenPct) = setAttribute("cy", centerY)
fun SVGCircleElement.r(radius: LenPct) = setAttribute("r", radius)
fun SVGCircleElement.transform(center: Point, radius: Number) {
    cx(center.x)
    cy(center.y)
    r(radius.toInt())
}

fun SVGLineElement.x1(x: LenPct) = setAttribute("x1", x)
fun SVGLineElement.y1(y: LenPct) = setAttribute("y1", y)
fun SVGLineElement.x2(x: LenPct) = setAttribute("x2", x)
fun SVGLineElement.y2(y: LenPct) = setAttribute("y2", y)
fun SVGLineElement.transform(vector: Vector) = transform(vector.initial, vector.terminal)
fun SVGLineElement.transform(start: Point, end: Point) {
    x1(start.x)
    y1(start.y)
    x2(end.x)
    y2(end.y)
}
