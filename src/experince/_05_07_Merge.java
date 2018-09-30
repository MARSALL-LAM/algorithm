package experince;

/**
 * Author: Marsall
 * Date: Create in 13:44 2018/9/29
 */
public class _05_07_Merge {
    private static boolean sort(int[] a) {
        int[] temp = new int[a.length];
        sort(a, 0, a.length - 1, temp);
        return isSorted(a);
    }

    private static boolean isSorted(int[] a) {
        for (int i = 0; i < a.length - 1; i++)
            if (a[i] > a[i + 1])
                return false;
        return true;
    }

    private static void sort(int[] a, int start, int end, int[] temp) {
        if (start >= end) return;
        int middle = (start + end) / 2;
        sort(a, start, middle, temp);
        sort(a, middle + 1, end, temp);
        Merge(a, start, middle, end, temp);
    }

    private static void Merge(int[] a, int start, int middle, int end, int[] temp) {
        if (a[middle] <= a[middle + 1]) return;
        int mark = start;
        int left = start;
        int right = middle + 1;
        while (left <= middle && right <= end) {
            while (left <= middle && a[left] <= a[right])
                temp[mark++] = a[left++];
            while (right <= end && a[left] > a[right])
                temp[mark++] = a[right++];
        }
        while (left <= middle)
            temp[mark++] = a[left++];
        while (right <= end)
            temp[mark++] = a[right++];
        for (int i = mark - 1; i >= start; i--)
            a[i] = temp[i];
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
