package org.blue.learning.leetcode.day5;

import java.util.Arrays;

/**
 * Created by klein on 2016/10/25.
 */
public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        long currentTime = System.nanoTime();
        System.out.println(longestPalindrome("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabcaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
        System.out.println(System.nanoTime() - currentTime);
        currentTime = System.nanoTime();
        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabcaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        System.out.println(manacher(s));
        System.out.println(System.nanoTime() - currentTime);
//  System.out.println(longestPalindrome("a"));
//        System.out.println(longestPalindrome("zudfweormatjycujjirzjpyrmaxurectxrtqedmmgergwdvjmjtstdhcihacqnothgttgqfywcpgnuvwglvfiuxteopoyizgehkwuvvkqxbnufkcbodlhdmbqyghkojrgokpwdhtdrwmvdegwycecrgjvuexlguayzcammupgeskrvpthrmwqaqsdcgycdupykppiyhwzwcplivjnnvwhqkkxildtyjltklcokcrgqnnwzzeuqioyahqpuskkpbxhvzvqyhlegmoviogzwuiqahiouhnecjwysmtarjjdjqdrkljawzasriouuiqkcwwqsxifbndjmyprdozhwaoibpqrthpcjphgsfbeqrqqoqiqqdicvybzxhklehzzapbvcyleljawowluqgxxwlrymzojshlwkmzwpixgfjljkmwdtjeabgyrpbqyyykmoaqdambpkyyvukalbrzoyoufjqeftniddsfqnilxlplselqatdgjziphvrbokofvuerpsvqmzakbyzxtxvyanvjpfyvyiivqusfrsufjanmfibgrkwtiuoykiavpbqeyfsuteuxxjiyxvlvgmehycdvxdorpepmsinvmyzeqeiikajopqedyopirmhymozernxzaueljjrhcsofwyddkpnvcvzixdjknikyhzmstvbducjcoyoeoaqruuewclzqqqxzpgykrkygxnmlsrjudoaejxkipkgmcoqtxhelvsizgdwdyjwuumazxfstoaxeqqxoqezakdqjwpkrbldpcbbxexquqrznavcrprnydufsidakvrpuzgfisdxreldbqfizngtrilnbqboxwmwienlkmmiuifrvytukcqcpeqdwwucymgvyrektsnfijdcdoawbcwkkjkqwzffnuqituihjaklvthulmcjrhqcyzvekzqlxgddjoir"));
//        System.out.println(longestPalindrome("dddffddd"));
//        System.out.println(longestPalindrome("abb"));
    }

    private static String longestPalindrome(String s) {

        // 暴力破解，此方法会超时 = =  O(n^3)复杂度
//        String longestPalindromicSubstring = "";
//        if (isPalindrome(s)) {
//            return s;
//        }
//        //　循环判断每个子串是否为回文
//        int length = s.length();
//        for (int i = 0; i < length; i ++) {
//            for (int j = i + 1; j <= length; j ++) {
//                String subString = s.substring(i, j);
//                if (isPalindrome(subString) && longestPalindromicSubstring.length() < subString.length()) {
//                    longestPalindromicSubstring = subString;
//                }
//            }
//        }
//        return longestPalindromicSubstring;
        // 动态规划 O(n^2)复杂度
        // 假设p[i][j]表示字符串的第i位至第j位的子串
        // 如果p[i][j]为回文串，那么p[i+1][j-1]一定为回文串
        // 所以可以从最小的回文串往外扩展
        boolean[][] p  = new boolean[s.length()][s.length()]; // 题目假设字符串最长为1000
        for (int i = 0; i < s.length(); i ++) {
            Arrays.fill(p[i], false); // 初始化
        }
        int start = 0;
        int maxLength = 1;
        int times = 0;
        for (int i = 0; i < s.length(); i ++) {
            p[i][i] = true;// 每单个字符串都是回文
            if (i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) {
                p[i][i + 1] = true;
                start = i;
                maxLength = 2;
                times ++;
            }
        }
        for (int subLength = 3; subLength <= s.length(); subLength ++) {
            for (int startIndex = 0; startIndex <= s.length() - subLength; startIndex ++) {
                int endIndex = startIndex + subLength - 1;
                if (p[startIndex + 1][endIndex - 1] && s.charAt(startIndex) == s.charAt(endIndex)) {
                    p[startIndex][endIndex] = true;
                    maxLength = subLength;
                    start = startIndex;
                    times ++;
                }
            }
        }
        System.out.println(times);
//        必须要以长度为外层循环，因为动态规划需要子问题先求解，如果长度为内循环，可能子问题还没求解，它的结果已经被使用了
//        比如第一次循环时，外层循环为0，里层循环依次从3->4->5.... 长度为4循环时需要用到长度为3的回文串的解，而长度为3的回文串还没解完
//        所以计算结果会有错误
//        for (int startIndex = 0; startIndex < s.length(); startIndex ++) {
//            for (int subLength = 3; subLength <= s.length() - startIndex; subLength ++) {
//                int endIndex = startIndex + subLength - 1;
////                System.out.println(i + "--" + endIndex)
//                if (p[startIndex + 1][endIndex - 1] && s.charAt(startIndex) == s.charAt(endIndex)) {
//                    p[startIndex][endIndex] = true;
//                    start = startIndex;
//                    maxLength = subLength;
//                }
//            }
//        }
        return s.substring(start, start + maxLength);

    }

    private static String center(String s) {
        // 中心扩展法 时间复杂度O(n^2)
        // 以字符串的每个字母为中心 向外扩展判断到最长的回文串
        // 中心扩展法需要分两种情况判断，一种是假设回文子穿为奇数（则是以当前字母为中心）一种是假设回文子串为偶数（则以中心2个字母为中心）
        int maxLength = 1;
        int start = 0;
        for (int startIndex = 0; startIndex < s.length(); startIndex ++) {
            int left = startIndex - 1;
            int right = startIndex +1;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                if (right -left + 1 > maxLength) {
                    start = left;
                    maxLength = right - left + 1;
                }
                left --;
                right ++;
            }

            left = startIndex;
            right = startIndex + 1;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                if (right -left + 1 > maxLength) {
                    start = left;
                    maxLength = right - left + 1;
                }
                left --;
                right ++;
            }
        }
        return s.substring(start, start + maxLength);
    }

    private static String manacher(String s) {
        // manacher算法 时间复杂度 O(n)
        // 利用回文串的性质减少无用的比较
        // 用一个数组radius[i]表示字符串中以第i的字符为中心的子回文串的半径
        // 如 abbcbfe; radius[3] = 1 即以字符c为中心的回文串半径为1,回文串为bcb，其他的如radius[0] = 0, radius[1]=1;
        // 这里可以发现以第二个字符（即'b'）为中心时，是找不到回文串的，但是它与下一个字符b也可以组成回文串，这就是因为这个子回文串是偶数个字符串
        // 所以加一点辅助字符进去，即每个字符前后都加上一个特殊字符如'#'，上述字符串变为#a#b#b#c#b#f#e#
        // 现在这个新的字符串将不存在长度为偶数的子回文串（上面提到的bb这个子回文串已经变成的#b#b#，以一个#号为中心）
        // 现在再来求解radius数组，我们先用目测的方法，求出radius[] = {0, 1, 0, 1, 2, 1, 0, 3, 0, 1, 0, 1, 0, 1, 0}
        // 通过这个数组可以发现以字符串的第8个位置的字符为中心的子回文串是最长的，半径为3，即以字符'c'为中心的 '#b#c#b#'这个子回文串
        // 所以求解最长子回文串的问题可以转换成求这个radius数组的值
        // 当然最简单最暴力的办法就是依次遍历每个字符，去求以当前字符为中心的子回文串的半径是多少（之前目测算出上面这个字符串的方法就是这样，哈哈）
        // 但我们可以利用回文串的一些特性，减少一些比较次数，达到更优的算法复杂度
        // 我们是从字符串的第一个字符依次向右求解，假设我们再求第i个字符的回文串半径时，前面的i-1的字符的回文串半径都已经求解出来了，也就是radius[0]-->radius[i-1]的值都是确定的
        // 设定一个变量max_right表示以前i-1个字符为中心的所有的子回文串能到达的最右侧的位置，假设这个子回文串的中心位置为pos，即pos + radius[pos]的右边界是最远的，如下图所示
        // -----left------I------------pos------------i-------max_right----- (left是指pos为中心的子回文串的左边界）
        // 现在来看i的位置：
        // 1.假设i >= max_right，这时候没办法利用之前计算的结果，只能老老实实通过中心扩展的方法计算i的半径
        // 2.假设i在pos和max_right之间，根据回文串的对称性，可以算出i的对称点I，radius[I]的值是已知的。
        //   注意上图中left-->I的距离和i-->max_right的距离是一致的
        //   现在分为三种情况：
        //   1、如果radius[I] > (I-left)，那么radius[i] = max_right - i，利用反证法证明。
        //      如果I的半径大于I-left，那么I这个回文串必须向左延伸一部分（超过left）
        //      根据回文串的性质，左侧延伸出去的一部分必然在I到pos之间也有对称的一部分
        //      我们假设radius[i] > max_right - i，同上所述，以i为中心的回文串会延伸到max_right右侧，
        //      根据回文对称性，i左侧的一部分与i右侧的一部分对称，而i左侧一部分在[pos--->i]这个区间内，是属于以pos为中心的回文串的一部分，
        //      这一部分将与[pos--->I]之间的那一部分对称，而[pos--->I]之间的那部分又与I回文串左侧的那部分对称（因为I也是一个回文串的中心），且它的半径
        //      大于I-left（上面假设的），所以以I为中心的回文串和以i为中心的回文串完全对称，那么以pos为中心的回文串就不是原来那么长，他必然要继续向外延展，
        //      这与之前算出的结果矛盾，所以radius[i] 只能为max_right - i;
        //   2、如果radius[I] < I-left， 没什么好说的，根据回文串的性质，radius[i]=radius[I]
        //   3、如果radius[I] = I-left，但此时radius[i]不一定等于radius[I]，可举例说明
        // 结合以上两种情况，radius[i] = min(radius[I], max_right - i);（两者之间较小的一部分）
        StringBuilder newString = new StringBuilder("#");
        // 预处理string，加上特殊字符
        for (int i = 0; i < s.length(); i ++) {
            newString.append(s.charAt(i)).append("#");
        }
        int len = newString.length();
        int[] radius = new int[len];
        int maxRight = 0;// 初始能达到的最右侧为0;
        int maxRightPos = 0;
        for (int i = 1; i < len; i ++ ) {
            if (i >= maxRight) {
                int start = i - 1;
                int end = i + 1;
                while ( start >= 0 && end < len && newString.charAt(start) == newString.charAt(end)) {
                    maxRight = end;
                    radius[i] = end - i;
                    maxRightPos = i;
                    start --;
                    end ++;
                }
            } else {
                int r1 = maxRight - i;
                int symmetryIPos = 2 * maxRightPos - i; // 对称位置
                int r2 = radius[symmetryIPos];
                radius[i] = r1 < r2 ? r1 : r2;
                if (symmetryIPos - radius[symmetryIPos] == maxRightPos - radius[maxRightPos]) {
                    // 如果左侧对称点刚好与最大的回文子串左侧重叠，需要继续探索
                    int start = i - radius[i] - 1;
                    int end = i + radius[i] + 1;
                    while (start >=0 && end < len && newString.charAt(start) == newString.charAt(end)) {
                        radius[i] = radius[i] + 1;
                        if (end > maxRight) {
                            maxRight = end;
                            maxRightPos = i;
                        }
                        start --;
                        end ++;
                    }
                }
            }
//            times ++;
        }
        int maxRadiusPos = 0;
        int maxRadius = 0;
        for (int i = 0; i < radius.length; i ++) {
            if (radius[i] > maxRadius) {
                maxRadiusPos = i;
                maxRadius = radius[i];
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = maxRadiusPos - maxRadius; i <= maxRadiusPos + maxRadius; i ++) {
            if ('#' != newString.charAt(i)) {
                result.append(newString.charAt(i));
            }
        }
        return result.toString();
    }

    // 判断是否为回文字符串
    private static boolean isPalindrome(String s) {
        int length = s.length();
        if (length == 1) {
            return false;
        }
        for (int i = 0; i < length / 2; i ++) {
            if (s.charAt(i) != s.charAt(length - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
