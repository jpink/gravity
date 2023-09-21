/** Direction in two dimensions. */
data class Coordinates(
    /** Horizontal coordinate. */
    val x: Double,

    /** Vertical coordinate. */
    val y: Double
) {
    override fun toString() = "($x, $y)"

    companion object {
        val ORIGIN = Coordinates(0.0, 0.0)
    }
}