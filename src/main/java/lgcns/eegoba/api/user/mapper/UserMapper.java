package lgcns.eegoba.api.user.mapper;

import lgcns.eegoba.api.user.vo.UserPasswordUpdateVO;
import lgcns.eegoba.api.user.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
  void insertUser(UserVO userVO);

  UserVO getUserByEmail(String email);

  void updatePasswordByEmail(UserPasswordUpdateVO userPasswordUpdateVO);
}
