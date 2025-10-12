package com.sesca.day07.OptionalExample;
// UserRepository.java (DB 대용 Mock 객체)
import java.util.Map;
import java.util.Optional;

class UserRepository {
    private Map<String, User> db = Map.of(
            "user1", new User(new Address("서울")), // 모든 정보가 있는 사용자
            "user2", new User(new Address(null)),   // 주소는 있지만 도시는 없는 사용자
            "user3", new User(null)                 // 주소 정보가 없는 사용자
    );


//    // 사용자를 찾지 못하면 null을 반환
//    public User findById(String id) {
//        return db.get(id);
//    }

    public Optional<User> findById(String id){
        return Optional.ofNullable(db.get(id));
    }

}

