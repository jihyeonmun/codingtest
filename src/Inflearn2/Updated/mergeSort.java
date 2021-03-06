package Inflearn2.Updated;

public class mergeSort {
    public static void main(String[] args) {
        int[] arr = { 69, 10, 30, 2, 16, 8, 31, 22 };
        mergeSort(arr, 0, arr.length - 1);
    }
    public static int[] sorted = new int[30];
    public static void mergeSort(int[] arr, int m, int n) {
        int middle;
        if (m < n) {
            middle = (m + n) / 2;
            mergeSort(arr, m, middle);
            mergeSort(arr, middle + 1, n);
            merge(arr, m, middle, n);
        }
    }
    public static void merge(int[] arr, int m, int middle, int n) {
        int i, j, k, t;
        i = m;
        j = middle + 1;
        k = m;
        while (i <= middle && j <= n) {
            if (arr[i] <= arr[j])
                sorted[k] = arr[i++];
            else
                sorted[k] = arr[j++];
            k++;
        }
        if (i > middle) {
            for (t = j; t <= n; t++, k++)
                sorted[k] = arr[t];
        } else {
            for (t = i; t <= middle; t++, k++)
                sorted[k] = arr[t];
        }
        for (t = m; t <= n; t++)
            arr[t] = sorted[t];
        System.out.println("\n 합병 정렬 >> ");
        SelectionSort.printArr(arr);

    }
}
