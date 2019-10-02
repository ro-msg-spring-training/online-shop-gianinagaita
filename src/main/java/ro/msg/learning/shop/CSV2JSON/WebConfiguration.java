package ro.msg.learning.shop.CSV2JSON;

        import org.springframework.context.annotation.Configuration;
        import org.springframework.http.converter.HttpMessageConverter;
        import org.springframework.web.servlet.config.annotation.EnableWebMvc;
        import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

        import java.util.List;

@EnableWebMvc
@Configuration
public class WebConfiguration implements WebMvcConfigurer {
    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(new CSVconverter());
    }
}
