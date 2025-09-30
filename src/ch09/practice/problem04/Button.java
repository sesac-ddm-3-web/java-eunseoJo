package ch09.practice.problem04;

public class Button{

    String buttonName;

    Button(String buttonName){
        this.buttonName = buttonName;
    }

    private EventListener eventListener = new EventListener() {
        @Override
        public void onClick() {
           // 오버라이딩 되는 부분
        }
    };

    public void setListener(EventListener eventListener ){
        this.eventListener = eventListener;
    }

    public void click(){
        System.out.println(this.buttonName + "버튼을 클릭합니다.");
        this.eventListener.onClick();

    }

}
