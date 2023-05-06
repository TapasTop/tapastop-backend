package tapastop.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheck {

    @GetMapping("/health-check")
    public ResponseEntity<String> healthCheck(){
        ResponseEntity<String> responseEntity = new ResponseEntity<>("Health check", HttpStatus.OK);
        return responseEntity;
    }
}
