package lgcns.eegoba.common.constant;

import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

@Getter
@ToString
public enum ResultCode {
  /* HTTP Common Success */
  Success(HttpStatus.OK.value(), "200", "Success"),
  Created(HttpStatus.CREATED.value(), "201", "Created"),
  NoContent(HttpStatus.NO_CONTENT.value(), "204", "NoContent"),

  /* User Success */
  REGISTER_SUCCESS(HttpStatus.OK.value(), "M001", "회원가입 되었습니다."),
  LOGIN_SUCCESS(HttpStatus.OK.value(), "M002", "로그인 되었습니다."),
  REISSUE_SUCCESS(HttpStatus.OK.value(), "M003", "재발급 되었습니다."),
  LOGOUT_SUCCESS(HttpStatus.OK.value(), "M004", "로그아웃 되었습니다."),
  GET_MY_INFO_SUCCESS(HttpStatus.OK.value(), "M005", "내 정보 조회 완료");

  private final int status;
  private final String code;
  private String message;

  ResultCode(int status, String code) {
    this.status = status;
    this.code = code;
  }

  ResultCode(int status, String code, String message) {
    this.status = status;
    this.code = code;
    this.message = message;
  }
}
