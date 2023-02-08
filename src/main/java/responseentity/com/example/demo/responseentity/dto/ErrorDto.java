package responseentity.com.example.demo.responseentity.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatusCode;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ErrorDto {
    private HttpStatusCode statusCode;
    private String message ;
}
