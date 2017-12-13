import org.junit.Test

class day4 {

    @Test
    void part1() {
        println getClass().getResource("day4.txt").readLines().stream().filter({
            def list = it.tokenize(' ')
            list.size() == list.unique().size()
        }).count()
    }

    @Test
    void part2() {
        println getClass().getResource("day4.txt").readLines().stream().filter({
            def list = it.tokenize(' ')
            list.size() == list.unique().size()
        }).filter({
            def list = it.tokenize(' ')
            def unique = list.stream().map({ it.toSet().sort().join() }).distinct().count()
            list.size() == unique
        }).count()
    }
}
