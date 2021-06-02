//给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。 
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：[3,2,3]
//输出：3 
//
// 示例 2： 
//
// 
//输入：[2,2,1,1,1,2,2]
//输出：2
// 
//
// 
//
// 进阶： 
//
// 
// 尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。 
// 
// Related Topics 位运算 数组 分治算法 
// 👍 956 👎 0

package com.amoszhu.leetcode.editor.cn;

import java.util.Arrays;
import java.util.function.BinaryOperator;
import java.util.stream.IntStream;

public class MajorityElement {
    public static void main(String[] args) {
        Solution solution = new MajorityElement().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int majorityElement(int[] nums) {
            // 摩尔投票法
            int counter = 1;
            int ret = nums[0];
            for (int i = 1; i < nums.length; i++) {
                if (counter == 0) {
                    ret = nums[i];
                }
                // 计数
                if (ret == nums[i]) {
                    ++counter;
                } else {
                    --counter;
                }
            }
            return ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}