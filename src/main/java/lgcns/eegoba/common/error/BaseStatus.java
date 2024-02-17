package lgcns.eegoba.common.error;

import java.io.Serializable;

public interface BaseStatus extends Serializable {

    String getCode();
    String getMessage();
    int getStatus();
    String toString();
}
