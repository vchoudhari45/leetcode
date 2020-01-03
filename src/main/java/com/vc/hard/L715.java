package com.vc.hard;

import java.util.*;

class RangeModule {

    private TreeMap<Integer, Integer> rangeMap = new TreeMap<>();

    public void addRange(int left, int right) {
        Integer pre = rangeMap.floorKey(left);
        Integer next = rangeMap.floorKey(right);

        // System.out.println("==================================================================");
        // System.out.println("Before adding left: "+left+" right: "+right+" pre: "+pre+" next: "+next);
        // System.out.println(rangeMap);

        if(pre != null && rangeMap.get(pre) >= left) {
            left = pre;
        }

        if(next != null && rangeMap.get(next) > right) {
            right = rangeMap.get(next);
        }

        rangeMap.subMap(left, true, right, true).clear();
        rangeMap.put(left, right);

        // System.out.println("After adding left: "+left+" right: "+right+" pre: "+pre+" next: "+next);
        // System.out.println(rangeMap);
    }

    public boolean queryRange(int left, int right) {
        Integer pre = rangeMap.floorKey(left);
        if(pre != null && rangeMap.get(pre) >= right) return true;
        else return false;
    }

    public void removeRange(int left, int right) {
        Integer pre = rangeMap.floorKey(left);
        Integer next = rangeMap.floorKey(right);

        // System.out.println("==================================================================");
        // System.out.println("Before adding left: "+left+" right: "+right+" pre: "+pre+" next: "+next);
        // System.out.println(rangeMap);

        if(next != null && rangeMap.get(next) > right) {
            rangeMap.put(right, rangeMap.get(next));
        }

        if(pre != null && rangeMap.get(pre) >= left) {
            rangeMap.put(pre, left);
        }

        rangeMap.subMap(left, true, right, false).clear();

        // System.out.println("==================================================================");
        // System.out.println("After adding left: "+left+" right: "+right+" pre: "+pre+" next: "+next);
        // System.out.println(rangeMap);
    }
}

/**
 * Your RangeModule object will be instantiated and called as such:
 * RangeModule obj = new RangeModule();
 * obj.addRange(left,right);
 * boolean param_2 = obj.queryRange(left,right);
 * obj.removeRange(left,right);
 */