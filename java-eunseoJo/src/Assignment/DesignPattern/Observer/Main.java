package Assignment.DesignPattern.Observer;

public class Main {
    public static void main(String[] args) {
        ChatRoom room = new ChatRoom("Java Study의 챗방");

        User u1 = new User("은서");
        User u2 = new User("용훈");

        room.attach(u1);
        room.attach(u2);

        room.notification(u1, "안녕!");
        room.notification(u2, "옵저버 패턴 쉽다!");
    }
}
