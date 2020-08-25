package com.curso.modulo3final;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.curso.modulo3final.databinding.LoginBinding;
import com.curso.modulo3final.model.User;
import com.curso.modulo3final.presenter.login.LoginPresenter;
import com.curso.modulo3final.presenter.login.LoginPresenterImplement;
import com.curso.modulo3final.presenter.login.LoginView;

public class LoginActivity extends AppCompatActivity implements LoginView {
    private LoginBinding lBinding;
    private LoginPresenter presenter;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lBinding = LoginBinding.inflate(getLayoutInflater());
        setContentView(lBinding.getRoot());
        presenter = new LoginPresenterImplement(this);
        lBinding.buttonLogin.setOnClickListener(v->{
            this.validateUser();
        });
    }

    private void validateUser(){
        user = new User(lBinding.etUser.getText().toString(),
                lBinding.etPass.getText().toString());
        if(this.presenter.validate(user)){
           Intent intent = new Intent(this,ContainerActivity.class);
           startActivity(intent);
        }
    }


    @Override
    public void showPassOrUserInvalid(int intentos) {
        lBinding.etUser.setError("user invalid");
        lBinding.etPass.setError("pass invalid");
        Toast.makeText(this,"Error de autenticacion"+"\n"+"cantidad intentos: "
                + intentos, Toast.LENGTH_SHORT)
                .show();
    }

    @Override
    public void disabledButtonLogin() {
        lBinding.buttonLogin.setEnabled(false);
    }
}