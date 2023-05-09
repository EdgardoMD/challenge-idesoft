package dev.edgardomd.challengeidesoft.infraestructure.gateway;

import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;
import dev.edgardomd.challengeidesoft.domain.model.Holiday;
import dev.edgardomd.challengeidesoft.domain.port.output.GetHolidaysGateway;
import dev.edgardomd.challengeidesoft.infraestructure.exception.GatewayException;
import dev.edgardomd.challengeidesoft.infraestructure.gateway.mapper.HolidayClientToDomainMapper;
import dev.edgardomd.challengeidesoft.infraestructure.gateway.model.ApiHolidayResponse;
import dev.edgardomd.challengeidesoft.infraestructure.gateway.model.HolidayClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;
import java.util.concurrent.TimeUnit;

@Service
public class GetAllHolidaysFromApiGateway implements GetHolidaysGateway {
    private final RestTemplate restTemplate;
    private final String urlApi;
    private final HolidayClientToDomainMapper holidayClientToDomainMapper;
    private final LoadingCache<String, Collection<HolidayClient>> cache;

    public GetAllHolidaysFromApiGateway(RestTemplate restTemplate,
                                        @Value("${urlApi.holidays}") String urlApi,
                                        HolidayClientToDomainMapper holidayClientToDomainMapper) {
        this.restTemplate = restTemplate;
        this.urlApi = urlApi;
        this.holidayClientToDomainMapper = holidayClientToDomainMapper;
        this.cache = Caffeine.newBuilder()
                .maximumSize(1)
                .expireAfterWrite(5, TimeUnit.MINUTES)
                .build(this::getAllHolidaysFromApi);
    }

    @Override
    public Collection<Holiday> execute() {
        Collection<HolidayClient> holidayClientCollection = cache.get("holidays");
        return holidayClientToDomainMapper.execute(holidayClientCollection);
    }

    private Collection<HolidayClient> getAllHolidaysFromApi(String key) {
        ResponseEntity<ApiHolidayResponse> response;
        ApiHolidayResponse apiHolidayResponse;

        try {
            response = restTemplate.getForEntity(urlApi, ApiHolidayResponse.class);
            apiHolidayResponse = response.getBody();

            if(null == apiHolidayResponse) {
                throw new GatewayException("Error Holiday Api Gateway");
            }
            return apiHolidayResponse.getData();
        } catch (RestClientException ex) {
            throw new RestClientException("Exception message!");
        }
    }
}
