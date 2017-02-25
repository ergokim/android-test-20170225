package com.example.ergokim.a072225;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private final static int REQUEST_CODE_INPUT = 123;

    TextView textNames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textNames = (TextView) findViewById(R.id.text_names);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.add) {
            startActivityForResult(new Intent(getApplicationContext(), InputActivity.class), REQUEST_CODE_INPUT);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode != RESULT_OK)
            return;

        if (requestCode == REQUEST_CODE_INPUT) {
            String name = data.getStringExtra(InputActivity.KEY_NAME);
            String email = data.getStringExtra(InputActivity.KEY_EMAIL);
            Log.i("###", "onActivityResult: |" + name + "|" + email + "|");

            textNames.append(name + "(" + email + ")\n");
        }
    }
}

