import java.util.*;

public class Main {
    public static void main(String[] args) {
        int year = 0, month = 0, day = 0;
        Scanner scan = new Scanner(System.in);

        System.out.println("Введите год полива кактуса: ");

        try {
            year = scan.nextInt();
        } catch(InputMismatchException e){
            throw new InputMismatchException("Неправильный формат строки! Введите число.");
        }

        if(year < 1 || year > 2023){
            System.out.println("Невозможное значение года");
        }

        System.out.println("Введите месяц полива кактуса, если январь - 1, декабрь - 12: ");

        try{
            month = scan.nextInt();
        }catch(InputMismatchException e){
            throw new InputMismatchException("Неправильный формат строки! Введите число.");
        }

        month -= 1;

        if(month < 0 || month > 11){
            throw new InputMismatchException("Невозможное значение месяца");
        }

        System.out.println("Введите день полива кактуса: ");

        try{
            day = scan.nextInt();
        }catch(InputMismatchException e){
            throw new InputMismatchException("Неправильный формат строки! Введите число.");
        }

        boolean highYear = (year%4 == 0 && year%100 != 0 || year%400 == 0);

        if(day < 1 || day > 31 || (month == 1 && highYear && day > 29)){
            throw new InputMismatchException("Невозможное значение дня");
        }
        scan.close();


        Calendar calendar = new GregorianCalendar(year, month , day);
        Date date = calendar.getTime();
//        System.out.println(date);
        CactusSchedule cactusik = new CactusSchedule(date);

        Date newDate = cactusik.getNextWaterDate();
        System.out.println(newDate);
    }
}

