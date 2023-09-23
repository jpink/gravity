package drawer

import dom.svg.*
import org.w3c.dom.svg.SVGSVGElement
import space.Space

class SpaceGraphics(private val space: Space) : Graphics<SpaceGraphics.Context>() {
    var orbGroups = space.orbs.map { OrbGroup(it) }

    class Context(element: SVGSVGElement) : Graphics.Context(element)

    override fun SVGSVGElement.create(): Context {
        className("space")
        space.view.apply {
            x(minX)
            y(minX)
            val max = maxOf(width, height)
            viewBox(minX, minY, max, max)
        }
        orbGroups.forEach { it.show(this) }
        return Context(this)
    }
}