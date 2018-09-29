package experince;

/**
 * Author: Marsall
 * Date: Create in 19:00 2018/9/26
 * 算法经历03 BITMAP
 */
public class _03_01_BITMAP {
    /**
     * 无符号int最大值可达到40多亿
     * bitmap[n/32][32]
     */
    private boolean[][] bitmap;

    void init(int length) {
        bitmap = new boolean[(length >> 5) + 1][32];
    }

    void put(int n) {
        bitmap[n >> 5][n % 32] = true;
    }

    boolean isExist(int n) {
        return bitmap[n >> 5][n & 32];
    }

    public static void main(String[] args){
        _03_01_BITMAP a = new _03_01_BITMAP();
        a.init(2000000000);
        for (int i = 0; i <= 1000000000;i++){
            a.put(i);
        }
        System.out.println(a.isExist(2000000000));
        System.out.println(a.isExist(1000000001));
    }
}
