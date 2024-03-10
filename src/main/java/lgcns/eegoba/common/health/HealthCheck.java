package lgcns.eegoba.common.health;

import lgcns.eegoba.common.response.ApiResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class HealthCheck extends ApiResponse {
  private String dbConnection;
}
