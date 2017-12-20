import org.junit.Test

class day5 {

    @Test
    void part1() {
        def maze = getClass().getResource("day5.txt").readLines()*.toInteger()
        int steps, index
        while (index < maze.size()) {
            index += maze[index]++
            steps++
        }
        println steps
    }

    @Test
    void part2() {
        def maze = getClass().getResource("day5.txt").readLines()*.toInteger()
        int steps, index
        while (index < maze.size()) {
            if (maze[index] >= 3) {
                index += maze[index]--
            } else {
                index += maze[index]++
            }
            steps++
        }
        println steps
    }
}
