import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class CarApplication {
    public static void main(String[] args ){
        Scanner scanner = new Scanner(System.in);
        // 몇대의 자동차, 몇번의 이동
        System.out.println("몇대의 자동차?");
        int carCount = scanner.nextInt();
        System.out.println("시도할 횟수는?");
        int moveCount = scanner.nextInt();

        // N대의 자동차 생성
        List<Car> carList = new ArrayList<>();

        for(int i = 0; i < carCount; i++){
            Car newCar = new Car();
            carList.add(newCar);
        }

        // 주어진 횟수동안 N대의 자동차는 전진하거나 정지한다.
        // 이때 전진하는 조건은 0-9 무작위값 >=4
        for(int i = 0; i < moveCount; i++){
            System.out.println("현재 횟수는 " + i );
            // 모든 N대의 자동차에게 랜덤 값 부여
            for(int j = 0; j < carCount; j++){
                Random r = new Random();
                int r1 = r.nextInt(10);

                if(r1 >= 4){
                    carList.get(j).move();
                }
            }

            // 움직인후에 상태 출력
            for(int j = 0; j < carCount; j++){
                int curr = carList.get(j).getPosition();
                System.out.println(curr);
            }
            System.out.println();
        }


    }

}

