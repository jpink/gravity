package drawer

import space.Orb
import dom.svg.*
import org.w3c.dom.svg.SVGCircleElement
import org.w3c.dom.svg.SVGGElement

class OrbGroup(private val orb: Orb) : BufferedGroup<OrbGroup.Context>() {
    class Context(
        element: SVGGElement,
        val circle: SVGCircleElement,
        val velocity: VectorLine
    ) : Group.Context(element)

    override fun SVGGElement.create(): Context {
        className("orb")
        val circle = add(Tag.circle)
        val location = orb.location
        val velocity = add(VectorLine(location.to(location + orb.velocity)))
        return Context(this, circle, velocity)
    }

    override fun SVGGElement.update(context: Context) {
        context.circle.apply {
            val radius = orb.radius
            transform(orb.location, radius)
            strokeWidth(radius / 10)
        }
    }
}
