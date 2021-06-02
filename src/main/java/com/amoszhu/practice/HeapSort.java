package com.amoszhu.practice;

/**
 * @author zhuliangzhou
 */
public class HeapSort {
    public static void heapSort(int[] nums) {
        // 构造大根堆,循环往堆中添加元素
        buildHeap(nums);
        int heapSize = nums.length;
        // 逐个调整堆
        while(heapSize > 1) {
            // 将当前元素与最后一个元素交换
            swap(nums, 0, heapSize);
            // 堆顶元素替换到了最后，不再参与排序
            heapSize --;
            // 调整剩下的堆
            adjustHeap(nums, 0, heapSize);
        }
    }

    /**
     * 拿出一个元素后重新调整剩下的堆,自顶向下
     * @param nums
     * @param index
     * @param heapSize
     */
    private static void adjustHeap(int[] nums, int index, int heapSize) {
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        while (left < heapSize) {
            int largestIndex = index;
            if (nums[left] < nums[right] && right < heapSize) {
                largestIndex = right;
            } else {
                largestIndex = left;
            }
            // 比较父节点的值与孩子中的最大值
            if (nums[index] > nums[largestIndex]) {
                largestIndex = index;
                break;
            }
            swap(nums, largestIndex, index);
            // 继续往下调整
            index = largestIndex;
            left = 2 * index + 1;
            right = 2 * index + 2;
        }
    }

    private static void swap(int[] nums, int i, int heapSize) {
        int temp = nums[i];
        nums[i] = nums[heapSize];
        nums[heapSize] = temp;
    }

    private static void buildHeap(int[] nums) {
        // 构建堆时自下而上
        for (int i = 0; i < nums.length; i++) {
            // 当前插入的索引
            int curr = i;
            // 父节点索引
            int fatherIndex = (curr-1)/2;
            while (nums[curr] > nums[fatherIndex]) {
                swap(nums, curr, fatherIndex);
                // 继续向上判断
                curr = fatherIndex;
                fatherIndex = (curr - 1) / 2;
            }
        }
    }
}
