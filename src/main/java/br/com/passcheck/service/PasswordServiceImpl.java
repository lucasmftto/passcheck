package br.com.passcheck.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;

@Service
public class PasswordServiceImpl implements PasswordService{

    Logger logger = LoggerFactory.getLogger(PasswordServiceImpl.class);

    @Override
    public boolean checkPassword(String password) {
        logger.info("Iniciando Validacao de password: " +password);

        if (password.equals("")){
            return false;
        }else if(password.length() < 9){
            return false;
        }else if (!containsLowerCase(password)){
            return false;
        }else if (!containsUpperCase(password)){
            return false;
        }else if(!containsNumber(password)){
            return false;
        }else if(!isSpecialCharacters(password)){
            return false;
        }else if(isRepeatedCharacter(password)){
            return false;
        }

        return true;
    }

    private boolean isRepeatedCharacter(String password) {

        List<Character> duplicateItemList = password.chars()
                .mapToObj(e -> (char)e)
                .collect(Collectors.toList());

        Set notDuplicateItemSet = new HashSet(duplicateItemList);
        if(notDuplicateItemSet.size() < duplicateItemList.size()){
            logger.info("Is Character Duplicate");
            return true;
        }
        return false;
    }

    private boolean isSpecialCharacters(String password) {
        boolean specialCaract = false;

        List<String> caracteresEspecialList = Arrays.asList("!", "@", "#", "$", "%", "^", "&", "*", "(", ")", "-", "+");
        CharSequence[] cs = caracteresEspecialList.toArray(new CharSequence[caracteresEspecialList.size()]);

        for (CharSequence a : cs) {
            if (password.contains(a)){
                specialCaract = true;
                break;
            }
        }
        return specialCaract;
    }

    private boolean containsLowerCase(String value) {
        return contains(value, i -> Character.isLetter(i) && Character.isLowerCase(i));
    }

    private boolean containsUpperCase(String value) {
        return contains(value, i -> Character.isLetter(i) && Character.isUpperCase(i));
    }

    private boolean containsNumber(String value) {
        return contains(value, Character::isDigit);
    }

    private boolean contains(String value, IntPredicate predicate) {
        return value.chars().anyMatch(predicate);
    }
}
