package lgcns.eegoba.api.mail.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.time.Duration;

@Mapper
public interface MailMapper {

    int insertEmailAuthInfo(String key, String value, Duration authCodeExpirationMillis);

    int checkDuplicateEmail(String email);

    String getValue(String key);
}
