//给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,1,1,2,2,3], k = 2
//输出: [1,2]
// 
//
// 示例 2: 
//
// 
//输入: nums = [1], k = 1
//输出: [1] 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 105 
// k 的取值范围是 [1, 数组中不相同的元素的个数] 
// 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的 
// 
//
// 
//
// 进阶：你所设计算法的时间复杂度 必须 优于 O(n log n) ，其中 n 是数组大小。 
// Related Topics 堆 哈希表 
// 👍 727 👎 0

package com.amoszhu.leetcode.editor.cn;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {
    public static void main(String[] args) {
        Solution solution = new TopKFrequentElements().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //
        public int[] topKFrequent(int[] nums, int k) {
            return topKFrequent1(nums, k);
//            return topKFrequent2(nums, k);
        }

        /**
         * 使用优先级队列实现最小堆
         * @param nums
         * @param k
         * @return
         */
        public int[] topKFrequent1(int[] nums, int k) {
            Map<Integer, Integer> kMap = new HashMap<>();
            for (int num: nums) {
                kMap.put(num, kMap.getOrDefault(num, 0) + 1);
            }
            // int[] 的第一个元素代表数组的值，第二个元素代表了该值出现的次数
            PriorityQueue<int []> queue = new PriorityQueue<>(
                    Comparator.comparingInt(o -> o[1])
            );

            for (Map.Entry<Integer, Integer> entry: kMap.entrySet()) {
                int num = entry.getKey();
                int count = entry.getValue();
                // 构造大小为K的小顶堆
                if (queue.size() == k) {
                    assert queue.peek() != null;
                    if (queue.peek()[1] < count) {// 第一个元素的出现的次数：小于当前元素出现次数
                        queue.poll(); // 丢弃堆顶
                        queue.offer(new int[]{num, count}); //塞进来
                    }
                } else {
                    queue.offer(new int[]{num, count}); //堆未满，直接塞进来
                }
            }

            int[] result = new int[k];
            for (int i = 0; i < k; i++) {
                result[i] = queue.poll()[0];
            }
            return result;
        }

        /**
         * 使用使用代码手撸最小堆
         * @param nums
         * @param k
         * @return
         */
        public int[] topKFrequent2(int[] nums, int k) {
            // 构建最小堆
            buildHeap(nums, k);
        }

        private void buildHeap(int[] nums, int k) {
            for (int i = k/2; i >= 0; i++) {
                adjustHeap(nums, i, k);
            }
        }

        private void adjustHeap(int[] nums, int i, int k) {
            // 堆的特点，完全二叉树，节点下标可确定
            int left = i * 2 + 1;
            int right = i * 2 + 2;
            int largest = i;
            if (left < k && nums[left] > nums[i]) {
                largest = left;
            }

            if (right < k && nums[right] > nums[i]) {
                largest = right;
            }
            if (largest != i) {
                swap(nums, i, largest);
                adjustHeap(nums, largest, k);
            }
        }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}