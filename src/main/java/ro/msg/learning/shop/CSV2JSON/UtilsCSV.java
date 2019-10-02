package ro.msg.learning.shop.CSV2JSON;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

//
public class UtilsCSV<T> {
    //generic type param T representing the type of POJO, in our case representing the Stock entity
    public List<T> fromCvs(Class<T> csvclass, InputStream inputStream) throws IOException {
        //mapper and schema always
        CsvMapper mapper = new CsvMapper();
        CsvSchema schema = mapper.schemaFor(csvclass);
        MappingIterator<T> it = mapper
                .readerFor(csvclass)
                .with(schema)
                .readValue(inputStream);
        return it.readAll();
    }

    public void toCsv(Class<T> tClass, List<T> listItem, OutputStream outputStream) throws IOException {
        outputStream.write(listItem.toString().getBytes());
    }
}

