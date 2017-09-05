package security.client.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;
import security.client.domain.User;
import security.client.dto.VerificationRequestDto;

import javax.validation.Valid;

/**
 * Created by Mocart on 04-Sep-17.
 */
@Controller
public class MainController {
    private static final String URL_OF_VERIFICATION = "http://localhost:4567/verify";
    @Value("${client.id}")
    private String ID;
    @Value("${client.key}")
    private String KEY;

    private final RestTemplate restTemplate;

    private Logger logger = LoggerFactory.getLogger(getClass());

    public MainController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping(value = "/hello")
    public ResponseEntity sayHello() {
        return new ResponseEntity("hello there", HttpStatus.OK);
    }

    @GetMapping(value = "/login")
    public String getLoginFrom() {
        return "login";
    }

//    @PostMapping(value = "/login")
//    public String getLoginFrom(@Valid VerificationRequestDto loginForm, BindingResult bindingResult, Model model) {
//        if (bindingResult.hasErrors()) {
//            model.addAttribute("error", "Please, fill all fields");
//            model.addAttribute("loginFormDto", new VerificationRequestDto());
//            return "login";
//        }
//
//        try {
//            getUser(loginForm);
//        } catch (Exception e) {
//            return "login";
//        }
//
//        return "login";
//    }

    @GetMapping(value = "/user/hello")
    public ResponseEntity helloUser() {
        return new ResponseEntity("hello, user", HttpStatus.OK);
    }

    @GetMapping(value = "/manager/hello")
    public ResponseEntity helloManager() {
        return new ResponseEntity("hello, manager", HttpStatus.OK);
    }


    @GetMapping(value = "/admin/hello")
    public ResponseEntity helloAdmin() {
        return new ResponseEntity("hello, admin", HttpStatus.OK);
    }


//    private User getUser(VerificationRequestDto verificationRequestDto) throws Exception {
//        System.out.println("hello");
//
//        verificationRequestDto.setId(ID);
//        verificationRequestDto.setKey(KEY);
//
//        System.out.println(verificationRequestDto);
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
//
//        HttpEntity<VerificationRequestDto> httpEntity = new HttpEntity<>(verificationRequestDto, headers);
//        System.out.println(httpEntity.getBody());
//
//        ResponseEntity<User> response = restTemplate.postForEntity(URL_OF_VERIFICATION, httpEntity, User.class);
//        logger.debug("Verification request has been sent. Status code of request: " + response.getStatusCode());
//
//        if (response.getStatusCode().equals(HttpStatus.OK))  {
//            return response.getBody();
//        }
//        else {
//            logger.error("An exception occurred. Status code: " + response.getStatusCodeValue());
//            throw new Exception("Error. Status code: " + response.getStatusCodeValue());
//        }
//    }
}
