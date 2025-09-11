package edu.kirkwood.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class FractionTest {

    private Fraction f1;
    private Fraction f2;

    @BeforeEach
    void setUp() {
        f1 = new Fraction();
        f2 = new Fraction(2, 3);
    }

    @Test
    void getNumerator() {
        assertEquals(1, f1.getNumerator());
        assertEquals(2, f2.getNumerator());
    }

    @Test
    void setNumerator() {
        f1.setNumerator(2); // Was 1
        assertEquals(2, f1.getNumerator());
        f2.setNumerator(0); // Was 2
        assertEquals(0, f2.getNumerator());
        f1.setNumerator(-1);
        assertEquals(-1, f1.getNumerator());
    }

    @Test
    void getDenominator() {
        assertEquals(1, f1.getDenominator());
        assertEquals(3, f2.getDenominator());
    }

    @Test
    void setDenominatorPostiveDenominator() {
        f1.setDenominator(2); // Was 1
        assertEquals(1, f1.getNumerator());
        assertEquals(2, f1.getDenominator());
    }

    @Test
    void setDenominatorNegativeDenominator() {
        f1.setDenominator(-1); // Was 1
        assertEquals(-1, f1.getNumerator(), "A negative denominator should be applied to the numerator");
        assertEquals(1, f1.getDenominator());
        f1.setDenominator(-1); // Was 1
        assertEquals(1, f1.getNumerator(), "-1/1 changed to -1/-1 should become 1/1");
        assertEquals(1, f1.getDenominator());
    }

    @Test
    void setDenominatorZeroDenominator() {
        assertThrows(ArithmeticException.class, () -> f1.setDenominator(0));
    }

    @Test
    void testToString() {
        assertEquals("1/1", f1.toString());
        assertEquals("2/3", f2.toString());
    }

    @Test
    void compareTo() {
        fail();
    }

    @Test
    void gcd() {
        assertEquals(15, Fraction.gcd(75, 45));
        assertEquals(2, Fraction.gcd(2, 4));
        assertEquals(1, Fraction.gcd(5, 7));
    }

    @Test
    void gcdWithNegatives() {
        assertEquals(3, Fraction.gcd(15, 6));
        assertEquals(3, Fraction.gcd(-15, 6));
        assertEquals(3, Fraction.gcd(15, -6));
        assertEquals(3, Fraction.gcd(-15, -6));
    }

    @Test
    @DisplayName("Test LCM with two positive integers")
    void testLcmWithPositiveIntegers() {
        assertEquals(24, Fraction.lcm(6, 8));
    }

    @Test
    @DisplayName("Test LCM where one number is a multiple of the other")
    void testLcmWithMultiple() {
        assertEquals(12, Fraction.lcm(4, 12));
    }

    @Test
    @DisplayName("Test LCM with two prime numbers")
    void testLcmWithPrimes() {
        // The lcm of two prime numbers is their product.
        assertEquals(77, Fraction.lcm(7, 11));
    }

    @Test
    @DisplayName("Test LCM with the number 1")
    void testLcmWithOne() {
        assertEquals(9, Fraction.lcm(1, 9));
        assertEquals(9, Fraction.lcm(9, 1));
    }

    @Test
    @DisplayName("Test LCM with identical numbers")
    void testLcmWithIdenticalNumbers() {
        assertEquals(5, Fraction.lcm(5, 5));
    }

    @Test
    @DisplayName("Test LCM where one of the inputs is zero")
    void testLcmWithZero() {
        assertEquals(0, Fraction.lcm(10, 0));
        assertEquals(0, Fraction.lcm(0, 10));
        assertEquals(0, Fraction.lcm(0, 0));
    }

    @Test
    void simplify() {
        fail();
    }

    @Test
    void toMixedNumber() {
        fail();
    }

    @Test
    @DisplayName("Test 1/1 + 2/3 = 5/3")
    void addWholeNumberToFraction() {
        Fraction f3 = f1.add(f2);
        assertEquals(5, f3.getNumerator());
        assertEquals(3, f3.getDenominator());
    }

    @Test
    @DisplayName("Test 1/4 + 2/3 = 5/12")
    void addNegativeFractionToPositive() {
        f1 = new Fraction(-1, 4);
        Fraction f3 = f1.add(f2);
        assertEquals(5, f3.getNumerator());
        assertEquals(12, f3.getDenominator());
    }

    @Test
    @DisplayName("Test 1/4 + 1/4 = 1/2")
    void addFractionsThatNeedSimplification() {
        f1 = new Fraction(1, 4);
        f2 = new Fraction(1, 4);
        Fraction f3 = f1.add(f2);
        assertEquals(1, f3.getNumerator());
        assertEquals(2, f3.getDenominator());
    }

    @Test
    void subtract() {
        fail();
    }

    @Test
    void multiply() {
        fail();
    }

    @Test
    @DisplayName("Test 2/3 * 4/5 = 8/15")
    void multiplyTwoFractions() {
        f1 = new Fraction(2, 3);
        f2 = new Fraction(4, 5);
        Fraction f3 = f1.multiply(f2);
        assertEquals(8, f3.getNumerator());
        assertEquals(15, f3.getDenominator());
    }

    @Test
    @DisplayName("Test -2/3 * 4/5 = -8/15")
    void multiplyTwoFractionsOneNumeratorNegative() {
        f1 = new Fraction(-2, 3);
        f2 = new Fraction(4, 5);
        Fraction f3 = f1.multiply(f2);
        assertEquals(-8, f3.getNumerator());
        assertEquals(15, f3.getDenominator());
    }

    @Test
    @DisplayName("Test 2/3 * 4/-5 = -8/15")
    void multiplyTwoFractionsOneDenominatorNegative() {
        f1 = new Fraction(2, 3);
        f2 = new Fraction(4, -5);
        Fraction f3 = f1.multiply(f2);
        assertEquals(-8, f3.getNumerator());
        assertEquals(15, f3.getDenominator());
    }

    @Test
    void divide() {
        fail();
    }
}