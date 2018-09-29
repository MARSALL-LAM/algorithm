package experince;

/**
 * Author: Marsall
 * Date: Create in 13:27 2018/9/29
 */
public class _05_06_Heal {
    private static void swap(int[] a, int j, int i) {
        int temp = a[j];
        a[j] = a[i];
        a[i] = temp;
    }

    private static boolean sort(int[] a) {
        int jump = a.length / 2;
        while (jump > 0) {
            for (int i = jump; i < a.length; i++) {
                int min = a[i];
                int j = i;
                for (; j >= jump && a[j - jump] > min; j -= jump)
                    a[j] = a[j - jump];
                a[j] = min;
            }
            jump /= 2;
        }
        return isSort(a);
    }

    private static boolean isSort(int[] a) {
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
