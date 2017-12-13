import org.junit.Test

class day1 {


    @Test
    void part1() {
        String string = getClass().getResource("day1.txt").text
        int count = 0
        for (int i = 0; i < string.length(); i++) {
            char a = string.charAt(i)
            char b = string.charAt((i + 1) % string.length())
            if (a == b) {
                count += Integer.parseInt(a as String)
            }
        }
        println count
    }

    @Test
    void part2() {
        String string = getClass().getResource("day1.txt").text
        int count = 0
        for (int i = 0; i < string.length(); i++) {
            char a = string.charAt(i)
            char b = string.charAt((i + (string.length() / 2) as int) % string.length())
            if (a == b) {
                count += Integer.parseInt(a as String)
            }
        }
        println count
    }


}
