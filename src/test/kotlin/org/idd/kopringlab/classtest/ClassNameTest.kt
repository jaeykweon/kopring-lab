package org.idd.kopringlab.classtest

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class ClassNameTest : DescribeSpec({

    describe("객체 내부 실행 순서 확인") {
        SecondClass()

        it("테스트 실행시 postConstruct 미적용") {
            """
            1. FirstClass companion object init
            2. SecondClass companion object init
            3. FirstInnerClass init
            4. FirstClass init
            5. SecondClass init
            """.trimIndent()
        }

        it("어플리케이션 실행 시 postConstruct 적용") {
            """
                1. FirstClass companion object init
                2. SecondClass companion object init
                3. FirstInnerClass init
                4. FirstClass init
                5. SecondClass init
                6. FirstClass companion object postConstruct
                6. FirstClass postConstruct
                7. SecondClass postConstruct
                7. SecondClass companion object postConstruct
            """.trimIndent()
        }
    }

    describe("class name test") {
        FirstClass::class.java.simpleName shouldBe "FirstClass"
        FirstClass::class.simpleName!! shouldBe "FirstClass"
        FirstClass::javaClass.name shouldBe "javaClass"
    }
})
