package com.example.appbarpractice;

import androidx.appcompat.widget.PopupMenu;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener{

    ImageView backButton, menu_button;
    TextView AppName;
    static int i=0;
    private Toolbar custom_toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        custom_toolbar = (Toolbar) findViewById(R.id.customToolBar);
        setSupportActionBar(custom_toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        AppName = findViewById(R.id.appName);
        backButton = findViewById(R.id.back_icon);
        menu_button = findViewById(R.id.menu_icon);
        menu_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(MainActivity.this, v);
                popup.setOnMenuItemClickListener(MainActivity.this);
                popup.inflate(R.menu.menu);
                popup.show();
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i++;
                if (i==2){
                    MainActivity.this.finish();
                }
                else
                    Toast.makeText(MainActivity.this,"press again to exit", Toast.LENGTH_LONG).show();
            }
        });
        AppName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,AppName.getText(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.exit:
                MainActivity.this.finish();
                return true;
            case R.id.share:
                try {
                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    shareIntent.setType("text/plain");
                    shareIntent.putExtra(Intent.EXTRA_SUBJECT, "AppBar Practice");
                    String shareMessage= "\nLet me recommend you this application\n\n";
                    shareMessage = shareMessage + ": https://github.com/AfaqShuaib09/App-Bar-Practice";
                    shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
                    startActivity(Intent.createChooser(shareIntent, "choose one"));
                } catch(Exception e) {
                    e.toString();
                }
                return true;
            default:
                return false;
            }
        }
    }

//    public void showOptions(View v) {
//        PopupMenu popup = new PopupMenu(this, v);
//        MenuInflater inflater = popup.getMenuInflater();
//        inflater.inflate(R.menu.menu, popup.getMenu());
//        popup.show();
//    }