package experince;

/**
 * Author: Marsall
 * Date: Create in 12:14 2018/9/29
 */
public class _05_04_SimpleQuick {
    private static int getRandom(int start, int end) {
        return (int) (Math.random() * (end - start) + start);
    }

    private static int getMiddleOfThree(int[] a, int start, int end) {
        int mid = (start + end) >> 1;
        if (a[mid] >= a[start] && a[mid] <= a[end] || a[mid] <= a[start] && a[mid] >= a[end])
            swap(a, mid, start);
        if (a[start] >= a[mid] && a[start] <= a[end] || a[start] <= a[mid] && a[start] >= a[end])
            return start;
        if (a[end] >= a[mid] && a[end] <= a[start] || a[end] <= a[mid] && a[end] >= a[start])
            swap(a, end, start);
        return start;
    }

    private static void swap(int[] a, int j, int i) {
        int temp = a[j];
        a[j] = a[i];
        a[i] = temp;
    }

    private static boolean sort(int[] a) {
        sortCore(a, 0, a.length - 1);
        return isSorted(a);
    }

    private static boolean isSorted(int[] a) {
        for (int i = 0; i < a.length - 1; i++)
            if (a[i] > a[i + 1])
                return false;
        return true;
    }

    private static void sortCore(int[] a, int start, int end) {
        if (start >= end) return;
        int pivot = start;
        int i = start;
        int j = end;
        while (i < j) {
            while (i < j && a[j] >= a[pivot])
                j--;
            while (i < j && a[i] <= a[pivot])
                i++;
            if (i < j)
                swap(a, i, j);
        }
        swap(a, pivot, j);
        sortCore(a, start, j - 1);
        sortCore(a, j + 1, end);
    }

    public static void main(String[] args) {
        int[] arr = new int[100000];
        for (int i = 0; i < arr.length; i++)
            arr[i] = (int) (Math.random() * 100000);
        for (int temp : arr
        ) {
            System.out.print(temp + "|");
        }
        System.out.println();
        long before = System.currentTimeMillis();
        System.out.println("before:" + before + "ms");
        System.out.println("isSorted?:" + sort(arr));
        long after = System.currentTimeMillis();
        System.out.println("after:" + after + "ms");
        System.out.println("cost:" + (after - before) + "ms");
        for (int temp : arr
        ) {
            System.out.print(temp + "|");
        }
    }
}
