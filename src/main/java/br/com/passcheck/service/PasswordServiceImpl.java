package br.com.passcheck.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class PasswordServiceImpl implements PasswordService{

    Logger logger = LoggerFactory.getLogger(PasswordServiceImpl.class);

    @Override
    public boolean checkPassword(String password) {
        logger.info("Iniciando Validacao de password");
        String[] pass = password.split("");


        if (password.equals("")){
            return false;
        }else if(pass.length < 9){
            return false;
        }

        return true;
    }
}
