package prep.SpringBootApplication_1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import prep.SpringBootApplication_1.exceptions.BadRequestException;
import prep.SpringBootApplication_1.requests.LoginRequest;
import prep.SpringBootApplication_1.service.LoginService;
import prep.SpringBootApplication_1.utilities.BaseResponse;

@RestController
@RequestMapping(("/login"))
@CrossOrigin("*")
public class LoginController {

    @Autowired
    LoginService loginService;

    @PostMapping("/authenticate")
    public BaseResponse<String> getLoginStatus(@RequestBody LoginRequest loginRequest) throws BadRequestException {
        return loginService.getLoggedInDetails(loginRequest);
    }

}
