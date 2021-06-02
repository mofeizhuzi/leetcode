//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。 
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。 
//
// 
//
// 示例: 
//
// 给定 nums = [2, 7, 11, 15], target = 9
//
//因为 nums[0] + nums[1] = 2 + 7 = 9
//所以返回 [0, 1]
// 
// Related Topics 数组 哈希表 
// 👍 9083 👎 0


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//Java：两数之和
public class P1TwoSum {
    static int i;
    final float i3 = 3.14f;

    public static void main(String[] args) {
        boolean b = true ? false : true == true ? false : true;
        System.out.println(b);

        long temp = (int) 3.9;
        System.out.println(temp %= 2);

        int a[] = new int[10];
        System.out.println(a[9]);

        int aaa = Integer.parseInt("2131231a");
    }

    /**
     * amos zhu
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map map = new HashMap(nums.length);
            for (int i = 0; i < nums.length; i++) {
                int left = target - nums[i];
                if (map.containsKey(left)) {
                    return new int[]{i, (int) map.get(left)};
                }
                map.put(nums[i], i);
            }
            return null;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}