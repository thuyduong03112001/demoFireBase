package com.example.firebase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        myRef = database.getReference("contacts");
        Log.d("abc","" + myRef.toString());
//        myRef.setValue("Hello, World!");
    }

    public void onClickBtn(View view) {
        Contact c = new Contact("Thuy Duong123", "Duongne@gmail.com", "0347973129");

        String id = myRef.push().getKey();
        c.setId(id);
        myRef.child(id).setValue(c);
    }
}