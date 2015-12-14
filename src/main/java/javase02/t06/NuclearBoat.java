package javase02.t06;

import javase02.t07.Classification;

@Classification(
        type = "Multi-purpose boat",
        date = "14.12.2015"
)
public class NuclearBoat {
    String name;
    StateBoat status;
    EngineNuclearBoat engine;

    public NuclearBoat(String name) {
        this.name = name;
        engine = new EngineNuclearBoat();
        status = StateBoat.PARKING;
    }

    public void goAway() {
        engine.start();
        status = StateBoat.SAIL;
    }

    private class EngineNuclearBoat {
        private boolean status = false;

        public void start() {
            if (status) {
                System.out.println("Engine already started");
            } else {
                status = true;
                System.out.println("Engine started");
            }
        }

        public void stop() {
            if (!status) {
                System.out.println("Engine already stopped");
            } else {
                status = false;
                System.out.println("Engine stopped");
            }
        }
    }
    private enum StateBoat {
        PARKING,
        SAIL
    }
}

