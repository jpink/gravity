package renderer

import space.Orb
import dom.svg.*
import org.w3c.dom.svg.SVGSVGElement

class OrbRenderer(private val orb: Orb, svg: SVGSVGElement) : Renderer {
    private val circle = svg.circle(orb.location, orb.radius) {
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
    }
}
