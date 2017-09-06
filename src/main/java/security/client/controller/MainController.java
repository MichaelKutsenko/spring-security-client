package security.client.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

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

    @GetMapping(value = "/login")
    public String getLoginFrom() {
        return "login";
    }

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

}
