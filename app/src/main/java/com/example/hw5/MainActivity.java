package com.example.hw5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.time.Year;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText year,month,day,hr,min,sec;
    Button show;
    TextView showtime,fyear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        show = (Button) findViewById(R.id.button);
        show.setOnClickListener(this);
        year = (EditText) findViewById(R.id.editTextNumber5);
        month = (EditText) findViewById(R.id.editTextNumber6);
        day = (EditText) findViewById(R.id.editTextNumber7);
        hr = (EditText) findViewById(R.id.editTextNumber);
        min = (EditText) findViewById(R.id.editTextNumber3);
        sec = (EditText) findViewById(R.id.editTextNumber4);
        showtime = (TextView) findViewById(R.id.textView5);
        fyear = (TextView) findViewById(R.id.textView10);
    }

    @Override
    public void onClick(View view) {
        double Year = Double.parseDouble(year.getText().toString());
        int YEAR = (int) Double.parseDouble(year.getText().toString());
        double fy = Year / 4;
        int FY = (int) Math.floor(fy);
        int MONTH = (int) Double.parseDouble(month.getText().toString());
        int DAY = (int) Double.parseDouble(day.getText().toString());
        int HR = (int) Double.parseDouble(hr.getText().toString());
        int MIN = (int) Double.parseDouble(min.getText().toString());
        int SEC = (int) Double.parseDouble(sec.getText().toString());
        int mode = 0;
        int error = 0;
        if (MONTH == 1 || MONTH == 3 || MONTH == 5 || MONTH == 7 || MONTH == 8 || MONTH == 10 || MONTH == 12) {
            mode = 1;
        }
        else if (MONTH == 2) {
            mode = 2;
        }
        else if (MONTH == 4 || MONTH == 6 || MONTH == 9 || MONTH == 11) {
            mode = 3;
        }
        if (HR >= 24 || MIN >= 60 || SEC >= 60) {
            error = 1;
        } else {
            error = 0;
        }
        if (error == 0) {
            if (FY == fy) {
                fyear.setText("是閏年");
            } else {
                fyear.setText("不是閏年");
            }
        }
        switch (mode) {
            case 1: {
                if (DAY <= 31 && error == 0) {
                    showtime.setText(YEAR + "/" + MONTH + "/" + DAY + "  " + HR + "：" + MIN + "：" + SEC);
                } else {
                    showtime.setText("請輸入正確的格式");
                    fyear.setText("");
                    error = 1;
                }
                mode = 0;
                break;
            }
            case 2: {
                if (FY == fy) {
                    if (DAY <= 29 && error == 0) {
                        showtime.setText(YEAR + "/" + MONTH + "/" + DAY + "  " + HR + "：" + MIN + "：" + SEC);
                    } else {
                        showtime.setText("請輸入正確的格式");
                        fyear.setText("");
                        error = 1;
                    }
                } else {
                    if (DAY <= 28 && error == 0) {
                        showtime.setText(YEAR + "/" + MONTH + "/" + DAY + "  " + HR + "：" + MIN + "：" + SEC);
                    } else {
                        showtime.setText("請輸入正確的格式");
                        fyear.setText("");
                        error = 1;
                    }
                }
                mode = 0;
                break;
            }
            case 3: {
                if (DAY <= 30 && error == 0) {
                    showtime.setText(YEAR + "/" + MONTH + "/" + DAY + "  " + HR + "：" + MIN + "：" + SEC);
                } else {
                    showtime.setText("請輸入正確的格式");
                    fyear.setText("");
                    error = 1;
                }
                mode = 0;
                break;
            }
        }
    }
}