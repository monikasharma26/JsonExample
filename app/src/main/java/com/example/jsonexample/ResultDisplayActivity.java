package com.example.jsonexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.jsonexample.Model.Student;

public class ResultDisplayActivity extends AppCompatActivity {
    private TextView rsid;
    private TextView rsname;
    private TextView rsgender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_display);
        rsid=findViewById(R.id.rsid);
        rsname=findViewById(R.id.rsname);
        rsgender=findViewById(R.id.rsgender);
        Intent i=getIntent();
        Student studobj = (Student) i.getExtras().getSerializable("stud");
        rsid.setText("StudentID:"+studobj.getSid());
        rsname.setText("StudentName:"+studobj.getSname());
        rsgender.setText("Gender:"+studobj.getGender());
    }
}
