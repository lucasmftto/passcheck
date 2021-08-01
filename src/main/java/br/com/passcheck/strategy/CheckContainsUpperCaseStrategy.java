package br.com.passcheck.strategy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CheckContainsUpperCaseStrategy implements ValidPasswordStrategy{

    Logger logger = LoggerFactory.getLogger(CheckContainsUpperCaseStrategy.class);

    @Override
    public boolean isValid(String password) {
        boolean result  = contains(password, i -> Character.isLetter(i) && Character.isUpperCase(i));
        logger.info("CheckContainsUpperCase: " + result);
        return result;
    }
}
