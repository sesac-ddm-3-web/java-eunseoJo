
public class Car {
    // 자동차의 상태
    private int position = 0;

    public Car(){
        this.position = 0;
    }

    public void move(){
        this.position += 1;
    }

    public int getPosition(){
        return this.position;
    }
}
