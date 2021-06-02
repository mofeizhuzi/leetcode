//一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。 
//
// 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。 
//
// 示例 1： 
//
// 输入：n = 2
//输出：2
// 
//
// 示例 2： 
//
// 输入：n = 7
//输出：21
// 
//
// 示例 3： 
//
// 输入：n = 0
//输出：1 
//
// 提示： 
//
// 
// 0 <= n <= 100 
// 
//
// 注意：本题与主站 70 题相同：https://leetcode-cn.com/problems/climbing-stairs/ 
//
// 
// Related Topics 递归 
// 👍 156 👎 0

package com.amoszhu.leetcode.editor.cn;

public class QingWaTiaoTaiJieWenTiLcof {
    public static void main(String[] args) {
        Solution solution = new QingWaTiaoTaiJieWenTiLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numWays(int n) {
            // 递推公式：f(n) = f(n-1) + f(n-2)
            int p = 0; // 走到n-2有多少种方法
            int q = 0; // 走到n-1有多少种方法
            int res = 1; // 走到n有多少种方法
            for (int i = 1; i <= n; ++i) {
                // 滚动数组，将f(n-1)的值转移到p，f(n)的值转移到q
                p = q;
                q = res;
                res = (p + q) % 1000000007; // 取余运算处理数字边界问题
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}