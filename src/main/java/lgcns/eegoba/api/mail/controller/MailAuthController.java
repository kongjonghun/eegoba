package lgcns.eegoba.api.mail.controller;

import jakarta.validation.Valid;
import lgcns.eegoba.api.mail.service.MailAuthService;
import lgcns.eegoba.common.constant.ResultCode;
import lgcns.eegoba.common.response.CommonApiResponse;
import lgcns.eegoba.common.response.MailVerificationResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/mail")
@RequiredArgsConstructor
public class MailAuthController {
    private final MailAuthService mailAuthService;

    @PostMapping("/verification-request")
    public ResponseEntity<CommonApiResponse> sendMessage(@RequestParam("email") @Valid String email) {
        mailAuthService.sendCodeToEmail(email);

        return ResponseEntity.ok(CommonApiResponse.of(ResultCode.Success));
    }

    @GetMapping("/verification")
    public ResponseEntity<CommonApiResponse> verificationEmail(@RequestParam("email") @Valid String email,
                                                               @RequestParam("code") String authCode) {
        MailVerificationResponse response = mailAuthService.verifiedCode(email, authCode);

        return ResponseEntity.ok(CommonApiResponse.of(ResultCode.Success, response));
    }
}