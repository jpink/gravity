package math

data class Vector(val initial: Point, val terminal: Point) {
    val length get() = (terminal - initial).length
}