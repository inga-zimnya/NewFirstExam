import java.util.Random;

public class Sensor {
    private final int randomGenerator;

    public Sensor() {
        this.randomGenerator = new Random().nextInt(100);
    }


    public int getRandomGenerator() {
//        System.out.println(randomGenerator);
        return randomGenerator;
    }
}
