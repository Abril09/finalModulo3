package com.curso.modulo3final.presenter.login;

public interface LoginView {
    void showPassOrUserInvalid(int intentos);
    void disabledButtonLogin();
}
