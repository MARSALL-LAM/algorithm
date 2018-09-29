package experince;

/**
 * Author: Marsall
 * Date: Create in 12:37 2018/9/29
 */
public class _05_05_Heap {
    private static void swap(int[] a, int j, int i) {
        int temp = a[j];
        a[j] = a[i];
        a[i] = temp;
    }

    private static boolean sort(int[] a) {
        for (int i = (a.length - 2) / 2; i >= 0; i--) {
            adjustHeap(a, i, a.length - 1);
        }
        for (int i = a.length - 1; i > 0; i--) {
            swap(a, i, 0);
            adjustHeap(a, 0, i - 1);
        }
        return isSorted(a);
    }

    private static boolean isSorted(int[] a) {
        for (int i = 0; i < a.length - 1; i++)
            if (a[i] > a[i + 1])
                return false;
        return true;
    }

    private static void adjustHeap(int[] a, int index, int end) {
        int left = index * 2 + 1;
        if (left > end) return;
        while (index <= (end - 1) / 2) {
            left = index * 2 + 1;
            int right = index * 2 + 2;
            int max = index;
            if (a[left] > a[max]) max = left;
            if (right < end && a[right] > a[max]) max = right;
            if (max == index) return;
            swap(a, max, index);
            index = max;
        }

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
