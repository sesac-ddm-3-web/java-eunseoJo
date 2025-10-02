package Assignment.DesignPattern.Observer;

public class User implements Observer {

    private String name;

    public User(String name){
        this.name = name;
    }

    String getName(){
        return this.name;
    }
    @Override
    public void update(String message){
        System.out.printf("> %s님에게 알림 : %s\n", this.name, message);
    }
}
