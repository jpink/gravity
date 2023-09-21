import kotlinx.browser.document

val Orb.circle get() = document.createElement("circle").apply {
    setAttribute("cx", position.x.toLong().toString())
    setAttribute("cy", position.y.toLong().toString())
    setAttribute("r", radius.toLong().toString())
    setAttribute("stroke", "blue")
    setAttribute("stroke-width", "3")
    setAttribute("fill", "green")
}

fun main() {
    val left = -EARTH_RADIUS.toLong()
    val top = -EARTH_RADIUS.toLong()
    val width = EARTH_MOON_DISTANCE.toLong() * 2
    val height = EARTH_MOON_DISTANCE.toLong() * 2
    document.body?.append(document.createElement("svg").apply {
        //setAttribute("height", "1000")
        //setAttribute("width", "1000")
        setAttribute("viewBox", "$left $top $width $height")
        append(EARTH.circle)
    })
    /*document.body?.append(document.createElement("svg").apply {
        setAttribute("height", "100")
        setAttribute("width", "100")
        append(document.createElement("circle").apply {
            setAttribute("cx", "50")
            setAttribute("cy", "50")
            setAttribute("r", "40")
            setAttribute("stroke", "blue")
            setAttribute("stroke-width", "3")
            setAttribute("fill", "green")
        })
    })*/
}

fun greet() = "world"