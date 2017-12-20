import org.junit.Test

import java.lang.reflect.Array

class day6 {

    @Test
    void part1() {
        Set<List<Integer>> states = new HashSet<>()
//        List<Integer> state = getClass().getResource("day6.txt").text.split("\t")*.toInteger()
        List<Integer> state = [0, 2, 7, 0]
        states.add(state.clone() as List<Integer>)
        int cycles = 0
        while (true) {
            int biggestIndex = state.indexOf(state.max())
            int biggestValue = state.max()
            state.set(biggestIndex, 1)
            int index = biggestIndex + 1
            while (biggestValue > 1) {
                int i = index++ % state.size()
                if (i != biggestIndex) {
                    state.set(i, state.get(i) + 1)
                    biggestValue--
                }
            }
            println state
            if (states.contains(state)) {
                break
            }
            cycles++
        }
    }
}
