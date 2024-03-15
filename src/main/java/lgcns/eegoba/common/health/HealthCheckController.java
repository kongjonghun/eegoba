package lgcns.eegoba.common.health;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import lgcns.eegoba.common.constant.ErrorCode;
import lgcns.eegoba.common.constant.ResultCode;
import lgcns.eegoba.common.response.CommonApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("HealthCheckController")
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
@RequiredArgsConstructor
public class HealthCheckController {

  private final HealthCheckService healthCheckService;

  @Value("${spring.config.activate.on-profile}")
  private String activeProfile;

  @GetMapping(value = "/health")
  public CommonApiResponse healthCheck(HttpServletRequest request, HttpServletResponse response)
      throws Exception {
    try {
      StringBuilder message = new StringBuilder();
      message
          .append("Success. ")
          .append("hostname : ")
          .append(getHost())
          .append(":")
          .append(activeProfile);

      healthCheckService.healthCheck();

      // DB Connection 성공일 경우 result = 1
      return new CommonApiResponse(ResultCode.Success, message.toString(), 1);
    } catch (Exception e) {
      // DB Connection 실패일 경우 result = 0
      return new CommonApiResponse(ErrorCode.InternalServerError, "DB Connection Fail", 0);
    }
  }

  private String getHost() {
    StringBuilder host = new StringBuilder();
    InetAddress localhost;
    try {
      localhost = InetAddress.getLocalHost();
      if (localhost != null) {
        for (String s : Arrays.asList(localhost.getHostName(), localhost.getHostAddress())) {
          host.append("/").append(s);
        }
      }
    } catch (UnknownHostException e) {
      host = new StringBuilder("UnknownHost");
    }
    return host.toString();
  }
}
