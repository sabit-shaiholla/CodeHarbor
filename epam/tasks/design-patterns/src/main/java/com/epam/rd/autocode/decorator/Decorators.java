package com.epam.rd.autocode.decorator;

import java.util.*;

public class Decorators {
    private Decorators() {}
    public static List<String> evenIndexElementsSubList(List<String> sourceList) {
        return new EvenIndexElementsSubListDecorator(sourceList);
    }

    private static class EvenIndexElementsSubListDecorator extends AbstractList<String> {
        private final List<String> sourceList;

        private EvenIndexElementsSubListDecorator(List<String> sourceList) {
            this.sourceList = sourceList;
        }

        @Override
        public String get(int index) {
            if (index < 0 || index >= size() || index * 2 >= sourceList.size()) {
                throw new IndexOutOfBoundsException("Invalid index");
            }
            return sourceList.get(index * 2);
        }

        @Override
        public int size() {
            return (sourceList.size() + 1) / 2;
        }

        @Override
        public Iterator<String> iterator() {
            return new Iterator<>() {
                private int currentIndex = 0;

                @Override
                public boolean hasNext() {
                    return currentIndex < size();
                }

                @Override
                public String next() {
                    if (!hasNext()) {
                        throw new NoSuchElementException("No more elements");
                    }
                    return sourceList.get(currentIndex++ * 2);
                }
            };
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            EvenIndexElementsSubListDecorator that = (EvenIndexElementsSubListDecorator) o;

            return Objects.equals(sourceList, that.sourceList);
        }

        @Override
        public int hashCode() {
            return Objects.hash(sourceList);
        }
    }
}
