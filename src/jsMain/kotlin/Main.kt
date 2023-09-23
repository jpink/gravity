import drawer.SpaceGraphics
import kotlinx.browser.document
import space.*

fun main() {
    val space = solarSystem()
    val graphics = SpaceGraphics(space)
    graphics.show(document.body!!)
    //window.setInterval({   }, 2000)
}
