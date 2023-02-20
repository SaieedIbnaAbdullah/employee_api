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
    @NotBlank
    @Size(min = 5, max = 150)
    private String name;
    @NotBlank(message = "Email is required")
    @Email(message = "Give a valid email")
    private String email;
    @NotNull
    @Min(value = 20, message = "Age not less then 20")
    @Max(value = 60, message = "Age not greater then 20")
    private Integer age;
}
