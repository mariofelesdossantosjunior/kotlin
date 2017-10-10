/*
 * Copyright 2010-2017 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package test.numbers

import org.junit.Test
import kotlin.math.*
import kotlin.test.*

fun assertAlmostEquals(expected: Double, actual: Double, tolerance: Double? = null) {
    val tolerance_ = tolerance?.let { abs(it) } ?: 0.000000000001
    if (abs(expected - actual) > tolerance_) {
        assertEquals(expected, actual)
    }
}

class DoubleMathTest {

    @Test fun trigonometric() {
        assertEquals(0.0, sin(0.0))
        assertAlmostEquals(0.0, sin(PI))

        assertEquals(0.0, asin(0.0))
        assertAlmostEquals(PI / 2, asin(1.0))

        assertEquals(1.0, cos(0.0))
        assertAlmostEquals(-1.0, cos(PI))

        assertEquals(0.0, acos(1.0))
        assertAlmostEquals(PI / 2, acos(0.0))

        assertEquals(0.0, tan(0.0))
        assertAlmostEquals(1.0, tan(PI / 4))

        assertAlmostEquals(0.0, atan(0.0))
        assertAlmostEquals(PI / 4, atan(1.0))

        assertAlmostEquals(PI / 4, atan2(10.0, 10.0))
        assertAlmostEquals(-PI / 4, atan2(Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY))
        assertAlmostEquals(0.0, atan2(0.0, 0.0))
        assertAlmostEquals(0.0, atan2(0.0, 10.0))
        assertAlmostEquals(PI / 2, atan2(2.0, 0.0))

        for (angle in listOf(Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY)) {
            assertTrue(sin(angle).isNaN(), "sin($angle)")
            assertTrue(cos(angle).isNaN(), "cos($angle)")
            assertTrue(tan(angle).isNaN(), "tan($angle)")
        }

        for (value in listOf(Double.NaN, 1.2, -1.1)) {
            assertTrue(asin(value).isNaN())
            assertTrue(acos(value).isNaN())
        }
        assertTrue(atan(Double.NaN).isNaN())
        assertTrue(atan2(Double.NaN, 0.0).isNaN())
        assertTrue(atan2(0.0, Double.NaN).isNaN())
    }

    @Test fun hyperbolic() {
        assertEquals(Double.POSITIVE_INFINITY, sinh(Double.POSITIVE_INFINITY))
        assertEquals(Double.NEGATIVE_INFINITY, sinh(Double.NEGATIVE_INFINITY))
        assertTrue(sinh(Double.NaN).isNaN())

        assertEquals(Double.POSITIVE_INFINITY, cosh(Double.POSITIVE_INFINITY))
        assertEquals(Double.POSITIVE_INFINITY, cosh(Double.NEGATIVE_INFINITY))
        assertTrue(cosh(Double.NaN).isNaN())

        assertAlmostEquals(1.0, tanh(Double.POSITIVE_INFINITY))
        assertAlmostEquals(-1.0, tanh(Double.NEGATIVE_INFINITY))
        assertTrue(tanh(Double.NaN).isNaN())
    }

    @Test fun powers() {
        assertEquals(5.0, hypot(3.0, 4.0))
        assertEquals(Double.POSITIVE_INFINITY, hypot(Double.NEGATIVE_INFINITY, Double.NaN))
        assertEquals(Double.POSITIVE_INFINITY, hypot(Double.NaN, Double.POSITIVE_INFINITY))
        assertTrue(hypot(Double.NaN, 0.0).isNaN())

        assertEquals(1.0, pow(Double.NaN, 0.0))
        assertEquals(1.0, Double.POSITIVE_INFINITY.pow(0))
        assertEquals(49.0, pow(7.0, 2))
        assertEquals(0.25, pow(2.0, -2))
        assertTrue(pow(0.0, Double.NaN).isNaN())
        assertTrue(pow(Double.NaN, -1).isNaN())
        assertTrue(pow(-7.0, 1/3.0).isNaN())
        assertTrue(pow(1.0, Double.POSITIVE_INFINITY).isNaN())
        assertTrue(pow(-1.0, Double.NEGATIVE_INFINITY).isNaN())

        assertEquals(5.0, sqrt(9.0 + 16.0))
        assertTrue(sqrt(-1.0).isNaN())
        assertTrue(sqrt(Double.NaN).isNaN())

        assertTrue(exp(Double.NaN).isNaN())
        assertAlmostEquals(E, exp(1.0))
        assertEquals(1.0, exp(0.0))
        assertEquals(0.0, exp(Double.NEGATIVE_INFINITY))
        assertEquals(Double.POSITIVE_INFINITY, exp(Double.POSITIVE_INFINITY))

        assertEquals(0.0, expm1(0.0))
        assertEquals(-1.0, expm1(Double.NEGATIVE_INFINITY))
        assertEquals(Double.POSITIVE_INFINITY, expm1(Double.POSITIVE_INFINITY))
    }

    @Test fun logarithms() {
        assertTrue(log(1.0, Double.NaN).isNaN())
        assertTrue(log(Double.NaN, 1.0).isNaN())
        assertTrue(log(-1.0, 2.0).isNaN())
        assertTrue(log(2.0, -1.0).isNaN())
        assertTrue(log(2.0, 0.0).isNaN())
        assertTrue(log(2.0, 1.0).isNaN())
        assertTrue(log(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY).isNaN())
        assertEquals(-2.0, log(0.25, 2.0))
        assertEquals(-0.5, log(2.0, 0.25))
        assertEquals(Double.NEGATIVE_INFINITY, log(Double.POSITIVE_INFINITY, 0.25))
        assertEquals(Double.POSITIVE_INFINITY, log(Double.POSITIVE_INFINITY, 2.0))
        assertEquals(Double.NEGATIVE_INFINITY, log(0.0, 2.0))
        assertEquals(Double.POSITIVE_INFINITY, log(0.0, 0.25))

        assertTrue(log(Double.NaN).isNaN())
        assertTrue(log(-1.0).isNaN())
        assertEquals(1.0, log(E))
        assertEquals(Double.NEGATIVE_INFINITY, log(0.0))
        assertEquals(Double.POSITIVE_INFINITY, log(Double.POSITIVE_INFINITY))

        assertEquals(1.0, log10(10.0))
        assertAlmostEquals(-1.0, log10(0.1))

        assertAlmostEquals(3.0, log2(8.0))
        assertEquals(-1.0, log2(0.5))

        assertTrue(log1p(Double.NaN).isNaN())
        assertTrue(log1p(-1.1).isNaN())
        assertEquals(0.0, log1p(0.0))
        assertEquals(Double.NEGATIVE_INFINITY, log1p(-1.0))
    }

    @Test fun rounding() {
        TODO()
    }


}

