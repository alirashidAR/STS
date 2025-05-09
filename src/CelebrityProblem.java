import java.util.*;

public class CelebrityProblem {
    public static int celebrtiySolution(int[][] mat){
        Stack<Integer> stk = new Stack<>();
        for(int i = 0; i < mat.length; i++){
            stk.push(i);
        }
        while(stk.size()>1){
            int col = stk.pop();
            int row = stk.pop();
            if(mat[row][col] == 1){
                stk.push(col);
            }else{
                stk.push(row);
            }
        }
        int x = stk.pop();
        for(int j = 0; j < mat.length; j++){
            if(x==j){
                continue;
            }
            if(mat[x][j] == 1){
                return -1;
            }
        }
        for(int i = 0; i < mat.length; i++){
            if(i==x){
                continue;
            }
            if(mat[i][x]  == 0){
                return -1;
            }
        }

        return x;
    }

    public static void printMatrix(int[][] mat){
        for(int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] mat = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                mat[i][j] = sc.nextInt();
            }
        }
        printMatrix(mat);
        System.out.println(celebrtiySolution(mat));
    }
}
