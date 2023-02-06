package nursalim.springboot.jwt.jobapp.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import lombok.extern.slf4j.Slf4j;
import nursalim.springboot.jwt.jobapp.dto.JobDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Slf4j
@Service
public class JobService {

    @Autowired
    RestTemplate restTemplate;

    @Value("${find.all.job.url}")
    private String getAllJobUrl;

    @Value("${find.job.detail}")
    private String getJobDetail;

    public List<JobDto> findAllJob() throws JsonProcessingException {
        UriComponents uriComponents = UriComponentsBuilder.fromUriString(getAllJobUrl).build();
        ResponseEntity<String> response = restTemplate.exchange(
                uriComponents.toUriString(),
                HttpMethod.GET,
                null,
                String.class
        );

        log.info(String.valueOf(response));

        ObjectMapper objectMapper = new ObjectMapper();
        TypeFactory typeFactory = objectMapper.getTypeFactory();
        List<JobDto> jobDtoList = objectMapper.readValue(response.getBody(), typeFactory.constructCollectionType(List.class, JobDto.class));

        return jobDtoList;
    }

    public JobDto findJobById(String id){
        UriComponents uriComponents = UriComponentsBuilder.fromUriString(getJobDetail).build();
        uriComponents = uriComponents.expand(id);

        ResponseEntity<JobDto> response = restTemplate.exchange(
                uriComponents.toUriString(),
                HttpMethod.GET,
                null,
                JobDto.class
        );

        log.info(String.valueOf(response));
        return response.getBody();
    }
}
