//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
// Related Topics 回溯算法 
// 👍 675 👎 0

package com.amoszhu.leetcode.editor.cn;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PermutationsIi {
    public static void main(String[] args) {
        Solution solution = new PermutationsIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        boolean[] markArr;
        public List<List<Integer>> permuteUnique(int[] nums) {
            List<List<Integer>> res = new LinkedList<>();
            LinkedList<Integer> tracker = new LinkedList<>();
            Arrays.sort(nums);
            markArr = new boolean[nums.length];
            permute(nums, tracker, 0, res);
            return res;
        }


        private void permute(int[] nums, LinkedList<Integer> tracker, int idx, List<List<Integer>> res) {
            // 递归终止条件，搜索完毕
            if (idx == nums.length) {
                res.add(new LinkedList<>(tracker));
                return;
            }

            // for循环递归
            for (int i = 0; i < nums.length; i++) {
                // 过滤去重复，保证重复元素的选择顺序从左到右唯一
                if (markArr[i] || (i>0 && nums[i] == nums[i-1] && !markArr[i-1])) {
                    continue;
                }
                // 选择
                tracker.add(nums[i]);
                // 标记已选择
                markArr[i] = true;
                // 进入下一层选择
                permute(nums, tracker, idx+1, res);
                // 撤销选择 撤销标记
                tracker.removeLast();
                markArr[i] = false;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}