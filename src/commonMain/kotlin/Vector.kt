import kotlin.math.sqrt

data class Vector(
    /** Horizontal coordinate. */
    val x: Double = 0.0,

    /** Vertical coordinate. */
    val y: Double = 0.0
) {
    val length get() = sqrt(x.pow2 + y.pow2)

    fun distance(that: Vector) = (that - this).length

    operator fun minus(that: Vector) = Vector(x - that.x, y - that.y)

    operator fun plus(that: Vector) = Vector(x + that.x, y + that.y)

    operator fun times(multiplier: Double) = Vector(multiplier * x, multiplier * y)

    override fun toString() = "($x, $y)"

    fun weightedPlus(thisWeight: Double, that: Vector, thatWeight: Double) =
        Vector(thisWeight * x + thatWeight * that.x, thisWeight * y + thatWeight * that.y)

    companion object {
        val ZERO = Vector(0.0, 0.0)
    }
}