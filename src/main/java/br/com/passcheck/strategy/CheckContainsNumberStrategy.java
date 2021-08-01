package br.com.passcheck.strategy;

import br.com.passcheck.service.PasswordServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CheckContainsNumberStrategy implements ValidPasswordStrategy{

    Logger logger = LoggerFactory.getLogger(PasswordServiceImpl.class);

    @Override
    public boolean isValid(String password) {
        boolean result = contains(password, Character::isDigit);
        logger.info("CheckContainsNumber: " + result);
        return result;
    }
}
