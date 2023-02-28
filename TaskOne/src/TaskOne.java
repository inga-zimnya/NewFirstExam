import java.util.InputMismatchException;
import java.util.Scanner;
import java.lang.String;

public class TaskOne {
    public static void main(String[] args) throws InputMismatchException{
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите сообщение для девочки");

        String input = scan.nextLine();
        if(!input.matches("[A-z А-Яа-яЁё]+")){
            throw new InputMismatchException("Для ввода доступны только буквы");
        }

        int spaceCount = 0, letters = 0;
        letters = input.length();
        for (char c : input.toCharArray()) {
            if (c == ' ') {
                spaceCount++;
            }
        }

        if (spaceCount != 3){
            throw new InputMismatchException("Количество пробелов не соотвествует 3");
        }

        if (letters != 18){
            throw new InputMismatchException("Количество символов не соотвествует 15");
        }

        double lengthOfMess = 5 * 62 + 3 * 12;
        int zabor = 0;

        System.out.println("Введите длину забора в см");

        try {
            zabor = scan.nextInt();
        } catch(InputMismatchException e){
            System.out.println("Неправильный формат строки! Введите число.");
        }

        double answer = zabor / lengthOfMess;

        if (answer >= 1.0){
            System.out.println("Надпись помещается на заборе");
        } else{
            System.out.println("Надпись не помещается, будь краток");
        }
    }
}