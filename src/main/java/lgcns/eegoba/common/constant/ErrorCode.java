package lgcns.eegoba.common.constant;

import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

@Getter
@ToString
public enum ErrorCode {
  /* HTTP Common Error */
  BAD_REQUEST(HttpStatus.BAD_REQUEST.value(), "400", "Bad Request"),
  UNAUTHORIZED(HttpStatus.UNAUTHORIZED.value(), "401", "Unauthorized"),
  FORBIDDEN(HttpStatus.FORBIDDEN.value(), "403", "Forbidden"),
  NOT_FOUND(HttpStatus.NOT_FOUND.value(), "404", "Not Found"),
  METHOD_NOT_ALLOWED(HttpStatus.METHOD_NOT_ALLOWED.value(), "405", "Method Not Allowed"),
  INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR.value(), "500", "Internal Server Error"),
  NOT_IMPLEMENTED(HttpStatus.NOT_IMPLEMENTED.value(), "501", "Not Implemented"),
  BAD_GATEWAY(HttpStatus.BAD_GATEWAY.value(), "502", "Bad Gateway"),
  SERVICE_UNAVAILABLE(HttpStatus.SERVICE_UNAVAILABLE.value(), "503", "Service Unavailable"),
  GATEWAY_TIMEOUT(HttpStatus.GATEWAY_TIMEOUT.value(), "504", "Gateway Timeout"),

  /* User Error */
  NOT_EXISTING_USER_EXCEPTION(
      HttpStatus.UNAUTHORIZED.value(), "E0002", "존재하지 않는 사용자입니다. 이메일을 확인해주세요."),
  ACCESS_DENIED_EXCEPTION(HttpStatus.UNAUTHORIZED.value(), "E0003", "비밀번호가 일치하지 않습니다."),
  PASSWORD_VALIDATION_FAILED(HttpStatus.UNAUTHORIZED.value(), "E0004", "이전과 동일한 비밀번호로 변경할 수 없습니다."),
  Security01(HttpStatus.UNAUTHORIZED.value(), "S0001", "권한이 없습니다."),
  ;

  private final int status;
  private final String code;
  private String message;

  ErrorCode(int status, String code) {
    this.status = status;
    this.code = code;
  }

  ErrorCode(int status, String code, String message) {
    this.status = status;
    this.code = code;
    this.message = message;
  }
}
