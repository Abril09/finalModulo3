package com.curso.modulo3final.presenter.login;

import com.curso.modulo3final.model.User;

public class LoginPresenterImplement implements LoginPresenter {
    private final static int MAX_INTENTOS = 3;
    private final User user2;
    private LoginView context;
    private int contador = 1;

    public LoginPresenterImplement(LoginView view) {
        user2 = new User("","123Pass");
        context = view;
    }

    @Override
    public boolean validate(User user1) {
        if (!user1.getPass().equals(this.user2.getPass())) {
            this.context.showPassOrUserInvalid((MAX_INTENTOS - this.contador));
            this.disabledButtonLogin();
            return false;
        }
        contador = 1;
        return true;
    }

    private void disabledButtonLogin() {
        if (this.contador == 3) {
            this.context.disabledButtonLogin();
        }
        this.contador++;
    }


}
