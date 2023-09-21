import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

class GravityTest {
    @Test
    fun scientificNotation() {
        assertEquals(6_371_000.0, 6.371E6)
    }

    @Test
    fun gravity_baseUnits_G() {
        assertEquals(GRAVITATIONAL, gravity(1.0, 1.0, 1.0))
    }

    // https://planetariodevitoria.org/fi/espaco/qual-a-forca-de-atracao-entre-a-terra-ea-lua.html
    // About 2.0E20 N
    @Test
    fun gravity_earthVsMoon_2E20() {
        assertEquals(EARTH_MOON_GRAVITY, gravity(EARTH_MASS, MOON_MASS, EARTH_MOON_DISTANCE))
    }

    @Test
    fun orderOfOperations() {
        val expected = 2.0 * ((3.0 * 4.0) / (4.0 * 5.0))
        assertEquals(1.2, expected)
        assertEquals(expected, 2.0 * (3.0 * 4.0) / (4.0 * 5.0))
        assertEquals(expected, 2.0 * 3.0 * 4.0 / (4.0 * 5.0))
        assertNotEquals(expected, 2.0 * 3.0 * 4.0 / 4.0 * 5.0)
    }
}