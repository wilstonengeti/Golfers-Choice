package com.example.golferschoice;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.golferschoice.utils.LocaleHelper;

public class LocaleActivity extends AppCompatActivity {

    TextView helloworld,dialog_language;
    int lang_selected;
    RelativeLayout show_lan_dialog;


    Context context;
    Resources resources;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dialog_language = findViewById(R.id.dialog_language);
        helloworld = findViewById(R.id.helloworld);
        show_lan_dialog = findViewById(R.id.showlangdialog);

        if(LocaleHelper.getLanguage(LocaleActivity.this).equalsIgnoreCase("en"))
        {
            context = LocaleHelper.setLocale(LocaleActivity.this,"en");
            resources =context.getResources();
            dialog_language.setText("ENGLISH");
            helloworld.setText(resources.getString(R.string.hello_world));
            setTitle(resources.getString(R.string.app_name));
            lang_selected = 0;

        }else if(LocaleHelper.getLanguage(LocaleActivity.this).equalsIgnoreCase("sw")){
            context = LocaleHelper.setLocale(LocaleActivity.this,"sw");
            resources =context.getResources();
            helloworld.setText(resources.getString(R.string.hello_world));
            setTitle(resources.getString(R.string.app_name));
            lang_selected =1;
        }

        show_lan_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String[] Language = {"ENGLISH","SWAHILI"};
                final int checkItem;
                Log.d("Clicked","Clicked");


                final AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(LocaleActivity.this);
                dialogBuilder.setTitle("Select a Language")
                        .setSingleChoiceItems(Language, lang_selected, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialog_language.setText(Language[i]);

                                if(Language[i].equals("ENGLISH")){
                                    context = LocaleHelper.setLocale(LocaleActivity.this,"en");
                                    resources =context.getResources();
                                    lang_selected = 0;

                                    helloworld.setText(resources.getString(R.string.hello_world));
                                    setTitle(resources.getString(R.string.app_name));

                                }
                                if(Language[i].equals("SWAHILI"))
                                {
                                    context = LocaleHelper.setLocale(LocaleActivity.this,"sw");
                                    resources =context.getResources();
                                    lang_selected = 1;
                                    helloworld.setText(resources.getString(R.string.hello_world));
                                    setTitle(resources.getString(R.string.app_name));
                                }
                            }
                        })
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        });
                dialogBuilder.create().show();
            }
        });

    }
}