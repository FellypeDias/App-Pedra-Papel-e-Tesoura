package com.example.pedrapapeletesoura;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void escolherPedra(View view){
        selecaoUsurario("pedra");
    }
    public void escolherPapel(View view){
        selecaoUsurario("papel");
    }
    public void escolherTesoura(View view) {
        selecaoUsurario("tesoura");
    }
    String gerarEscolhaApp(){
        String[] opcoes = {"pedra", "papel", "tesoura"};
        int numero = new Random().nextInt(opcoes.length);
        String escolhaApp = opcoes[numero];
        ImageView imgEscolhaApp = findViewById(R.id.imgEscolhaApp);
        switch ( escolhaApp ) {
            case "pedra":
                imgEscolhaApp.setImageResource(R.drawable.pedra);
                break;
            case "papel":
                imgEscolhaApp.setImageResource(R.drawable.papel);
                break;
            case "tesoura":
                imgEscolhaApp.setImageResource(R.drawable.tesoura);
                break;
        }
        return escolhaApp;
    }
    void selecaoUsurario(String escolhaUsuario){
        String escolhaApp = gerarEscolhaApp();
        verificarGanhador(escolhaUsuario, escolhaApp);
    }
    private void verificarGanhador(String escolhaUsuario, String escolhaApp){
        TextView textResultado = findViewById(R.id.textResultado);
        if((escolhaUsuario == "pedra" && escolhaApp == "tesoura") || (escolhaUsuario == "tesoura" && escolhaApp == "papel") || (escolhaUsuario == "papel" && escolhaApp == "pedra")){
            textResultado.setText("Você ganhou!");
        }else if((escolhaApp == "pedra" && escolhaUsuario == "tesoura") || (escolhaApp == "tesoura" && escolhaUsuario == "papel") || (escolhaApp == "papel" && escolhaUsuario == "pedra")){
            textResultado.setText("Você perdeu!");
        }else{
            textResultado.setText("Empate!");
        }
    }
}