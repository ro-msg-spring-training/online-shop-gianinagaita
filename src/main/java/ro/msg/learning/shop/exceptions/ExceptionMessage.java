package ro.msg.learning.shop.exceptions;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ExceptionMessage {
    private List<String> message;
    private String messageCod;

    public ExceptionMessage(final String messageCod, final List<String> s) {
        this.message = s;
        this.messageCod = messageCod;
    }
}
