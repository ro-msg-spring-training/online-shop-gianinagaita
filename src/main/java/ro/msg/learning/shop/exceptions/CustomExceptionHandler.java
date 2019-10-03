package ro.msg.learning.shop.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
    private String INCORRECT_REQUEST = "INCORRECT_REQUEST";
    private String BAD_REQUEST = "BAD_REQUEST";
    private String LOCATION_NOT_FOUND = "LOCATION_NOT_FOUND";
    private String STOCK_NOT_FOND = "STOCK_NOT_FOND";
    private String STRATEGY_INABLE = "STRATEGY_INABLE";
    private String ADDRESS_NOT_FOUND = "ADDRESS_NOT_FOUND";

    @ExceptionHandler(StrategyEnableException.class)
    public final ResponseEntity<ExceptionMessage> handleUserNotFoundException
            (AddressNotFound ex, WebRequest request) {
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        ExceptionMessage error = new ExceptionMessage(STRATEGY_INABLE, details);
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(StrategyEnableException.class)
    public final ResponseEntity<ExceptionMessage> handleUserNotFoundException
            (StrategyEnableException ex, WebRequest request) {
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        ExceptionMessage error = new ExceptionMessage(STRATEGY_INABLE, details);
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(StockNotFoundException.class)
    public final ResponseEntity<ExceptionMessage> handleUserNotFoundException
            (StockNotFoundException ex, WebRequest request) {
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        ExceptionMessage error = new ExceptionMessage(STOCK_NOT_FOND, details);
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(LocationNotFoundException.class)
    public final ResponseEntity<ExceptionMessage> handleUserNotFoundException
            (LocationNotFoundException ex, WebRequest request) {
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        ExceptionMessage error = new ExceptionMessage(LOCATION_NOT_FOUND, details);
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RecordNotFoundException.class)
    public final ResponseEntity<ExceptionMessage> handleUserNotFoundException
            (RecordNotFoundException ex, WebRequest request) {
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        ExceptionMessage error = new ExceptionMessage(INCORRECT_REQUEST, details);
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MissingHeaderInfoException.class)
    public final ResponseEntity<ExceptionMessage> handleInvalidTraceIdException
            (MissingHeaderInfoException ex, WebRequest request) {
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        ExceptionMessage error = new ExceptionMessage(BAD_REQUEST, details);
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(OrderNotFound.class)
    public final ResponseEntity<ExceptionMessage> handleInvalidTraceIdException
            (OrderNotFound ex, WebRequest request) {
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        ExceptionMessage error = new ExceptionMessage(BAD_REQUEST, details);
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
