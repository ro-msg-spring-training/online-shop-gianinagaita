package ro.msg.learning.shop.exceptions;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
    private String INCORRECT_REQUEST = "INCORRECT_REQUEST";
    private String BAD_REQUEST = "BAD_REQUEST";
    private String LOCATION_NOT_FOUND = "LOCATION_NOT_FOUND";
    private String STOCK_NOT_FOND = "STOCK_NOT_FOND";
    private String STRATEGY_INABLE = "STRATEGY_INABLE";
    private String ADDRESS_NOT_FOUND = "ADDRESS_NOT_FOUND";

    @ExceptionHandler(StrategyEnableException.class)
    @ResponseStatus
    public final ExceptionMessage handleUserNotFoundException
            (AddressNotFound ex, WebRequest request) {
        ArrayList<String> details = new ArrayList<>(List.of(ex.getLocalizedMessage()));
        ExceptionMessage error = new ExceptionMessage(STRATEGY_INABLE, details);
        return error;
    }

    @ExceptionHandler(StrategyEnableException.class)
    @ResponseStatus
    public final ExceptionMessage handleUserNotFoundException
            (StrategyEnableException ex, WebRequest request) {
        List<String> details = Collections.singletonList(ex.getLocalizedMessage());
        ExceptionMessage error = new ExceptionMessage(STRATEGY_INABLE, details);
        return error;
    }

    @ExceptionHandler(StockNotFoundException.class)
    @ResponseStatus
    public final ExceptionMessage handleUserNotFoundException
            (StockNotFoundException ex, WebRequest request) {
        List<String> details = Collections.singletonList(ex.getLocalizedMessage());
        ExceptionMessage error = new ExceptionMessage(STOCK_NOT_FOND, details);
        return error;
    }

    @ExceptionHandler(LocationNotFoundException.class)
    @ResponseStatus
    public final ExceptionMessage handleUserNotFoundException
            (LocationNotFoundException ex, WebRequest request) {
        List<String> details = Collections.singletonList(ex.getLocalizedMessage());
        ExceptionMessage error = new ExceptionMessage(LOCATION_NOT_FOUND, details);
        return error;
    }

    @ExceptionHandler(RecordNotFoundException.class)
    @ResponseStatus
    public final ExceptionMessage handleUserNotFoundException
            (RecordNotFoundException ex, WebRequest request) {
        List<String> details = Collections.singletonList(ex.getLocalizedMessage());
        ExceptionMessage error = new ExceptionMessage(INCORRECT_REQUEST, details);
        return error;
    }

    @ExceptionHandler(MissingHeaderInfoException.class)
    @ResponseStatus
    public final ExceptionMessage handleInvalidTraceIdException
            (MissingHeaderInfoException ex, WebRequest request) {
        List<String> details = Collections.singletonList(ex.getLocalizedMessage());
        ExceptionMessage error = new ExceptionMessage(BAD_REQUEST, details);
        return error;
    }

    @ExceptionHandler(OrderNotFound.class)
    @ResponseStatus
    public final ExceptionMessage handleInvalidTraceIdException
            (OrderNotFound ex, WebRequest request) {
        List<String> details = Collections.singletonList(ex.getLocalizedMessage());
        ExceptionMessage error = new ExceptionMessage(BAD_REQUEST, details);
        return error;
    }
}
