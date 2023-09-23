import drawer.SpaceGraphics
import kotlinx.browser.document
import math.Point
import space.*

fun main() {
    val space = solarSystem()
    space.orbs[0].apply {
        val r = radius
        velocity = Point(r, r)
    }
    val graphics = SpaceGraphics(space)
    graphics.show(document.body!!)
    //window.setInterval({   }, 2000)
}
