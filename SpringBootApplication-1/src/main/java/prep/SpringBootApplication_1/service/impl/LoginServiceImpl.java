package prep.SpringBootApplication_1.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import prep.SpringBootApplication_1.exceptions.BadRequestException;
import prep.SpringBootApplication_1.repositories.UserRepo;
import prep.SpringBootApplication_1.requests.LoginRequest;
import prep.SpringBootApplication_1.service.LoginService;
import prep.SpringBootApplication_1.utilities.BaseResponse;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    UserRepo userRepo;

    @Override
    public BaseResponse<String> getLoggedInDetails(LoginRequest loginRequest) throws BadRequestException {
        if(loginRequest.getUserId().isEmpty()||loginRequest.getPassword().isEmpty())
            throw new BadRequestException("Invalid User");
       var user= userRepo.findByEmail(loginRequest.getUserId());
        if(user.getUserId()!=null)
            return new BaseResponse<String>().createResponse(200,"succes");
        throw new BadRequestException("Failed");
    }
}
