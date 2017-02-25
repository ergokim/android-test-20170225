package com.example.ergokim.a072225;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class InputActivity extends AppCompatActivity {
    EditText editName;
    EditText editEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
        Button buttonOk = (Button) findViewById(R.id.button_ok);
        editName = (EditText) findViewById(R.id.edit_name);
        editEmail = (EditText) findViewById(R.id.edit_email);

        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputName();

            }
        });
    }

    private void inputName() {
        String name = editName.getText().toString();
        String email = editEmail.getText().toString();
        Log.i("###", "111 onClick: name = |" + name + "|email = " + email + "|");

        if (!isValid(name, email))
            return;

        Intent result = new Intent();
        result.putExtra("name", name);
        result.putExtra("email", email);
        setResult(RESULT_OK, result);
        finish();
    }

    private boolean isValid(String name, String email) {
        // check
        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(email))
            return false;

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches())
            return false;

        return true;
    }
}

