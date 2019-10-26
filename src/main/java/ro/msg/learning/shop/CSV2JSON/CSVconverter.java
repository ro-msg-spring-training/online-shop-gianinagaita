package ro.msg.learning.shop.CSV2JSON;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractGenericHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.*;

@Component
public class CSVconverter extends AbstractGenericHttpMessageConverter {
    UtilsCSV methodsCSV = new UtilsCSV();

    public CSVconverter() {
        super(new MediaType("text", "csv"));
    }

    @Override
    protected void writeInternal(Object o, Type type, HttpOutputMessage httpOutputMessage) throws IOException, HttpMessageNotWritableException {
        List<Object> objectArrayList;
        if (o instanceof ArrayList) {
            objectArrayList = new ArrayList<>((ArrayList<Object>) o);
        } else {
            objectArrayList = Collections.singletonList(o);
        }
        methodsCSV.toCsv(o.getClass(), objectArrayList, httpOutputMessage.getBody());
    }

    @Override
    protected Object readInternal(Class aClass, HttpInputMessage httpInputMessage) throws IOException, HttpMessageNotReadableException {
        return methodsCSV.fromCvs(aClass, httpInputMessage.getBody());
    }


    @Override
    public Object read(Type type, Class aClass, HttpInputMessage httpInputMessage) throws IOException, HttpMessageNotReadableException {
        return readInternal(aClass, httpInputMessage);
    }


}
