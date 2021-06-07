package mastery.jms;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mastery.dto.EmployeeDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class JmsProducer {

    private final JmsTemplate jmsTemplate;

    @Value("${by.akoltovich.queue}")
    private String queue;

    ObjectMapper objectMapper = new ObjectMapper();

    public void sendMessage(EmployeeDto employeeDto) {
        try {
            String employeeJson = objectMapper.writeValueAsString(employeeDto);
            log.info("Attempting Send employeeJson {} to queue: {}", employeeJson, queue);
            jmsTemplate.convertAndSend(queue, employeeJson);
        } catch (Exception e) {
            log.error("Recieved Exception during send Message: ", e);
        }
    }
}
