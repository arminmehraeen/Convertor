package com.armin.mehraein.convertor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText meter ;
    EditText canti_meter ;
    EditText kilo_meter ;
    EditText ench ;
    Button btn ;
    Button btn1 ;
    TextView show ;
    int sum = 0 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(meter.getText().toString().trim().length() > 1){
                    sum ++ ;
                }
                if(canti_meter.getText().toString().trim().length() > 1){
                    sum ++ ;
                }
                if(kilo_meter.getText().toString().trim().length() > 1){
                    sum ++ ;
                }
                if(ench.getText().toString().trim().length() > 1){
                    sum ++ ;
                }

                if (sum > 1){
                    show.setVisibility(View.VISIBLE);
                    show.setText("لطفا یک فیلد را پر کنید");
                }else if (meter.getText().toString().trim().length() != 0){
                    computeByMeter();
                }else if (canti_meter.getText().toString().trim().length() != 0){
                    computeByCantiMeter();
                }else if (kilo_meter.getText().toString().trim().length() != 0){
                    computeByKiloMeter();
                }else if (ench.getText().toString().trim().length() != 0){
                    computeByEnch();
                }else {
                    show.setVisibility(View.VISIBLE);
                }
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ench.setText("");
                meter.setText("");
                kilo_meter.setText("");
                canti_meter.setText("");
                show.setVisibility(View.INVISIBLE);
            }
        });
    }

    private void computeByEnch() {
        float i = Float.parseFloat(ench.getText().toString().trim());
        float cm = i * 2.54f ;
        float m = cm / 100f ;
        float km = m / 1000f ;
        setData(m,cm,km,i);
    }

    private void computeByKiloMeter() {
        float km = Float.parseFloat(kilo_meter.getText().toString().trim());
        float m = km * 1000f ;
        float cm = m * 100f ;
        float i = cm / 2.54f ;
        setData(m,cm,km,i);
    }

    private void computeByCantiMeter() {
        float cm = Float.parseFloat(canti_meter.getText().toString().trim());
        float m = cm / 100f ;
        float km = m / 1000f ;
        float i = cm / 2.54f ;
        setData(m,cm,km,i);
    }

    private void computeByMeter() {
        float m = Float.parseFloat(meter.getText().toString().trim());
        float cm = m * 100f ;
        float km = m / 1000f ;
        float i = cm / 2.54f ;
        setData(m,cm,km,i);
    }

    private void setData(float m,float cm,float km,float i){
        show.setVisibility(View.INVISIBLE);
        ench.setText(""+i+" اینچ ");
        meter.setText(""+m+" متر ");
        kilo_meter.setText(""+km+" کیلومتر ");
        canti_meter.setText(""+cm+" سانتی متر ");
    }

    private void initView() {
        meter = findViewById(R.id.meter);
        canti_meter = findViewById(R.id.canti_meter);
        kilo_meter = findViewById(R.id.kilo_meter);
        ench = findViewById(R.id.ench);
        btn = findViewById(R.id.btn);
        btn1 = findViewById(R.id.btn1);
        show = findViewById(R.id.show);
    }
}
