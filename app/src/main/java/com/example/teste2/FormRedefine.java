package com.example.teste2;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.snackbar.Snackbar;

public class FormRedefine extends AppCompatActivity {

    private EditText redefine_nome, redefine_rg, redefine_senha, redefine_confirmar_senha;
    private Button bt_redefine;
    private ProgressBar progressBar;

    String[] mensagens = {"Preencha todos os campos!", "As senhas não são iguais."};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_form_redefine);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        IniciarComponentes();

        bt_redefine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nome = redefine_nome.getText().toString();
                String rg = redefine_rg.getText().toString();
                String senha = redefine_senha.getText().toString();
                String redefinirSenha = redefine_confirmar_senha.getText().toString();

                if (nome.isEmpty() || rg.isEmpty() || senha.isEmpty() || redefinirSenha.isEmpty()) {
                    Snackbar snackbar = Snackbar.make(v,mensagens[0],Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.WHITE);
                    snackbar.setTextColor(Color.BLACK);
                    snackbar.show();
                }
                else if (!senha.equals(redefinirSenha)) {
                    Snackbar snackbar = Snackbar.make(v,mensagens[1],Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.WHITE);
                    snackbar.setTextColor(Color.BLACK);
                    snackbar.show();

                } else{

                    progressBar.setVisibility(View.VISIBLE);

                    long delayMillis;

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Intent intent = new Intent(FormRedefine.this, FormLogin.class);
                            startActivity(intent);
                        }
                    }, 3000);

                }

            }
        });

    }

    private void IniciarComponentes() {

        bt_redefine = findViewById(R.id.bt_redefine);
        redefine_nome = findViewById(R.id.redefine_nome);
        redefine_rg = findViewById(R.id.redefine_rg);
        redefine_senha = findViewById(R.id.redefine_senha);
        redefine_confirmar_senha = findViewById(R.id.redefine_confirmar_senha);
        progressBar = findViewById(R.id.redefine_progressbar);
    }

}