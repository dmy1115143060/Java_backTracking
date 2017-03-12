package LeetCode.BackTrack;

import java.util.ArrayList;

/**
 *  Given a string s, partition s such that every substring of the partition is a palindrome.
    Return the minimum cuts needed for a palindrome partitioning of s.
    For example, given s = "aab",
    Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
 */
public class Palindrome_Partitioning_II_132 {

    private int minNum = Integer.MAX_VALUE;
    ArrayList<String> currList;

    public static void main(String[] args) {

        Solution solution = new Solution();
        System.out.println(solution.minCut("fifgbeajcacehiicccfecbfhhgfiiecdcjjffbghdidbhbdbfbfjccgbbdcjheccfbhafehieabbdfeigbiaggchaeghaijfbjhi"));
    }

    public int minCut(String s) {

        if(isPalindrome(s,0,s.length()-1))
            return 0;
        currList = new ArrayList<>();
        backTrack(s,0);
        return minNum - 1;
    }

    public void backTrack(String s, int l) {

        if(currList.size()>0 //the initial str could be palindrome
                && l>=s.length()) {
            if(currList.size() < minNum)
                minNum = currList.size();
        }

        for(int i=l;i<s.length();i++) {

            if(isPalindrome(s,l,i)) {
                if(l==i)
                    currList.add(Character.toString(s.charAt(i)));
                else
                    currList.add(s.substring(l,i+1));
                backTrack(s,i+1);
                currList.remove(currList.size()-1);
            }
        }
    }

    public boolean isPalindrome(String str, int l, int r) {

        if(l==r) return true;
        while(l<r) {
            if(str.charAt(l)!=str.charAt(r)) return false;
            l++;r--;
        }
        return true;
    }
}
