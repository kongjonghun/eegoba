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
public class ApiResponse<T> {
  private Integer status;
  private String code;
  private String message;

  @JsonInclude(JsonInclude.Include.NON_NULL)
  private T result;

  /* ResultCode */
  public ApiResponse(ResultCode resultCode) {
    this.status = resultCode.getStatus();
    this.code = resultCode.getCode();
    this.message = resultCode.getMessage();
  }

  public ApiResponse(ResultCode resultCode, T result) {
    this.status = resultCode.getStatus();
    this.code = resultCode.getCode();
    this.message = resultCode.getMessage();
    this.result = result;
  }

  public ApiResponse(ResultCode resultCode, String message, T result) {
    this.status = resultCode.getStatus();
    this.code = resultCode.getCode();
    this.message = message;
    this.result = result;
  }

  public static <T> ApiResponse<T> of(ResultCode resultCode) {
    return new ApiResponse<T>(resultCode);
  }

  public static <T> ApiResponse<T> of(ResultCode resultCode, T result) {
    return new ApiResponse<T>(resultCode, result);
  }

  /* ErrorCode */
  public ApiResponse(ErrorCode errorCode) {
    this.status = errorCode.getStatus();
    this.code = errorCode.getCode();
    this.message = errorCode.getMessage();
  }

  public ApiResponse(ErrorCode errorCode, T result) {
    this.status = errorCode.getStatus();
    this.code = errorCode.getCode();
    this.message = errorCode.getMessage();
    this.result = result;
  }

  public ApiResponse(ErrorCode errorCode, String message, T result) {
    this.status = errorCode.getStatus();
    this.code = errorCode.getCode();
    this.message = message;
    this.result = result;
  }

  public static <T> ApiResponse<T> of(ErrorCode errorCode) {
    return new ApiResponse<T>(errorCode);
  }

  public static <T> ApiResponse<T> of(ErrorCode errorCode, T result) {
    return new ApiResponse<T>(errorCode, result);
  }
}
