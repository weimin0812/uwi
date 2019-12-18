package pdd;

import java.io.Serializable;

public class BaseResponse<T> implements Serializable {
    private static final long serialVersionUID = 3852160569347342717L;
    private boolean success;
    private Integer errorCode;
    private String errorMsg;
    private T result;

    public BaseResponse() {

    }

    private BaseResponse(Builder<T> builder) {

    }

    public static final class Builder<T> {
        private boolean success = false;
        private Integer errorCode;
        private String errorMsg;
        private T result;

        public Builder() {
        }

        public BaseResponse build() {
            return new BaseResponse(this);
        }


    }


    public boolean isSuccess() {
        return success;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public T getResult() {
        return result;
    }
}
