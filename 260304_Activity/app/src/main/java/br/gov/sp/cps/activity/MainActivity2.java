package br.gov.sp.cps.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    private Button btnChamaT3;
    private Button btnFechaT2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.i("Ciclo de vida", "T2-onCreate");

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        /*recebe dados
        Bundle bundle = getIntent().getExtras();
        String nome = bundle.getString("nome");

        //para mandar texto por paginas
            intent.putExtra();


        //Mostra resultado
        String result =
            "nome" + nome

            textResultadoT2.setText(result)
         */

        btnChamaT3 = findViewById(R.id.btnChamaT3);
        btnChamaT3.setOnClickListener(view -> {
            Intent intent = new Intent(this, MainActivity3.class);
            startActivity(intent);
        });

        btnFechaT2 = findViewById(R.id.btnFechaT2);
        btnFechaT2.setOnClickListener(v -> {
            finish();
        });
    }

    @Override
    public void onResume(){
        super.onResume();
        Log.i("Ciclo de vida","T2-onRestart");
    }

    @Override
    public void onStart(){
        super.onStart();
        Log.i("Ciclo de vida", "T2-onStart");
    }

    @Override
    public void onStop(){
        super.onStop();
        Log.i("Ciclo de vida", "T2-onStop");
    }

    @Override
    public void onRestart(){
        super.onRestart();
        Log.i("Ciclo de vida", "T2-onRestart");
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.i("Ciclo de vida", "T2-onDestroy");
    }

    @Override
    public void onPause(){
        super.onPause();
        Log.i("Ciclo de vida", "T2-onPause");
    }
}