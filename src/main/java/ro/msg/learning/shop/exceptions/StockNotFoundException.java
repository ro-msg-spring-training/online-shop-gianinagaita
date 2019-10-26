package ro.msg.learning.shop.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)

public class StockNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public StockNotFoundException(String message) {
        super(message);
    }
}
