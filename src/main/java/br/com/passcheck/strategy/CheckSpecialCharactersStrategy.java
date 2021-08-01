package br.com.passcheck.strategy;

import br.com.passcheck.service.PasswordServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

public class CheckSpecialCharactersStrategy implements ValidPasswordStrategy{

    Logger logger = LoggerFactory.getLogger(CheckSpecialCharactersStrategy.class);

    @Override
    public boolean isValid(String password) {
        boolean specialCaract = false;

        List<String> caracteresEspecialList = Arrays.asList("!", "@", "#", "$", "%", "^", "&", "*", "(",")", "-", "+");
        CharSequence[] cs = caracteresEspecialList.toArray(new CharSequence[caracteresEspecialList.size()]);

        for (CharSequence a : cs) {
            if (password.contains(a)){
                specialCaract = true;
                break;
            }
        }

        logger.info("CheckSpecialCharacters: " + specialCaract);
        return specialCaract;
    }
}
