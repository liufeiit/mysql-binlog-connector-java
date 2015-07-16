package com.mysql.binlog.network;

public class AuthenticationException extends ServerException {

    private static final long serialVersionUID = 1L;

	public AuthenticationException(String message, int errorCode, String sqlState) {
        super(message, errorCode, sqlState);
    }

    public AuthenticationException(String message) {
        super(message, 0, "HY000");
    }
}