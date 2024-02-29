package lgcns.eegoba.common.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApiResponseVO<T> {
  private Integer code;
  private String message;

  @JsonInclude(JsonInclude.Include.NON_NULL)
  private T result;
}
