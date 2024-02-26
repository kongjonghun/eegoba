package lgcns.eegoba.common.exception;

import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

@Getter
@ToString
public enum ExceptionEnum {
  RUNTIME_EXCEPTION(HttpStatus.BAD_REQUEST, "E0001"),
  NOT_EXISTING_USER_EXCEPTION(HttpStatus.UNAUTHORIZED, "E0002", "존재하지 않는 사용자입니다. 이메일을 확인해주세요."),
  ACCESS_DENIED_EXCEPTION(HttpStatus.UNAUTHORIZED, "E0003", "비밀번호가 일치하지 않습니다."),
  INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "E0004"),

  SECURITY_01(HttpStatus.UNAUTHORIZED, "S0001", "권한이 없습니다.");

  private final HttpStatus status;
  private final String code;
  private String message;

  ExceptionEnum(HttpStatus status, String code) {
    this.status = status;
    this.code = code;
  }

  ExceptionEnum(HttpStatus status, String code, String message) {
    this.status = status;
    this.code = code;
    this.message = message;
  }
}
