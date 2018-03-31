package com.example.tcsexam.trainingday2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {  //For heigher version
//public class MainActivity extends Activity {    //For Lover and higher version
//public class MainActivity extends ActionBarActivity {  //For both to run but depricated class

    Toolbar toolbar;
    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

        linearLayout = findViewById(R.id.main_layout);
        registerForContextMenu(linearLayout);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = new MenuInflater(this);
        menuInflater.inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.share:
                showToast("Share");
                break;
            case R.id.setting:
                showToast("Setting");
                break;
            case R.id.call:
                showToast("Call");
                break;
            case R.id.search:
                showToast("Search");
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu_long_click,menu);
    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.share:
                showToast("Share");
                break;
        }
        return super.onContextItemSelected(item);
    }

    private void showToast(String textToDisplay){
        Toast.makeText(this, textToDisplay, Toast.LENGTH_SHORT).show();
    }
}
