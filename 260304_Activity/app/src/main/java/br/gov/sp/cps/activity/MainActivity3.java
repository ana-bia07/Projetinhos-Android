package br.gov.sp.cps.activity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity3 extends AppCompatActivity {

    private Button btnFechaT3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnFechaT3 = findViewById(R.id.btnFechaT3);
        btnFechaT3.setOnClickListener(v -> {
            finish();
        });


        Log.i("Ciclo de vida", "T3-onCreate");
    }

    @Override
    public void onResume(){
        super.onResume();
        Log.i("Ciclo de vida","T3-onRestart");
    }

    @Override
    public void onStart(){
        super.onStart();
        Log.i("Ciclo de vida", "T3-onStart");
    }

    @Override
    public void onStop(){
        super.onStop();
        Log.i("Ciclo de vida", "T3-onStop");
    }

    @Override
    public void onRestart(){
        super.onRestart();
        Log.i("Ciclo de vida", "T3-onRestart");
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.i("Ciclo de vida", "T3-onDestroy");
    }

    @Override
    public void onPause(){
        super.onPause();
        Log.i("Ciclo de vida", "T3-onPause");
    }
}