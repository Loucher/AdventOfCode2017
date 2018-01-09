import org.junit.Test

class day8 {

    Map<String, Integer> registers = new HashMap<>()
    int biggestValue = Integer.MIN_VALUE

    @Test
    void part1and2() {
        getClass().getResource("day8.txt").eachLine { String line ->
            List<String> tokens = line.tokenize(' ')
            boolean execute = false
            switch (tokens.get(5)) {
                case ">":
                    execute = getRegister(tokens.get(4)) > tokens.get(6).toInteger()
                    break
                case "<":
                    execute = getRegister(tokens.get(4)) < tokens.get(6).toInteger()
                    break
                case ">=":
                    execute = getRegister(tokens.get(4)) >= tokens.get(6).toInteger()
                    break
                case "<=":
                    execute = getRegister(tokens.get(4)) <= tokens.get(6).toInteger()
                    break
                case "==":
                    execute = getRegister(tokens.get(4)) == tokens.get(6).toInteger()
                    break
                case "!=":
                    execute = getRegister(tokens.get(4)) != tokens.get(6).toInteger()
                    break
            }
            if (execute) {
                if ("inc".equals(tokens.get(1))) {
                    incrementRegister(tokens.get(0), tokens.get(2).toInteger())
                    if (biggestValue < registers.max { it.value }.value) {
                        biggestValue = registers.max { it.value }.value
                    }
                } else {
                    decrementRegister(tokens.get(0), tokens.get(2).toInteger())
                }
            }
        }
        println "day1: ${registers.max { it.value }.value}"
        println "day2: $biggestValue"
    }

    private int getRegister(String name) {
        Integer value = registers.get(name)
        if (value == null) {
            return 0
        }
        return value.intValue()
    }

    private void incrementRegister(String name, int value) {
        registers.put(name, getRegister(name) + value)
    }

    private void decrementRegister(String name, int value) {
        registers.put(name, getRegister(name) - value)
    }


}
