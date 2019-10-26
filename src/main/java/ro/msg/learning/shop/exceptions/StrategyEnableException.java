package ro.msg.learning.shop.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class StrategyEnableException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public StrategyEnableException(String message) {
        super(message);
    }
}