package experince;

/**
 * Author: Marsall
 * Date: Create in 14:01 2018/9/29
 */
public class _05_08_Count {
    private static boolean sort(int[] a) {
        sortCore(a);
        return isSorted(a);
    }

    private static boolean isSorted(int[] a) {
        for (int i = 0; i < a.length - 1; i++)
            if (a[i] > a[i + 1])
                return false;
        return true;
    }

    private static void sortCore(int[] a) {
        int max = a[0];
        int min = a[0];
        for (int aa : a
        ) {
            if (aa > max)
                max = aa;
            if (aa < min)
                min = aa;
        }
        int[] count = new int[max - min + 1];
        int[] temp = new int[a.length];
        for (int i = 0; i < a.length; i++)
            count[a[i] - min] += 1;
        for (int i = 1; i < count.length; i++)
            count[i] += count[i - 1];
        for (int i = a.length - 1; i >= 0; i--)
            temp[--count[a[i] - min]] = a[i];
        for (int i = 0; i < a.length; i++)
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
