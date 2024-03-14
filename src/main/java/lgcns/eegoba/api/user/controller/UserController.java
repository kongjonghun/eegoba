package lgcns.eegoba.api.user.controller;

import lgcns.eegoba.api.user.service.UserService;
import lgcns.eegoba.api.user.vo.UserLoginRequestVO;
import lgcns.eegoba.api.user.vo.UserPasswordUpdateVO;
import lgcns.eegoba.api.user.vo.UserVO;
import lgcns.eegoba.common.constant.ErrorCode;
import lgcns.eegoba.common.constant.ResultCode;
import lgcns.eegoba.common.exception.ApiException;
import lgcns.eegoba.common.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/user")
public class UserController {

  private final UserService userService;

  @PostMapping(value = "/join")
  public ApiResponse join(@RequestBody UserVO userVO) throws Exception {
    userService.join(userVO);
    try {
      return new ApiResponse<>(ResultCode.Success);
    } catch (ApiException e) {
      throw new ApiException(ErrorCode.InternalServerError);
    } catch (Exception e) {
      throw new Exception(e);
    }
  }

  @PostMapping(value = "/login")
  public ApiResponse login(@RequestBody UserLoginRequestVO userLoginRequestVO) throws Exception {
    log.info("Login Requesnt => " + userLoginRequestVO.toString());
    UserVO userVO = userService.login(userLoginRequestVO);

    if (userVO == null) {
      throw new ApiException(ErrorCode.NOT_EXISTING_USER_EXCEPTION);
    }

    // session 적용 시 userId session에 저장하는 로직 구현 필요
    try {
      return new ApiResponse<>(ResultCode.Success, userVO);
    } catch (ApiException e) {
      throw new ApiException(ErrorCode.InternalServerError);
    } catch (Exception e) {
      throw new Exception(e);
    }
  }

  @PostMapping(value = "/init-password")
  public ApiResponse initPassword(@RequestBody UserPasswordUpdateVO userPasswordUpdateVO)
      throws Exception {
    userService.updatePassword(userPasswordUpdateVO);

    try {
      return new ApiResponse<>(ResultCode.Success);
    } catch (ApiException e) {
      throw new ApiException(ErrorCode.InternalServerError);
    } catch (Exception e) {
      throw new Exception(e);
    }
  }

  @PostMapping(value = "/check-nickname")
  public ApiResponse checkNickname(@RequestParam String nickname) throws Exception {

    try {
      return new ApiResponse<>(ResultCode.Success);
    } catch (ApiException e) {
      throw new ApiException(ErrorCode.InternalServerError);
    } catch (Exception e) {
      throw new Exception(e);
    }
  }
}
