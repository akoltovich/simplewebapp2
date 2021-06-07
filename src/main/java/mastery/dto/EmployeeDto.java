package mastery.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.*;
import mastery.validation.DateOfBirthValidation;
import mastery.validation.GenderValidation;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmployeeDto {

    private Long employeeId;

    @Length(min = 2, max = 30)
    @NotBlank
    private String firstName;

    @Length(min = 2, max = 30)
    @NotBlank
    private String lastName;

    @Min(1)
    @NotNull
    private Long departmentId;

    @Length(min = 2, max = 30)
    @NotBlank
    private String jobTitle;

    @GenderValidation(enumClazz = Gender.class)
    @NotNull
    private Gender gender;

    @DateOfBirthValidation
    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd")
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate dateOfBirth;
}
