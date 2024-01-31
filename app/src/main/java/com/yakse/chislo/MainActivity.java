package com.yakse.chislo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.location.altitude.AltitudeConverter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tvInfo;
    EditText etInput;
    Button bControl;
    public int guess = (int)(Math.random() * 100);
    public boolean gameFinished = false;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvInfo = (TextView)findViewById(R.id.tvText);
        etInput = (EditText)findViewById(R.id.etnNumber);
        bControl = (Button)findViewById(R.id.button);



    }

    public void onClick(View v){

        if (!gameFinished){
            int inp=Integer.parseInt(etInput.getText().toString());
            if (inp > guess){
                tvInfo.setText("Перелет!");
                etInput.setText("");}
            if (inp < guess){
                tvInfo.setText("Недолет!");
                etInput.setText("");}
            if (inp == guess){
                tvInfo.setText("В точку!");
                etInput.setText(String.format("%d", guess));
                bControl.setText("Сыграть еще");
                gameFinished=true;}
        }
        else {
            guess = (int)(Math.random()*100);
            bControl.setText("Ввести значение:");
            etInput.setText("");
            tvInfo.setText("Попробуйте угадать число(1-100)");
            gameFinished = false;
        }


    }
}