package br.com.cwi.reset.projeto1;

import java.util.Arrays;
import java.util.List;

public class Exercicios1 {

    public Integer somarLista(List<Integer> numeros) {


        Integer soma = 0;
        for (Integer valor : numeros) {
            soma += valor;
        }

        return soma;
    }

    public Double calcularMedia(List<Integer> numeros) {


        return Double.valueOf(somarLista(numeros)/numeros.size());
    }

    public Integer obterMaiorNumero(List<Integer> numeros) {
        Integer maior = 0;
        for (Integer numero : numeros ) {
            if (numero > maior){
                maior = numero;
            }
        }

        return maior;
    }

    public String obterPalavraInvertida(String palavra) {
        String reverse ="";
        for (int i = palavra.length() -1; i >= 0 ; i--) {
            reverse += palavra.charAt(i);
        }
        return reverse;
    }

    public List<Integer> ordenarLista(List<Integer> numeros) {
        Integer [] ord = numeros.toArray(new Integer[numeros.size()]);
        Integer temp;
        for (int i = 0; i < numeros.size(); ++i) {
               for (int j = 0; j < numeros.size() -1; ++j){
                   if (ord [j] > ord [j+1]){
                       temp = ord[j];
                       ord [j] = ord [j + 1];
                       ord [j + 1] = temp;
                   }

               }

        }

        return Arrays.asList(ord);
    }
}

