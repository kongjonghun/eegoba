package lgcns.eegoba.common.utils;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import lombok.experimental.UtilityClass;

@UtilityClass
public class DateTimeUtil {

  private static final ZoneId SEOUL_ZONE = ZoneId.of("Asia/Seoul");

  public Date getSeoulDateTime() {
    ZonedDateTime nowSeoul = ZonedDateTime.now(SEOUL_ZONE);

    return Date.from(nowSeoul.toInstant());
  }
}
