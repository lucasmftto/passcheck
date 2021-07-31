package br.com.passcheck.service;

import org.springframework.stereotype.Service;

@Service
public class PasswordServiceImpl implements PasswordService{

    @Override
    public boolean checkPassword(String password) {
        return false;
    }
}
