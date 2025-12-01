package com.sesca.day04.problem02;

public class SmartPhone implements Callable, Messageable, Connectable{

    @Override
    public void call(String number){
        System.out.printf("%s로 전화를 겁니다.\n", number);
    }
    @Override
    public void endCall(){
        System.out.println("통화를 종료합니다.");
    }
    @Override
    public void sendMessage(String message, String recipient){
        System.out.println("Sending To " + recipient);
    }
    @Override
    public void connectWiFi(String network){
        System.out.println("Connected...." + network);
    }
    @Override
    public  void disconnectWiFi(){
        System.out.println("WiFi 연결을 해제했습니다. ");
    }
}
