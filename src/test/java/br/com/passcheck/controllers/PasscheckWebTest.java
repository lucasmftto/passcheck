package br.com.passcheck.controllers;

import br.com.passcheck.dto.PasswordDto;
import br.com.passcheck.service.PasswordService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PasscheckController.class)
public class PasscheckWebTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PasswordService service;

    @Test
    public void checkPasswordEmpty() throws Exception {
        PasswordDto dto = new PasswordDto("");
        when(service.checkPassword(dto.getPassword())).thenReturn(false);

        this.mockMvc.perform( MockMvcRequestBuilders
                .post("/checkPassword")
                .content(asJsonString(dto))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(content().string("false"))
        ;
    }

    @Test
    public void checkPasswordLowerCase() throws Exception {
        PasswordDto dto = new PasswordDto("aa");
        when(service.checkPassword(dto.getPassword())).thenReturn(false);

        this.mockMvc.perform( MockMvcRequestBuilders
                        .post("/checkPassword")
                        .content(asJsonString(dto))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                        .andExpect(status().isCreated())
                        .andExpect(content().string("false"))
        ;
    }

    @Test
    public void checkPasswordUpperCase() throws Exception {
        PasswordDto dto = new PasswordDto("Aa");
        when(service.checkPassword(dto.getPassword())).thenReturn(false);

        this.mockMvc.perform( MockMvcRequestBuilders
                        .post("/checkPassword")
                        .content(asJsonString(dto))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                        .andExpect(status().isCreated())
                        .andExpect(content().string("false"))
        ;
    }

    @Test
    public void checkPasswordNotDigitAndSpecialCharacters() throws Exception {
        PasswordDto dto = new PasswordDto("AAAbbbCc");
        when(service.checkPassword(dto.getPassword())).thenReturn(false);

        this.mockMvc.perform( MockMvcRequestBuilders
                        .post("/checkPassword")
                        .content(asJsonString(dto))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(content().string("false"))
        ;
    }

    @Test
    public void checkPasswordNotDigit() throws Exception {
        PasswordDto dto = new PasswordDto("AbTp9!foo");
        when(service.checkPassword(dto.getPassword())).thenReturn(false);

        this.mockMvc.perform( MockMvcRequestBuilders
                        .post("/checkPassword")
                        .content(asJsonString(dto))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(content().string("false"))
        ;
    }

    @Test
    public void checkPasswordRepeatCharacters() throws Exception {
        PasswordDto dto = new PasswordDto("AbTp9!foA");
        when(service.checkPassword(dto.getPassword())).thenReturn(false);

        this.mockMvc.perform( MockMvcRequestBuilders
                        .post("/checkPassword")
                        .content(asJsonString(dto))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(content().string("false"))
        ;
    }

    @Test
    public void checkPasswordSpace() throws Exception {
        PasswordDto dto = new PasswordDto("AbTp9 fok");
        when(service.checkPassword(dto.getPassword())).thenReturn(false);

        this.mockMvc.perform( MockMvcRequestBuilders
                        .post("/checkPassword")
                        .content(asJsonString(dto))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(content().string("false"))
        ;
    }

    @Test
    public void checkPasswordSuccess() throws Exception {
        PasswordDto dto = new PasswordDto("AbTp9!fok");

        when(service.checkPassword(dto.getPassword())).thenReturn(true);
        this.mockMvc.perform( MockMvcRequestBuilders
                        .post("/checkPassword")
                        .content("{\t\"password\": \"AbTp9!fok\" }")
                        .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().isCreated())
                        .andExpect(content().string("true"))
        ;
    }

    public static String asJsonString(final Object obj) {
        try {
            String result = new ObjectMapper().writeValueAsString(obj);
            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
