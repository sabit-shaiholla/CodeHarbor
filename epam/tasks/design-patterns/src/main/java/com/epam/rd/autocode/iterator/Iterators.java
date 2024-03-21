package com.epam.rd.autocode.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

class Iterators {
    private Iterators() {}
    private static class ArrayTimesIterator implements Iterator<Integer> {
        private final int[] array;
        private final int times;
        private int index = 0;

        private ArrayTimesIterator(int[] array, int times) {
            this.array = array;
            this.times = times;
        }

        @Override
        public boolean hasNext() {
            return index < array.length * times;
        }

        @Override
        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No more elements");
            }
            int value = array[index / times];
            index++;
            return value;
        }
    }

    public static Iterator<Integer> intArrayTwoTimesIterator(int[] array){
        return new ArrayTimesIterator(array, 2);
    }

    public static Iterator<Integer> intArrayThreeTimesIterator(int[] array) {
        return new ArrayTimesIterator(array, 3);
    }

    public static Iterator<Integer> intArrayFiveTimesIterator(int[] array) {
        return new ArrayTimesIterator(array, 5);
    }

    public static Iterable<String> table(String[] columns, int[] rows){
        return () -> new Iterator<>() {
            private int colIndex = 0;
            private int rowIndex = 0;

            @Override
            public boolean hasNext() {
                return colIndex < columns.length && rowIndex < rows.length;
            }

            @Override
            public String next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("No more elements");
                }
                String cell = columns[colIndex] + rows[rowIndex];
                rowIndex++;
                if (rowIndex == rows.length) {
                    rowIndex = 0;
                    colIndex++;
                }
                return cell;
            }
        };
    }
}
