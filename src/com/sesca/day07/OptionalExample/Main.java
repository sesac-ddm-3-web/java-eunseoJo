package com.sesca.day07.OptionalExample;

import java.util.Optional;

// Main.java
public class Main {
    public static String getUserCity(String userId, UserRepository userRepository) {

        User user = userRepository.findById(userId).orElseThrow(); // 필드에 옵셔널 사용 X
       // user가 없을 경우
       //user.orElseThrow(() -> new RuntimeException("user is null")) ;

       // user O , 주소 x
       //user.get().getOptionalAddress();

       // user O, 주소 O , city X
       //return user.get().getAddress().getOptionalCity().orElse("null");


       return user.getOptionalAddress().orElseThrow().getOptionalCity().orElseThrow();

    }

    public static void main(String[] args) {
        UserRepository userRepository = new UserRepository();


        System.out.println("user1 도시: " + getUserCity("user1", userRepository));
        System.out.println("user2 도시: " + getUserCity("user2", userRepository));
        System.out.println("user3 도시: " + getUserCity("user3", userRepository));
        System.out.println("user4 도시: " + getUserCity("user4", userRepository));
    }
}

