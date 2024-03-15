package lgcns.eegoba.common.constant;

import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

@Getter
@ToString
public enum ErrorCode {
  /* HTTP Common Error */
  BadRequest(HttpStatus.BAD_REQUEST.value(), "400", "Bad Request"),
  Unauthorized(HttpStatus.UNAUTHORIZED.value(), "401", "Unauthorized"),
  Forbidden(HttpStatus.FORBIDDEN.value(), "403", "Forbidden"),
  NotFound(HttpStatus.NOT_FOUND.value(), "404", "Not Found"),
  MethodNotAllowed(HttpStatus.METHOD_NOT_ALLOWED.value(), "405", "Method Not Allowed"),
  InternalServerError(HttpStatus.INTERNAL_SERVER_ERROR.value(), "500", "Internal Server Error"),
  NotImplemented(HttpStatus.NOT_IMPLEMENTED.value(), "501", "Not Implemented"),
  BadGateway(HttpStatus.BAD_GATEWAY.value(), "502", "Bad Gateway"),
  ServiceUnavailable(HttpStatus.SERVICE_UNAVAILABLE.value(), "503", "Service Unavailable"),
  GatewayTimeout(HttpStatus.GATEWAY_TIMEOUT.value(), "504", "Gateway Timeout"),

  /* User Error */
  NotExistingUserException(
      HttpStatus.UNAUTHORIZED.value(), "E0002", "존재하지 않는 사용자입니다. 이메일을 확인해주세요."),
  AccessDeniedException(HttpStatus.UNAUTHORIZED.value(), "E0003", "비밀번호가 일치하지 않습니다."),
  PasswordValidationFailed(HttpStatus.UNAUTHORIZED.value(), "E0004", "이전과 동일한 비밀번호로 변경할 수 없습니다."),
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
