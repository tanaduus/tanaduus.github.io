//给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那 两个 整数，并返回它们的数组下标。 
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。 
//
// 你可以按任意顺序返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,7,11,15], target = 9
//输出：[0,1]
//解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,4], target = 6
//输出：[1,2]
// 
//
// 示例 3： 
//
// 
//输入：nums = [3,3], target = 6
//输出：[0,1]
// 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 10⁴ 
// -10⁹ <= nums[i] <= 10⁹ 
// -10⁹ <= target <= 10⁹ 
// 只会存在一个有效答案 
// 
//
// 进阶：你可以想出一个时间复杂度小于 O(n²) 的算法吗？ 
//
// Related Topics 数组 哈希表 👍 15402 👎 0

package tanaduus.github.io.algorithm.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目Id：1
 * 题目：两数之和
 * 日期：2022-09-23 23:11:28
 */
public class TwoSum {
    public static void main(String[] args) {
        Solution solution = new TwoSum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 一次遍历，每次计算map中是否已存在所需值
         */
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
            for (int i = 0; i < nums.length; ++i) {
                if (hashtable.containsKey(target - nums[i])) {
                    return new int[]{hashtable.get(target - nums[i]), i};
                }
                hashtable.put(nums[i], i);
            }
            return new int[0];
        }

//        public int[] twoSum(int[] nums, int target) {
//
//            if (null == nums || nums.length == 0) {
//                return null;
//            }
//
//            //<value, index>
//            HashMap<Integer, List<Integer>> map = new HashMap<>();
//            for (int i = 0; i < nums.length; i++) {
//                List<Integer> list = map.get(nums[i]);
//                if (list == null) {
//                    list = new ArrayList<>();
//                    list.add(i);
//                    map.put(nums[i], list);
//                } else {
//                    list.add(i);
//                }
//            }
//
//            for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
//                Integer value = entry.getKey();
//                int another = target - value;
//                List<Integer> indexList = entry.getValue();
//
//                if (map.containsKey(another)) {
//
//                    if (value == another) {
//                        return new int[]{indexList.get(0), indexList.get(1)};
//                    } else {
//                        return new int[]{indexList.get(0), map.get(another).get(0)};
//                    }
//                }
//            }
//            return null;
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

} 
