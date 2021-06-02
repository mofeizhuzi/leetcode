//给定一个 没有重复 数字的序列，返回其所有可能的全排列。 
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法 
// 👍 1300 👎 0

package com.amoszhu.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        Solution solution = new Permutations().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> res = new LinkedList<>();
//        public List<List<Integer>> permute(int[] nums) {
//            LinkedList<Integer> tracker = new LinkedList<>();
//            permute(nums, tracker);
//            return res;
//        }
//
//        private void permute(int[] nums, LinkedList<Integer> tracker) {
//            // 递归终止条件，搜索完毕
//            if (tracker.size() == nums.length) {
//                res.add(new LinkedList<>(tracker));
//                return;
//            }
//
//            // for循环递归
//            for (int num : nums) {
//                if (tracker.contains(num)) {
//                    // 去除重复选择
//                    continue;
//                }
//                // 选择
//                tracker.add(num);
//                // 进入下一层选择
//                permute(nums, tracker);
//                // 撤销选择 在当前层选择进行遍历
//                tracker.removeLast();
//            }
//        }

        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> res2 = new LinkedList<>();
            List<Integer> tracker = new ArrayList<>();
            for (int num : nums) {
                tracker.add(num);
            }
            permute(nums.length, tracker, res2, 0);
            return res2;
        }

        private void permute(int length, List<Integer> tracker, List<List<Integer>> res2, int first) {
            // 已选择[0,first],未选择[first+1,length-1]
            // 递归终止条件，交换完毕
            if (first == length) {
                res2.add(new ArrayList<Integer>(tracker));
                return;
            }

            // for循环递归
            for (int i = first; i < length; i++) {
                // 选择既交换
                Collections.swap(tracker, first, i);
                // 进入下一层选择
                permute(length,tracker, res2, first + 1);
                // 撤销选择既再次交换回来
                Collections.swap(tracker, first, i);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}