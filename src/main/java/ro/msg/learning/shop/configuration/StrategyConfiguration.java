package ro.msg.learning.shop.configuration;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ro.msg.learning.shop.strategy.MostAbundant;
import ro.msg.learning.shop.strategy.Proximity;
import ro.msg.learning.shop.strategy.SingleLocation;
import ro.msg.learning.shop.strategy.Strategy;

@Configuration
@Data
//ConfigurationProperties e folosit intr un pojo separat si il injectez, cand am mai multe campuri
//@ConfigurationProperties(prefix = "strategy")
public class StrategyConfiguration {
    @Bean
    public Strategy strategy(@Value("${strategy.type}") StrategyType type, MostAbundant mostAbundant, SingleLocation singleLocation, Proximity proximity) {
        switch (type) {
            case MOSTABUNDANT:
                return mostAbundant;
            case SINGLELOCATION:
                return singleLocation;
            case PROXIMITY:return proximity;
        }
        throw new IllegalArgumentException();
    }
}
