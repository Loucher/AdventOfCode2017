import org.junit.Test

class day6 {

    @Test
    void part1() {

        List<Integer> state = getClass().getResource("day6.txt").text.split("\t")*.toInteger()
//        int cycles = calculate([0, 2, 7, 0])
        println calculate(state)
    }


    private int calculate(List<Integer> state) {
        List<int[]> states = new ArrayList<>()
        states.add(state.clone() as int[])
        int cycles = 0
        while (true) {
            int index = state.indexOf(state.max())
            int value = state.max()
            int share = Math.max(value / (state.size() - 1) as int, 1) as int
            state.set(index, 0)
            while (value > 0) {
                index = (index + 1) % (state.size())
                int dif = share
                if (value < share) {
                    dif = value
                }
                state.set(index, state.get(index) + dif)
                value -= dif
            }

//            println state
            for (int i = 0; i < states.size(); i++) {
                List<Integer> s = states.get(i)
                if (state == s) {
                    println states.size() - i
                    return ++cycles
                }
            }
            for (List<Integer> s : states) {

            }
            states.add(state as int[])
            cycles++
        }
    }

}
