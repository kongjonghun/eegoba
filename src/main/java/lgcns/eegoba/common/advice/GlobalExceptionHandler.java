package lgcns.eegoba.common.advice;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lgcns.eegoba.common.constant.ErrorCode;
import lgcns.eegoba.common.exception.ApiException;
import lgcns.eegoba.common.response.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler({ApiException.class})
  public ResponseEntity<ApiResponse> apiExceptionHandler(
      HttpServletRequest request, HttpServletResponse response, final ApiException e) {
    return ResponseEntity.status(e.getErrorCode().getStatus())
        .body(ApiResponse.of(e.getErrorCode(), e.getMessage()));
  }

  @ExceptionHandler({Exception.class})
  public ResponseEntity<ApiResponse> exceptionHandler(
      HttpServletRequest request, HttpServletResponse response, final Exception e) {
    return ResponseEntity.status(ErrorCode.InternalServerError.getStatus())
        .body(ApiResponse.of(ErrorCode.InternalServerError, e.getMessage()));
  }

  //
  //  @ExceptionHandler({AccessDeniedException.class})
  //  public ResponseEntity<ApiExceptionEntity> exceptionHandler(
  //      HttpServletRequest request, final AccessDeniedException e) {
  //    e.printStackTrace();
  //    return ResponseEntity.status(ExceptionEnum.ACCESS_DENIED_EXCEPTION.getStatus())
  //        .body(
  //            ApiExceptionEntity.builder()
  //                .errorCode(ExceptionEnum.ACCESS_DENIED_EXCEPTION.getCode())
  //                .errorMessage(e.getMessage())
  //                .build());
  //  }
  //

}
