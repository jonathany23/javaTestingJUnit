package org.jonathany23.javatests.reto2;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class FizzBuzzShould {

    @Test
    public void when_number_is_divisible_by_3() {
        assertEquals("Fizz", FizzBuzz.fizzBuzz(3));
        assertEquals("Fizz", FizzBuzz.fizzBuzz(6));
    }

    @Test
    public void when_number_is_divisible_by_5() {
        assertEquals("Buzz", FizzBuzz.fizzBuzz(5));
        assertEquals("Buzz", FizzBuzz.fizzBuzz(10));
    }

    @Test
    public void when_number_is_divisible_by_5_and_3() {
        assertEquals("FizzBuzz", FizzBuzz.fizzBuzz(15));
        assertEquals("FizzBuzz", FizzBuzz.fizzBuzz(30));
    }

    @Test
    public void when_others() {
        assertEquals("2", FizzBuzz.fizzBuzz(2));
        assertEquals("16", FizzBuzz.fizzBuzz(16));
    }
}