package security.client.factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;

/**
 * Created by Mocart on 05-Sep-17.
 */
public class AuthResponseHandler implements ResponseErrorHandler {

    private static final Logger logger = LoggerFactory.getLogger(AuthResponseHandler.class);

    @Override
    public boolean hasError(ClientHttpResponse clientHttpResponse) throws IOException {
        return clientHttpResponse.getStatusCode().is4xxClientError();
    }

    @Override
    public void handleError(ClientHttpResponse clientHttpResponse) throws IOException {
        logger.error("Response error in Authorization: " + clientHttpResponse.getStatusCode() + " " + clientHttpResponse.getStatusText());
    }
}
