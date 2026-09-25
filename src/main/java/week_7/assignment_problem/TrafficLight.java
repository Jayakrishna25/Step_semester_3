package main.java.week_7.assignment_problem;
class TrafficLightDemo {

    public static class TrafficLight {
        private final String id;
        private int stateIndex;

        private static final String[] CYCLE = {"RED", "GREEN", "YELLOW"};

        public TrafficLight(String id) {
            this.id = id;
            this.stateIndex = 0;
        }

        public String getId() {
            return this.id;
        }

        public String getColor() {
            return CYCLE[this.stateIndex];
        }

        public String next() {
            this.stateIndex = (this.stateIndex + 1) % CYCLE.length;
            return getColor();
        }
    }

    public static void main(String[] args) {
        TrafficLight t = new TrafficLight("TL-9");

        System.out.println("t.getColor() -> \"" + t.getColor() + "\"");
        System.out.println("t.next() -> \"" + t.next() + "\"");
        System.out.println("t.next() -> \"" + t.next() + "\"");
        System.out.println("t.next() -> \"" + t.next() + "\"");
    }
}
