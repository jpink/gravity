package physics

import math.pow2

/** [Gravitational constant](https://en.wikipedia.org/wiki/Gravitational_constant) (N * m² / kg²). */
const val GRAVITATIONAL = 6.674E-11

/**
 * Counts gravity force (F = G * m1 * m2 / r²).
 *
 * @param mass1 The mass (m1) of body 1 in kilograms (kg).
 * @param mass2 The mass (m2) of body 2 in kilograms (kg).
 * @param distance The distance (r) of bodies in meters (m).
 * @return The attractive force (F) in newtons (N).
 */
fun gravity(mass1: Double, mass2: Double, distance: Double) = GRAVITATIONAL * mass1 * mass2 / distance.pow2


