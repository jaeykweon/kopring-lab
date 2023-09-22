package org.idd.kopringlab.distance

import kotlin.math.acos
import kotlin.math.cos
import kotlin.math.sin

/**
 * https://www.w3resource.com/java-exercises/basic/java-basic-exercise-36.php
 */
class DistanceCalculator {

    /**
     * @return distance between two coordinates (meter)
     */
    fun measureTwoCoordinatesInMeter(
        _lat1: Double,
        _lon1: Double,
        _lat2: Double,
        _lon2: Double
    ): Double {
        val lat1 = Math.toRadians(_lat1)
        val lon1 = Math.toRadians(_lon1)
        val lat2 = Math.toRadians(_lat2)
        val lon2 = Math.toRadians(_lon2)

        val earthRadius = 6371010 // meter

        val sinX1sinX2 = sin(lat1) * sin(lat2)
        val cosX1cosX2cosY1_Y2 = cos(lat1) * cos(lat2) * cos(lon1 - lon2)
        val acosResult = acos(
            sinX1sinX2 +
                cosX1cosX2cosY1_Y2
        )

        return earthRadius * acosResult
    }
}
