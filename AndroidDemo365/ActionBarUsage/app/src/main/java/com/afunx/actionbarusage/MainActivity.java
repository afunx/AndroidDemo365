package com.afunx.actionbarusage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actionbar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_always:
                Toast.makeText(this, R.string.item_always_is_clicked, Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item_if_room:
                Toast.makeText(this, R.string.item_if_room_is_clicked, Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item_never:
                Toast.makeText(this, R.string.item_never_is_clicked, Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
