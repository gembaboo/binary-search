package org.gembaboo.binarysearch;

import java.util.Arrays;

public class BinarySearch {

    /**
     * Finds the position of an value in an ordered array
     *
     * @param value the value which should be inserted
     * @param array an integer array containing non-null ordered elements.
     * @return the position of the value, where it should be inserted into the ordered array
     * In case the value is smaller than the smallest element of the array, it returns -1. The same applies when the array is empty.
     * In case the value is greater than the biggest element of the array, it returns array.length + 1.
     *
     * It throws IllegalArgumentException if the array is null, or it has null element, or its elements are not ordered.
     */
    public static int getPosition(int value, int[] array) {

        validateParameters(array);
        int lowIndex = 0;
        int highIndex = array.length;
        int position = -1;

        while (lowIndex < highIndex) {

            position = lowIndex + Math.round((float) (highIndex - lowIndex) / 2f) - 1;
            int element = array[position];
            if (position == 0 && value < element)
                return -1;
            else if (position == array.length - 1 && element < value)
                return array.length;
            else if (value < element)
                highIndex = position;
            else if (element < value)
                lowIndex = position + 1;
            else
                return position;
        }
        return position;

    }

    private static void validateParameters(int[] array) {
        if (null == array) {
            throw new IllegalArgumentException("array can not be null");
        }
        int[] sortedArray = Arrays.copyOf(array, array.length);

        Arrays.sort(sortedArray);

        if (!Arrays.deepEquals(getObjectArray(sortedArray), getObjectArray(array)))
            throw new IllegalArgumentException("array is not ordered");
    }

    private static Object[] getObjectArray(int[] array) {
        return Arrays.stream(array).mapToObj(value -> value).toArray();
    }
}
