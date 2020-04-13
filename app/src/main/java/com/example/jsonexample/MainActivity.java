package com.example.jsonexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.jsonexample.Model.Student;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Student> studentArrayList;
    private ArrayList<String> iname;
    private ListView lstStudentData;
    Student s=new Student();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        processJSON();
        Log.d("hshsh",String.valueOf(studentArrayList.size()));
        lstStudentData = findViewById(R.id.lst1);
        iname = new ArrayList<>();
        for (Student str : studentArrayList) {
            iname.add(str.getSname());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, iname );
        lstStudentData.setAdapter(adapter);

        lstStudentData.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Student stud = studentArrayList.get(position);
                Intent mIntent=new Intent(MainActivity.this,ResultDisplayActivity.class);
                mIntent.putExtra("stud",stud);
                startActivity(mIntent);
            }
        });
    }
    public String loadJSONFromAsset() {
        String json;
        try {
            InputStream is = getAssets().open("studentdetails.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, StandardCharsets.UTF_8);
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
    private void processJSON()
    {
        String js=loadJSONFromAsset();
        if(js !=null)
        {
            try {
                JSONArray mJSONArray=new JSONArray(js);
                studentArrayList = new ArrayList<>();
                for(int i=0;i<mJSONArray.length();i++) {
                    JSONObject mJSONObj=mJSONArray.getJSONObject(i);
                    if(mJSONObj.has("sid")) {
                        String id = mJSONObj.getString("sid");
                        String sname = mJSONObj.getString("sname");
                        String gender = mJSONObj.getString("gender");
                        String userName = mJSONObj.getString("username");
                        String email = mJSONObj.getString("email");
                        String street = mJSONObj.getString("street");
                        String suite = mJSONObj.getString("suite");
                        String city = mJSONObj.getString("city");
                        String zipcode = mJSONObj.getString("zipcode");
                        String country = mJSONObj.getString("country");
                        studentArrayList.add(new  Student(id,sname,gender,userName,email,street,suite, city,zipcode,country));
                    }
                }
                s.setStudentArrayList(studentArrayList);
            } catch (JSONException e) {
                e.printStackTrace();
            }


        }
    }
}
