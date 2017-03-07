package LeetCode.BackTrack;

import java.util.ArrayList;
import java.util.List;

/**
 *  Given a 2D board and a list of words from the dictionary, find all words in the board.
    Each word must be constructed from letters of sequentially adjacent cell,
    where "adjacent" cells are those horizontally or vertically neighboring.
    The same letter cell may not be used more than once in a word.
    For example,
    Given words = ["oath","pea","eat","rain"] and board =
    [
        ['o','a','a','n'],
        ['e','t','a','e'],
        ['i','h','k','r'],
        ['i','f','l','v']
    ]
    Return ["eat","oath"].
    Note:
    You may assume that all inputs are consist of lowercase letters a-z.
 */
public class WordSearchII_212
{
    private boolean[][] used;

    public static void main(String[] args)
    {
        WordSearchII_212 solution = new WordSearchII_212();
        char[][] board = {
                {'o','a','a','n'},
                {'e','t','a','e'},
                {'i','h','k','r'},
                {'i','f','l','v'}
                         };
        String[] words = {"oath", "pea", "eat", "rain"};

        System.out.println(solution.findWords(board, words));
    }

    public List<String> findWords(char[][] board, String[] words)
    {
        List<String> result = new ArrayList<>();
        boolean flag = false;

        for(String word : words)
        {
            used = new boolean[board.length][board[0].length];
            for(int i=0; i<board.length && !flag; i++)
                for(int j=0; j<board[0].length && !flag; j++)
                {
                    if(board[i][j] == word.charAt(0) && search(board, word, i, j, 0))
                    {
                        flag = true;
                        if(!result.contains(word))
                            result.add(word);
                    }
                }
        }
       return result;
    }

    public boolean search(char[][] board, String word, int i, int j, int index)
    {
        if(index == word.length())
            return true;

        if(i<0 || i>=board.length || j<0 || j>= board[0].length)
            return false;

        if(board[i][j] != word.charAt(index) || used[i][j])
            return false;

        used[i][j] = true;

        if(search(board, word, i-1, j, index+1) || search(board, word, i+1, j, index+1))
            return true;

        if(search(board, word, i, j-1, index+1) || search(board, word, i, j+1, index+1))
            return true;

        used[i][j] = false;
        return false;
    }
}
