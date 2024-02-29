package lgcns.eegoba.api.user.controller;

import lgcns.eegoba.common.response.ApiResponseVO;
import lgcns.eegoba.api.user.service.UserService;
import lgcns.eegoba.api.user.vo.UserLoginRequestVO;
import lgcns.eegoba.api.user.vo.UserPasswordUpdateVO;
import lgcns.eegoba.api.user.vo.UserVO;
import lgcns.eegoba.common.constant.StatusConst;
import lgcns.eegoba.common.exception.ApiException;
import lgcns.eegoba.common.exception.ExceptionEnum;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpStatusCodeException;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/user")
public class UserController {

  private final UserService userService;

  @PostMapping(value = "/join")
  public ApiResponseVO join(@RequestBody UserVO userVO) throws HttpStatusCodeException {
    userService.join(userVO);
    try {
      return ApiResponseVO.builder()
          .code(StatusConst.Success.getStatus())
          .message(StatusConst.Success.getMessage())
          .build();
    } catch (Exception e) {
      return ApiResponseVO.builder()
          .code(StatusConst.InternalServerError.getStatus())
          .message(e.getMessage())
          .build();
    }
  }

  @PostMapping(value = "/login")
  public ApiResponseVO login(@RequestBody UserLoginRequestVO userLoginRequestVO)
      throws HttpStatusCodeException {
    log.info("Login Requesnt => " + userLoginRequestVO.toString());
    UserVO userVO = userService.login(userLoginRequestVO);

    if (userVO == null) {
      throw new ApiException(ExceptionEnum.NOT_EXISTING_USER_EXCEPTION);
    }

    // session 적용 시 userId session에 저장하는 로직 구현 필요
    try {
      return ApiResponseVO.builder()
          .code(StatusConst.Success.getStatus())
          .message(StatusConst.Success.getMessage())
          .build();
    } catch (Exception e) {
      return ApiResponseVO.builder()
          .code(StatusConst.InternalServerError.getStatus())
          .message(e.getMessage())
          .build();
    }
  }

  @PostMapping(value = "/password-init")
  public ApiResponseVO passwordInit(@RequestBody UserPasswordUpdateVO userPasswordUpdateVO)
      throws HttpStatusCodeException {
    userService.updatePassword(userPasswordUpdateVO);

    try {
      return ApiResponseVO.builder()
          .code(StatusConst.Success.getStatus())
          .message(StatusConst.Success.getMessage())
          .build();
    } catch (Exception e) {
      return ApiResponseVO.builder()
          .code(StatusConst.InternalServerError.getStatus())
          .message(e.getMessage())
          .build();
    }
  }

  @PostMapping(value = "/dup-nickname")
  public ApiResponseVO dupNicknameCheck(@RequestParam String usrNnm)
      throws HttpStatusCodeException {

    try {
      // 로직 구현
      return ApiResponseVO.builder()
          .code(StatusConst.Success.getStatus())
          .message(StatusConst.Success.getMessage())
          .build();
    } catch (Exception e) {
      return ApiResponseVO.builder()
          .code(StatusConst.InternalServerError.getStatus())
          .message(e.getMessage())
          .build();
    }
  }
}
