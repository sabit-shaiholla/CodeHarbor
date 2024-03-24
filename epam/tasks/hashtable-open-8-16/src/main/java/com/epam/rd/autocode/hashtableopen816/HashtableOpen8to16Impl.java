package com.epam.rd.autocode.hashtableopen816;

import java.util.Arrays;

public class HashtableOpen8to16Impl implements HashtableOpen8to16{
    private static final int INITIAL_CAPACITY = 8;
    private static final int MAX_CAPACITY = 16;
    private static final int CAPACITY_MULTIPLIER = 2;
    private static final int CAPACITY_DIVIDER = 2;
    private static final int MIN_CAPACITY = 2;
    private static final double LOAD_FACTOR = 0.25;
    private int fullness = 0;
    private Integer[] keysFact = new Integer[INITIAL_CAPACITY];

    @Override
    public void insert(int key, Object value) {
        if (search(key) != null) {
            return;
        }

        if (fullness == MAX_CAPACITY) {
            throw new IllegalStateException("Hashtable is full");
        }

        if (fullness == size()) {
            resizeTableInteger(size() * CAPACITY_MULTIPLIER);
        }

        int place = hashPlace(key, keysFact);
        keysFact[place] = key;
        fullness++;
    }

    private int hashPlace(int key, Integer[] map) {
        int place;
        for (int i = 0; i < map.length; i++) {
            place = (Math.abs(key) + i) % map.length;
            if (map[place] == null) {
                return place;
            }
        }
        return -1;
    }

    private void resizeTableInteger(int newSize) {
        Integer[] tmpArray = Arrays.copyOf(keysFact, size());
        Integer[] newKeys = new Integer[newSize];
        Arrays.fill(newKeys, null);

        for (Integer integer : tmpArray) {
            if (integer != null) {
                int place = hashPlace(integer, newKeys);
                newKeys[place] = integer;
            }
        }

        keysFact = newKeys;
    }

    @Override
    public Object search(int key) {
        int place;
        for (int i = 0; i < size(); i++) {
            place = (Math.abs(key) + i) % size();
            if (keysFact[place] != null && keysFact[place].equals(key)) {
                return keysFact[place];
            }
        }
        return null;
    }

    @Override
    public void remove(int key) {
        int place;
        for (int i = 0; i < keysFact.length; i++) {
            place = (Math.abs(key) + i) % keysFact.length;
            if (place == -1) {
                return;
            }
            if (keysFact[place] != null && keysFact[place].equals(key)) {
                keysFact[place] = null;
                break;
            }
            if (i == keysFact.length - 1) {
                return;
            }
        }

        fullness--;
        if (fullness <= (size() * LOAD_FACTOR) && size() > MIN_CAPACITY) {
            resizeTableInteger(size() / CAPACITY_DIVIDER);
        }
    }

    @Override
    public int size() {
        return keysFact.length;
    }

    @Override
    public int[] keys() {
        return convertKeysToArray();
    }

    private int[] convertKeysToArray() {
        int[] tmp = new int[keysFact.length];
        for (int i = 0; i < tmp.length; i++) {
            if (keysFact[i] == null) {
                tmp[i] = 0;
            } else {
                tmp[i] = keysFact[i];
            }
        }
        return tmp;
    }
}
