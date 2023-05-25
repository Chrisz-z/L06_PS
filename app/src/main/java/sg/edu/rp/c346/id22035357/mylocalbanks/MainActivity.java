package sg.edu.rp.c346.id22035357.mylocalbanks;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    TextView tvDBS;
    TextView tvOCBC;
    TextView tvUOB;

    String wordClicked = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvDBS = findViewById(R.id.tvDBS);
        tvOCBC = findViewById(R.id.tvOCBC);
        tvUOB = findViewById(R.id.tvUOB);
        registerForContextMenu(tvDBS);
        registerForContextMenu(tvOCBC);
        registerForContextMenu(tvUOB);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.language_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            String language = "en";
            setlocale(language);
            return true;
        } else if (id == R.id.MandarinSelection) {
            String language = "zh";
            setlocale(language);
            return true;
        } else {

        }
        return super.onOptionsItemSelected(item);
    }

    private void setlocale(String language) {
        Resources resources = getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        Configuration configuration = resources.getConfiguration();
        configuration.locale = new Locale(language);
        resources.updateConfiguration(configuration,metrics);
        onConfigurationChanged(configuration);
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        tvDBS.setText(getText((R.string.dbs)));
        tvOCBC.setText(getText((R.string.ocbc)));
        tvUOB.setText(getText((R.string.uob)));
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(0,0,0,getString(R.string.optWeb));
        menu.add(0,1,1,getString(R.string.optContact));

        if(v == tvDBS){
            wordClicked = getString(R.string.dbs);
        }
        else if(v == tvOCBC){
            wordClicked = getString(R.string.ocbc);
        }
        else{
            wordClicked = getString(R.string.uob);
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (wordClicked.equalsIgnoreCase("dbs")) {
            if (item.getItemId() == 0) { //check whether the selected menu item ID is 0
                //code for action
                Intent intentWeb = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.dbsWeb)));
                startActivity(intentWeb);
                return true; //menu item successfully handled

            } else if (item.getItemId() == 1) { //check if the selected menu item ID is 1
                //code for action
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: " + getString(R.string.dbsNo)));
                startActivity(intentCall);
                return true;
            }
        }
        else if(wordClicked.equalsIgnoreCase("ocbc")){
            if (item.getItemId() == 0) { //check whether the selected menu item ID is 0
                //code for action
                Intent intentWeb = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.ocbcWeb)));
                startActivity(intentWeb);
                return true; //menu item successfully handled

            } else if (item.getItemId() == 1) { //check if the selected menu item ID is 1
                //code for action
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: " + getString(R.string.ocbcNo)));
                startActivity(intentCall);
                return true;
            }
        }
        else{
            if (item.getItemId() == 0) { //check whether the selected menu item ID is 0
                //code for action
                Intent intentWeb = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.uobWeb)));
                startActivity(intentWeb);
                return true; //menu item successfully handled

            } else if (item.getItemId() == 1) { //check if the selected menu item ID is 1
                //code for action
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: " + getString(R.string.uobNo)));
                startActivity(intentCall);
                return true;
            }
        }
        return super.onContextItemSelected(item); //pass menu item to the superclass implementation
    }


}