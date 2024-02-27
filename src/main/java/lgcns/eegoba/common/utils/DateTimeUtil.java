package lgcns.eegoba.common.utils;

import lombok.experimental.UtilityClass;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

@UtilityClass
public class DateTimeUtil {

    public Date getCurrentDateTime() {
        ZonedDateTime nowSeoul = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));

        return Date.from(nowSeoul.toInstant());
    }
}
