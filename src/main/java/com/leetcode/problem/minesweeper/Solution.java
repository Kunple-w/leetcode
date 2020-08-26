package com.leetcode.problem.minesweeper;

import java.util.HashSet;
import java.util.Set;

/**
 * <pre>
 *     输入:
 *
 * [['E', 'E', 'E', 'E', 'E'],
 *  ['E', 'E', 'M', 'E', 'E'],
 *  ['E', 'E', 'E', 'E', 'E'],
 *  ['E', 'E', 'E', 'E', 'E']]
 *
 * Click : [3,0]
 *
 * 输出:
 *
 * [['B', '1', 'E', '1', 'B'],
 *  ['B', '1', 'M', '1', 'B'],
 *  ['B', '1', '1', '1', 'B'],
 *  ['B', 'B', 'B', 'B', 'B']]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minesweeper
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </pre>
 *
 * @author wangyongxu
 * @date 2020/8/20 10:22 下午
 */
public class Solution {
    public static final char M = 'M';
    public static final char E = 'E';
    public static final char B = 'B';
    public static final char X = 'X';

    public static final char N = 'N';

    /**
     * 递归的方式，退出条件:
     * 2. 点击到M
     * 3. 点击到空白后揭开到最终
     *
     * @param board :
     * @param click :
     * @return char[][]
     * @author hugh
     * @date : 2020-08-20 10:28:03
     */
    public char[][] updateBoard(char[][] board, int[] click) {
        int y = click[0];
        int x = click[1];
        if (y < 0 || x < 0 || y > board.length + 1 || x > board[0].length + 1) {
            return board;
        }
        Around around = new Around(board, click);
        if (around.isMine()) {
            board[y][x] = X;
        } else {
            char count = around.getAroundMineCount();
            board[y][x] = count;
            // 如果是空，开始计算周围的数量
            if (count == B) {
                if (around.getP1() != N) {
                    click[0] = y - 1;
                    click[1] = x - 1;
                    updateBoard(board, click);
                }
                if (around.getP2() != N) {
                    click[0] = y - 1;
                    click[1] = x;
                    updateBoard(board, click);
                }
                if (around.getP3() != N) {
                    click[0] = y - 1;
                    click[1] = x + 1;
                    updateBoard(board, click);
                }
                if (around.getP4() != N) {
                    click[0] = y;
                    click[1] = x - 1;
                    updateBoard(board, click);
                }
                if (around.getP5() != N) {
                    click[0] = y;
                    click[1] = x + 1;
                    updateBoard(board, click);
                }
                if (around.getP6() != N) {
                    click[0] = y + 1;
                    click[1] = x - 1;
                    updateBoard(board, click);
                }
                if (around.getP7() != N) {
                    click[0] = y + 1;
                    click[1] = x;
                    updateBoard(board, click);
                }
                if (around.getP8() != N) {
                    click[0] = y + 1;
                    click[1] = x + 1;
                    updateBoard(board, click);
                }
            } else {
                board[y][x] = count;
            }
        }
        return board;

    }

    static class Around {

        private static Set<Character> digits = new HashSet<Character>(8);

        static {
            digits.add('1');
            digits.add('2');
            digits.add('3');
            digits.add('4');
            digits.add('5');
            digits.add('6');
            digits.add('7');
            digits.add('8');
        }

        public Around(char[][] board, int[] click) {
            int y = click[0];
            int x = click[1];
            this.board = board;
            this.p = board[y][x];

            this.p1 = adjust(x - 1, y - 1);
            this.p2 = adjust(x, y - 1);
            this.p3 = adjust(x + 1, y - 1);

            this.p4 = adjust(x - 1, y);
            this.p5 = adjust(x + 1, y);

            this.p6 = adjust(x - 1, y + 1);
            this.p7 = adjust(x, y + 1);
            this.p8 = adjust(x + 1, y + 1);
        }

        public boolean isMine() {
            return this.p == M;
        }

        public char getAroundMineCount() {
            int count = 0;
            if (p1 == M) {
                count++;
            }
            if (p2 == M) {
                count++;
            }
            if (p3 == M) {
                count++;
            }
            if (p4 == M) {
                count++;
            }
            if (p5 == M) {
                count++;
            }
            if (p6 == M) {
                count++;
            }
            if (p7 == M) {
                count++;
            }
            if (p8 == M) {
                count++;
            }

            return count == 0 ? 'B' : (char) count;
        }

        private char adjust(int x, int y) {
            try {
                return board[y][x];
            } catch (IndexOutOfBoundsException e) {
                return N;
            }
        }

        private char p;
        private char[][] board;

        private char p1;
        private char p2;
        private char p3;
        private char p4;
        private char p5;
        private char p6;
        private char p7;
        private char p8;
        private char p9;

        public char getP1() {
            return p1;
        }

        public void setP1(char p1) {
            this.p1 = p1;
        }

        public char getP2() {
            return p2;
        }

        public void setP2(char p2) {
            this.p2 = p2;
        }

        public char getP3() {
            return p3;
        }

        public void setP3(char p3) {
            this.p3 = p3;
        }

        public char getP4() {
            return p4;
        }

        public void setP4(char p4) {
            this.p4 = p4;
        }

        public char getP5() {
            return p5;
        }

        public void setP5(char p5) {
            this.p5 = p5;
        }

        public char getP6() {
            return p6;
        }

        public void setP6(char p6) {
            this.p6 = p6;
        }

        public char getP7() {
            return p7;
        }

        public void setP7(char p7) {
            this.p7 = p7;
        }

        public char getP8() {
            return p8;
        }

        public void setP8(char p8) {
            this.p8 = p8;
        }

        public char getP9() {
            return p9;
        }

        public void setP9(char p9) {
            this.p9 = p9;
        }

        public char getP() {
            return p;
        }

        public void setP(char p) {
            this.p = p;
        }
    }
}
