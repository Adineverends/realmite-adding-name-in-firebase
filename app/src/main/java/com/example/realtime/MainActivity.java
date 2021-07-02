package com.example.realtime;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    EditText edit;
    Button add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      // for one child
      //   FirebaseDatabase.getInstance().getReference().child("programing Knowledge").child("Android").setValue("abcd");

        //   for multiple childs
      /*  HashMap<String,Object> map= new HashMap<>();
        map.put("name","Rishabh");
        map.put("Email","aditya9778@gmail.com");
        FirebaseDatabase.getInstance().getReference().child("programing Knowledge").child("Multiple value").updateChildren(map);*/

        edit=findViewById(R.id.editTextTextPersonName);
        add=findViewById(R.id.button);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt_name=edit.getText().toString();
                if(txt_name.isEmpty()){
                    Toast.makeText(MainActivity.this,"no name enterd",Toast.LENGTH_SHORT).show();

                }
                else{

                    FirebaseDatabase.getInstance().getReference().child("programing Knowledge").push().child("name").setValue(txt_name);
                }
            }
        });
    }
}