package com.company;

import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    void maxHeapify(List<Integer> list, int index)
    {
        int left = 2*index;
        int right = 2*index + 1;

        int max = index;

        // Se filho da esquerda maior que max
        if (left <= list.size() && list.get(left) > list.get(max))
            max = left;

        // Se filho da direita maior que max
        if (right <= list.size() && list.get(right) > list.get(max))
            max = right;

        // se max nao for raiz
        if (max != index)
        {
            //troca raiz com max
            int aux = list.get(index);
            list.set(index, list.get(max));
            list.set(max, aux);


            maxHeapify(list, max);
        }
    }
}
