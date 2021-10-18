package com.homework.individualproject2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button loginB;
    Button registerB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText emailAddress = findViewById(R.id.emailAddressET);
        final EditText passWord = findViewById(R.id.PasswordET);
        loginB = findViewById(R.id.loginBtn);
        registerB = findViewById(R.id.registerBtn);
//Once the user has signed up/registered the user can successfully enter the app
        loginB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = emailAddress.getText().toString();
                String password = passWord.getText().toString();

                // email and password verification
                if (email.equals(""))
                {
                    Toast.makeText(MainActivity.this,"No blanks", Toast.LENGTH_LONG).show();
                }
                else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches())
                {
                    Toast.makeText(MainActivity.this, "Invalid Email", Toast.LENGTH_LONG).show();
                }
                else if (password.equals(""))
                {
                    Toast.makeText(MainActivity.this,"No blanks", Toast.LENGTH_LONG).show();
                }
                else if (password.length() < 3 || password.length() >30)
                {
                    Toast.makeText(MainActivity.this,"Invalid Password", Toast.LENGTH_LONG).show();
                }
                else // saving user information to be printed on last screen
                {
                    SharedPreferences spreferences = getSharedPreferences("MyUserPrefs", MODE_PRIVATE);
                    String userInfo = spreferences.getString(email + password + "data","Email or Password is Incorrect" );
                    SharedPreferences.Editor editor = spreferences.edit();
                    editor.putString("show", userInfo);
                    editor.apply();

                    Intent intent = new Intent(MainActivity.this, GameScreen.class);
                   startActivity(intent);
                }


            }
        });
        //Giving user the option to register and sending the to the register activity
        registerB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(MainActivity.this, Register.class);
                startActivity(intent);
            }
        });
    }
}