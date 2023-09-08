package org.idd.kopringlab.classtest

import org.springframework.stereotype.Component
import javax.annotation.PostConstruct

@Component
class SecondClass : FirstClass() {

    init {
        println("5. SecondClass init")
    }

    @PostConstruct
    fun secondPostConstruct() {
        println("7. SecondClass postConstruct")
    }

    companion object {
        init {
            println("2. SecondClass companion object init")
        }

        @PostConstruct
        @JvmStatic
        fun secondClassCompanionObjectPostConstruct() {
            println("7. SecondClass companion object postConstruct")
        }
    }
}
