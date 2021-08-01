package br.com.passcheck.unit;

import br.com.passcheck.dto.PasswordDto;
import br.com.passcheck.service.PasswordServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PasscheckUnitTests {

    private PasswordServiceImpl service = new PasswordServiceImpl();

    @Test
    public void checkPasswordEmpty(){
        PasswordDto dto = new PasswordDto("");
        Assertions.assertFalse(service.checkPassword(dto.getPassword()));
    }

    @Test
    public void checkPasswordLowerCase() throws Exception {
        PasswordDto dto = new PasswordDto("aa");
        Assertions.assertFalse(service.checkPassword(dto.getPassword()));
    }

    @Test
    public void checkPasswordUpperCase() throws Exception {
        PasswordDto dto = new PasswordDto("Aa");
        Assertions.assertFalse(service.checkPassword(dto.getPassword()));
    }

    @Test
    public void checkPasswordNotDigitAndSpecialCharacters() throws Exception {
        PasswordDto dto = new PasswordDto("AAAbbbCc");
        Assertions.assertFalse(service.checkPassword(dto.getPassword()));
    }

    @Test
    public void checkPasswordNotDigit() throws Exception {
        PasswordDto dto = new PasswordDto("AbTp9!foo");
        Assertions.assertFalse(service.checkPassword(dto.getPassword()));
    }

    @Test
    public void checkPasswordRepeatCharacters() throws Exception {
        PasswordDto dto = new PasswordDto("AbTp9!foA");
        Assertions.assertFalse(service.checkPassword(dto.getPassword()));
    }

    @Test
    public void checkPasswordSpace() throws Exception {
        PasswordDto dto = new PasswordDto("AbTp9 fok");
        Assertions.assertFalse(service.checkPassword(dto.getPassword()));
    }

    @Test
    public void checkPasswordSuccess() throws Exception {
        PasswordDto dto = new PasswordDto("AbTp9!fok");
        Assertions.assertTrue(service.checkPassword(dto.getPassword()));
    }
}
