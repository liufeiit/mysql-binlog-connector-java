package com.mysql.binlog.network;

import java.io.IOException;

public class ServerException extends IOException {

    private static final long serialVersionUID = 1L;
    
	private int errorCode;
    private String sqlState;

    public ServerException(String message, int errorCode, String sqlState) {
        super(message);
        this.errorCode = errorCode;
        this.sqlState = sqlState;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getSqlState() {
        return sqlState;
    }
}