package org.idd.kopringlab.distance

import io.kotest.core.spec.style.ExpectSpec
import io.kotest.matchers.shouldBe

/**
 * *
 */
class DistanceCalculatorTest : ExpectSpec({

    expect("1") {
        val distanceCalculator = DistanceCalculator()

        val result = distanceCalculator.measureTwoCoordinatesInMeter(37.5497693, 126.9318415, 37.549419, 126.931662)
        result shouldBe 42.043221419494934
    }
})
