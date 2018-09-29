package experince;

/**
 * Author: Marsall
 * Date: Create in 12:06 2018/9/29
 */
public class _05_03_Insert {
    private static boolean sort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int temp = a[i];
            int j = i;
            for (; j > 0 && temp < a[j - 1]; j -= 1) {
                a[j] = a[j - 1];
            }
            a[j] = temp;
        }
        return isSorted(a);
    }

    private static boolean isSorted(int[] a) {
        for (int i = 0; i < a.length - 1; i++)
            if (a[i] > a[i + 1])
                return false;
        return true;
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
