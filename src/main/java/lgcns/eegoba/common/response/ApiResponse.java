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

  // ResultCode : result 값이 없을 경우
  public ApiResponse(ResultCode resultCode) {
    this.status = resultCode.getStatus();
    this.code = resultCode.getCode();
    this.message = resultCode.getMessage();
  }

  // ResultCode : 정상일 경우 ApiResponse
  public ApiResponse(ResultCode resultCode, T result) {
    this.status = resultCode.getStatus();
    this.code = resultCode.getCode();
    this.message = resultCode.getMessage();
    this.result = result;
  }

  // ErrorCode : 에러일 경우 ApiResponse
  public ApiResponse(ErrorCode errorCode, T result) {
    this.status = errorCode.getStatus();
    this.code = errorCode.getCode();
    this.message = errorCode.getMessage();
    this.result = result;
  }
}
