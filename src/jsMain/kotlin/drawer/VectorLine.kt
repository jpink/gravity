package drawer

import dom.svg.Line
import dom.svg.className
import dom.svg.strokeWidth
import dom.svg.transform
import math.Vector
import org.w3c.dom.svg.SVGLineElement

// https://thenewcode.com/1068/Making-Arrows-in-SVG
class VectorLine(var vector: Vector) : Line<VectorLine.Context>() {
    class Context(element: SVGLineElement) : Line.Context(element)

    override fun SVGLineElement.create(): Context {
        className("v")
        return Context(this)
    }

    override fun SVGLineElement.update(context: Context) {
        transform(vector)
        strokeWidth(vector.length / 50)
    }
}