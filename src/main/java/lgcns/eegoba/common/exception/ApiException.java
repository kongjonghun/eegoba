package lgcns.eegoba.common.exception;

import lgcns.eegoba.common.constant.ErrorCode;
import lombok.Getter;

@Getter
public class ApiException extends RuntimeException {
  private final ErrorCode errorCode;

  public ApiException(ErrorCode e) {
    super(e.getMessage());
    this.errorCode = e;
  }
}
