package prep.SpringBootApplication_1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import prep.SpringBootApplication_1.exceptions.BadRequestException;
import prep.SpringBootApplication_1.requests.LoginRequest;
import prep.SpringBootApplication_1.service.LoginService;
import prep.SpringBootApplication_1.utilities.BaseResponse;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

    public static void main(String[] args) {
        List<Integer> integerList= List.of(1, 2, 3);
        System.out.println("Before Filtering : "+integerList);
        integerList= integerList.stream().filter(i->i%2==0).collect(Collectors.toList());
        System.out.println("After Filtering : "+integerList);
    }

}
