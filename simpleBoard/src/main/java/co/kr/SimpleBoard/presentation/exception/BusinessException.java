package co.kr.SimpleBoard.presentation.exception;


import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;


@Getter
public class BusinessException extends RuntimeException{
    private ExceptionCode exceptionCode;

    public BusinessException(ExceptionCode exceptionCode){
        super(exceptionCode.getMessage());
    }

}
