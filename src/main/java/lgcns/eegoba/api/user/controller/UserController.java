package lgcns.eegoba.api.user.controller;

import lgcns.eegoba.api.user.service.UserService;
import lgcns.eegoba.api.user.vo.UserLoginRequestVO;
import lgcns.eegoba.api.user.vo.UserPasswordUpdateVO;
import lgcns.eegoba.api.user.vo.UserVO;
import lgcns.eegoba.common.constant.ErrorCode;
import lgcns.eegoba.common.constant.ResultCode;
import lgcns.eegoba.common.exception.ApiException;
import lgcns.eegoba.common.response.CommonApiResponse;
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
  public CommonApiResponse join(@RequestBody UserVO userVO) throws HttpStatusCodeException {
    userService.join(userVO);
    try {
      return CommonApiResponse.builder()
          .status(ResultCode.SUCCESS.getStatus())
          .code(ResultCode.SUCCESS.getCode())
          .message(ResultCode.SUCCESS.getMessage())
          .build();
    } catch (Exception e) {
      return CommonApiResponse.builder()
          .status(ErrorCode.INTERNAL_SERVER_ERROR.getStatus())
          .code(ErrorCode.INTERNAL_SERVER_ERROR.getCode())
          .message(e.getMessage())
          .build();
    }
  }

  @PostMapping(value = "/login")
  public CommonApiResponse login(@RequestBody UserLoginRequestVO userLoginRequestVO)
      throws HttpStatusCodeException {
    log.info("Login Requesnt => " + userLoginRequestVO.toString());
    UserVO userVO = userService.login(userLoginRequestVO);

    if (userVO == null) {
      throw new ApiException(ErrorCode.NOT_EXISTING_USER_EXCEPTION);
    }

    // session 적용 시 userId session에 저장하는 로직 구현 필요
    try {
      return CommonApiResponse.builder()
          .status(ResultCode.SUCCESS.getStatus())
          .code(ResultCode.SUCCESS.getCode())
          .message(ResultCode.SUCCESS.getMessage())
          .build();
    } catch (Exception e) {
      return CommonApiResponse.builder()
          .status(ErrorCode.INTERNAL_SERVER_ERROR.getStatus())
          .code(ErrorCode.INTERNAL_SERVER_ERROR.getCode())
          .message(e.getMessage())
          .build();
    }
  }

  @PostMapping(value = "/init-password")
  public CommonApiResponse initPassword(@RequestBody UserPasswordUpdateVO userPasswordUpdateVO)
      throws HttpStatusCodeException {
    userService.updatePassword(userPasswordUpdateVO);

    try {
      return CommonApiResponse.builder()
          .status(ResultCode.SUCCESS.getStatus())
          .code(ResultCode.SUCCESS.getCode())
          .message(ResultCode.SUCCESS.getMessage())
          .build();
    } catch (Exception e) {
      return CommonApiResponse.builder()
          .status(ErrorCode.INTERNAL_SERVER_ERROR.getStatus())
          .message(e.getMessage())
          .build();
    }
  }

  @PostMapping(value = "/check-nickname")
  public CommonApiResponse checkNickname(@RequestParam String nickname)
      throws HttpStatusCodeException {

    try {
      // 로직 구현
      return CommonApiResponse.builder()
          .status(ResultCode.SUCCESS.getStatus())
          .code(ResultCode.SUCCESS.getCode())
          .message(ResultCode.SUCCESS.getMessage())
          .build();
    } catch (Exception e) {
      return CommonApiResponse.builder()
          .status(ErrorCode.INTERNAL_SERVER_ERROR.getStatus())
          .code(ErrorCode.INTERNAL_SERVER_ERROR.getCode())
          .message(e.getMessage())
          .build();
    }
  }
}
