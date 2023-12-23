package com.example.sayarprojects;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ArrayAdapter;


import java.util.ArrayList;
public class activity_input_data extends AppCompatActivity {

    private EditText editTextStudentNumber;
    private EditText editTextFullName;
    private Button buttonSave;
    private ListView listView;

    private ArrayList<String> studentList;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_data);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        editTextStudentNumber = findViewById(R.id.editTextStudentNumber);
        editTextFullName = findViewById(R.id.editTextFullName);
        buttonSave = findViewById(R.id.buttonSave);
        listView = findViewById(R.id.listView);

        studentList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, studentList);
        listView.setAdapter(adapter);

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void saveData() {
        String studentNumber = editTextStudentNumber.getText().toString().trim();
        String fullName = editTextFullName.getText().toString().trim();

        if (!studentNumber.isEmpty() && !fullName.isEmpty()) {
            String studentInfo = "شماره دانشجویی: " + studentNumber + "\nنام و نام خانوادگی: " + fullName;
            studentList.add(studentInfo);
            adapter.notifyDataSetChanged();

            editTextStudentNumber.getText().clear();
            editTextFullName.getText().clear();
        }
    }
}