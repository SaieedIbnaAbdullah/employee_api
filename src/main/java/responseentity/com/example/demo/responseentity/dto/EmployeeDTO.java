package responseentity.com.example.demo.responseentity.dto;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EmployeeDTO {
    @NotBlank(message = "Name is required")
    @Size(min = 5, max = 150, message
            = "Name must be between 5 and 150 characters")
    private String name;
    @NotBlank(message = "Email is required")
    @Email(message = "Give a valid email")
    private String email;
    @NotNull(message = "Age should not be empty")
    @Min(value = 10, message = "Age should not be less than 10")
    @Max(value = 60, message = "Age should not be greater than 60")
    private Integer age;
}
