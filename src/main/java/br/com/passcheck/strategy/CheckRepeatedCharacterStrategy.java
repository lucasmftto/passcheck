package br.com.passcheck.strategy;

import br.com.passcheck.service.PasswordServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CheckRepeatedCharacterStrategy implements ValidPasswordStrategy{

    Logger logger = LoggerFactory.getLogger(CheckRepeatedCharacterStrategy.class);

    @Override
    public boolean isValid(String password) {
        List<Character> duplicateItemList = password.chars()
                .mapToObj(e -> (char)e)
                .collect(Collectors.toList());

        Set notDuplicateItemSet = new HashSet(duplicateItemList);
        if(notDuplicateItemSet.size() < duplicateItemList.size()){
            logger.info("CheckRepeatedCharacter: " + false);
            return false;
        }
        logger.info("CheckRepeatedCharacter: " + true);
        return true;
    }
}
