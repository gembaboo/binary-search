package org.gembaboo.binarysearch;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertSame;

public class BinarySearchTest {


    private BinarySearch binarySearch;


    @Test(expected = IllegalArgumentException.class)
    public void WhenNullArray_ThrowsIllegalArgumentException() {
        binarySearch.getPosition(0, null);
    }

    @Test
    public void WhenEmptyArray_ReturnsMinusOne() {

        int position = binarySearch.getPosition(0, new int[0]);
        assertSame(position, -1);

    }


    @Before
    public void setUp() {
        binarySearch = new BinarySearch();
    }


}
