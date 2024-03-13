package lgcns.eegoba.api.user.service;

import lgcns.eegoba.api.user.mapper.UserMapper;
import lgcns.eegoba.api.user.vo.UserLoginRequestVO;
import lgcns.eegoba.api.user.vo.UserPasswordUpdateVO;
import lgcns.eegoba.api.user.vo.UserVO;
import lgcns.eegoba.common.exception.ApiException;
import lgcns.eegoba.common.exception.ExceptionEnum;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

  private final UserMapper userMapper;
  private final PasswordEncoder passwordEncoder;

  @Transactional
  public void join(UserVO userVO) {
    userVO.setPassword(passwordEncoder.encode(userVO.getPassword()));
    userMapper.insertUser(userVO);
  }

  public UserVO login(UserLoginRequestVO userLoginRequestVO) {
    UserVO userVO;
    userVO = userMapper.getUserByEmail(userLoginRequestVO.getEmail());
    if (userVO == null) { // 사용자가 존재하지 않는 경우
      return userVO;
    }

    if (passwordEncoder.matches(userLoginRequestVO.getPassword(), userVO.getPassword())) {
      return userVO;
    } else { // password 오류
      throw new ApiException(ExceptionEnum.ACCESS_DENIED_EXCEPTION);
    }
  }

  @Transactional
  public void updatePassword(UserPasswordUpdateVO userPasswordUpdateVO) {
    UserVO userVO;
    userVO = userMapper.getUserByEmail(userPasswordUpdateVO.getEmail());
    if (passwordEncoder.matches(userPasswordUpdateVO.getPassword(), userVO.getPassword())) {
      throw new ApiException(ExceptionEnum.PASSWORD_VALIDATION_FAILED);
    }
    userPasswordUpdateVO.setPassword(passwordEncoder.encode(userPasswordUpdateVO.getPassword()));
    userMapper.updatePasswordByEmail(userPasswordUpdateVO);
  }

  // pw check를 backend에서 할 경우 사용 예정(미사용 시 삭제 예정)
  private boolean checkPw(String pw, String pwCheck) {
    return pw.equals(pwCheck);
  }
}
