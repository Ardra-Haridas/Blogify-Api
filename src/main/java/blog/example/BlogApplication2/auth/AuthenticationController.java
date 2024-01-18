package blog.example.BlogApplication2.auth;

import blog.example.BlogApplication2.Model.User;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    @Autowired
    private final AuthenticationService service;
    @PostMapping(path = "/register")
    public ResponseEntity<Object> register(
         @Valid @RequestBody User user
    ){
        return ResponseEntity.ok(service.register(user));
    }
    @PostMapping(path = "/authenticate")
    public ResponseEntity<Object>register(
          @Valid  @RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(service.authenticate(request));
    }

}

