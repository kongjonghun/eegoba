package lgcns.eegoba.api.user.vo;

import lombok.*;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserLoginRequestVO {
  private String usrEmail = "";
  private String usrPw = "";
}
