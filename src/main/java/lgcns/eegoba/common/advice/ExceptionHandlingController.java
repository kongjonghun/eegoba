package lgcns.eegoba.common.advice;

import jakarta.servlet.http.HttpServletRequest;
import lgcns.eegoba.common.exception.ApiException;
import lgcns.eegoba.common.exception.ApiExceptionEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlingController {

  @ExceptionHandler({ApiException.class})
  public ResponseEntity<ApiExceptionEntity> exceptionHandler(
      HttpServletRequest request, final ApiException e) {
    // e.printStackTrace();
    return ResponseEntity.status(e.getError().getStatus())
        .body(
            ApiExceptionEntity.builder()
                .errorCode(e.getError().getCode())
                .errorMessage(e.getError().getMessage())
                .build());
  }

  //  @ExceptionHandler({RuntimeException.class})
  //  public ResponseEntity<ApiExceptionEntity> exceptionHandler(
  //      HttpServletRequest request, final RuntimeException e) {
  //    e.printStackTrace();
  //    return ResponseEntity.status(ExceptionEnum.RUNTIME_EXCEPTION.getStatus())
  //        .body(
  //            ApiExceptionEntity.builder()
  //                .errorCode(ExceptionEnum.RUNTIME_EXCEPTION.getCode())
  //                .errorMessage(e.getMessage())
  //                .build());
  //  }
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
