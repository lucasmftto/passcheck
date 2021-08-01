package br.com.passcheck.strategy;

import br.com.passcheck.service.PasswordServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CheckNullStrategy implements ValidPasswordStrategy{

    Logger logger = LoggerFactory.getLogger(CheckNullStrategy.class);

    @Override
    public boolean isValid(String password) {
        if (password.equals("")){
            logger.info("CheckNull: " + false);
            return false;
        }
        logger.info("CheckNull: " + true);
        return true;
    }
}
