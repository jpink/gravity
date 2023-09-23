package drawer

import space.Orb
import dom.svg.*
import org.w3c.dom.svg.SVGCircleElement
import org.w3c.dom.svg.SVGGElement

class OrbGroup(private val orb: Orb) : BufferedGroup<OrbGroup.Context>() {
    class Context(
        element: SVGGElement,
        val circle: SVGCircleElement
    ) : Group.Context(element)

    override fun SVGGElement.create(): Context {
        className("orb")
        val circle = add(Tag.circle)
        return Context(this, circle)
    }

    override fun SVGGElement.update(context: Context) {
        context.circle.apply {
            val radius = orb.radius
            transform(orb.location, radius)
            strokeWidth(radius / 10)
        }
    }

    /*private val circle = svg.circle(orb.location, orb.radius) {
        fill("green")
        stroke("blue")
        strokeWidth("1%")
    }
    private val line = svg.line(orb.location, orb.location + orb.velocity) {
        stroke("red")
        strokeWidth("2")
    }

    override fun update() {
        circle.c(orb.location)
        line.position(orb.location, orb.location + orb.velocity)
    }*/
}
