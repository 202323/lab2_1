package edu.iis.mto.bsearch;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

import static org.junit.Assert.*;

public class BinarySearchTest {
    /** How about creating a class with those variables? **/
    private int valueInSequence = 5;
    private int valueNotInSequence = 0;
    private int valueMiddleInSequence = 15;
    private int [] sizeOneSequence = {5};
    private int [] sizeFiveSequence = {5, 12, 66, 194, 199};
    private int [] emptySequence = {};
    private SearchResult result;
    
    @Test
    public void isInSequenceTest() {
        result = BinarySearch.search(valueInSequence, sizeOneSequence);
        assertTrue(result.isFound());
        assertThat(result.getPosition(),is(equalTo(1)));
    }

    @Test
    public void isNotInSequenceTest() {
        result = BinarySearch.search(valueNotInSequence, sizeOneSequence);
        assertFalse(result.isFound());
        assertThat(result.getPosition(),is(equalTo(-1)));
    }

    @Test
    public void isFirstInSequenceTest() {
        result = BinarySearch.search(sizeFiveSequence[0], sizeFiveSequence);
        assertTrue(result.isFound());
        assertThat(result.getPosition(),is(equalTo(1)));
    }

    @Test
    public void isLastInSequenceTest() {
        result = BinarySearch.search(sizeFiveSequence[sizeFiveSequence.length-1], sizeFiveSequence);
        assertTrue(result.isFound());
        assertThat(result.getPosition(), is(equalTo(sizeFiveSequence.length)));
    }

    @Test
    public void isMiddleInSequenceTest() {
        result = BinarySearch.search(valueMiddleInSequence, sizeFiveSequence);
        assertTrue(result.isFound());
        assertThat(result.getPosition(), is(equalTo((sizeFiveSequence.length/2)+1)));
    }

    @Test
    public void isNotInNonSingularSequenceTest() {
        result = BinarySearch.search(valueNotInSequence, sizeFiveSequence);
        assertFalse(result.isFound());
        assertThat(result.getPosition(),is(equalTo(-1)));
    }

    @Test
    public void emptySequenceExceptionTest(){
        try{
            BinarySearch.sequenceCheck(emptySequence);
            fail("expected IllegalArgumentException");
        }catch(IllegalArgumentException e) {/**success**/}
    }

}