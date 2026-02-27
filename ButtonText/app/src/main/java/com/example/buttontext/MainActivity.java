package com.example.buttontext;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;
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

    //metodo para setar varios text como mesmo conteudp
    public void setMutiTexts(String novoTexto, TextView... textViews) {
        for (TextView tv : textViews) {
            tv.setText(novoTexto);
        }
    }
    public int sortedOneNumber(){
        int n = new Random().nextInt(60);
        return n;
    }

    public void megaSorteio(View view){
        List<Integer> sorteioMega = new ArrayList<>();
        for(int i=1; i <= 6; i++) {
            int n = sortedOneNumber();
            if (!sorteioMega.contains(n)) { //.contains verifica se não tem na lista
                sorteioMega.add(n);
            } else {
                i--;
            }
        }

        TextView n1 = findViewById(R.id.n1);
        TextView n2 = findViewById(R.id.n2);
        TextView n3 = findViewById(R.id.n3);
        TextView n4 = findViewById(R.id.n4);
        TextView n5 = findViewById(R.id.n5);
        TextView n6 = findViewById(R.id.n6);

        n1.setText(String.valueOf(sorteioMega.get(0)));
        n2.setText(String.valueOf(sorteioMega.get(1)));
        n3.setText(String.valueOf(sorteioMega.get(2)));
        n4.setText(String.valueOf(sorteioMega.get(3)));
        n5.setText(String.valueOf(sorteioMega.get(4)));
        n6.setText(String.valueOf(sorteioMega.get(5)));
    }

    public void cleanResults(){
        TextView n1 = findViewById(R.id.n1);
        TextView n2 = findViewById(R.id.n2);
        TextView n3 = findViewById(R.id.n3);
        TextView n4 = findViewById(R.id.n4);
        TextView n5 = findViewById(R.id.n5);
        TextView n6 = findViewById(R.id.n6);

        setMutiTexts("--", n1, n2, n3, n4, n5, n6);
    }

}