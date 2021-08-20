package com.example.golferschoice;


import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.golferschoice.utils.Course;
import com.example.golferschoice.utils.CourseInfo;
import com.example.golferschoice.utils.RecyclerAdapter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<CourseInfo> courseInfos;
    private RecyclerAdapter adapter;
    private TextView greetings;
    //Constant keys for shared preferences
    public final String SHARED_PREFS = "shared_prefs";

    //storing phone
    public final String USER_NAME = "user_name";

    SharedPreferences sharedPreferences;
    String username;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //initializing shared prefs
        sharedPreferences = getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);
        //getting data and storing it
        username = sharedPreferences.getString(USER_NAME, null);


        greetings =(TextView)findViewById(R.id.greetings);
        Calendar c = Calendar.getInstance();
        int timeOfDay = c.get(Calendar.HOUR_OF_DAY);

        if(timeOfDay >= 0 && timeOfDay < 12){
            greetings.setText("Good Morning, " + username);
        }else if(timeOfDay >= 12 && timeOfDay < 16){
            greetings.setText("Good Afternoon, " + username);
        }else if(timeOfDay >= 16 && timeOfDay < 24){
            greetings.setText("Good Evening, " + username);
        }
        recyclerView = findViewById(R.id.recycler_view);
        courseInfos = new ArrayList<>();

        setData();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new RecyclerAdapter(this, courseInfos);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        adapter.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        adapter.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.item_github) {
            Uri uri = Uri.parse("https://github.com/wngeti");
            startActivity(Intent.createChooser(new Intent(Intent.ACTION_VIEW, uri), "Choose Browser"));
        }
        return true;
    }

    private void setData() {
        ArrayList<Course> airforce = new ArrayList<>();
        airforce.add(new Course("9 holes"));
        airforce.add(new Course("Bar"));
        airforce.add(new Course("Club"));
        airforce.add(new Course("Putting Green"));
        airforce.add(new Course("36 Yellow Pars "));
        airforce.add(new Course("36 Red Pars"));

        ArrayList<Course> eldoret = new ArrayList<>();
        eldoret.add(new Course("9 holes"));
        eldoret.add(new Course("Bar"));
        eldoret.add(new Course("Lockers"));
        eldoret.add(new Course("Restaurant"));
        eldoret.add(new Course("Swimming Pool"));
        eldoret.add(new Course("Putting Green"));
        eldoret.add(new Course("35 Yellow Pars "));
        eldoret.add(new Course("35 Red Pars"));

        ArrayList<Course> fairmont = new ArrayList<>();
        fairmont.add(new Course("9 holes"));
        fairmont.add(new Course("Bar"));
        fairmont.add(new Course("Lockers"));
        fairmont.add(new Course("Restaurant"));
        fairmont.add(new Course("Swimming Pool"));
        fairmont.add(new Course("27 Yellow Pars - 2184m"));
        fairmont.add(new Course("27 Red Pars"));

        ArrayList<Course> gilgil = new ArrayList<>();
        gilgil.add(new Course("9 holes"));
        gilgil.add(new Course("Bar"));
        gilgil.add(new Course("Club"));
        gilgil.add(new Course("Putting Green"));
        gilgil.add(new Course("36 Yellow Pars - 2825m"));
        gilgil.add(new Course("35 Red Pars"));

        ArrayList<Course> great = new ArrayList<>();
        great.add(new Course("18 holes"));
        great.add(new Course("Bar"));
        great.add(new Course("Driving Range"));
        great.add(new Course("Chipping Area"));
        great.add(new Course("Putting Green"));
        great.add(new Course("Swimming Pool"));
        great.add(new Course("Restaurant"));
        great.add(new Course("Club Rental"));
        great.add(new Course("Lockers"));
        great.add(new Course("Caddy"));
        great.add(new Course("71 Yellow Pars - 6504m"));
        great.add(new Course("71 Red Pars - 5502m"));

        ArrayList<Course> kakamega = new ArrayList<>();
        kakamega.add(new Course("9 holes"));
        kakamega.add(new Course("Bar"));
        kakamega.add(new Course("Lockers"));
        kakamega.add(new Course("Pro Shop"));
        kakamega.add(new Course("Restaurant"));
        kakamega.add(new Course("Putting Green"));
        kakamega.add(new Course("36 Yellow Pars - 3234m"));
        kakamega.add(new Course("36 Red Pars - 2812m"));

        ArrayList<Course> karen = new ArrayList<>();
        karen.add(new Course("18 holes"));
        karen.add(new Course("Bar"));
        karen.add(new Course("Driving Range"));
        karen.add(new Course("Putting Green"));
        karen.add(new Course("Swimming Pool"));
        karen.add(new Course("Restaurant"));
        karen.add(new Course("Club Rental"));
        karen.add(new Course("Lockers"));
        karen.add(new Course("Pro Shop"));
        karen.add(new Course("71 Yellow Pars - 6662m"));
        karen.add(new Course("71 Red Pars - 570m"));
        karen.add(new Course("Handicap - Mandatory"));

        ArrayList<Course> kenya = new ArrayList<>();
        kenya.add(new Course("9 holes"));
        kenya.add(new Course("Bar"));
        kenya.add(new Course("Lockers"));
        kenya.add(new Course("Putting Green"));
        kenya.add(new Course("36 Yellow Pars"));
        kenya.add(new Course("36 Red Pars"));

        ArrayList<Course> kiambu = new ArrayList<>();
        kiambu.add(new Course("9 holes"));
        kiambu.add(new Course("Bar"));
        kiambu.add(new Course("Locker"));
        kiambu.add(new Course("Putting Green"));
        kiambu.add(new Course("36 Yellow Pars - 3411m"));
        kiambu.add(new Course("36 Red Pars - 2878m"));

        ArrayList<Course> kisii = new ArrayList<>();
        kisii.add(new Course("9 holes"));
        kisii.add(new Course("Bar"));
        kisii.add(new Course("35 Yellow Pars"));
        kisii.add(new Course("35 Red Pars"));

        ArrayList<Course> kitale = new ArrayList<>();
        kitale.add(new Course("18 holes"));
        kitale.add(new Course("Bar"));
        kitale.add(new Course("Lockers"));
        kitale.add(new Course("73 Yellow Pars - 6869m"));
        kitale.add(new Course("73 Red Pars - 5931m"));

        ArrayList<Course> leisure = new ArrayList<>();
        leisure.add(new Course("18 holes"));
        leisure.add(new Course("Bar"));
        leisure.add(new Course("Swimming Pool"));
        leisure.add(new Course("Restaurant"));
        leisure.add(new Course("Swimming Pool"));
        leisure.add(new Course("Lockers"));
        leisure.add(new Course("72 Yellow Pars - 6084m"));
        leisure.add(new Course("72 Red Pars "));
        leisure.add(new Course("Handicap - Mandatory"));

        ArrayList<Course> limuru = new ArrayList<>();
        limuru.add(new Course("19 holes"));
        limuru.add(new Course("Bar"));
        limuru.add(new Course("Lockers"));
        limuru.add(new Course("Restaurant"));
        limuru.add(new Course("Swimming Pool"));
        limuru.add(new Course("Pro Shop"));

        ArrayList<Course> magadi = new ArrayList<>();
        magadi.add(new Course("18 holes"));
        magadi.add(new Course("Bar"));
        magadi.add(new Course("Yellow Pars - 5994m"));
        magadi.add(new Course("Red Pars - 5183m"));

        ArrayList<Course> malindi = new ArrayList<>();
        malindi.add(new Course("11 holes"));
        malindi.add(new Course("Bar"));
        malindi.add(new Course("Restaurant"));
        malindi.add(new Course("Golf School"));
        malindi.add(new Course("Pro Shop"));
        malindi.add(new Course("35 Yellow Pars - 3043m"));
        malindi.add(new Course("35 Red Pars - 2618m"));

        ArrayList<Course> molo = new ArrayList<>();
        molo.add(new Course("11 holes"));
        molo.add(new Course("Bar"));
        molo.add(new Course("Lockers"));
        molo.add(new Course("Yellow Pars - 2457m"));
        molo.add(new Course(" Red Pars - 2210m"));

        ArrayList<Course> mombasa = new ArrayList<>();
        mombasa.add(new Course("9 holes"));
        mombasa.add(new Course("Bar"));
        mombasa.add(new Course("35 Yellow Pars - 2288m"));
        mombasa.add(new Course("36 Red Pars - 2628m"));

        ArrayList<Course> mumias = new ArrayList<>();
        mumias.add(new Course("9 holes"));

        ArrayList<Course> muthaiga = new ArrayList<>();
        muthaiga.add(new Course("9 holes"));
        muthaiga.add(new Course("Bar"));
        muthaiga.add(new Course("Driving Range"));
        muthaiga.add(new Course("Restaurant"));
        muthaiga.add(new Course("Golf School"));
        muthaiga.add(new Course("69 Yellow Pars - 6111m"));
        muthaiga.add(new Course("73 Red Pars - 5783m"));

        ArrayList<Course> nakuru = new ArrayList<>();
        nakuru.add(new Course("18 holes"));
        nakuru.add(new Course("Bar"));
        nakuru.add(new Course("73 Yellow Pars - 6802m"));
        nakuru.add(new Course("73 Red Pars"));

        ArrayList<Course> nandi = new ArrayList<>();
        nandi.add(new Course("9 holes"));
        nandi.add(new Course("36 Yellow Pars"));
        nandi.add(new Course("36 Red Pars"));

        ArrayList<Course> nanyuki = new ArrayList<>();
        nanyuki.add(new Course("Swimming Pool"));
        nanyuki.add(new Course("Lockers"));
        nanyuki.add(new Course("Bar"));
        nanyuki.add(new Course("9 holes"));
        nanyuki.add(new Course("36 Yellow Pars"));
        nanyuki.add(new Course("36 Red Pars"));

        ArrayList<Course> ngong = new ArrayList<>();
        ngong.add(new Course("9 holes"));
        ngong.add(new Course("Bar"));
        ngong.add(new Course("Driving Range"));
        ngong.add(new Course("36 Yellow Pars"));
        ngong.add(new Course("36 Red Pars"));

        ArrayList<Course> njoro = new ArrayList<>();
        njoro.add(new Course("10 holes"));
        njoro.add(new Course("Driving Range"));
        njoro.add(new Course("Chipping Area"));
        njoro.add(new Course("Restaurant"));
        njoro.add(new Course("Wi-Fi"));
        njoro.add(new Course("Golf School"));

        ArrayList<Course> nyali = new ArrayList<>();
        nyali.add(new Course("18 holes"));
        nyali.add(new Course("Bar"));
        nyali.add(new Course("Driving Range"));
        nyali.add(new Course("Chipping Area"));
        nyali.add(new Course("Putting Green"));
        nyali.add(new Course("Club Rental"));
        nyali.add(new Course("Trolley Rental"));
        nyali.add(new Course("Restaurant"));
        nyali.add(new Course("Lockers"));
        nyali.add(new Course("Swimming Pool"));
        nyali.add(new Course("71 Yellow Pars - 6510m"));
        nyali.add(new Course("71 Red Pars - 5431m"));

        ArrayList<Course> nyanza = new ArrayList<>();
        nyanza.add(new Course("9 holes"));
        nyanza.add(new Course("Bar"));
        nyanza.add(new Course("Lockers"));
        nyanza.add(new Course("Putting Green"));
        nyanza.add(new Course("Golf School"));
        nyanza.add(new Course("35 Yellow Pars"));
        nyanza.add(new Course("35 Red Pars"));

        ArrayList<Course> nyeri = new ArrayList<>();
        nyeri.add(new Course("9 holes"));
        nyeri.add(new Course("Bar"));
        nyeri.add(new Course("Lockers"));
        nyeri.add(new Course("Caddy"));
        nyeri.add(new Course("Putting Green"));
        nyeri.add(new Course("Swimming Pool"));
        nyeri.add(new Course("36 Yellow Pars - 3012m"));
        nyeri.add(new Course("36 Red Pars"));

        ArrayList<Course> royal = new ArrayList<>();
        royal.add(new Course("18 holes"));
        royal.add(new Course("Bar"));
        royal.add(new Course("Lockers"));
        royal.add(new Course("Pro Shop"));
        royal.add(new Course("Putting Green"));
        royal.add(new Course("Chipping Area"));
        royal.add(new Course("Club Rental"));
        royal.add(new Course("Restaurant"));
        royal.add(new Course("Swimming Pool"));
        royal.add(new Course("72 Yellow Pars - 7021m"));
        royal.add(new Course("72 Red Pars - 5845m"));

        ArrayList<Course> sigona = new ArrayList<>();
        sigona.add(new Course("18 holes"));
        sigona.add(new Course("Bar"));
        sigona.add(new Course("Lockers"));
        sigona.add(new Course("Buggy"));
        sigona.add(new Course("Putting Green"));
        sigona.add(new Course("Chipping Area"));
        sigona.add(new Course("Club Rental"));
        sigona.add(new Course("72 Yellow Pars - 6591m"));
        sigona.add(new Course("72 Red Pars - 5723m"));

        ArrayList<Course> andrews = new ArrayList<>();
        andrews.add(new Course("9 holes"));
        andrews.add(new Course("27 Yellow Pars"));
        andrews.add(new Course("27 Red Pars"));

        ArrayList<Course> aberdare = new ArrayList<>();
        aberdare.add(new Course("18 holes"));
        aberdare.add(new Course("Bar"));
        aberdare.add(new Course("Lockers"));
        aberdare.add(new Course("Restaurant"));
        aberdare.add(new Course("Swimming Pool"));
        aberdare.add(new Course("33 Yellow Pars - 1931m"));
        aberdare.add(new Course("33 Red Pars"));

        ArrayList<Course> thikagreens = new ArrayList<>();
        thikagreens.add(new Course("18 holes"));
        thikagreens.add(new Course("Bar"));
        thikagreens.add(new Course("Lockers"));
        thikagreens.add(new Course("Buggy"));
        thikagreens.add(new Course("Putting Green"));
        thikagreens.add(new Course("Chipping Area"));
        thikagreens.add(new Course("72 Yellow Pars"));
        thikagreens.add(new Course("72 Red Pars"));
        thikagreens.add(new Course("Handicap - Mandatory"));

        ArrayList<Course> thikasports = new ArrayList<>();
        thikasports.add(new Course("18 holes"));
        thikasports.add(new Course("72 Yellow Pars - 6602m"));
        thikasports.add(new Course("72 Red Pars - 5675m"));

        ArrayList<Course> vet = new ArrayList<>();
        vet.add(new Course("9 holes"));
        vet.add(new Course("Bar"));
        vet.add(new Course("Restaurant"));
        vet.add(new Course("35 Yellow Pars - 3184m"));
        vet.add(new Course("35 Red Pars - 2801m"));

        ArrayList<Course> vipingo = new ArrayList<>();
        vipingo.add(new Course("18 holes"));
        vipingo.add(new Course("Bar"));
        vipingo.add(new Course("Wifi"));
        vipingo.add(new Course("Buggy"));
        vipingo.add(new Course("Caddy"));
        vipingo.add(new Course("Driving Range"));
        vipingo.add(new Course("Lockers"));
        vipingo.add(new Course("Putting Green"));
        vipingo.add(new Course("Club Rental"));
        vipingo.add(new Course("Pro Shop"));
        vipingo.add(new Course("72 Yellow Pars - 5928m"));
        vipingo.add(new Course("72 Red Pars - 5380m"));

        ArrayList<Course> windsor = new ArrayList<>();
        windsor.add(new Course("18 holes"));
        windsor.add(new Course("Bar"));
        windsor.add(new Course("Lockers"));
        windsor.add(new Course("Buggy"));
        windsor.add(new Course("Golf School"));
        windsor.add(new Course("Trolley Rental"));
        windsor.add(new Course("Restaurant"));
        windsor.add(new Course("Driving Range"));
        windsor.add(new Course("Lockers"));
        windsor.add(new Course("Putting Green"));
        windsor.add(new Course("Club Rental"));
        windsor.add(new Course("Pro Shop"));
        windsor.add(new Course("Swimming Pool"));
        windsor.add(new Course("72 Yellow Pars - 7277m"));
        windsor.add(new Course("72 Red Pars"));
        windsor.add(new Course("Handicap - Mandatory"));


        courseInfos.add(new CourseInfo("Air Force Golf Club", airforce));
        courseInfos.add(new CourseInfo("Eldoret Club", eldoret));
        courseInfos.add(new CourseInfo("Fairmont Mount Kenya Safari Club", fairmont));
        courseInfos.add(new CourseInfo("Gilgil Golf Club", gilgil));
        courseInfos.add(new CourseInfo("Great Rift Valley Lodge & Golf Resort", great));
        courseInfos.add(new CourseInfo("Kakamega Golf Club", kakamega));
        courseInfos.add(new CourseInfo("Karen Golf And Country Club", karen));
        courseInfos.add(new CourseInfo("Kenya Railway Golf Club", kenya));
        courseInfos.add(new CourseInfo("Kiambu Club", kiambu));
        courseInfos.add(new CourseInfo("Kisii Sports Club", kisii));
        courseInfos.add(new CourseInfo("Kitale Golf Club", kitale));
        courseInfos.add(new CourseInfo("Leisure Lodge Golf Resort", leisure));
        courseInfos.add(new CourseInfo("Limuru Country Club", limuru));
        courseInfos.add(new CourseInfo("Magadi Golf Club", magadi));
        courseInfos.add(new CourseInfo("Malindi Golf & Country Club", malindi));
        courseInfos.add(new CourseInfo("Molo Highlands Golf Course", molo));
        courseInfos.add(new CourseInfo("Mombasa Golf Club", mombasa));
        courseInfos.add(new CourseInfo("Mumias Golf Club", mumias));
        courseInfos.add(new CourseInfo("Muthaiga Golf Club", muthaiga));
        courseInfos.add(new CourseInfo("Nakuru Golf Club", nakuru));
        courseInfos.add(new CourseInfo("Nandi Bears Golf Club", nandi));
        courseInfos.add(new CourseInfo("Nanyuki Sports Club", nanyuki));
        courseInfos.add(new CourseInfo("Ngong Racecourse And Golf Club", ngong));
        courseInfos.add(new CourseInfo("Njoro Country Club", njoro));
        courseInfos.add(new CourseInfo("Nyali Golf & Country Club", nyali));
        courseInfos.add(new CourseInfo("Nyanza Club", nyanza));
        courseInfos.add(new CourseInfo("Nyeri Golf Club", nyeri));
        courseInfos.add(new CourseInfo("Royal Nairobi Golf Club", royal));
        courseInfos.add(new CourseInfo("Sigona Golf Club", sigona));
        courseInfos.add(new CourseInfo("St. Andrews - Ndumberi Golf Club", andrews));
        courseInfos.add(new CourseInfo("The Aberdare Country Club", aberdare));
        courseInfos.add(new CourseInfo("Thika Greens Golf City", thikagreens));
        courseInfos.add(new CourseInfo("Thika Sports Club", thikasports));
        courseInfos.add(new CourseInfo("Vet Lab Golf Club", vet));
        courseInfos.add(new CourseInfo("Vipingo Ridge Golf Resort", vipingo));
        courseInfos.add(new CourseInfo("Windsor Golf Hotel And Country Club", windsor));
    }
}