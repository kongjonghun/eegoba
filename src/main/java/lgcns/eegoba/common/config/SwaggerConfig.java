package lgcns.eegoba.common.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(info = @Info(title = "Eegoba API", description = "이거바 API 명세서", version = "v1"))
@RequiredArgsConstructor
@Configuration
public class SwaggerConfig {

  @Bean
  public GroupedOpenApi bookApi() {
    String[] userPaths = {"/book/**"};

    return GroupedOpenApi.builder().group("Book").pathsToMatch(userPaths).build();
  }

  @Bean
  public GroupedOpenApi reviewApi() {
    String[] userPaths = {"/review/**"};

    return GroupedOpenApi.builder().group("Review").pathsToMatch(userPaths).build();
  }

  @Bean
  public GroupedOpenApi userApi() {
    String[] userPaths = {"/user/**"};

    return GroupedOpenApi.builder().group("User").pathsToMatch(userPaths).build();
  }
}
