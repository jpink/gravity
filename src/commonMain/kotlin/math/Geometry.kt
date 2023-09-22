package math

import kotlin.math.PI
import kotlin.math.cbrt

/**
 * Counts the radius (r) of the sphere from volume r = ∛( 3 * V / (4 * π) ).
 *
 * @param volume The volume (V) of the sphere in cubic meters (m³).
 * @return The radius (r) of the sphere in meters (m).
 */
fun sphereRadius(volume: Double) = cbrt(3 * volume / (4 * PI))
