package lgcns.eegoba.common.health;

import lgcns.eegoba.common.response.ApiResponseVO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class HealthCheckVO extends ApiResponseVO {
  private String dbConnection;
}
