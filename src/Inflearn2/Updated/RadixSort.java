package Inflearn2.Updated;
import java.util.*;
import Inflearn2.Updated.SelectionSort;
public class RadixSort {
    public static void main(String[] args) {
        int[] arr = { 69, 10, 30, 2, 16, 128, 131, 22 };
        RadixSort.sortLSD(arr, 3);
    }

    @SuppressWarnings("unchecked")
    private static LinkedList<Integer>[] counter = new LinkedList[] {
            new LinkedList<Integer>(), new LinkedList<Integer>(),
            new LinkedList<Integer>(), new LinkedList<Integer>(),
            new LinkedList<Integer>(), new LinkedList<Integer>(),
            new LinkedList<Integer>(), new LinkedList<Integer>(),
            new LinkedList<Integer>(), new LinkedList<Integer>() };

    // 버킷으로 사용할 counter 변수

    // maxDigitSymbols는 정렬할 숫자 중에서 가장 많은 자릿수를 갖는 녀석 기준
    public static void sortLSD(int[] array, int maxDigitSymbols) {
        int mod = 10;
        int dev = 1;
        for (int i = 0; i < maxDigitSymbols; i++, dev *= 10, mod *= 10) {
            for (int j = 0; j < array.length; j++) {
                int bucket = (array[j] % mod) / dev;
                counter[bucket].add(array[j]);
            }

            int pos = 0;

            for (int j = 0; j < counter.length; j++) {
                Integer value = null;
                while ((value = counter[j].poll()) != null) {
                    array[pos++] = value;
                }
            }
            System.out.println("기수 정렬 " + (i + 1) + " 단계:");
            SelectionSort.printArr(array);
        }

    }
}
