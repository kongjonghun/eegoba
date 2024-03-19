package lgcns.eegoba.common.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lgcns.eegoba.common.constant.ErrorCode;
import lgcns.eegoba.common.constant.ResultCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommonApiResponse<T> {
  private Integer status;
  private String code;
  private String message;

  @JsonInclude(JsonInclude.Include.NON_NULL)
  private T result;

  /* ResultCode */
  public CommonApiResponse(ResultCode resultCode) {
    this.status = resultCode.getStatus();
    this.code = resultCode.getCode();
    this.message = resultCode.getMessage();
  }

  public CommonApiResponse(ResultCode resultCode, T result) {
    this.status = resultCode.getStatus();
    this.code = resultCode.getCode();
    this.message = resultCode.getMessage();
    this.result = result;
  }

  public CommonApiResponse(ResultCode resultCode, String message, T result) {
    this.status = resultCode.getStatus();
    this.code = resultCode.getCode();
    this.message = message;
    this.result = result;
  }

  public static <T> CommonApiResponse<T> of(ResultCode resultCode) {
    return new CommonApiResponse<T>(resultCode);
  }

  public static <T> CommonApiResponse<T> of(ResultCode resultCode, T result) {
    return new CommonApiResponse<T>(resultCode, result);
  }

  /* ErrorCode */
  public CommonApiResponse(ErrorCode errorCode) {
    this.status = errorCode.getStatus();
    this.code = errorCode.getCode();
    this.message = errorCode.getMessage();
  }

  public CommonApiResponse(ErrorCode errorCode, T result) {
    this.status = errorCode.getStatus();
    this.code = errorCode.getCode();
    this.message = errorCode.getMessage();
    this.result = result;
  }

  public CommonApiResponse(ErrorCode errorCode, String message, T result) {
    this.status = errorCode.getStatus();
    this.code = errorCode.getCode();
    this.message = message;
    this.result = result;
  }

  public static <T> CommonApiResponse<T> of(ErrorCode errorCode) {
    return new CommonApiResponse<T>(errorCode);
  }

  public static <T> CommonApiResponse<T> of(ErrorCode errorCode, T result) {
    return new CommonApiResponse<T>(errorCode, result);
  }
}
