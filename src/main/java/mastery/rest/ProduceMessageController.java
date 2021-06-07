package mastery.rest;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import mastery.dto.EmployeeDto;
import mastery.external.EmployeeClient;
import mastery.jms.JmsProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;

@RestController
@Slf4j
@RequestMapping("/active")
@RequiredArgsConstructor
public class ProduceMessageController {

    private final JmsProducer jmsProducer;
    private final EmployeeClient employeeClient;

    @PostMapping("/employee")
    public void sendMessage (@Valid @RequestBody EmployeeDto message) {
        jmsProducer.sendMessage(message);
    }

    @GetMapping(path = "/id")
    @ApiOperation("Get employee from database by id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved employee"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Server not available")
    })
    public EmployeeDto getEmployeeById(@Positive @RequestParam Long employeeId) {
        log.info("Calling get employee by id {}", employeeId);
        return employeeClient.getEmployee(employeeId);
    }
}
