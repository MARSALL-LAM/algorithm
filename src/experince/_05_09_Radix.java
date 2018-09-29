package experince;

/**
 * Author: Marsall
 * Date: Create in 14:20 2018/9/29
 */
public class _05_09_Radix {
    private static boolean sort(int[] a) {
        int max = a[0];
        for (int aa : a
        ) {
            if (aa > max)
                max = aa;
        }
        int radix = 0;
        while (max != 0) {
            radix++;
            max /= 10;
        }
        sort(a, radix);
        return isSorted(a);
    }

    private static boolean isSorted(int[] a) {
        for (int i = 0; i < a.length - 1; i++)
            if (a[i] > a[i + 1])
                return false;
        return true;
    }

    private static void sort(int[] a, int radix) {
        int n = 0;
        int k = 0;
        int[][] store = new int[10][a.length];
        int[] count = new int[10];
        while (n < radix) {
            for (int i = 0; i < a.length; i++) {
                int mark = (int) (a[i] / Math.pow(10, n)) % 10;
                store[mark][count[mark]++] = a[i];
            }
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < count[i]; j++) {
                    a[k++] = store[i][j];
                }
                count[i] = 0;
            }
            n++;
            k = 0;
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
