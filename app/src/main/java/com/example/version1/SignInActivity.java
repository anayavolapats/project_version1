package com.example.version1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignInActivity extends AppCompatActivity {

    private EditText e_mail;
    private EditText password;
    private EditText name;
    private Button sign_in;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        e_mail = findViewById(R.id.e_mail);
        name = findViewById(R.id.name);
        password = findViewById(R.id.password);
        sign_in = findViewById(R.id.sign_in_button);
        sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                check_email();
                check_password();
                if(check_email().equals("E-mail is correct") && check_name().equals("Name is correct") && check_password().equals("Password is correct")) {
                    Intent i = new Intent(SignInActivity.this, MainMenuActivity.class);
                    startActivity(i);
                    User man = new User(e_mail.getText().toString(), name.getText().toString(), password.getText().toString());
                }
            }
        });
    }
    public  String check_name(){
        String name_result = "Name is correct";
        if(name.getText().toString().isEmpty()){
            name.setError("Здесь ничего нет :(");
            name_result = "Password is empty";
        }
        return name_result;
    }
    public String check_email() {
        String e_mail_result = "E-mail is correct";
        if (e_mail.getText().toString().isEmpty()) {
            e_mail.setError("Здесь ничего нет :(");
            e_mail_result = "E-mail is empty";
        } else {
            if (e_mail.getText().toString().contains("@") && e_mail.getText().toString().contains(".")) {
            }else{
                e_mail.setError("Это не e-mail :(");
                e_mail_result = "E-mail is wrong";
            }
        }
        return e_mail_result;
    }
    public String check_password(){
        String password_result ="Password is correct";
        if(password.getText().toString().isEmpty()){
            password.setError("Здесь ничего нет :(");
            password_result = "Password is empty";
        }
        if(password.getText().toString().length() < 6){
            password.setError("Пароль должен быть длиннее 6 символов :(");
            password_result = "Password is short";
        }
        return password_result;
    }
}
