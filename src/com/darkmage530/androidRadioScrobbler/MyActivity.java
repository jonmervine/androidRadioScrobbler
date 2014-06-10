package com.darkmage530.androidRadioScrobbler;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MyActivity extends Activity {
    public static final String EXTRA_MESSAGE = "com.darkmage530.androidRadioScrobbler.MESSAGE";
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.edit_message);
        String sentMessage = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, sentMessage);
        startActivity(intent);
    }
}