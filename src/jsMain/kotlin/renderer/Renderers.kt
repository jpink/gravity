package renderer

import math.Vector
import dom.svg.*
import org.w3c.dom.svg.*
import space.Orb

fun SVGSVGElement.circle(center: Vector, r: Number, builder: (SVGCircleElement.() -> Unit)? = null) =
    circle(center.x, center.y, r, builder)
fun SVGCircleElement.c(center: Vector) = c(center.x, center.y)

fun SVGSVGElement.line(start: Vector, end: Vector, builder: (SVGLineElement.() -> Unit)? = null) =
    line(start.x, start.y, end.x, end.y, builder)
fun SVGLineElement.position(start: Vector, end: Vector) = position(start.x, start.y, end.x, end.y)

fun SVGSVGElement.renderer(orb: Orb) = OrbRenderer(orb, this)
