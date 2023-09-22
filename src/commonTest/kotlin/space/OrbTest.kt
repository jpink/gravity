package space

import math.Vector
import kotlin.test.*

class OrbTest {
    @Test
    fun distance_earthVsMoon() {
        assertEquals(EARTH_MOON_DISTANCE, EARTH.distance(MOON))
        assertEquals(EARTH_MOON_DISTANCE, MOON.distance(EARTH))
    }

    @Test
    fun gravity_earthVsMoon_2E20() {
        assertEquals(EARTH_MOON_GRAVITY, EARTH.gravity(MOON))
        assertEquals(1.90100221959206E20, MOON.gravity(EARTH))
    }

    @Test
    fun impact_earthVsMoon_false() {
        assertFalse(EARTH.impact(MOON))
    }

    @Test
    fun impact_hugeEarthVsMoon_true() {
        assertTrue(EARTH.copy(mass = 1000000 * EARTH_MASS).impact(MOON))
    }

    @Test
    fun plus_earthAndMoon() {
        val orb = EARTH + MOON
        assertEquals(Vector(4768133.646868944), orb.location)
        assertEquals(EARTH_MASS + MOON_MASS, orb.mass)
        assertEquals(5472.006889199539, orb.density)
        assertEquals(Vector.ZERO, orb.velocity)
    }

    @Test
    fun radius_earth_6371E3() {
        assertEquals(6370818.309903006, EARTH.radius)
    }

    @Test
    fun radius_moon_1737E3() {
        assertEquals(1738088.7529881808, MOON.radius)
    }
}