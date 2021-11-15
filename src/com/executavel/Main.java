package com.executavel;

import com.util.Termo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

import static com.util.TermoUtil.*;

public class Main {

    public static void main(String[] args) {
        int op = -1;

        Scanner scan = new Scanner(System.in);
        while(op != 1){
            ArrayList<Termo> termos = new ArrayList<>();
            System.out.println("|=============================|");
            System.out.println("|=[0]| Realizar uma operacao");
            System.out.println("|=[1]| Sair");
            System.out.println("|=============================|");
            System.out.print("|=| Insira sua escolha:"); op = scan.nextInt();
            switch (op){
                case 0: {
                    int nVariaveis = 0;
                    while(nVariaveis <= 0){
                        System.out.print("|=| Insira o numero de variaveis: "); nVariaveis = scan.nextInt();
                        if(nVariaveis <= 0){
                            System.out.println("|=| Insira uma entrada valida");
                        }
                    }
                    int size = ((int)Math.pow(2, (nVariaveis))) - 1;
                    int nTermos = 0;
                    while(nTermos <= 0 && nTermos <= size){
                        System.out.print("|=| Insira o numero de minitermos: "); nTermos = scan.nextInt();
                        if(nTermos <= 0){
                            if(nTermos <= 0 && nTermos <= size){
                                System.out.println("|=| Insira uma entrada valida");
                            }
                        }
                    }
                    HashSet<Integer> tempSet = new HashSet<>();
                    while(termos.size() < nTermos){
                        int temp = -1;
                        while((!(temp >= 0 && temp <= size))){
                            System.out.print("|=| Insera o minitermo: "); temp = scan.nextInt();
                            if(!tempSet.add(temp)){
                                System.out.println("|=| Insira um minitermo novo");
                            }else{
                                if(temp <= size){
                                    Termo term = new Termo(temp, (Integer.toBinaryString(size)).length());
                                    termos.add(term);
                                }else{
                                    System.out.printf("|=| Apenas minitermo menores que %d sao permitidos\n", size);
                                }
                            }
                        }
                    }
                    imprimeTermos(termos);
                    sortTermos(termos);
                    imprimeTermos(termos);
                    ArrayList<Termo> result = groupTermos(termos);
                    imprimeExp(termos);
                    imprimeExp(result);
                    break;
                }
                case 1:

                    System.out.println("|=| Saindo do programa");
                    break;
                default:
                    System.out.println("|=| Entrada invalida");
                    break;
            }
        }
    }
}
