package com.leetcode.problem.minesweeper;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void test() {
        char[][] board = new char[][]{
                {'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'M', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'}
        };
        int[] click = new int[]{3, 0};
        char[][] chars = new Solution().updateBoard(board, click);
        for (char[] aChar : chars) {
            System.out.println(Arrays.toString(aChar));
        }
    }

}