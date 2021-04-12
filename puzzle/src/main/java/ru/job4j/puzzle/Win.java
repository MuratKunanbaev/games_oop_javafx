package ru.job4j.puzzle;

public class Win {
    public static boolean check(int[][] board) {
        boolean rsl = true;
        if (checkColumn(board) == false && checkRow(board) == false) {
            rsl = false;
        };
        return rsl;
    }
    public static boolean checkRow(int[][] arr) {
        boolean result = false;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j] == 1) {
                    sum++;
                }

            }
            if (sum != 5 ) {
                sum = 0;
            }

        }
        if (sum== 5) {
            result = true;
        }
        return result;
    }

    public static boolean checkColumn(int[][] arr) {
        boolean result = false;
        int sum = 0;
        int row = 0;
        int col =0;
        while (col < arr.length && row < arr.length){
            if (arr[col][row] ==1) {
                sum++;
                col++;
            }else{
                col = 0;
                row++;
                sum = 0;
            }

        }
        if (sum== 5) {
            result = true;
        }
        return result;
    }

}


