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

public class Register extends AppCompatActivity {

    Button rBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final EditText fName = findViewById(R.id.firstName);
        final EditText lName = findViewById(R.id.lastName);
        final EditText eMail = findViewById(R.id.emailAddressET2);
        final EditText DateOfBirth = findViewById(R.id.DOB);
        final EditText passWord = findViewById(R.id.PasswordET2);
        rBtn = findViewById(R.id.registerBtn2);

        rBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String FstName, LstName, Email, Dob, Password;
                FstName = fName.getText().toString();
                LstName = lName.getText().toString();
                Email = eMail.getText().toString();
                Dob = DateOfBirth.getText().toString();
                Password = passWord.getText().toString();


                //verifying user information
                if (FstName.equals(""))
                {
                    Toast.makeText(Register.this,"No blanks", Toast.LENGTH_LONG).show();
                }
                else if (FstName.length() < 3)
                {
                    Toast.makeText(Register.this,"Name too short", Toast.LENGTH_LONG).show();
                }
                else if (LstName.equals(""))
                {
                    Toast.makeText(Register.this,"No blanks", Toast.LENGTH_LONG).show();
                }
                else if (LstName.length() < 3)
                {
                    Toast.makeText(Register.this,"Name too short", Toast.LENGTH_LONG).show();
                }
                else if (Email.equals(""))
                {
                    Toast.makeText(Register.this,"No blanks", Toast.LENGTH_LONG).show();
                }
                else if (!Patterns.EMAIL_ADDRESS.matcher(Email).matches())
                {
                    Toast.makeText(Register.this, "Invalid Email", Toast.LENGTH_LONG).show();
                }
                else if (Password.equals(""))
                {
                    Toast.makeText(Register.this,"No blanks", Toast.LENGTH_LONG).show();
                }
                else if (Password.length() < 5 || Password.length() > 30 )
                {
                    Toast.makeText(Register.this,"Password to short, 5 minimum", Toast.LENGTH_LONG).show();
                }
                else if (Dob.equals(""))
                {
                    Toast.makeText(Register.this,"No blanks", Toast.LENGTH_LONG).show();
                }
                else //
                {
                    SharedPreferences spreferences = getSharedPreferences("MyUserPrefs", MODE_PRIVATE);
                    SharedPreferences.Editor editor2 = spreferences.edit();
                    String userInfo2 = spreferences.getString(Email + Password + "Data", FstName + " " + LstName + "\n" + Email + "\n" + Dob);
                    editor2.putString("show", userInfo2);
                    editor2.commit();

                    Intent intent = new Intent(Register.this, MainActivity.class);
                    startActivity(intent);
                }

            }
        });
    }
}