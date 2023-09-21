data class Velocity(
    /** (Positive) speed in m/s. */
    val speed: Double = 0.0,

    /** Direction coordinates in meters. */
    val direction: Coordinates = Coordinates.ORIGIN,
) {
    companion object {
        val STILL = Velocity()
    }
}
