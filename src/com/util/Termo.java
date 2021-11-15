package com.util;

import java.util.ArrayList;

import static com.util.StringUtil.countChar;
import static com.util.StringUtil.fillString;

public class Termo {
    private int num;
    private String bin;
    private String exp;
    private int oneCount;
    private ArrayList<Integer> hist = new ArrayList<>();

    public Termo(int num, int size) {
        this.setNum(num);
        String temp = Integer.toBinaryString(num);
        temp = fillString("0", temp, size);
        this.setBin(temp);
        this.setOneCount(countChar(getBin(), '1'));
        this.addHist(num);
    }
    public Termo(){}

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
        setExp();
    }

    public int getOneCount() {
        return oneCount;
    }

    public void setOneCount(int oneCount) {
        this.oneCount = oneCount;
    }

    public ArrayList<Integer> getHist() {
        return hist;
    }

    public void setHist(ArrayList<Integer> hist){
        this.hist = hist;
    }

    public void addHist(int var) {
        this.hist.add(var);
    }
    public String getString(){
        if(hist.size() > 1){
            StringBuilder temp = new StringBuilder();
            for(int i = 0; i < hist.size(); i++){
                temp.append(hist.get(i));
                if(i < hist.size() - 1){
                    temp.append(", ");
                }
            }
            return temp.toString();
        }else{
            return Integer.toString(num);
        }
    }

    public String getExp() {
        return exp;
    }

    public void setExp() {
        this.exp = "";
        for(int i  = 0; i < getBin().length(); i++){
            if(getBin().charAt(i) != '_'){
                if(getBin().charAt(i) == '1'){
                    this.exp = this.exp + (Character.toString(65 + i));
                }else{
                    this.exp = this.exp + (Character.toString(65 + i));
                    this.exp = this.exp + "`";
                }
            }
        }
    }
}
