package com.vc.easy;

class L1342 {
    public int numberOfSteps (int num) {
        int step = 0;
        while(num > 0) {
            if(num % 2 == 0) num /= 2;
            else num--;
            step++;
        }
        return step;
    }
}
