package com.util;

import static com.util.StringUtil.countChar;
import static com.util.StringUtil.fillString;

public class Termo {
    private int num;
    private String bin;
    private int oneCount;

    public Termo(int num, int size) {
        this.setNum(num);
        String temp = Integer.toBinaryString(num);
        temp = fillString("0", temp, size);
        this.setBin(temp);
        this.setOneCount(countChar(getBin(), '1'));
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getBin() {
        return bin;
    }

    public void setBin(String bin) {
        this.bin = bin;
    }

    public int getOneCount() {
        return oneCount;
    }

    public void setOneCount(int oneCount) {
        this.oneCount = oneCount;
    }
}
