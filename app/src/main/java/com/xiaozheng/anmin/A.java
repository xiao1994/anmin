package com.xiaozheng.anmin;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

/**
 * Created by Administrator on 2015/11/12.
 */
public class A extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {

    private ImageView cityImage;
    private EditText cityText;
    private SeekBar seekBar;
    private TextView tv1;
    private TextView tv2;
    private EditText dateText;
    private ImageView dateImage;
    private DatePickerDialog dialog;
    private int year,monthOfYear,dayOfMonth;
    private Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a);
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
        dateText = (EditText) findViewById(R.id.dateText);
        dateImage = (ImageView) findViewById(R.id.dateImage);
        cityImage = (ImageView) findViewById(R.id.cityImage);
        cityText = (EditText) findViewById(R.id.cityText);
        Calendar calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        monthOfYear = calendar.get(Calendar.MONTH);
        dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        seekBar.setOnSeekBarChangeListener(this);
        mContext = this;

        cityImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, City.class);
                startActivity(intent);
            }
        });

        dialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                String text = year + "-" + monthOfYear + "-" + dayOfMonth;
                dateText.setText(text);
            }
        },year,monthOfYear,dayOfMonth);
        dateImage.setOnClickListener(new View.OnClickListener(){
            @Override
        public void onClick(View v){
                dialog.show();
            }
        });

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        tv1.setText("正在拖动");
        tv2.setText("满意度："+progress+"%");

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        tv1.setText("开始拖动");

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        tv1.setText("停止拖动");

    }


}
