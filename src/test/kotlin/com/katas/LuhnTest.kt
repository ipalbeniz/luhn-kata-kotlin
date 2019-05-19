package com.katas

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class LuhnTest {

    @Test
    fun `strings of length 1 or less are not valid`() {
        assertFalse(Luhn.valid(""))
        assertFalse(Luhn.valid("1"))
    }

    @Test
    fun `strings containing spaces are allowed`() {
        assertTrue(Luhn.valid(" 2 6"))
    }

    @Test
    fun `strings containing non-digit characters are not valid`() {
        assertFalse(Luhn.valid("*"))
        assertFalse(Luhn.valid("*=()"))
        assertFalse(Luhn.valid("1.1"))
        assertFalse(Luhn.valid(".1"))
        assertFalse(Luhn.valid("1."))
        assertFalse(Luhn.valid(".1."))
    }

    @Test
    fun `valid credit card numbers`() {
        assertTrue(Luhn.valid("4539 1488 0343 6467"))
        assertTrue(Luhn.valid("4024 0071 2688 3791"))
        assertTrue(Luhn.valid("5366 8538 5460 6513"))
        assertTrue(Luhn.valid("6011 1483 0022 4798"))
        assertTrue(Luhn.valid("3450 0064 5737 333"))
    }

    @Test
    fun `invalid credit card numbers`() {
        assertFalse(Luhn.valid("8273 1232 7352 0569"))
        assertFalse(Luhn.valid("3024 5074 2585 1790"))
        assertFalse(Luhn.valid("3241 3854 5712 2167"))
        assertFalse(Luhn.valid("8743 1265 2485 2548"))
        assertFalse(Luhn.valid("8754 2645 3215 5741"))
    }
}
