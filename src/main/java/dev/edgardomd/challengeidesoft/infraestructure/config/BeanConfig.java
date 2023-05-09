package dev.edgardomd.challengeidesoft.infraestructure.config;

import dev.edgardomd.challengeidesoft.domain.port.input.GetHollidays;
import dev.edgardomd.challengeidesoft.domain.usecase.GetHolidaysUseCase;
import dev.edgardomd.challengeidesoft.infraestructure.gateway.GetAllHolidaysFromApiGateway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class BeanConfig {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public GetHollidays getHollidaysSortByType(GetAllHolidaysFromApiGateway getAllHolidaysFromApiGateway) {
        return new GetHolidaysUseCase(getAllHolidaysFromApiGateway);
    }

}
