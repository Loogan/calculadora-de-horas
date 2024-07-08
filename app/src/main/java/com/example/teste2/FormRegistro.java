package com.example.teste2;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.snackbar.Snackbar;

public class FormRegistro extends AppCompatActivity {
    private EditText cadastro_nome,cadastro_rg,cadastro_senha,cadastro_confirmar_senha;
    private Button bt_cadastrar;
    String[] mensagens = {"Preencha todos os campos!", "As senhas não são iguais."};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_form_registro);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;


        });

        IniciarComponentes();

        bt_cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nome = cadastro_nome.getText().toString();
                String rg = cadastro_rg.getText().toString();
                String senha = cadastro_senha.getText().toString();
                String cadastrarSenha = cadastro_confirmar_senha.getText().toString();

                if (nome.isEmpty() || rg.isEmpty() || senha.isEmpty() || cadastrarSenha.isEmpty()) {
                    Snackbar snackbar = Snackbar.make(v,mensagens[0],Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.WHITE);
                    snackbar.setTextColor(Color.BLACK);
                    snackbar.show();
                }
                else if (!senha.equals(cadastrarSenha)) {
                    Snackbar snackbar = Snackbar.make(v,mensagens[1],Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.WHITE);
                    snackbar.setTextColor(Color.BLACK);
                    snackbar.show();

                } else{
                    Intent intent = new Intent(FormRegistro.this, FormLogin.class);
                    startActivity(intent);
                }

            }
        });

    }

    private void IniciarComponentes(){

        bt_cadastrar = findViewById(R.id.bt_cadastrar);
        cadastro_nome = findViewById(R.id.cadastro_nome);
        cadastro_rg = findViewById(R.id.cadastro_rg);
        cadastro_senha = findViewById(R.id.cadastro_senha);
        cadastro_confirmar_senha = findViewById(R.id.cadastro_confirmar_senha);

    }

}