package security.client.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import security.client.domain.User;
import security.client.dto.VerificationRequestDto;
import security.client.security.CustomUserDetails;

/**
 * Created by Mocart on 06-Sep-17.
 */
@Service
public class UserDetailService implements UserDetailsService{
    private static final String URL_OF_VERIFICATION = "http://localhost:4567/verify";
    @Value("${client.id}")
    private String ID;
    @Value("${client.key}")
    private String KEY;

    private final RestTemplate restTemplate;

    public UserDetailService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    private Logger logger = LoggerFactory.getLogger(getClass());


    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user =  getUser(userName);
        if (user == null) {
            throw  new UsernameNotFoundException("user not found");
        }
        return new CustomUserDetails(user);
    }

    private User getUser(String userName) {
        VerificationRequestDto verificationRequestDto = new VerificationRequestDto();
        verificationRequestDto.setUsername(userName);
        verificationRequestDto.setId(ID);
        verificationRequestDto.setKey(KEY);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        HttpEntity<VerificationRequestDto> httpEntity = new HttpEntity<>(verificationRequestDto, headers);
        System.out.println(httpEntity.getBody());

        ResponseEntity<User> response = restTemplate.postForEntity(URL_OF_VERIFICATION, httpEntity, User.class);
        logger.debug("Verification request has been sent. Status code of request: " + response.getStatusCode());

        if (response.getStatusCode().equals(HttpStatus.OK))  {
            return response.getBody();
        }
        else {
            logger.error("An exception occurred. Status code: " + response.getStatusCodeValue());
            return null;
        }
    }
}
