package lgcns.eegoba.common.utils;

import java.util.HashMap;
import java.util.List;
import lombok.experimental.UtilityClass;

/** 공통 Validation을 위한 Utility Class * */
@UtilityClass
public class ValidationUtil {

  /**
   * Input 값이 Null이거나 공백일 경우 True를 반환, 아닐경우 false를 반환
   *
   * @param value
   * @return
   */
  public boolean isEmpty(String value) {
    if (value != null && value.length() > 0) {
      return false;
    } else {
      return true;
    }
  }

  /**
   * Input 값이 Null이거나 빈값일 경우 True를 반환, 아닐경우 false를 반환
   *
   * @param value
   * @return
   */
  public boolean isEmpty(Object value) {
    if (value == null) {
      return true;
    } else {
      if (value instanceof String) {
        return !(value.toString().length() > 0);
      } else if (value instanceof List) {
        return !(((List<Object>) value).size() > 0);
      } else if (value instanceof String[]) {
        return !(((String[]) value).length > 0);
      } else if (value instanceof HashMap) {
        return !(((HashMap) value).keySet().size() > 0);
      } else {
        return false;
      }
    }
  }

  public boolean isNotEmpty(String value) {
    return !isEmpty(value);
  }

  public boolean isNotEmpty(Object value) {
    return !isEmpty(value);
  }
}
