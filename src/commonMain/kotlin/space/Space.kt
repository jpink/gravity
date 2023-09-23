package space

import kotlin.math.abs

/** Two-dimensional space */
class Space(val orbs: MutableList<Orb>) {
    data class View(val minX: Double, val minY: Double, val maxX: Double, val maxY: Double) {
        val width get() = abs(minX) + abs(maxX)
        val height get() = abs(minY) + abs(maxY)
    }

    var view = countView()

    private fun countView(): View {
        var minX = -1.0
        var minY = -1.0
        var maxX = 1.0
        var maxY = 1.0
        orbs.forEach {
            it.location.apply {
                if (x < minX) minX = x
                else if (maxX < x) maxX = x
                if (y < minY) minY = y
                else if (maxY < y) maxY = y
            }
        }
        return View(minX, minY, maxX, maxY)
    }
}