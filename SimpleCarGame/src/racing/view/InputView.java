package racing.view;

import java.util.Scanner;

public class InputView {

    private final Scanner scanner;
    public InputView(){
       scanner = new Scanner(System.in);
    }

    public int readCarCount(){
        //System.out.println("몇대의 자동차?");
        return readNextInt();
    }

    public int readMoveCount(){
        //System.out.println("시도할 횟수는?");
        return readNextInt();
    }

    public int readNextInt(){
        int value = scanner.nextInt();
        return value;
    }


}
