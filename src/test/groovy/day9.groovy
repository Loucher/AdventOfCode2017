import org.junit.Test

class day9 {


    @Test
    void part1and2() {
        assert evaluate("{}").part1 == 1
        assert evaluate("{{{}}}").part1 == 6
        assert evaluate("{{},{}}").part1 == 5
        assert evaluate("{{{},{},{{}}}}").part1 == 16
        assert evaluate("{<a>,<a>,<a>,<a>}").part1 == 1
        assert evaluate("{{<ab>},{<ab>},{<ab>},{<ab>}}").part1 == 9
        assert evaluate("{{<!!>},{<!!>},{<!!>},{<!!>}}").part1 == 9
        assert evaluate("{{<a!>},{<a!>},{<a!>},{<ab>}}").part1 == 3

        assert evaluate("<>").part2 == 0
        assert evaluate("<random characters>").part2 == 17
        assert evaluate("<<<<>").part2 == 3
        assert evaluate("<{!>}>").part2 == 2
        assert evaluate("<!!>").part2 == 0
        assert evaluate("<!!!>>").part2 == 0
        assert evaluate('<{o"i!a,<{i<a>').part2 == 10

        println evaluate(getClass().getResource("day9.txt").text)
    }

    static def evaluate(String stream) {
        int level = 1
        int score = 0
        int removed = 0
        boolean isGarbage
        for (int i = 0; i < stream.size(); i++) {
            char c = stream.charAt(i)
            if (c == '!') {
                i++
            } else if (isGarbage) {
                if (c == '>') {
                    isGarbage = false
                } else {
                    removed++
                }
            } else {
                switch (c) {
                    case '{':
                        score += level++
                        break
                    case '}':
                        level--
                        break
                    case '<':
                        isGarbage = true
                        break
                }
            }
        }
        return [part1: score, part2: removed]
    }


}
