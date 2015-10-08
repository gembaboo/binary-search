package org.gembaboo.binarysearch;

import org.junit.Test;

import static org.gembaboo.binarysearch.BinarySearch.getPosition;
import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;

public class BinarySearchTest {


    @Test(expected = IllegalArgumentException.class)
    public void WhenNullArray_ThrowsIllegalArgumentException() {
        getPosition(0, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void WhenWrongOrderedArray_ThrowsIllegalArgumentException() {
        getPosition(0, new int[]{3, 4, 6, 2, 5});
    }

    @Test(expected = IllegalArgumentException.class)
    public void WhenArrayWithUninitializedMiddleElement_ThrowsIllegalArgumentException() {
        int[] array = new int[5];
        for (int i = 0; i < 5; i++) {
            // for the third element keep it zero
            if (i == 3)
                continue;
            array[i] = i;
        }
        getPosition(0, array);
    }

    @Test
    public void WhenEmptyArray_ReturnsMinus1() {
        int position = getPosition(0, new int[0]);
        assertSame(-1, position);
    }


    @Test
    public void WithOneElementAndValueGreater_ReturnsLength() {
        int position = getPosition(5, new int[]{2});
        assertSame(1, position);
    }

    @Test
    public void WithOneNegativeElementsAndValueGreater_ReturnsLength() {
        int position = getPosition(5, new int[]{-2});
        assertSame(1, position);
    }

    @Test
    public void WithOneElementsAndValueSmaller_ReturnsMinus1() {
        int position = getPosition(1, new int[]{2});
        assertSame(-1, position);
    }

    @Test
    public void WithOneNegativeElementAndValueSmaller_ReturnsMinus1() {
        int position = getPosition(-3, new int[]{-2});
        assertSame(-1, position);
    }

    @Test
    public void WithTwoElementsAndValueSmaller_ReturnsMinus1() {
        int position = getPosition(1, new int[]{2, 3});
        assertSame(-1, position);
    }


    @Test
    public void WithTwoNegativeElementsAndValueSmaller_ReturnsMinus1() {
        int position = getPosition(-3, new int[]{-2, -1});
        assertSame(-1, position);
    }


    @Test
    public void WithTwoElementsAndValueGreater_ReturnsLength() {
        int position = getPosition(5, new int[]{2, 3});
        assertSame(2, position);
    }


    @Test
    public void WithTwoNegativeElementsAndValueGreater_ReturnsLength() {
        int position = getPosition(0, new int[]{-3, -2});
        assertSame(2, position);
    }

    @Test
    public void WithTwoElementsAndElementEqual_ReturnsEqualElementPosition1() {
        int position = getPosition(3, new int[]{2, 3});
        assertSame(1, position);
    }


    @Test
    public void WithTwoElementsAndElementEqual_ReturnsEqualElementPosition2() {
        int position = getPosition(2, new int[]{2, 3});
        assertSame(0, position);
    }


    @Test
    public void WithTwoElementsAndElementEqual_ReturnsEqualElementPosition3() {
        int position = getPosition(4, new int[]{2, 3, 4, 5, 6});
        assertSame(2, position);
    }

    @Test
    public void WithTwoElementsAndElementEqual_ReturnsEqualElementPosition4() {
        int position = getPosition(5, new int[]{2, 3, 4, 5, 5, 5, 6});
        assertThat(position, anyOf(equalTo(3), equalTo(4), equalTo(5)));
    }


}
