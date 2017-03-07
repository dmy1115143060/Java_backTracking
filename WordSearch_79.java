package LeetCode.BackTrack;

/**
 *  Given a 2D board and a word, find if the word exists in the grid.
 *  The word can be constructed from letters of sequentially adjacent cell,
 *  where "adjacent" cells are those horizontally or vertically neighboring.
 *  The same letter cell may not be used more than once.
    For example,
    Given board =
    [
        ['A','B','C','E'],
        ['S','F','C','S'],
        ['A','D','E','E']
    ]
    word = "ABCCED", -> returns true,
    word = "SEE", -> returns true,
    word = "ABCB", -> returns false.
 */
public class WordSearch_79
{
    //用于判断当前字符数组中的元素是否被访问过
    private boolean[][] visited;

    public static void main(String[] args)
    {
        WordSearch_79 solution = new WordSearch_79();

        char[][] board = {
                            {'A','B','C','E'},
                            {'S','F','E','S'},
                            {'A','D','E','E'}
                         };
        String word = "ABCESEEEFS";

        System.out.println(solution.exist(board, word));
    }

    public boolean exist(char[][] board, String word)
    {
        visited = new boolean[board.length][board[0].length];

        //每次从word的第一个匹配的字符处开始遍历
        for(int i=0; i<board.length; i++)
            for(int j=0; j<board[0].length; j++)
            {
                if(word.charAt(0) == board[i][j] && search(board, word, i, j, 0))
                    return true;
            }
        return false;
    }

    /**
     * @param board : 字符数组
     * @param word  : 待判断的字符串
     * @param i     : 当前访问的字符数组元素对应的行号
     * @param j     : 当前访问的字符数组元素对应的列号
     * @param index : 当前待判断的字符串对应的字符下标
     * @return
     */
    public boolean search(char[][] board, String word, int i, int j, int index)
    {
        //说明当前word的所有字符都可以在board中连续的进行找到
        if(index == word.length())
            return true;

        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index) || visited[i][j])
            return false;

        //访问board中的元素,当前元素和word中的字符相匹配，继续搜寻，并标记已经被访问过
        visited[i][j] = true;

        //按照上下左右四个方向进行搜寻
        if(search(board, word, i-1, j, index+1) ||
                search(board, word, i+1, j, index+1) ||
                search(board, word, i, j-1, index+1) ||
                search(board, word, i, j+1, index+1)){
            return true;
        }

        //用于回退，因为可能走了其他路径，回退时保证元素可以重新被访问
        visited[i][j] = false;
        return false;
    }
}
