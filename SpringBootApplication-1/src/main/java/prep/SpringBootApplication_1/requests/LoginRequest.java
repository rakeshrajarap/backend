package prep.SpringBootApplication_1.requests;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class LoginRequest {
    private String userId;
    private String password;
}
