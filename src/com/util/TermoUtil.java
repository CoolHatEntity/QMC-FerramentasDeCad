package com.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static com.util.StringUtil.*;

public class TermoUtil {
    public static void imprimeTermos(ArrayList<Termo> termos){
        if(termos.size() > 0){
            int size = getMaxString(termos);
            for (Termo termo : termos) {
                String temp = fillString(" ", termo.getString(), size);
                System.out.printf("|=| [%s] | %s \n", temp, termo.getBin());
            }
            System.out.println("|========================|");
        }else{
            System.out.println("|=| Sem termos presentes, por favor insira algo antes");
        }
    }

    public static void imprimeExp(ArrayList<Termo> termos) {
        System.out.print("|=| F = ");
        int c = 0;
        for(int i = 0; i < termos.size(); i++){
            if(i < termos.size() - 1){
                System.out.print(termos.get(i).getExp());
                System.out.print(" + ");
            }else{
                System.out.println(termos.get(i).getExp());
            }
            c = c + termos.get(i).getLiteralCount();
        }
        System.out.println("|=| Literais: " + c);
    }
    public static int getMaxString(ArrayList<Termo> termos){
        int retVal = (termos.get(0).getString()).length();
        for (Termo termo : termos) {
            if ((termo.getString()).length() > retVal) {
                retVal = (termo.getString()).length();
            }
        }
        return retVal;

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
    public static ArrayList<Termo> groupTermos(ArrayList<Termo> termos){
        ArrayList<Termo> sorted = new ArrayList<>(termos);
        Collections.copy(sorted, termos);
        ArrayList<Termo> reduced = new ArrayList<>();
        ArrayList<Termo> tempList = new ArrayList<>();
        findMatch(sorted, reduced);
        findMatch(reduced, tempList);

        organizeTermos(tempList);
        imprimeTermos(tempList);

        ArrayList<Termo> result = getPrime(tempList);
        if (!findCoverage(result).equals(findCoverage(tempList))) {
            while (!(findCoverage(result).equals(findCoverage(tempList)))) {
                ArrayList<Integer> diff = new ArrayList<>(findCoverage(tempList));
                diff.removeAll(findCoverage(result));
                int pos = 0;
                int size = diff.size();
                for (int i = 0; i < tempList.size(); i++) {
                    ArrayList<Integer> tmp = new ArrayList<>(diff);
                    Collections.copy(tmp, diff);
                    tmp.removeAll(tempList.get(i).getHist());
                    if (tmp.size() < size) {
                        pos = i;
                        size = tmp.size();
                    }
                }
                result.add(tempList.get(pos));
            }
        }
        imprimeTermos(result);
        return result;
    }

    private static void organizeTermos(ArrayList<Termo> tempList) {
        for (Termo termo : tempList) {
            termo.getHist().sort(null);
        }

        Set<String> temp = new HashSet<>();
        tempList.removeIf(termo -> !temp.add(termo.getBin()));
    }

    private static ArrayList<Termo> getPrime(ArrayList<Termo> termos) {
        ArrayList<Integer> terms = findCoverage(termos);
        Set<Termo> tempResult =  new HashSet<>();
        for (Integer term : terms) {
            int c = 0;
            int index = 0;
            for (int j = 0; j < termos.size(); j++) {
                if (termos.get(j).getHist().contains(term)) {
                    c++;
                    index = j;
                }
            }
            if(c == 1){
                tempResult.add(termos.get(index));
            }
        }
        return new ArrayList<>(tempResult);
    }

    private static ArrayList<Integer> findCoverage(ArrayList<Termo> termos){
        Set<Integer> tempTerms = new HashSet<>();
        for(Termo termo : termos){
            tempTerms.addAll(termo.getHist());
        }
        return new ArrayList<>(tempTerms);
    }

    private static void findMatch(ArrayList<Termo> original, ArrayList<Termo> destination) {
        for(int i = 0; i < original.size(); i++){
            for(int j = i; j < original.size() - 1;j++){
                int diff = diffString(original.get(i).getBin(), original.get(j + 1).getBin());
                if(diff == 1){
                    int pos = diffStringPos(original.get(i).getBin(), original.get(j + 1).getBin());
                    updateTermo(original, destination, i, j, pos);
                }
            }
        }
        ArrayList<Integer> diff;
        diff = findCoverage(original);
        diff.removeAll(findCoverage(destination));
        ArrayList<Termo> temp = new ArrayList<>();
        if(!diff.isEmpty()){
            for (Termo termo : original) {
                if (!Collections.disjoint(termo.getHist(), diff)) {
                    temp.add(termo);
                    diff.removeAll(temp.get(temp.size() - 1).getHist());
                }
            }
        }
        //imprimeTermos(temp);
        destination.addAll(temp);
    }

    private static void updateTermo(ArrayList<Termo> termos, ArrayList<Termo> tempList, int i, int j, int pos) {
        String temp = replaceChar(termos.get(i).getBin(), '_', pos);
        Termo termoTemp = new Termo();

        termoTemp.setNum(i);
        termoTemp.setBin(temp);
        if(termos.get(i).getHist().size() > 1){
            ArrayList<Integer> tempHist = new ArrayList<>(termos.get(i).getHist());
            Collections.copy(tempHist, termos.get(i).getHist());
            tempHist.addAll(termos.get(j + 1).getHist());
            termoTemp.setHist(tempHist);
        }else{
            termoTemp.addHist(termos.get(i).getNum());
            termoTemp.addHist(termos.get(j + 1).getNum());
        }
        termoTemp.setOneCount(countChar(termoTemp.getBin(), '1'));
        tempList.add(termoTemp);
    }

}
