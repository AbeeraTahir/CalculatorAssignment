package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView tvOne;
    TextView tvTw0;
    EditText etOne;
    EditText etTwo;
    Spinner sp;
    EditText etRes;
    Button btnCal;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etOne = findViewById(R.id.etValueOne);
        tvOne = findViewById(R.id.tvValueOne);
        etTwo = findViewById(R.id.etValueTwo);
        tvTw0 = findViewById(R.id.tvValueTwo);
        etRes = findViewById(R.id.etOutput);
        btnCal = findViewById(R.id.btnCalculate);
        sp = findViewById(R.id.spinner);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.operation, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(adapter);

        btnCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int result;
                int firstValue = Integer.parseInt(etOne.getText().toString());
                int secondValue = Integer.parseInt(etTwo.getText().toString());
                String selectedOp = (String)sp.getSelectedItem();
                if (selectedOp.trim().equals("Add")){
                    result = firstValue + secondValue;
                    etRes.setText(String.valueOf(result));
                }
                else if (selectedOp.trim().equals("Subtract")){
                    result = firstValue - secondValue;
                    etRes.setText(String.valueOf(result));
                }
                else if (selectedOp.trim().equals("Multiply")){
                    result = firstValue * secondValue;
                    etRes.setText(String.valueOf(result));
                }
                else if (selectedOp.trim().equals("Divide")){
                    if (secondValue == 0)
                    {
                        Toast.makeText(MainActivity.this, "Warning: Division by zero", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        result = firstValue / secondValue;
                        int rem = firstValue % secondValue;
                        etRes.setText(String.valueOf(result)+" R: "+String.valueOf(rem));

                    }
                }
            }
        });

    }

}