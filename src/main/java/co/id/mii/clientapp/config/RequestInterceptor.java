/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.id.mii.clientapp.config;

import co.id.mii.clientapp.util.AuthorizationUtil;
import java.io.IOException;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

/**
 *
 * @author hp
 */
public class RequestInterceptor implements ClientHttpRequestInterceptor {

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, 
            ClientHttpRequestExecution ex) throws IOException {
        if (AuthorizationUtil.auth()!= null) {
            request
                    .getHeaders()
                    .add("Authorization", "Basic " +
                            AuthorizationUtil.auth().getCredentials().toString());
        }
        ClientHttpResponse response = ex.execute(request, body);
        return response;
    }
    
}
