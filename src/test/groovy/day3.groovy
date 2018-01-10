import org.junit.Test

class day3 {

    static int input = 361527
    private int[][] matrix

    @Test
    void part1() {
        int n = 1;
        while (Math.pow(2 * n - 1, 2) < input) {
            n++
        }
        int max = Math.pow(2 * n - 1, 2) as int
        int dif = max - input
        int A = n - 1
        int P = n - 1 / 2 as int
        int addition = (A / P) * (P - Math.abs(dif % (2 * P) - P)) as int
        int distance = n - 1 + (n - 1 - addition)
        println distance
    }

    @Test
    void part2() {
        println find()
    }

    private int find() {
        int size = 1000
        matrix = new int[size][size]
        int center = size / 2 as int
        matrix[center][center] = 1;
        int layer = 1
        int y = center;
        int x = center + 1;
        while (true) {
            while (y > center - layer) {
                matrix[y][x] = getValue(x, y)
                if (matrix[y][x] > input) {
                    return matrix[y][x]
                }
                y--
            }
            while (x > center - layer) {
                matrix[y][x] = getValue(x, y)
                if (matrix[y][x] > input) {
                    return matrix[y][x]
                }
                x--
            }
            while (y < center + layer) {
                matrix[y][x] = getValue(x, y)
                if (matrix[y][x] > input) {
                    return matrix[y][x]
                }
                y++
            }
            while (x < center + layer + 1) {
                matrix[y][x] = getValue(x, y)
                if (matrix[y][x] > input) {
                    return matrix[y][x]
                }
                x++
            }
            layer++
        }
    }


    private void printMatrix() {
        for (int y = 0; y < matrix.length; y++) {
            for (int x = 0; x < matrix.length; x++) {
                print matrix[y][x] + "\t"
            }
            println ""
        }
        println ""
    }

    private int getValue(int x, int y) {
        int count = 0
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                count += matrix[y + i][x + j];
            }
        }
        return count;
    }

}
