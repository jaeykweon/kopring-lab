package org.idd.kopringlab.`object`

import javax.annotation.PostConstruct

open class FirstClass {
    private val test = FirstInnerClass()

    init {
        println("4. FirstClass init")
    }

    @PostConstruct
    fun firstPostConstruct() {
        println("6. FirstClass postConstruct")
    }

    class FirstInnerClass() {
        init {
            println("3. FirstInnerClass init")
        }
    }

    companion object {
        init {
            println("1. FirstClass companion object init")
        }

        @PostConstruct
        @JvmStatic
        fun firstClassCompanionObjectPostConstruct() {
            println("7. FirstClass companion object postConstruct")
        }
    }
}
