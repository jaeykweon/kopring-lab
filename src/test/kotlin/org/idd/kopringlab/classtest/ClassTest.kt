package org.idd.kopringlab.classtest

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import kotlin.reflect.full.declaredMemberProperties

class ClassTest : DescribeSpec({

    afterEach {
        println("========")
    }

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

    describe("dto 내부 필드 데이터 확인") {

        it("SampleDto::class") {
            println(SampleDto::class.declaredMemberProperties)
            "[val org.idd.kopringlab.classtest.SampleDto.innerClass: org.idd.kopringlab.classtest.SampleDto.InnerClass, val org.idd.kopringlab.classtest.SampleDto.nonNullLongData: kotlin.Long, val org.idd.kopringlab.classtest.SampleDto.nullableLongData: kotlin.Long?, val org.idd.kopringlab.classtest.SampleDto.stringData: kotlin.String]"

            SampleDto::class.declaredMemberProperties.forEach {
                println(it.name)
                println(it.returnType)
            }
            """
                innerClass
                org.idd.kopringlab.classtest.SampleDto.InnerClass
                nonNullLongData
                kotlin.Long
                nullableLongData
                kotlin.Long?
                stringData
                kotlin.String
            """.trimIndent()
        }

        it("SampleDto::class.java") {
            SampleDto::class.java.declaredFields.forEach {
                println(it.name)
                println(it.type.simpleName)
            }
            """
                stringData
                String
                nullableLongData
                Long
                nonNullLongData
                long
                innerClass
                InnerClass
            """.trimIndent()
        }
    }
})
