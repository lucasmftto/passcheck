package br.com.passcheck.controllers;

import br.com.passcheck.dto.PasswordDto;
import br.com.passcheck.service.PasswordService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/checkPassword")
@RequiredArgsConstructor
@CrossOrigin("*")
public class PasscheckController {

    @Autowired
    private PasswordService service;

    @ApiOperation(value = "Valida Password")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Boolean isValid(@RequestBody()  @Valid PasswordDto passwordDto) {
        MDC.clear();
        MDC.put("Valida Password: ", String.valueOf(UUID.randomUUID()));
        return this.service.checkPassword(passwordDto.getPassword());
    }

}
