//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。 
//
// 说明：本题中，我们将空字符串定义为有效的回文串。 
//
// 示例 1: 
//
// 输入: "A man, a plan, a canal: Panama"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "race a car"
//输出: false
// 
// Related Topics 双指针 字符串 
// 👍 367 👎 0

package com.amoszhu.leetcode.editor.cn;

public class ValidPalindrome {
    public static void main(String[] args) {
        Solution solution = new ValidPalindrome().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPalindrome(String s) {
            if (s.isEmpty()) {
                return true;
            }

            // 方法一：采用双指针遍历字符串,一前一后比较
            // 方法二：采用StringBuffer来实现字符串反转，有取巧成分
            // 核心方法：Character.isLetterOrDigit(ch)，判断字符是否是字母或者数字
//            StringBuffer strGood = new StringBuffer();
//            for (char charItem: s.toCharArray()) {
//                if (Character.isLetterOrDigit(charItem)) {
//                    strGood.append(charItem);
//                }
//            }
//
//            int left = 0;
//            int right = strGood.length() - 1;
//            while (left < right) {
//                if (Character.toLowerCase(strGood.charAt(left)) != Character.toLowerCase(strGood.charAt(right))) {
//                    return false;
//                }
//                left ++;
//                right --;
//            }
//            return true;

            // 方法3：不生成额外空间，在原串上进行判断
            int left = 0;
            int right = s.length() - 1;
            while (left < right) {
                // 需要分别判断左右指针当前所指元素是否是数字或者字母
                while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                    ++left;
                }

                while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                    --right;
                }

                if (left < right) {
                    if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                        return false;
                    }
                    ++left;
                    --right;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}