package com.example.tesltraprecticeapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String NAME = "name";
    public static final String PASSWORD = "password";
    private static final String TAG = MainActivity.class.getSimpleName() ; //"MainActivity"
    EditText nameEditText;
    EditText passwordEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i(TAG, "Main Activity Started");
        nameEditText = findViewById(R.id.editTextName);
        passwordEditText = findViewById(R.id.editTextPassword);
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "Main Activity onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "Main Activity onResume");
        restoreData();
    }

    private void restoreData() {
        //open the file
        SharedPreferences preferences = getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);

        //read the file
        String name = preferences.getString(NAME,"");
        String pwd = preferences.getString(PASSWORD,"");
        //restore the datq in edittexts
        nameEditText.setText(name);
        passwordEditText.setText(pwd);
    }
    @Override
    protected void onPause() { //saving data
        super.onPause();
        Log.i(TAG, "Main Activity onPause");
        saveData();
    }
    
    private void saveData(){
        //get data from editTexts
        String name = nameEditText.getText().toString();
        String password = passwordEditText.getText().toString();
        //create a file shared pref
        SharedPreferences preferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        //open that file
        SharedPreferences.Editor editor = preferences.edit();
        //write to file
        editor.putString(NAME, name);
        editor.putString(PASSWORD, password);
        //save the file
        editor.commit();
    }
    
    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "Main Activity onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG,"mainactivity onDestroy");

    }

    public void clickListener(View view) {
        Log.i(TAG, "Button Clicked");

        switch(view.getId()){
            case R.id.buttonLogin:startHomeActivity();
                                    break;
            case R.id.buttonCancel:
                                    dialPhone();
                                    break;
        }

    }

    private int add(int i, int i1) {
        return  i+i1;
    }

    private void dialPhone() {
        Log.v(TAG,"Dialing Phone No");
        Intent dIntent = new Intent();
        dIntent.setAction(Intent.ACTION_DIAL);
        dIntent.setData(Uri.parse("tel:8447593990"));
        startActivity(dIntent);
    }

    private void startHomeActivity() {
        Log.w(TAG,"Starting Home Activity");
        String name = nameEditText.getText().toString();
        Toast toast = Toast.makeText(this, "Welcome To Android " + name, Toast.LENGTH_SHORT);
        toast.show();
        Intent hIntent = new Intent(MainActivity.this, HomeActivity.class);
        hIntent.putExtra("studentName",name);
        startActivity(hIntent);
    }


}