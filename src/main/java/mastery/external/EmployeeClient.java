package mastery.external;

import mastery.dto.EmployeeDto;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class EmployeeClient {

    public EmployeeDto getEmployee(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        String resourceUrl
                = "http://localhost:8080/simplewebapp/employees/id?employeeId=" + id;
        return restTemplate.getForObject(resourceUrl, EmployeeDto.class);
    }
}
