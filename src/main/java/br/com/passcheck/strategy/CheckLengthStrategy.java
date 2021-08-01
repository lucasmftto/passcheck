package br.com.passcheck.strategy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CheckLengthStrategy implements ValidPasswordStrategy{

    Logger logger = LoggerFactory.getLogger(CheckLengthStrategy.class);

    @Override
    public boolean isValid(String password) {
        if(password.length() < 9){
            logger.info("CheckLength: " + false);
            return false;
        }
        logger.info("CheckLength: " + true);
        return true;
    }
}
