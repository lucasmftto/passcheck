package br.com.passcheck.service;

import br.com.passcheck.strategy.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;

@Service
public class PasswordServiceImpl implements PasswordService{

    Logger logger = LoggerFactory.getLogger(PasswordServiceImpl.class);

    @Override
    public boolean checkPassword(String password) {
        logger.info("Iniciando Validacao de password: " + password);

        List<ValidPasswordStrategy> strategies =
                Arrays.asList(
                        new CheckNullStrategy(),
                        new CheckLengthStrategy(),
                        new CheckContainsLowerCaseStrategy(),
                        new CheckContainsUpperCaseStrategy(),
                        new CheckContainsNumberStrategy(),
                        new CheckRepeatedCharacterStrategy(),
                        new CheckSpecialCharactersStrategy()
                );

        boolean result = strategies.stream().allMatch(str -> str.isValid(password) == true);
        logger.info("Finalizando Validacao de password: " + password + " is: " + result);

        return result;
    }
}
