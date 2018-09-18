package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(57,205,342,200,197,946,631,92,66,581,345,220,398,249,329,87,186,144,462,431));
        heapSort(list);
    }

    static void heapSort(List<Integer> list){
        Stack<Integer> pilha = new Stack<>();

        buildMaxHeap(list);

        int size = list.size() - 1;

        for(int i = size; i>=0; i--){
            //swap
            int aux = list.get(0);
            list.set(0, list.get(i));
            list.set(i, aux);

            pilha.push(list.get(i));
            list.remove(i);

            maxHeapify(list, 0);
        }

        print(pilha);
    }

    static void print(Stack<Integer> pilha){
        System.out.print("List: ");
        while(pilha.size() > 0) {
            System.out.print(pilha.pop() + " ");
        }
        System.out.println();
    }

    static void buildMaxHeap(List<Integer> list){
        int size = list.size() - 1;

        for(int i = size/2; i >= 0; i--){
            maxHeapify(list, i);
        }
    }

    static void maxHeapify(List<Integer> list, int index){
        int left = 2*index;
        int right = 2*index + 1;

        int max = index;

        // Se filho da esquerda maior que max
        if (left < list.size() && list.get(left) > list.get(max))
            max = left;

        // Se filho da direita maior que max
        if (right < list.size() && list.get(right) > list.get(max))
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
