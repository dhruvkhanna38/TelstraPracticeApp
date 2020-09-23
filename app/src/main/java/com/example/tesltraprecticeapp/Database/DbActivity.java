package com.example.tesltraprecticeapp.Database;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tesltraprecticeapp.R;

public class DbActivity extends AppCompatActivity {
    EditText titleET, subTitleET, textViewdb;
    Dao dao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db);
        titleET = findViewById(R.id.titleEditText);
        subTitleET = findViewById(R.id.editSubTitle);
        dao = new Dao(this);
        dao.openDb();
    }

    public void handleDbClicks(View view) {
        switch(view.getId()){
            case R.id.buttonPut :
                putDb();
                break;
            case R.id.buttonGet:
                getDb();
                break;
        }
    }

    private void putDb() {
        String title = titleET.getText().toString();
        String subTitle = subTitleET.getText().toString();
        dao.createRow(title, subTitle);
    }

    private void getDb() {
        String result = dao.readRow();
        TextView resultTextView = findViewById(R.id.DbOutput);
        resultTextView.setText(result);
    }



}