package prep.SpringBootApplication_1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class SpringBootApplication1Application {
    Logger logger = LoggerFactory.getLogger(SpringBootApplication1Application.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringBootApplication1Application.class, args);
    }

    @Bean
    WebMvcConfigurer corsConfigurer1() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                logger.info("Adding CORS Mappings..!");
                registry.addMapping("/**")
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS").allowedHeaders("*")
                        .allowCredentials(false).maxAge(3600);
            }
        };
    }

}
