package lgcns.eegoba.common.health;

import lgcns.eegoba.common.health.mapper.HealthCheckMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HealthCheckService {
  private final HealthCheckMapper healthCheckMapper;

  public String healthCheck() {
    return healthCheckMapper.dbConnectionCheck();
  }
}
