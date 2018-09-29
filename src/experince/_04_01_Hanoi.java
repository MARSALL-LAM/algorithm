package experince;

/**
 * Author: Marsall
 * Date: Create in 10:41 2018/9/29
 * 算法经历04 Hanoi
 * 要求：任何时刻小盘子必须在大盘子上面
 */
public class _04_01_Hanoi {
    /**
     * 有A、B、C三个柱子，其中A中有n个盘子，目标借助B柱将n个盘子从A移到C
     * 基本思想：先将A上的n-1个盘子移到辅助柱子B，将第n个盘子移到C，再将B上的n-1一个柱子移到C
     */
    static int i = 1;

    static private void hanoi(int n, char from, char assitance, char to) {
        if (n == 1) {
            move(n, from, to);
        } else {
            hanoi(n - 1, from, to, assitance);
            move(n, from, to);
            hanoi(n - 1, assitance, from, to);
        }
    }

    static private void move(int n, char from, char to) {
        System.out.println("第" + i++ + "步：将" + n + "个盘子从" + from + "移到到" + to);
    }

    public static void main(String[] args) {
        char a = 'A';
        char b = 'B';
        char c = 'C';
        hanoi(4, a, b, c);
    }
}
