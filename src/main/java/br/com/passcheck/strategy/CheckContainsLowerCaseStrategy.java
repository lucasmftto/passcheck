package br.com.passcheck.strategy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CheckContainsLowerCaseStrategy implements ValidPasswordStrategy{

    Logger logger = LoggerFactory.getLogger(CheckContainsLowerCaseStrategy.class);

    @Override
    public boolean isValid(String password) {
        boolean result = contains(password, i -> Character.isLetter(i) && Character.isLowerCase(i));
        logger.info("CheckContainsLowerCase: " + result);
        return result;
    }
}
