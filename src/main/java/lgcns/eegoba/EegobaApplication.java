package lgcns.eegoba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

// Spring Security Redirect 로그인 페이지 해제
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class EegobaApplication {

  public static void main(String[] args) {
    SpringApplication.run(EegobaApplication.class, args);
  }
}
