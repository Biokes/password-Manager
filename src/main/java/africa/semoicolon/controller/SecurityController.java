package africa.semoicolon.controller;

import africa.semoicolon.services.SecurityUserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class SecurityController{
    private SecurityUserService securityUserService;
}
