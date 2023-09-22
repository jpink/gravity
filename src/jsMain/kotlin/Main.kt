import dom.*
import dom.svg.*
import math.Vector
import renderer.renderer
import space.*

fun main() {
    val svg = body {
        svg {
            width("100%")
            height("100%")
            viewBox(EARTH_MOON_DISTANCE / 20)
        }
    }
    val earth = svg.renderer(EARTH.copy(velocity = Vector(1538088.0,1338088.0)))
    val moon = svg.renderer(MOON.copy(velocity = Vector(154808.0,1538088.0)))
    //window.setInterval({   }, 2000)
}
