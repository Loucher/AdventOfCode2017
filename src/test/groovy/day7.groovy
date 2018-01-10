import org.junit.Test

class day7 {


    TreeMap<String, Program> cache = new TreeMap<>()
    Program root = null

    @Test
    void part1() {
        buildTree()
        println root.name
    }


    @Test
    void part2() {
        buildTree()
        root.getTotalWeight()






    }

    Program imbalancedProgram(Program parent){
        Map<Integer, List<Program>> occurrences = new HashMap<>()
        for(Program child : parent.disc){
            if(occurrences.containsKey(child.totalWeight)){
                occurrences.put(child.totalWeight, occurrences.get(child.totalWeight))
            }
        }
    }


    private void buildTree() {
        if (root != null) {
            return
        }
        getClass().getResource("day7.txt").eachLine { String line ->
            String[] parts = line.split("->")
            String[] parameters = parts[0].split(" ")
            String name = parameters[0]
            int weight = parameters[1].replaceAll("[()]", "").toInteger()
            Program program = getProgram(name)
            program.setProgramWeight(weight)
            if (parts.size() == 2) {
                String disk = parts[1].trim()
                String[] programs = disk.split(", ")
                for (String childProgram : programs) {
                    program.addChild(getProgram(childProgram))
                }
            }
        }
        Program program = cache.firstEntry().value
        while (program.parent != null) {
            program = program.parent
        }
        root = program
    }

    synchronized private Program getProgram(String name) {
        Program program = cache.get(name)
        if (program == null) {
            program = new Program(name)
            cache.put(name, program)
        }
        return program
    }


    private static class Program {
        String name
        int programWeight = -1
        int totalWeight = -1
        Set<Program> disc = new HashSet<>()
        Program parent = null

        Program(String name) {
            this.name = name
        }

        void addChild(Program program) {
            disc.add(program)
            program.setParent(this)
        }

        int getTotalWeight() {
            if (totalWeight == -1) {
                totalWeight = programWeight
                for (Program child : disc) {
                    totalWeight += child.getTotalWeight()
                }
            }
            return totalWeight
        }
    }


}
