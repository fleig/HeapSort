package com.company;

import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    void HeapSort(List<Integer> list){
        buildMaxHeap(list);

        for(int i = list.size()-1; i>0; i--){
            int aux = list.get(0);
            list.set(0, list.get(i));
            list.set(i, aux);
        }
    }

    void buildMaxHeap(List<Integer> list){
        int size = list.size() - 1;

        for(int i = size/2; i >= 0; i--){
            maxHeapify(list, i);
        }
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
