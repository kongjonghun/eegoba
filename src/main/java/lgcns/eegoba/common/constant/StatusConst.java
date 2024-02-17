package lgcns.eegoba.common.constant;

import lgcns.eegoba.common.error.BaseStatus;

import java.io.Serializable;

public enum StatusConst implements BaseStatus, Serializable {

    Success(200, "200", "Success"),
    BadRequest(400, "400", "Bad Request"),
    Unauthorized(401, "401", "Unauthorized"),
    Forbidden(403, "403", "Forbidden"),
    NotFound(404, "404", "Not Found"),
    MethodNotAllowed(405, "405", "Method Not Allowed"),
    InternalServerError(500, "500", "Internal Server Error"),
    NotImplemented(501, "501", "Not Implemented"),
    BadGateway(502, "502", "Bad Gateway"),
    ServiceUnavailable(503, "503", "Service Unavailable"),
    GatewayTimeout(504, "504", "Gateway Timeout");
    ;


    private int status;
    private String code;
    private String message;

    StatusConst(int status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

    @Override
    public int getStatus() {
        return this.status;
    }
}
