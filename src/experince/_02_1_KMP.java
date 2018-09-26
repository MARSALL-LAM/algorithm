package experince;

import java.util.ArrayList;

/**
 * Author: Marsall
 * Date: Create in 19:29 2018/9/25
 * 笔试经历02：判断字符串T中包含多少个S字符串
 * 题目：KMP
 */
public class _02_1_KMP {
    /**
     * 分析：先用一个数组记录S中每个位置与前面部分的相同数
     * 例如S为"abcab",则next[0]=0,next[1]=0,next[2]=0,next[3]=1,next[4]=2;
     * 遍历T,当到某位不同时，j=j-next[i],i=0（j为T下标,i为S下标）
     */
    private int[] next;

    private void getNext(char[] chars) {
        int length = chars.length;
        next = new int[length];
        next[0] = -1;
        int k = -1;
        int j = 0;
        //k为前缀和后缀相同的最后一位
        while (j < length - 1) {
            if (k == -1 || chars[k] == chars[j]) {
                j++;
                k++;
                if (chars[j] != chars[k])//避免j不匹配后继续不匹配next[k]
                    next[j] = k;
                else
                    next[j] = next[k];
            } else //当chars[j] != chars[k]时，找k之前的更短的前后缀相同的k
                k = next[k];
        }
    }

    private void findSInT(String T, String S) {
        char[] Ts = T.toCharArray();
        char[] Ss = S.toCharArray();
        ArrayList<Integer> mark = new ArrayList<>();
        int i = 0;
        int j = 0;

        while (i < Ts.length && j < Ss.length) {
            if (j == -1 || Ts[i] == Ss[j]) {
                i++;
                j++;
            } else {
                j = next[j];
            }
            if (j == Ss.length) {
                mark.add(i - j);
                j = 0;
            }
        }
        for (int q = 0; q < mark.size(); q++) {
            int e = mark.get(q);
            System.out.println(e);
            for (int w = 0; w < Ss.length; w++)
                System.out.print(Ts[e++]);
        }
    }

    public static void main(String[] args) {
        _02_1_KMP a = new _02_1_KMP();
        String T = "i am marsall lam";
        String S = "am";
        a.getNext(S.toCharArray());
        a.findSInT(T, S);
    }
}
