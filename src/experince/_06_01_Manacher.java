package experince;

/**
 * Author: Marsall
 * Date: Create in 11:17 2018/9/30
 * 算法经历06 字符串最长回文(Moslems)--Manacher算法
 */
public class _06_01_Manacher {
    //解决回文长度为偶数
    private static String getString(String origin) {
        StringBuilder sb = new StringBuilder();
        sb.append('|');
        for (int i = 0; i < origin.length(); i++) {
            sb.append(origin.charAt(i));
            sb.append('|');
        }
        return sb.toString();
    }

    private static String getLongestMoslems(String origin) {
        String forFinding = getString(origin);
        System.out.println(forFinding);
        int len = forFinding.length();
        int[] record = new int[len];
        StringBuilder sb = new StringBuilder();
        int center = 0;
        int longest = 0;
        int rightEdge = 0;
        int rightEdgeCenter = 0;
        for (int i = 0; i < len; i++) {
            boolean needCalc = true;
            if (i < rightEdge) {
                int leftCenter = 2 * rightEdgeCenter - i;
                record[i] = record[leftCenter];
                if (i + record[i] > rightEdge)
                    record[i] = rightEdge - i;
                if (i + record[leftCenter] < rightEdge)
                    needCalc = false;
            }
            if (needCalc) {
                while ((i - 1 - record[i] >= 0) && (i + 1 + record[i] < len)) {
                    if (forFinding.charAt(i + 1 + record[i]) == forFinding.charAt(i - 1 - record[i]))
                        record[i]++;
                    else
                        break;
                }
                rightEdge = i + record[i];
                rightEdgeCenter = i;
                if (record[i] > longest) {
                    center = i;
                    longest = record[i];
                }
            }
        }
        for (int i = center - longest + 1; i <= center + longest; i += 2)
            sb.append(forFinding.charAt(i));
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(getLongestMoslems("abcbaabcdcba"));
    }
}
