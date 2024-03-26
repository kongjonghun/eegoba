package lgcns.eegoba.api.mail.service;

import lgcns.eegoba.api.mail.mapper.MailMapper;
import lgcns.eegoba.common.constant.ErrorCode;
import lgcns.eegoba.common.exception.ApiException;
import lgcns.eegoba.common.response.MailVerificationResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.time.Duration;
import java.util.Random;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class MailAuthService {

    private static final String AUTH_CODE_PREFIX = "AuthCode ";

    private final MailService mailService;

    private final MailMapper mailMapper;

    @Value("${spring.mail.auth-code-expiration-millis}")
    private long authCodeExpirationMillis;

    @Value("${spring.mail.title}")
    private String mailTitle;

    public void sendCodeToEmail(String toEmail) {
        this.checkDuplicateEmail(toEmail);
        String authCode = this.createCode();
        mailService.sendEmail(toEmail, mailTitle, authCode);
        mailMapper.insertEmailAuthInfo(AUTH_CODE_PREFIX + toEmail,
                authCode, Duration.ofMillis(this.authCodeExpirationMillis));
    }

    private void checkDuplicateEmail(String email) {
        if (mailMapper.checkDuplicateEmail(email) > 0) {
            log.debug("MailAuthServiceImpl.checkDuplicateEmail exception occur email: {}", email);
            throw new ApiException(ErrorCode.MAIL_EXISTS_EXCEPTION);
        }
    }

    private String createCode() {
        int lenth = 6;
        try {
            Random random = SecureRandom.getInstanceStrong();
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < lenth; i++) {
                builder.append(random.nextInt(10));
            }
            return builder.toString();
        } catch (NoSuchAlgorithmException e) {
            log.debug("MailAuthService.createCode() exception occur");
            throw new ApiException(ErrorCode.MAIL_SERVER_EXCEPTION);
        }
    }

    public MailVerificationResponse verifiedCode(String email, String authCode) {
        this.checkDuplicateEmail(email);
        String serverAuthCode = mailMapper.getValue(AUTH_CODE_PREFIX + email);
        boolean authResult = serverAuthCode.equals(authCode);

        return MailVerificationResponse.of(authResult);
    }
}