package com.metabolic.mongodb.result;

/**
 * Created by Administrator on 2018/09/12.
 */
public class BusinessException extends RuntimeException{
    private String errorCode;
    private String errorMessage;

    public BusinessException(Throwable cause, String errorCode, String errorMessage) {
        super(cause);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public BusinessException(String errorCode) {
        this.errorCode = errorCode;
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }

    public BusinessException() {
    }

    public BusinessException(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String toString() {
        return "|BusinessException|errorCode=" + this.errorCode + "|errorMessage=" + this.errorMessage;
    }

    public String getMessage() {
        return "|BusinessException|errorCode=" + this.errorCode + "|errorMessage=" + this.errorMessage;
    }
}
