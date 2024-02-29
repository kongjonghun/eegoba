package lgcns.eegoba.common.health;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import lgcns.eegoba.common.constant.StatusConst;
import lgcns.eegoba.common.response.ApiResponseVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpStatusCodeException;

@RestController("HealthCheckController")
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
@RequiredArgsConstructor
public class HealthCheckController {

  private final HealthCheckService healthCheckService;

  @Value("${spring.config.activate.on-profile}")
  private String activeProfile;

  @GetMapping(value = "/health")
  public ApiResponseVO healthCheck(HttpServletRequest request, HttpServletResponse response)
      throws HttpStatusCodeException {
    try {
      StringBuilder message = new StringBuilder();
      message
          .append("Success. ")
          .append("hostname : ")
          .append(getHost())
          .append(":")
          .append(activeProfile);

      HealthCheckVO healthCheckVO = new HealthCheckVO();
      healthCheckVO.setCode(StatusConst.Success.getStatus());
      healthCheckVO.setMessage(message.toString());
      healthCheckVO.setDbConnection(healthCheckService.healthCheck()); // DB Connection OK이면 1

      return healthCheckVO;
    } catch (Exception e) {
      HealthCheckVO healthCheckVO = new HealthCheckVO();
      healthCheckVO.setCode(StatusConst.InternalServerError.getStatus());
      healthCheckVO.setMessage(e.getMessage());
      healthCheckVO.setDbConnection("0"); // DB Connection X이면 0

      return healthCheckVO;
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
