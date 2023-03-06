package co.LabsProjects.Oauthsecuritydemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;

import java.util.HashMap;
import java.util.Map;

@org.springframework.stereotype.Service
public class Service {

    @Autowired
    private ClientRegistrationRepository clientRegistrationRepository;

    public Map<String, String> getClientRegistrations(){
//        ClientRegistration google = clientRegistrationRepository.findByRegistrationId("google");
//        ClientRegistration github = clientRegistrationRepository.findByRegistrationId("github");

        Map<String, String> clientRegistrationAuthorizationUris = new HashMap<>();
        clientRegistrationAuthorizationUris.put("google", "/oauth2/authorization/google");
        clientRegistrationAuthorizationUris.put("github", "/oauth2/authorization/github");
        return clientRegistrationAuthorizationUris;
    }
}
