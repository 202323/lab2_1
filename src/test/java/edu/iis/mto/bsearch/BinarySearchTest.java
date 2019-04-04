package edu.iis.mto.bsearch;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

import static org.junit.Assert.*;

public class BinarySearchTest {

    int valueInSequence = 5;
    int valueNotInSequence = 0;
    int [] seq = {5};
    int [] seq2 = {5, 12, 66, 194, 199};
    int [] emptySeq = {};
    SearchResult result;

    @Test /*** is this one even needed? ***/
    public void isInSequenceTest() {
        result = BinarySearch.search(valueInSequence, seq);
        assertTrue(result.isFound());
        assertThat(result.getPosition(),is(equalTo(1)));
    }

    @Test
    public void isNotInSequenceTest() {
        result = BinarySearch.search(valueNotInSequence, seq);
        assertFalse(result.isFound());
        assertThat(result.getPosition(),is(equalTo(-1)));
    }

    @Test
    public void isFirstInSequenceTest() {
        result = BinarySearch.search(seq2[0], seq2);
        assertTrue(result.isFound());
        assertThat(result.getPosition(),is(equalTo(1)));
    }

    @Test
    public void isLastInSequenceTest() {
        result = BinarySearch.search(seq2[seq2.length-1], seq2);
        assertTrue(result.isFound());
        assertThat(result.getPosition(), is(equalTo(seq2.length)));
    }

    @Test
    public void isMiddleInSequenceTest() {
        result = BinarySearch.search(seq2[seq2.length/2], seq2);
        assertTrue(result.isFound());
        assertThat(result.getPosition(), is(equalTo((seq2.length/2)+1)));
    }

    @Test
    public void isNotInNonSingularSequenceTest() {
        result = BinarySearch.search(valueNotInSequence, seq2);
        assertFalse(result.isFound());
        assertThat(result.getPosition(),is(equalTo(-1)));
    }

    @Test
    public void emptySequenceExceptionTest(){
        try{
            BinarySearch.sequenceCheck(emptySeq);
            fail("expected IllegalArgumentException");
        }catch(IllegalArgumentException e) {/**success**/}
    }

}