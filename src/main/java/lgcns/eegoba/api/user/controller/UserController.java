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
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpStatusCodeException;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/user")
public class UserController {

  private final UserService userService;

  @PostMapping(value = "/join")
  public ResponseEntity<CommonApiResponse> join(@RequestBody UserVO userVO)
      throws HttpStatusCodeException {
    userService.join(userVO);
    try {
      return ResponseEntity.ok(CommonApiResponse.of(ResultCode.Success));
    } catch (Exception e) {
      throw new ApiException(ErrorCode.InternalServerError);
    }
  }

  @PostMapping(value = "/login")
  public ResponseEntity<CommonApiResponse> login(@RequestBody UserLoginRequestVO userLoginRequestVO)
      throws HttpStatusCodeException {
    log.info("Login Requesnt => " + userLoginRequestVO.toString());
    UserVO userVO = userService.login(userLoginRequestVO);

    if (userVO == null) {
      throw new ApiException(ErrorCode.NotExistingUserException);
    }

    // session 적용 시 userId session에 저장하는 로직 구현 필요
    try {
      return ResponseEntity.ok(CommonApiResponse.of(ResultCode.Success));
    } catch (Exception e) {
      throw new ApiException(ErrorCode.InternalServerError);
    }
  }

  @PostMapping(value = "/init-password")
  public ResponseEntity<CommonApiResponse> initPassword(
      @RequestBody UserPasswordUpdateVO userPasswordUpdateVO) throws HttpStatusCodeException {
    userService.updatePassword(userPasswordUpdateVO);

    try {
      return ResponseEntity.ok(CommonApiResponse.of(ResultCode.Success));
    } catch (Exception e) {
      throw new ApiException(ErrorCode.InternalServerError);
    }
  }

  @PostMapping(value = "/check-nickname")
  public ResponseEntity<CommonApiResponse> checkNickname(@RequestParam String nickname)
      throws HttpStatusCodeException {

    try {
      return ResponseEntity.ok(CommonApiResponse.of(ResultCode.Success));
    } catch (Exception e) {
      throw new ApiException(ErrorCode.InternalServerError);
    }
  }
}
