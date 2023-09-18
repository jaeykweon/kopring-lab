package org.idd.kopringlab.classtest

data class SampleDto(
    private val stringData: String,
    private val nullableLongData: Long?,
    private val nonNullLongData: Long,
    private val innerClass: InnerClass
) {
    data class InnerClass(
        val innerData: Int
    )
}
