package math

import kotlin.math.sqrt

data class Point(
    /** Horizontal coordinate. */
    val x: Double = 0.0,

    /** Vertical coordinate. */
    val y: Double = 0.0
) {
    val length get() = sqrt(x.pow2 + y.pow2)

    fun distance(that: Point) = (that - this).length

    operator fun minus(that: Point) = Point(x - that.x, y - that.y)

    operator fun plus(that: Point) = Point(x + that.x, y + that.y)

    operator fun times(multiplier: Double) = Point(multiplier * x, multiplier * y)

    fun to(terminal: Point) = Vector(this, terminal)

    override fun toString() = "($x, $y)"

    fun weightedPlus(thisWeight: Double, that: Point, thatWeight: Double) =
        Point(thisWeight * x + thatWeight * that.x, thisWeight * y + thatWeight * that.y)

    companion object {
        val ZERO = Point(0.0, 0.0)
    }
}