package space

import math.*
import physics.*

/** Astronomical object, a body in the space. */
class Orb(
    /** Coordinates in meters (m). */
    var location: Vector = Vector.ZERO,

    /** Mass (m) in kilograms (kg). */
    var mass: Double = 0.0,

    /** Density (ρ = m/V) in kilograms (kg) per cubic meters (m³). */
    var density: Double = WATER_DENSITY,

    /** Velocity (v) in meter/seconds (m/s). */
    var velocity: Vector = Vector.ZERO
) {
    /** Radius (r) in meters (m). */
    val radius get() = sphereRadius(volume)

    val volume get() = mass / density

    fun acceleration(gravity: Double) = gravity / mass

    fun copy(
        location: Vector = this.location,
        mass: Double = this.mass,
        density: Double = this.density,
        velocity: Vector = this.velocity
    ) = Orb(location, mass, density, velocity)

    fun distance(that: Orb) = location.distance(that.location)

    fun gravity(that: Orb) = gravity(mass, that.mass, distance(that))

    fun impact(that: Orb) = distance(that) < radius + that.radius

    operator fun plus(that: Orb): Orb {
        val thatMass = that.mass
        val totalMass = mass + thatMass
        val totalVolume = volume + that.volume
        val combinedDensity = totalMass / totalVolume
        val thisWeight = mass / (totalMass)
        val thatWeight = thatMass / (totalMass)
        return Orb(
            location.weightedPlus(thisWeight, that.location, thatWeight),
            totalMass,
            combinedDensity,
            velocity.weightedPlus(thisWeight, that.velocity, thatWeight)
        )
    }

    override fun toString() = "[$location, $mass, $velocity]"

    companion object {
        const val WATER_DENSITY = 1.0E3
    }
}