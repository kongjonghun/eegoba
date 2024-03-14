package lgcns.eegoba.api.user.vo;

import lombok.*;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserVO {
  private int userId;
  private String userName = "";
  private String email = "";
  private String gender = "";
  private String nickname = "";
  private String birthdate = "";
  private String position = "";
  private String password = "";
}
