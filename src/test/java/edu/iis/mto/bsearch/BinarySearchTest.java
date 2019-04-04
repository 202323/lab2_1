package edu.iis.mto.bsearch;

import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTest {

    int key;
    int [] seq = {5};
    int [] seq2 = {5, 12, 66, 194, 199};
    int [] emptySeq = {};
    SearchResult result;

    @Test
    void isInSequenceTest() {
        key = 5;
        result = BinarySearch.search(key, seq);
        assertTrue(result.isFound());
        assertEquals(result.getPosition(), 1);
    }

    @Test
    void isNotInSequenceTest() {
        key = 0;
        result = BinarySearch.search(key, seq);
        assertFalse(result.isFound());
        assertEquals(result.getPosition(), -1);
    }
}