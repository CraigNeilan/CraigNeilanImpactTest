import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumbersTest {

    private Numbers numbers;

    @BeforeEach
    void setUp() {
        numbers = new Numbers();
    }

    @Test
    void testCollectPositiveNumbers() {
        Collection<Integer> result = numbers.collect("1 4 5 6 iebfh 2 3297y ntq439t8 h4qt 324 6 647 245 tyre 5y54w");
        assertEquals(Arrays.asList(1, 2, 4, 5, 6, 8, 54, 245, 324, 439, 647, 3297), result);
    }

    @Test
    void testCollectNegativeNumbers() {
        Collection<Integer> result = numbers.collect("1 -3 5 -7 -5 5 -5 -7 -12");
        assertEquals(Arrays.asList(-12, -7, -5, -3, 1, 5), result);
    }

    @Test
    void testCollectMixedNumbers() {
        Collection<Integer> result = numbers.collect("-1 -6 iewlbfh -2 3297y ntq439t8 h4qt 324 6 647 245 tyre 5y54w");
        assertEquals(Arrays.asList(-6, -2, -1, 4, 5, 6, 8, 54, 245, 324, 439, 647, 3297), result);
    }

    @Test
    void testCollectEmptyInput() {
        Collection<Integer> result = numbers.collect("");
        assertEquals(Arrays.asList(), result);
    }

    @Test
    void testSummarizeCollectionMisc1() {
        Collection<Integer> input = Arrays.asList(-5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12);
        String expectedResult = "-5-6, 8-10, 12";
        String result = numbers.summarizeCollection(input);
        assertEquals(expectedResult, result);
    }

    @Test
    void testSummarizeCollectionMisc2() {
        Collection<Integer> input = Arrays.asList(-4, -2, 0, 1, 4, 5, 6, 7);
        String expectedResult = "-4, -2, 0-1, 4-7";
        String result = numbers.summarizeCollection(input);
        assertEquals(expectedResult, result);
    }

    @Test
    void testSummarizeCollection3() {
        Collection<Integer> input = Arrays.asList(1, 2, 3, 5, 6, 7, 9);
        String expectedResult = "1-3, 5-7, 9";
        String result = numbers.summarizeCollection(input);
        assertEquals(expectedResult, result);
    }

    @Test
    void testSummarizeCollectionMisc4() {
        Collection<Integer> input = Arrays.asList(-3, -2, -1, 1, 2, 3);
        String expectedResult = "-3--1, 1-3";
        String result = numbers.summarizeCollection(input);
        assertEquals(expectedResult, result);
    }

    @Test
    void testSummarizeCollectionMisc5() {
        Collection<Integer> input = Arrays.asList(1, 3, 5, 7);
        String expectedResult = "1, 3, 5, 7";
        String result = numbers.summarizeCollection(input);
        assertEquals(expectedResult, result);
    }
}
