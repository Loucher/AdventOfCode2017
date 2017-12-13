import org.junit.Test

class day2 {

    @Test
    void part1() {
        int checksum = 0
        getClass().getResource("day2.txt").eachLine { line ->
            Scanner s = new Scanner(line).useDelimiter("\\t")
            int smallest = Integer.MAX_VALUE
            int largest = Integer.MIN_VALUE
            while (s.hasNext()) {
                int number = s.nextInt()
                if (smallest > number) {
                    smallest = number
                }
                if (largest < number) {
                    largest = number
                }
            }
            println line
            println "$largest $smallest"
            checksum += largest - smallest
        }
        println checksum
    }

    @Test
    void part2() {
        int checksum = 0
        getClass().getResource("day2.txt").eachLine { line ->
            int[] numbers = line.findAll(/\d+/)*.toInteger()
            for (int i = 0; i < numbers.length - 1; i++) {
                for (int j = i + 1; j < numbers.length; j++) {
                    if (numbers[i] % numbers[j] == 0) {
                        checksum += numbers[i] / numbers[j]
                    }
                    if (numbers[j] % numbers[i] == 0) {
                        checksum += numbers[j] / numbers[i]
                    }
                }
            }
        }
        println checksum
    }
}
