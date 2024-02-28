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
  private int usrId;
  private String usrNm = "";
  private String usrEmail = "";
  private String usrGndr = "";
  private String usrNnm = "";
  private String usrBrth = "";
  private String usrRnk = "";
  private String usrPw = "";
}
