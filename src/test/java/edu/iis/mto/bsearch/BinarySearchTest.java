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
    public void isInSequenceTest() {
        key = 5;
        result = BinarySearch.search(key, seq);
        assertTrue(result.isFound());
        assertEquals(result.getPosition(), 1);
    }

    @Test
    public void isNotInSequenceTest() {
        key = 0;
        result = BinarySearch.search(key, seq);
        assertFalse(result.isFound());
        assertEquals(result.getPosition(), -1);
    }

    @Test
    public void isFirstInSequenceTest() {
        key = seq2[0];
        result = BinarySearch.search(key, seq2);
        assertTrue(result.isFound());
        assertEquals(result.getPosition(),1);
    }

    @Test
    public void isLastInSequenceTest() {
        key = seq2[seq2.length-1];
        result = BinarySearch.search(key, seq2);
        assertTrue(result.isFound());
        assertEquals(result.getPosition(),seq2.length);
    }

    @Test
    public void isMiddleInSequenceTest() {
        key = seq2[seq2.length/2];
        result = BinarySearch.search(key, seq2);
        assertTrue(result.isFound());
        assertEquals(result.getPosition(),(seq2.length/2)+1);
    }

    @Test
    public void isNotInNonSingularSequenceTest() {
        key = 0;
        result = BinarySearch.search(key, seq2);
        assertFalse(result.isFound());
        assertEquals(result.getPosition(),-1);
    }

    @Test
    public void emptySequenceExceptionTest(){
        try{
            BinarySearch.sequenceCheck(emptySeq);
            fail("expected IllegalArgumentException");
        }catch(IllegalArgumentException e)
        {
            //success
        }
    }

}