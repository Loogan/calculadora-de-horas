package com.example.teste2;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.Firebase;


public class FormLogin extends AppCompatActivity {

    private TextView text_tela_registrar;
    private EditText edit_nome,edit_rg,edit_senha;
    private Button bt_login;
    private ProgressBar progressBar;
    private TextView esqueci_senha;

    String[] mensagens = {"Preencha todos os campos!"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_form_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;


        });


        IniciarComponentes();

        text_tela_registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(FormLogin.this, FormRegistro.class);
                startActivity(intent);

            }
        });

        esqueci_senha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(FormLogin.this, FormRedefine.class);
                startActivity(intent);
            
            }
        });

        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nome = edit_nome.getText().toString();
                String rg = edit_rg.getText().toString();
                String senha = edit_senha.getText().toString();

                if (nome.isEmpty() || rg.isEmpty() || senha.isEmpty()) {
                    Snackbar snackbar = Snackbar.make(v,mensagens[0],Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.WHITE);
                    snackbar.setTextColor(Color.BLACK);
                    snackbar.show();
                } else {
                    progressBar.setVisibility(View.VISIBLE);

                    long delayMillis;
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            TelaPrincipal();
                        }
                    }, 3000);

                }

            }
        });
    }

    private void TelaRedefine(){
        Intent intent = new Intent(FormLogin.this, calculadora.class);
        startActivity(intent);
    }

    private void TelaPrincipal(){
        Intent intent = new Intent(FormLogin.this, calculadora.class);
        startActivity(intent);
        finish();
    }

    private void IniciarComponentes(){

        text_tela_registrar = findViewById(R.id.text_tela_cadastro);
        edit_nome = findViewById(R.id.edit_nome);
        edit_rg = findViewById(R.id.edit_rg);
        edit_senha = findViewById(R.id.edit_senha);
        progressBar = findViewById(R.id.progressbar);
        bt_login = findViewById(R.id.bt_login);
        esqueci_senha = findViewById(R.id.esqueci_senha);


    }
}