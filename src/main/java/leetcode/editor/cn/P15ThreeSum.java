//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复
//的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例： 
//
// 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
// 
// Related Topics 数组 双指针 
// 👍 2572 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//Java：三数之和
public class P15ThreeSum {
    public static void main(String[] args) {
        Solution solution = new P15ThreeSum().new Solution();
        // TO TEST
    }

    /**
     * p15 解题思路：双路快排
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            // 1. 对数组进行排序
            Arrays.sort(nums);
            // 2. 遍历数组，并进行双指针循环
            List<List<Integer>> res = new ArrayList<>();
            if (nums.length < 3) {
                return res;
            }
            int len = nums.length;
            for (int i = 0; i < len; ++i) {
                if (nums[i] > 0) {
                    return res;
                }

                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                int L = i + 1;
                int R = len - 1;
                int curr = nums[i];
                while (L < R) {
                    // 判断求和值
                    int tmp = curr + nums[L] + nums[R];
                    if (tmp == 0) {
                        List<Integer> list = new ArrayList<>();
                        list.add(curr);
                        list.add(nums[L]);
                        list.add(nums[R]);
                        res.add(list);
                        while (L < R && nums[L + 1] == nums[L]) {
                            ++L;
                        }
                        while (L < R && nums[R - 1] == nums[R]) {
                            --R;
                        }
                        ++L;
                        --R;
                    } else if (tmp < 0) {
                        ++L;
                    } else {
                        --R;
                    }
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}