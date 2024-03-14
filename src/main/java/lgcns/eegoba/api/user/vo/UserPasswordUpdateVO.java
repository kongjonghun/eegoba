package lgcns.eegoba.api.user.vo;

import lombok.*;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserPasswordUpdateVO {
  private String email = "";
  private String password = "";
}
