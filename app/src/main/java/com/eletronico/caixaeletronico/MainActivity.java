package com.eletronico.caixaeletronico;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edit_dinheiro;
    private Button bt_sacar;
    private TextView saldo;

    double saldoEmConta = 3000.00;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniciarComponentes();//Iniciando o método, tratado

        getSupportActionBar().hide();

        saldo.setText("Saldo em conta:" + "R$ " + saldoEmConta);

        //Evento de click no botão
        bt_sacar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Double dinheiro;
                dinheiro = Double.parseDouble(edit_dinheiro.getText().toString());

                if (dinheiro < 20) {
                    Toast.makeText(MainActivity.this, "Saque a partir de 20 reais", Toast.LENGTH_SHORT).show();

                } else if (dinheiro > saldoEmConta) {
                    Toast.makeText(MainActivity.this, "Saldo Insuficiente.",Toast.LENGTH_SHORT).show();

                }else {
                    saldoEmConta -= dinheiro;
                    saldo.setText("Saldo em conta:" + "R$ " + saldoEmConta);
                    Toast.makeText(MainActivity.this, + dinheiro + "0" + " Reais Sacados", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }

    private void iniciarComponentes() {
        edit_dinheiro = findViewById(R.id.edit_dinheiro);
        bt_sacar = findViewById(R.id.bt_sacar);
        saldo = findViewById(R.id.saldo);
    }
}