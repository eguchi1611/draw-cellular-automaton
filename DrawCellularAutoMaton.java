/**
 * DrawCellularAutoMaton
 */
public class DrawCellularAutoMaton {

    public static void main(String[] args) {
        int input = Integer.parseInt(args[0]);
        DrawCellularAutoMaton drawCellularAutoMaton = new DrawCellularAutoMaton();
        int n = 100;
        int[] rule = drawCellularAutoMaton.rule(input);
        int[][] result = drawCellularAutoMaton.calc(rule, n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(result[i][j] == 1 ? "*" : " ");
            }
            System.out.println();
        }
    }

    private int[][] calc(int[] rule, int n) {
        int[][] result = new int[n][n];
        result[0][n / 2] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n - 1; j++) {
                int a = result[i - 1][j - 1];
                int b = result[i - 1][j];
                int c = result[i - 1][j + 1];
                int index = 7 - (a << 2 | b << 1 | c);
                result[i][j] = rule[index];
            }
        }
        return result;
    }

    private int[] rule(int r) {
        int[] rule = new int[8];
        for (int i = 0; i < 8; i++) {
            rule[i] = (r >> i) & 1;
        }
        return rule;
    }
}
