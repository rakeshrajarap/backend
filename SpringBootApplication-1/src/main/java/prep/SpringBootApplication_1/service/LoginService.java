package prep.SpringBootApplication_1.service;

import org.springframework.stereotype.Service;
import prep.SpringBootApplication_1.exceptions.BadRequestException;
import prep.SpringBootApplication_1.requests.LoginRequest;
import prep.SpringBootApplication_1.utilities.BaseResponse;

@Service
public interface LoginService {


    BaseResponse<String> getLoggedInDetails(LoginRequest loginRequest) throws BadRequestException;

}
