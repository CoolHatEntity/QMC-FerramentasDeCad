package com.util;

import java.util.ArrayList;

import static com.util.StringUtil.fillString;

public class TermoUtil {
    public static void imprimeTermos(ArrayList<Termo> termos){
        if(termos.size() > 0){
            int max = termos.get(getMaxValue(termos)).getNum();
            int size = (Integer.toString(max).length());
            for (Termo termo : termos) {
                String temp = fillString("0", Integer.toString(termo.getNum()), size);
                System.out.printf("|=| [%s] | %s \n", temp, termo.getBin());
            }
            System.out.println("|========================|");
        }else{
            System.out.println("|=| Sem termos presentes, por favor insira algo antes");
        }
    }
    public static int getMaxValue(ArrayList<Termo> termos){
        int cmpVal = termos.get(0).getNum();
        int retVal = 0;
        for(int i = 0; i < termos.size(); i++){
            if(termos.get(i).getNum() > cmpVal){
                cmpVal = termos.get(i).getNum();
                retVal = i;
            }
        }
        return retVal;
    }
    public static int getMinValue(ArrayList<Termo> termos){
        int cmpVal = termos.get(0).getNum();
        int retVal = 0;
        for(int i = 0; i < termos.size(); i++){
            if(termos.get(i).getNum() < cmpVal){
                cmpVal = termos.get(i).getNum();
                retVal = i;
            }
        }
        return retVal;
    }
    public static int getMaxCount(ArrayList<Termo> termos){
        int cmpVal = termos.get(0).getOneCount();
        int retVal = 0;
        for(int i = 0; i < termos.size(); i++){
            if(termos.get(i).getOneCount() > cmpVal){
                cmpVal = termos.get(i).getOneCount();
                retVal = i;
            }
        }
        return retVal;
    }
    public static int getMinCount(ArrayList<Termo> termos){
        int cmpVal = termos.get(0).getOneCount();
        int retVal = 0;
        for(int i = 0; i < termos.size(); i++){
            if(termos.get(i).getOneCount() < cmpVal){
                cmpVal = termos.get(i).getOneCount();
                retVal = i;
            }
        }
        return retVal;
    }
    public static void sortTermos(ArrayList<Termo> termos){
        ArrayList<Termo> tempList = new ArrayList<>();
        while (!termos.isEmpty()){
            Termo tempTermo = termos.get(getMinCount(termos));
            tempList.add(tempTermo);
            termos.remove(tempTermo);
        }
        termos.addAll(tempList);
    }
    public static void groupTermos(ArrayList<Termo> termos){
        ArrayList<Termo> tempList = new ArrayList<>();
    }

}
