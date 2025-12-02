package co.kr.SimpleBoard.presentation.user;

import co.kr.SimpleBoard.application.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<String>signup(@RequestBody SignupRequestDto signupRequestDto){
        userService.signup(signupRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("회원가입 완료!");
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto loginRequestDto){
        String token = userService.login(loginRequestDto);
        return ResponseEntity.ok(new LoginResponseDto(token));
    }






}
