package com.meritamerica.assignment5.Exception;

import ch.qos.logback.core.status.Status;

public class ExceedsCombinedBalanceLimitException extends Exception {
    public ExceedsCombinedBalanceLimitException(String message) { super(message); }
}

