import java.util.Scanner;

public class Sudoku {
    private final int[][] board = new int[9][9];
    private final boolean[][] fixed = new boolean[9][9];

    public Sudoku(String input) {
        for (String entry : input.trim().split(" ")) {
            String[] parts = entry.split(";");
            String[] coords = parts[0].split(",");
            int col = Integer.parseInt(coords[0]);
            int row = Integer.parseInt(coords[1]);
            int value = Integer.parseInt(parts[1]);
            boolean isFixed = Boolean.parseBoolean(parts[2]);
            board[row][col] = value;
            fixed[row][col] = isFixed;
        }
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            printBoard();
            System.out.print("linha,coluna,valor (ou 'sair'): ");
            String input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("sair")) break;

            String[] parts = input.split(",");
            if (parts.length != 3) continue;

            try {
                int row = Integer.parseInt(parts[0]);
                int col = Integer.parseInt(parts[1]);
                int val = Integer.parseInt(parts[2]);

                if (row < 0 || row > 8 || col < 0 || col > 8 || val < 1 || val > 9) continue;
                if (fixed[row][col]) continue;
                if (!isValid(row, col, val)) continue;

                board[row][col] = val;
            } catch (Exception ignored) {}
        }
        scanner.close();
    }

    private boolean isValid(int row, int col, int val) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == val || board[i][col] == val) return false;
        }
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int r = startRow; r < startRow + 3; r++) {
            for (int c = startCol; c < startCol + 3; c++) {
                if (board[r][c] == val) return false;
            }
        }
        return true;
    }

    private void printBoard() {
        System.out.println("\n   0 1 2 3 4 5 6 7 8");
        for (int i = 0; i < 9; i++) {
            System.out.print(i + "  ");
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] == 0 ? ". " : board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        String input = "0,0;4,false 1,0;7,false 2,0;9,true 3,0;5,false 4,0;8,true 5,0;6,true 6,0;2,true 7,0;3,false 8,0;1,false " +
                       "0,1;1,false 1,1;3,true 2,1;5,false 3,1;4,false 4,1;7,true 5,1;2,false 6,1;8,false 7,1;9,true 8,1;6,true " +
                       "0,2;2,false 1,2;6,true 2,2;8,false 3,2;9,false 4,2;1,true 5,2;3,false 6,2;7,false 7,2;4,false 8,2;5,true " +
                       "0,3;5,true 1,3;1,false 2,3;3,true 3,3;7,false 4,3;6,false 5,3;4,false 6,3;9,false 7,3;8,true 8,3;2,false " +
                       "0,4;8,false 1,4;9,true 2,4;7,false 3,4;1,true 4,4;2,true 5,4;5,true 6,4;3,false 7,4;6,true 8,4;4,false " +
                       "0,5;6,false 1,5;4,true 2,5;2,false 3,5;3,false 4,5;9,false 5,5;8,false 6,5;1,true 7,5;5,false 8,5;7,true " +
                       "0,6;7,true 1,6;5,false 2,6;4,false 3,6;2,false 4,6;3,true 5,6;9,false 6,6;6,false 7,6;1,true 8,6;8,false " +
                       "0,7;9,true 1,7;8,true 2,7;1,false 3,7;6,false 4,7;4,true 5,7;7,false 6,7;5,false 7,7;2,true 8,7;3,false " +
                       "0,8;3,false 1,8;2,false 2,8;6,true 3,8;8,true 4,8;5,true 5,8;1,false 6,8;4,true 7,8;7,false 8,8;9,false";
        Sudoku game = new Sudoku(input);
        game.play();
    }
}
