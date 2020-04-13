package com.example.jsonexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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
            // Log.d("json",js);
            try {
                JSONArray mJSONArray=new JSONArray(js);
                studentArrayList = new ArrayList<>();
                for(int i=0;i<mJSONArray.length();i++) {

                    JSONObject mJSONObj=mJSONArray.getJSONObject(i);
                    //  Log.d("mjson", mJSONObj.toString());
                    if(mJSONObj.has("sid")) {
                        String id = mJSONObj.getString("sid");
                        String sname = mJSONObj.getString("sname");
                        String gender = mJSONObj.getString("gender");
                        //   Log.d("mjson_ID", String.valueOf(id));
                        //   Log.d("mjson_name", String.valueOf(sname));
                        //   Log.d("mjson_gender", String.valueOf(gender));
                        studentArrayList.add(new  Student(String.valueOf(id),String.valueOf(sname), String.valueOf(gender)));

                        //  for (Student str : studentArrayList) {
                        //      System.out.println(str.getSid());
                        //  System.out.println(str.getSname());

                        // }
                        System.out.println("Using Iterator class");
                        System.out.println("-----------------------");
                        Iterator<Student> it = studentArrayList.iterator();
                        while(it.hasNext()){
                            System.out.println(it.next().getSname());
                        }
                    }


                }
                s.setStudentArrayList(studentArrayList);
            } catch (JSONException e) {
                e.printStackTrace();
            }


        }
    }
}
