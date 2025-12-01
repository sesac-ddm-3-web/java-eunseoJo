package Assignment.DesignPattern.Observer;

import java.util.ArrayList;
import java.util.List;

public class ChatRoom {

    private String subject; // 채팅방 이름

    private List<Observer> chatObservers = new ArrayList<>(); // 옵저버 목록

    public ChatRoom(String subject) {
        this.subject = subject;
    }

    public void attach(Observer o){
        chatObservers.add(o);

    }

    public void detach(Observer o){
        chatObservers.remove(o);
    }

    // 목록을 순회하며 옵저버에게 알린다.
    public void notification(User user, String message){
        String fullMessage = user.getName() + " :  " + message;

        System.out.printf("[ChatRoom - %s] - (알림)  %s\n", this.subject, message);

        for(Observer o : chatObservers) {
            // 보낸 사람은 알림에서 제외
            if(o != user){
                o.update(fullMessage);
            }

        }
    }

}
