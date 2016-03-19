package com.abhisheksomanithegreatgmail.advancedtranslator;

import android.os.Bundle;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.Locale;
import java.util.*;


import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.os.AsyncTask;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.content.ContentUris;
import android.widget.EditText;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.content.Context;
import android.speech.RecognizerIntent;
import android.provider.CalendarContract;
import android.provider.CalendarContract.*;
import android.support.v4.app.FragmentActivity;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ListView;
import android.widget.Toast;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.app.Dialog;
import android.widget.ImageView;
import android.widget.ImageButton;
import android.speech.SpeechRecognizer;
import android.speech.*;
import android.net.ConnectivityManager;


import com.memetix.mst.language.Language;
import com.memetix.mst.translate.Translate;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,TextToSpeech.OnInitListener{


    private int check_code = 0;
    Spinner lang;
    Button say;
    EditText text;
    TextView translatedText;
    TextToSpeech t1;
    String original=null;
    String translated=null;
    String langSelected;
    public TextToSpeech convert;
    ImageView iv;
    public static final int RESULT_GALLERY=0;
    private TextView txtSpeechInput;
    private ImageButton btnSpeak;
    private final int REQ_CODE_SPEECH_INPUT = 100;


    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        txtSpeechInput = (TextView) findViewById(R.id.txtSpeechInput);
        btnSpeak = (ImageButton) findViewById(R.id.btnSpeak);

        // hide the action bar
//        getActionBar().hide();

        btnSpeak.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                promptSpeechInput();
            }
        });



        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Mail me at abhisheksomanithegreat@gmail.com", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();



            }
        });



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
/* Main portion of taking input to be given focus here */


        lang=(Spinner)findViewById(R.id.selectLanguage);
        say=(Button)findViewById(R.id.say);
        text=(EditText)findViewById(R.id.text);
        translatedText=(TextView)findViewById(R.id.translatedtext);

        Intent check = new Intent();
        check.setAction(TextToSpeech.Engine.ACTION_CHECK_TTS_DATA);
        startActivityForResult(check, check_code);

        say.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                original = text.getText().toString();
                langSelected = String.valueOf(lang.getSelectedItem());
                String toSpeak = original;
                //t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);

                if (langSelected != null)
                    System.out.println(langSelected);
                else
                    System.out.println("Shit");

                class bgStuff extends AsyncTask<Void, Void, Void> {

                    @Override
                    protected Void doInBackground(Void... params) {
                        // TODO Auto-generated method stub

                        Translate.setClientId("Abusomani");
                        Translate.setClientSecret("abhisheksomanizeniaafrinzeba");


                        if (original != null && original.length() > 0) {
                            try {
                                if (langSelected.equalsIgnoreCase("ENGLISH")) {
                                    convert.setLanguage(Locale.ENGLISH);
                                    translated = Translate.execute(original, Language.ENGLISH);
                                } else if (langSelected.equalsIgnoreCase("GERMAN")) {
                                    convert.setLanguage(Locale.GERMAN);
                                    translated = Translate.execute(original, Language.GERMAN);
                                } else if (langSelected.equalsIgnoreCase("FRENCH")) {
                                    convert.setLanguage(Locale.FRENCH);
                                    translated = Translate.execute(original, Language.FRENCH);
                                } else if (langSelected.equalsIgnoreCase("ITALIAN")) {
                                    convert.setLanguage(Locale.ITALIAN);
                                    translated = Translate.execute(original, Language.ITALIAN);
                                } else if (langSelected.equalsIgnoreCase("HINDI")) {
                                    Locale l = new Locale("hin", "IND");
                                    convert.setLanguage(l);
                                    translated = Translate.execute(original, Language.HINDI);
                                    //Log.i("translated text................", translated);
                                } else if (langSelected.equalsIgnoreCase("ARABIC")) {
                                    translated = Translate.execute(original, Language.ARABIC);
                                } else if (langSelected.equalsIgnoreCase("BULGARIAN")) {
                                    translated = Translate.execute(original, Language.BULGARIAN);
                                } else if (langSelected.equalsIgnoreCase("CATALAN")) {
                                    translated = Translate.execute(original, Language.CATALAN);
                                } else if (langSelected.equalsIgnoreCase("CZECH")) {
                                    translated = Translate.execute(original, Language.CZECH);
                                } else if (langSelected.equalsIgnoreCase("DANISH")) {
                                    translated = Translate.execute(original, Language.DANISH);
                                } else if (langSelected.equalsIgnoreCase("DUTCH")) {
                                    translated = Translate.execute(original, Language.DUTCH);
                                } else if (langSelected.equalsIgnoreCase("ESTONIAN")) {
                                    translated = Translate.execute(original, Language.ESTONIAN);
                                } else if (langSelected.equalsIgnoreCase("FINNISH")) {
                                    translated = Translate.execute(original, Language.FINNISH);
                                } else if (langSelected.equalsIgnoreCase("GREEK")) {
                                    convert.setLanguage(Locale.GERMAN);
                                    translated = Translate.execute(original, Language.GREEK);
                                } else if (langSelected.equalsIgnoreCase("HAITIAN_CREOLE")) {
                                    translated = Translate.execute(original, Language.HAITIAN_CREOLE);
                                } else if (langSelected.equalsIgnoreCase("HEBREW")) {
                                    translated = Translate.execute(original, Language.HEBREW);
                                } else if (langSelected.equalsIgnoreCase("HINDI")) {
                                    translated = Translate.execute(original, Language.HINDI);
                                } else if (langSelected.equalsIgnoreCase("HMONG_DAW")) {
                                    translated = Translate.execute(original, Language.HMONG_DAW);
                                } else if (langSelected.equalsIgnoreCase("HUNGARIAN")) {
                                    translated = Translate.execute(original, Language.HUNGARIAN);
                                } else if (langSelected.equalsIgnoreCase("INDONESIAN")) {
                                    translated = Translate.execute(original, Language.INDONESIAN);
                                } else if (langSelected.equalsIgnoreCase("JAPANESE")) {
                                    convert.setLanguage(Locale.JAPANESE);
                                    translated = Translate.execute(original, Language.JAPANESE);
                                } else if (langSelected.equalsIgnoreCase("KOREAN")) {
                                    convert.setLanguage(Locale.KOREAN);
                                    translated = Translate.execute(original, Language.KOREAN);
                                } else if (langSelected.equalsIgnoreCase("LATVIAN")) {
                                    translated = Translate.execute(original, Language.LATVIAN);
                                } else if (langSelected.equalsIgnoreCase("LITHUANIAN")) {
                                    translated = Translate.execute(original, Language.LITHUANIAN);
                                } else if (langSelected.equalsIgnoreCase("NORWEGIAN")) {
                                    translated = Translate.execute(original, Language.NORWEGIAN);
                                } else if (langSelected.equalsIgnoreCase("POLISH")) {
                                    translated = Translate.execute(original, Language.POLISH);
                                } else if (langSelected.equalsIgnoreCase("PORTUGUESE")) {
                                    translated = Translate.execute(original, Language.PORTUGUESE);
                                } else if (langSelected.equalsIgnoreCase("ROMANIAN")) {
                                    translated = Translate.execute(original, Language.ROMANIAN);
                                } else if (langSelected.equalsIgnoreCase("RUSSIAN")) {
                                    translated = Translate.execute(original, Language.RUSSIAN);
                                } else if (langSelected.equalsIgnoreCase("SLOVAK")) {
                                    translated = Translate.execute(original, Language.SLOVAK);
                                } else if (langSelected.equalsIgnoreCase("SLOVENIAN")) {
                                    translated = Translate.execute(original, Language.SLOVENIAN);
                                } else if (langSelected.equalsIgnoreCase("SPANISH")) {
                                    translated = Translate.execute(original, Language.SPANISH);
                                } else if (langSelected.equalsIgnoreCase("SWEDISH")) {
                                    translated = Translate.execute(original, Language.SWEDISH);
                                } else if (langSelected.equalsIgnoreCase("THAI")) {
                                    translated = Translate.execute(original, Language.THAI);
                                } else if (langSelected.equalsIgnoreCase("TURKISH")) {
                                    translated = Translate.execute(original, Language.TURKISH);
                                } else if (langSelected.equalsIgnoreCase("UKRAINIAN")) {
                                    translated = Translate.execute(original, Language.UKRAINIAN);
                                } else if (langSelected.equalsIgnoreCase("VIETNAMESE")) {
                                    translated = Translate.execute(original, Language.VIETNAMESE);
                                }
                            } catch (Exception e) {
                            }
                        }
                        return null;
                    }

                    @Override
                    protected void onPostExecute(Void result) {
                        translatedText.setText(translated);
                        Toast.makeText(MainActivity.this, "Saying: " + translated, Toast.LENGTH_LONG).show();
                        convert.speak(translated, TextToSpeech.QUEUE_ADD, null);

                    }
                }
                new bgStuff().execute();
            }
        });

    }



    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.


        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if ( id == R.id.action_settings) {
            startActivityForResult(new Intent(android.provider.Settings.ACTION_SETTINGS), 0);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camara) {
            Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 0);

        } else if (id == R.id.nav_gallery) {

            Intent galleryIntent = new Intent(
                    Intent.ACTION_PICK,
                    android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(galleryIntent , RESULT_GALLERY );


        }
      else if (id == R.id.nav_calendar) {

            Uri.Builder builder = CalendarContract.CONTENT_URI.buildUpon();
            builder.appendPath("time");
            ContentUris.appendId(builder, Calendar.getInstance().getTimeInMillis());
            Intent intent = new Intent(Intent.ACTION_VIEW)
                    .setData(builder.build());
            startActivity(intent);

        }
        else if (id == R.id.nav_manage) {
            Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
            intent.setType("file/*");
            int YOUR_RESULT_CODE = 0;
            startActivityForResult(intent, YOUR_RESULT_CODE);

        } else if (id == R.id.nav_share) {
            Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            String shareBody = "Here is the share content body";
            sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
            sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
            startActivity(Intent.createChooser(sharingIntent, "Share via"));

        }
        else if (id == R.id.nav_maps) {
            Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                    Uri.parse("http://maps.google.com/maps?saddr=20.344,34.34&daddr=20.5666,45.345"));
            startActivity(intent);
        }
        else {
            if (id == R.id.nav_speech) {

            }
            else if (id == R.id.nav_send) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://plus.google.com/u/0/+ABHISHEKSOMANIthegreat")));
            }
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void promptSpeechInput() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,
                getString(R.string.speech_prompt));
        try {
            startActivityForResult(intent, REQ_CODE_SPEECH_INPUT);
        } catch (ActivityNotFoundException a) {
            Toast.makeText(getApplicationContext(),
                    getString(R.string.speech_not_supported),
                    Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == check_code) {
            if (resultCode == TextToSpeech.Engine.CHECK_VOICE_DATA_PASS) {
                // success, create the TTS instance
                convert = new TextToSpeech(this, this);
            }

            else if(requestCode == REQ_CODE_SPEECH_INPUT){
                    if (resultCode == RESULT_OK && null != data) {

                        ArrayList<String> result = data
                                .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                        txtSpeechInput.setText(result.get(0));
                    }


            }

            else {
                // missing data, install it
                Intent installIntent = new Intent();
                installIntent.setAction(TextToSpeech.Engine.ACTION_INSTALL_TTS_DATA);
                startActivity(installIntent);
            }
        }


    }

    @Override
    public void onInit(int status) {
        if (status == TextToSpeech.SUCCESS) {
            Toast.makeText(MainActivity.this,"Engine is initialized", Toast.LENGTH_LONG).show();

            int result = convert.setLanguage(Locale.GERMAN);

            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {

            }
            else {
//        `       convert.setLanguage(Locale.)
            }
        }
        else if (status == TextToSpeech.ERROR) {
            Toast.makeText(MainActivity.this,"Error occurred while initializing engine", Toast.LENGTH_LONG).show();
        }
    }

}
