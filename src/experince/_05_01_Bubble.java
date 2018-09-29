package experince;


/**
 * Author: Marsall
 * Date: Create in 11:29 2018/9/29
 */
public class _05_01_Bubble {
    static private boolean sort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int mark = 0;
            for (int j = 0; j < a.length - 1; j++) {
                if (a[j] > a[j + 1]) {
                    swap(a, j, j + 1);
                    mark++;
                }
            }
            if (mark == 0) break;
        }
        return isSorted(a);
    }

    private static boolean isSorted(int[] a) {
        for (int i = 0; i < a.length - 1; i++)
            if (a[i] > a[i + 1])
                return false;
        return true;
    }

    private static void swap(int[] a, int j, int i) {
        int temp = a[j];
        a[j] = a[i];
        a[i] = temp;
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
        System.out.println("isSorted?:"+sort(arr));
        long after = System.currentTimeMillis();
        System.out.println("after:" + after + "ms");
        System.out.println("cost:"+(after - before) + "ms");
        for (int temp : arr
        ) {
            System.out.print(temp + "|");
        }
    }
}
