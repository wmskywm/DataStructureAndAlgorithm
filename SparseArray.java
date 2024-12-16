public class SparseArray {
    public static void main(String[] args) {
        //稀疏数组，当一个数组中大部分元素是0，或者为同一个值时，可以使用稀疏数组进行保存
        //处理方式，记录数组有几行几列，有多少个不同的值，这些信息存放在一个小规模数组中
        //假设有一个8 * 8 的二维数组
        int[][] arr = {
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 2, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 3, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 1, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 8, 0},
        };
        System.out.println("原始数组：");
        int elementCount = 0;
        for (int[] arrInner : arr) {
            for (int i : arrInner) {
                if (i != 0){
                    elementCount++;
                }
                System.out.print(i + " ");
            }
            System.out.println();
        }
        int[][] record = new int[elementCount][3];
        int null_index = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                int value = arr[i][j];
                if (value != 0){
                    record[null_index][0] = i;
                    record[null_index][1] = j;
                    record[null_index][2] = value;
                    null_index++;
                }
            }
        }
        System.out.println("稀疏数组：");
        for (int[] ints : record) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
        int[][] reArr = new int[8][8];
        for (int[] ints : record) {
            int row = ints[0];
            int col = ints[1];
            int value = ints[2];
            reArr[row][col] = value;
        }
        System.out.println("恢复后的数组：");
        for (int[] arrInner : reArr) {
            for (int i : arrInner) {
                if (i != 0){
                    elementCount++;
                }
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
