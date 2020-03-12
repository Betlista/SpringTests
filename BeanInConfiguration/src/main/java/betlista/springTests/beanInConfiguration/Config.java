package betlista.springTests.beanInConfiguration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("my")
public class Config {

    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Bean
    public StringWrapper getStringWrapper() {
        return new StringWrapper(name);
    }

}
