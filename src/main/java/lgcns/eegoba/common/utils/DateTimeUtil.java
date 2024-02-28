package lgcns.eegoba.common.utils;

import lombok.experimental.UtilityClass;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@UtilityClass
public class DateTimeUtil {

    private static final ZoneId SEOUL_ZONE =  ZoneId.of("Asia/Seoul");

    public Date getCurrentSeoulDateTime() {
        LocalDateTime seoulLocalDateTime = LocalDateTime.now(SEOUL_ZONE);

        return Date.from(seoulLocalDateTime.atZone(SEOUL_ZONE).toInstant());
    }
}
