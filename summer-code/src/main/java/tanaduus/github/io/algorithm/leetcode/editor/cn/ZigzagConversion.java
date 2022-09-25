//将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。 
//
// 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下： 
//
// 
//P   A   H   N
//A P L S I I G
//Y   I   R 
//
// 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。 
//
// 请你实现这个将字符串进行指定行数变换的函数： 
//
// 
//string convert(string s, int numRows); 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "PAYPALISHIRING", numRows = 3
//输出："PAHNAPLSIIGYIR"
// 
//
//示例 2：
//
// 
//输入：s = "PAYPALISHIRING", numRows = 4
//输出："PINALSIGYAHRPI"
//解释：
//P     I    N
//A   L S  I G
//Y A   H R
//P     I
// 
//
// 示例 3： 
//
// 
//输入：s = "A", numRows = 1
//输出："A"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 由英文字母（小写和大写）、',' 和 '.' 组成 
// 1 <= numRows <= 1000 
// 
//
// Related Topics 字符串 👍 1824 👎 0

package tanaduus.github.io.algorithm.leetcode.editor.cn;

/**
 * 题目Id：6
 * 题目：Z 字形变换
 * 日期：2022-09-25 15:00:54
 */
public class ZigzagConversion {
    public static void main(String[] args) {
        Solution solution = new ZigzagConversion().new Solution();
//        System.out.println(solution.convert("PAYPALISHIRING", 3));

        System.out.println(solution.convert("AB", 1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String convert(String s, int numRows) {

            if (numRows == 1) {
                return s;
            }

            /*     isStright
            0,0      true
            1,0      true
            2,0      true
            1,1      false
            0,2      true
            1,2      true
            2,2      true
             */
            int i = 0, j = 0;
            boolean isStright = true;
            Character[][] rs = new Character[numRows][s.length()];
            for (char c : s.toCharArray()) {

                rs[i][j] = c;
                if (isStright) {
                    if (i < numRows - 1) {
                        i++;
                    } else {
                        i--;
                        j++;
                        isStright = false;
                    }
                } else {
                    if (i > 0) {
                        i--;
                        j++;
                    } else {
                        isStright = true;
                        i++;
                    }
                }
            }

            String result = "";
            for (int k = 0; k < rs.length; k++) {
                for (int l = 0; l < rs[0].length; l++) {
                    if (rs[k][l] == null) {
                        continue;
                    }
                    result += rs[k][l];
                }
            }

            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

} 
