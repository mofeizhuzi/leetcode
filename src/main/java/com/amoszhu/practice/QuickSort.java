package com.amoszhu.practice;

import com.sun.scenario.effect.Brightpass;

/**
 * @author zhuliangzhou
 */
public class QuickSort {
    public static void main(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        // 初始调用
        quickSort(arr, 0, arr.length - 1);
    }

    /**
     * 划分子序列，返回界线index
     *
     * @param arr
     * @param i
     * @param j
     * @return int
     */
    private static int partition(int[] arr, int left, int right) {
        //取第一个元素当作基准值，可以优化为随机数取值，此时left有坑
        int pivot = arr[left];
        while (left < right) {
            while (left < right && arr[right] >= pivot) {
                // 右边元素大于等于基准元素时，右指针前移
                right --;
            }
            // 出来第一个循环时，代表当前右指针元素小于基准值,填坑，此时right处无值
            arr[left] = arr[right];
            while (left < right && arr[left] <= pivot) {
                // 左边元素小于等于基准元素时，左指针后移
                left ++;
            }
            // 出来第二个循环时，代表当前左指针元素大于基准值,填right坑
            arr[right] = arr[left];
        }
        // 把基准值放到新的left处
        arr[left] = pivot;
        return left;
    }

    /**
     * 递归调用划为子序列
     *
     * @param arr
     */
    private static void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        // 基准值确定
        int pivot = partition(arr, left, right);
        // 递归调用 [0, pivotIndex-1],[pivotIndex+1, right]
        quickSort(arr, left, pivot - 1);
        quickSort(arr, pivot + 1, right);
    }
}
