package lgcns.eegoba.common.health.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HealthCheckMapper {

  String dbConnectionCheck();
}
