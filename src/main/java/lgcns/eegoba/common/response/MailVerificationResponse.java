package lgcns.eegoba.common.response;

import lombok.Data;

@Data
public class MailVerificationResponse {
    private final boolean authResult;

    public MailVerificationResponse(boolean authResult) {
        this.authResult = authResult;
    }

    public static MailVerificationResponse of(boolean authResult) {
        return new MailVerificationResponse(authResult);
    }
}
