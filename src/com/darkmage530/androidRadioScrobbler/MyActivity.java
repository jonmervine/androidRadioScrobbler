package com.darkmage530.androidRadioScrobbler;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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

    @Override
    public void onStop() {
        super.onStop();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_activity_actions, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.action_search:
                openSearch();
                return true;
            case R.id.action_settings:
                actionSettings();
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }

    private void actionSettings() {
        SettingsDialog settings = new SettingsDialog();
        settings.show(getFragmentManager(), "settings");
    }

    private void openSearch() {
        SearchDialog search = new SearchDialog();
        search.show(getFragmentManager(), "search");
    }

    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.edit_message);
        String sentMessage = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, sentMessage);
        startActivity(intent);
    }

    public void startStreaming(View view) {
        Intent intent = new Intent(this, MusicPlayer.class);
        startActivity(intent);
    }
}
