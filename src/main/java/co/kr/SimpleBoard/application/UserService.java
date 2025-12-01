package co.kr.SimpleBoard.application;

import co.kr.SimpleBoard.domain.user.User;
import co.kr.SimpleBoard.infra.user.UserRepository;
import co.kr.SimpleBoard.presentation.exception.BusinessException;
import co.kr.SimpleBoard.presentation.exception.ExceptionCode;
import co.kr.SimpleBoard.presentation.user.LoginRequestDto;
import co.kr.SimpleBoard.presentation.user.SignupRequestDto;
import co.kr.SimpleBoard.security.JwtUtil;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;


   public String login(LoginRequestDto loginRequestDto) {
       // 회원 조회
       User user = userRepository.findByUsername(loginRequestDto.username())
               .orElseThrow(() -> new BusinessException(ExceptionCode.USER_NOT_FOUND));

       // 비밀번호 검증
       if(!passwordEncoder.matches(loginRequestDto.password(), user.getPassword())){
           throw new BusinessException(ExceptionCode.PASSWORD_NOT_MATCH);
       }

       String token = jwtUtil.createToken(user.getUsername());

       return token;
   }

   @Transactional
    public void signup(SignupRequestDto signupRequestDto){
       // 아이디 중복되는지 체크
       if(userRepository.existsByUsername(signupRequestDto.username())){
           throw new BusinessException(ExceptionCode.USER_EXIST);
       }
       // 비밀번호 암호화
       String encodedPassword = passwordEncoder.encode(signupRequestDto.password());
       // DB 저장
       User user = User.builder()
                       .username(signupRequestDto.username())
                               .password(encodedPassword).build();
       userRepository.save(user);
   }
}
