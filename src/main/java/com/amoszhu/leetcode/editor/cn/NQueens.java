//n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。 
//
// 
// 
// 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 4
//输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
//解释：如上图所示，4 皇后问题存在两个不同的解法。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[["Q"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 9 
// 皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。 
// 
// 
// 
// Related Topics 回溯算法 
// 👍 837 👎 0

package com.amoszhu.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    public static void main(String[] args) {
        Solution solution = new NQueens().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> solveNQueens(int n) {
            List<List<String>> res = new ArrayList<>();
            List<String> tracker = new ArrayList<>();
            solveNQueens(res, n, tracker, 0);
            return res;
        }

        private void solveNQueens(List<List<String>> res, int size, List<String> tracker, int idx) {
//            if (tracker.size() == size) {
//                res.add(new ArrayList<>(tracker));
//            }
//            for (int i = 0; i < size; i++) {
//                // 过滤条件
//                if (tracker.)
//            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}