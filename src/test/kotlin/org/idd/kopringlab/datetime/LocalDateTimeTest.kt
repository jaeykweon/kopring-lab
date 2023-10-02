package org.idd.kopringlab.datetime

import io.kotest.core.spec.style.StringSpec
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.ZonedDateTime

class LocalDateTimeTest : StringSpec({

    "LocalDateTime to currentTimeMills" {
        val time = LocalDateTime.now()

        val zdt = ZonedDateTime.of(time, ZoneId.systemDefault())
        val date = zdt.toInstant().toEpochMilli()

        println(date)
        println(System.currentTimeMillis())
    }
})
