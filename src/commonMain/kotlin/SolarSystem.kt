// https://polku.opetus.tv/node/470

const val EARTH_DENSITY = 5_515.3
const val EARTH_MASS = 5.973_7E24
const val EARTH_MOON_GRAVITY = 1.9010022195920598E20 // counted
const val EARTH_MOON_MEAN_DISTANCE = 384.4E6
const val EARTH_RADIUS = 6.371E6
const val MOON_DENSITY = 3.34E3
const val MOON_MASS = 7.346E22
const val MOON_RADIUS = 1_737.4E3
// https://polku.opetus.tv/node/470
const val MOON_SPEED = 2.38E3

/** The distance between the centers of gravity of the earth and the moon. */
const val EARTH_MOON_DISTANCE = EARTH_RADIUS + EARTH_MOON_MEAN_DISTANCE + MOON_RADIUS

val EARTH = Orb(mass = EARTH_MASS, density = EARTH_DENSITY)

val MOON = Orb(Vector(EARTH_MOON_DISTANCE), MOON_MASS, MOON_DENSITY)