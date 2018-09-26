package experince;

import java.util.ArrayList;

/**
 * Author: Marsall
 * Date: Create in 18:21 2018/9/26
 * 笔试经历02：判断字符串T中包含多少个S字符串
 * 题目：BM
 */
public class _02_2_BM {
    /**
     * 分析：从匹配字符串右往左匹配，用right数组记录匹配字符串中每种字符的最右位置，当不匹配时通过right[]来使i移动skip位
     *      当原字符串T和匹配字符串S某位不匹配时，当T该位字符存在于S中则skip = j - right[T.charAt(i+j)]
     *                                             当不存在时，skip为1
     */
    private int[] right;
    private String pat;

    void BoyerMoore(String pat) {
        this.pat = pat;
        int M = pat.length();
        int R = 256;
        right = new int[R];
        for (int c = 0; c < R; c++) {
            right[c] = -1;
        }
        for (int j = 0; j < M; j++)
            right[pat.charAt(j)] = j;
    }

    public void search(String T, String S) {
        BoyerMoore(S);
        int N = T.length();
        int M = S.length();
        int skip;
        ArrayList<Integer> mark = new ArrayList<>();
        for (int i = 0; i <= N - M; i += skip) {
            skip = 0;
            for (int j = M - 1; j >= 0; j--) {
                if (pat.charAt(j) != T.charAt(i + j)) {
                    skip = j - right[T.charAt(i + j)];
                    if (skip < 1) skip = 1;
                    break;
                }
            }
            if (skip == 0) {
                mark.add(i);
                skip = M;
            }
        }
        for (int q = 0; q < mark.size(); q++) {
            int e = mark.get(q);
            System.out.println(e);
            for (int w = 0; w < S.length(); w++)
                System.out.print(T.charAt(e++));
        }
    }

    public static void main(String[] args) {
        _02_2_BM a = new _02_2_BM();
        String T = "i am marsall lam";
        String S = "am";
        a.search(T, S);
    }
}
