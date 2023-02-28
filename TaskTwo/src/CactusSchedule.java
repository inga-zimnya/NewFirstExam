import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.Random;

public class CactusSchedule {

    private Date lastWaterDate;

    public CactusSchedule(Date lastWaterDate) {
        this.lastWaterDate = lastWaterDate;
    }


    public Date getNextWaterDate() {
        Date currentDate = lastWaterDate;
        int currentMonth = currentDate.getMonth();
        int waterFrequency = 0;

        if (currentMonth == 11 || currentMonth == 0 || currentMonth == 1) {
            // Winter
            waterFrequency = 30;
        } else if (currentMonth >= 2 && currentMonth <= 4) {
            // Spring || Autumn
            waterFrequency = 7;
        } else {
            // Summer
            Sensor per = new Sensor();

            int humidityProcentage = per.getRandomGenerator();
//            System.out.println(humidityProcentage);
            if (humidityProcentage < 30) {
                waterFrequency = 2;
            } else {
                waterFrequency = 7;
            }
        }

        Instant nextWaterDate = Instant.ofEpochMilli(lastWaterDate.toInstant().toEpochMilli()).plusSeconds(waterFrequency * 86400);
        return Date.from(nextWaterDate);
    }
}
