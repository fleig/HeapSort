import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        System.out.println("Starting...");

        int param = 12;

        for (String arg : args) {
            param = Integer.parseInt(arg);
        }

        ArrayList<Long> list = readFile(chooseFile(param));

        heapSort(list);
    }

    static String chooseFile(int i){
        String name;
        switch (i){
            case 1: name = "num.1000.1.in"; break;
            case 2: name = "num.1000.2.in"; break;
            case 3: name = "num.1000.3.in"; break;
            case 4: name = "num.1000.4.in"; break;
            case 5: name = "num.10000.1.in"; break;
            case 6: name = "num.10000.2.in"; break;
            case 7: name = "num.10000.3.in"; break;
            case 8: name = "num.10000.4.in"; break;
            case 9: name = "num.100000.1.in"; break;
            case 10: name = "num.100000.2.in"; break;
            case 11: name = "num.100000.3.in"; break;
            case 12: name = "num.100000.4.in"; break;

            default: name = "couting.txt"; break;
        }


        String filePath = new File("").getAbsolutePath();
        return filePath + "/testes/" + name;
    }

    static ArrayList<Long> readFile(String str){
        ArrayList<Long> list = new ArrayList<>();

        BufferedReader br = null;
        FileReader fr = null;

        try {
            fr = new FileReader(str);
            br = new BufferedReader(fr);

            String line;

            while ((line = br.readLine()) != null) {
                list.add(Long.valueOf(line));
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
                if (fr != null)
                    fr.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        return list;
    }

    static void heapSort(ArrayList<Long> list){
        Stack<Long> pilha = new Stack<>();

        buildMaxHeap(list);

        int size = list.size() - 1;

        for(int i = size; i>=0; i--){
            //swap
            long aux = list.get(0);
            list.set(0, list.get(i));
            list.set(i, aux);

            pilha.push(list.get(i));
            list.remove(i);

            maxHeapify(list, 0);
        }

        print(pilha);
    }

    static void print(Stack<Long> pilha){
        System.out.print("Sort: ");
        while(pilha.size() > 0) {
            System.out.print(pilha.pop() + " ");
        }
        System.out.println();
    }

    static void buildMaxHeap(ArrayList<Long> list){
        int size = list.size() - 1;

        for(int i = size/2; i >= 0; i--){
            maxHeapify(list, i);
        }
    }

    static void maxHeapify(ArrayList<Long> list, int index){
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
            long aux = list.get(index);
            list.set(index, list.get(max));
            list.set(max, aux);

            maxHeapify(list, max);
        }
    }
}
