package com.vc.medium;

class L33 {
    public int search(int[] arr, int target) {
        int lo = 0;
        int hi = arr.length - 1;
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if(arr[mid] == target) return mid;

            if(arr[lo] == arr[mid] && arr[hi] == arr[mid]) {
                lo++; hi--;
            }
            else if(arr[lo] <= arr[mid]) {
                if(arr[lo] <= target && arr[mid] > target) hi = mid - 1;
                else lo = mid + 1;
            }
            else {
                if(arr[mid] < target && arr[hi] >= target) lo = mid + 1;
                else hi = mid - 1;
            }
        }
        return -1;
    }
}
