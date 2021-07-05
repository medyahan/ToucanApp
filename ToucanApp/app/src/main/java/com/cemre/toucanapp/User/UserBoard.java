package com.cemre.toucanapp.User;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cemre.toucanapp.HelperClasses.HomeAdapter.FeaturedAdapter;
import com.cemre.toucanapp.HelperClasses.HomeAdapter.FeaturedHelperClass;
import com.cemre.toucanapp.Location.Map;
import com.cemre.toucanapp.R;
import com.cemre.toucanapp.Start.Login;
import com.cemre.toucanapp.Start.StartUp;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class UserBoard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = "Userboard";
    private static final int ERROR_DIALOG_REQUEST = 9001;
    static final float END_SCALE = 0.7f;

    RecyclerView featuredRecycler, featuredRecycler2, featuredRecycler3, featuredRecycler4, mostViewedRecycler, categoriesRecycler;
    RecyclerView.Adapter adapter, adapter2, adapter3, adapter4;

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ImageView menuIcon;
    LinearLayout contentView, content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_user_board);

        if(isServicesOK())
        {
            init();
        }

        //Hooks
        featuredRecycler = findViewById(R.id.featured_recycler);
        featuredRecycler2 = findViewById(R.id.featured_recycler2);
        featuredRecycler3 = findViewById(R.id.featured_recycler3);
        featuredRecycler4 = findViewById(R.id.featured_recycler4);
        featuredRecycler();



        //Menu Hooks
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);
        menuIcon = findViewById(R.id.menu_icon);
        contentView = findViewById(R.id.content);

        navigationDrawer();

    }

    // MAPS -------------------------------------------------------------------------------------------//
    private void init()
    {
        Button btnMap = (Button) findViewById(R.id.btnMap);
        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserBoard.this, Map.class);
                startActivity(intent);
            }
        });

    }

    public boolean isServicesOK()
    {
        Log.d(TAG, "isServicesOK: checking google services version..");
        int available = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(UserBoard.this);
        if(available == ConnectionResult.SUCCESS)
        {
            Log.d(TAG, "isServicesOK: Google Play Services is working..");
            return  true;
        }
        else if(GoogleApiAvailability.getInstance().isUserResolvableError(available))
        {
            Log.d(TAG, "isServicesOK: an error occured but we can fix it..");
            Dialog dialog = GoogleApiAvailability.getInstance().getErrorDialog(UserBoard.this, available, ERROR_DIALOG_REQUEST);
            dialog.show();
        }
        else{
            Toast.makeText(this, "You can't make map request", Toast.LENGTH_SHORT).show();
        }
        return false;
    }
    // ---------------------------------------------------------------------------------------------------------------  //

    public void Logout(View view)
    {
        FirebaseAuth.getInstance().signOut();
        Toast.makeText(UserBoard.this, "Çıkış yapıldı..", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(getApplicationContext(), StartUp.class));
        finish();
    }


    private void navigationDrawer(){

        //Naviagtion Drawer
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this );
        navigationView.setCheckedItem(R.id.nav_home);

        menuIcon.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(drawerLayout.isDrawerVisible(GravityCompat.START))
                    drawerLayout.closeDrawer(GravityCompat.START);
                else drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        animateNavigationDrawer();
    }
    private void animateNavigationDrawer() {

        drawerLayout.setScrimColor(getResources().getColor(R.color.turuncu));
        drawerLayout.addDrawerListener(new DrawerLayout.SimpleDrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {

                // Scale the View based on current slide offset
                final float diffScaledOffset = slideOffset * (1 - END_SCALE);
                final float offsetScale = 1 - diffScaledOffset;
                contentView.setScaleX(offsetScale);
                contentView.setScaleY(offsetScale);

                // Translate the View, accounting for the scaled width
                final float xOffset = drawerView.getWidth() * slideOffset;
                final float xOffsetDiff = contentView.getWidth() * diffScaledOffset / 2;
                final float xTranslation = xOffset - xOffsetDiff;
                contentView.setTranslationX(xTranslation);
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerVisible(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else
            super.onBackPressed();
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return true;
    }

    private void featuredRecycler() {


        ///MEKAN VERİLERİ
        featuredRecycler.setHasFixedSize(true);
        featuredRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<FeaturedHelperClass> featuredLocationsMekan = new ArrayList<>();

        featuredLocationsMekan.add(new FeaturedHelperClass(R.drawable.sardalyemekan, "Sardalye", "Ekmek arası sardalya dedin mi adres belli. Yanında acılı turşu suyu ile Çanakkale'ye her yolu düşenin tatması gereken bir lezzet."));
        featuredLocationsMekan.add(new FeaturedHelperClass(R.drawable.doganpastamekan, "Doğan Pastanesi", "Dondurmaya adini veren, birbirinden güzel pasta ve tatlı çeşitleriyle damağınızda unutulmaz tatlar bırakıyor."));
        featuredLocationsMekan.add(new FeaturedHelperClass(R.drawable.burgermekan, "Altı Üstü Burger", "Günlük hazırlanan zerdeçallı ekmeği ve köftesiyle şehrin en lezzetli hamburgerleri..."));
        featuredLocationsMekan.add(new FeaturedHelperClass(R.drawable.oncumekan, "Öncü Döner", "Et İskenderden, Tavuk Dönere uzanan çeşitlerle etin en lezzetli versiyonlarının bulunduğu mekandır."));
        featuredLocationsMekan.add(new FeaturedHelperClass(R.drawable.yalovarestoranimekan, "Yalova Restaurant", "Çanakkale'de en iyi balık yapan restoran. Mezeleri , çorbası ve  manzarası ile  her zaman tercih sebebidir."));
        featuredLocationsMekan.add(new FeaturedHelperClass(R.drawable.verandamekan, "Veranda Cafe", "Dünya kahveleri, sandviçler, özel el yapımı cheesecake ve pastalarla hizmetinizde."));

        adapter = new FeaturedAdapter(featuredLocationsMekan);
        featuredRecycler.setAdapter(adapter);

        ///MÜZE VERİLERİ
        featuredRecycler2.setHasFixedSize(true);
        featuredRecycler2.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<FeaturedHelperClass> featuredLocationsMuze = new ArrayList<>();

        featuredLocationsMuze.add(new FeaturedHelperClass(R.drawable.troyamuzesi, "Troya Müzesi", "Troya antik kentini anlamak ve ören yeri gezisini de anlamlandırmak için mükemmel bir mekan."));
        featuredLocationsMuze.add(new FeaturedHelperClass(R.drawable.kentmuzesi, "Kent Müzesi", "Şehrin tarihçesi ve sosyal yaşamı anlatılan, bağışlanan eşyaların da sunulduğu müze."));
        featuredLocationsMuze.add(new FeaturedHelperClass(R.drawable.denizmuzesi, "Deniz Müzesi", "1915 Çanakkale Deniz ve Kara Savaşları hakkında bilgilendirmek için kurulmuş askeri müze."));
        featuredLocationsMuze.add(new FeaturedHelperClass(R.drawable.rhapdosmozaikmuze, "Rhapdos Mozaik", "Mozaikler üzerinden Troya mitoliji'sinin anlatıldığı, Troya harabelerinden önce görülmesi gereken bir yer."));

        adapter2 = new FeaturedAdapter(featuredLocationsMuze);
        featuredRecycler2.setAdapter(adapter2);

        ///TARİHİ YERLER VERİLERİ
        featuredRecycler3.setHasFixedSize(true);
        featuredRecycler3.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<FeaturedHelperClass> featuredLocationsTarihiYer = new ArrayList<>();

        featuredLocationsTarihiYer.add(new FeaturedHelperClass(R.drawable.sehitlikabidesi, "Şehitler Abidesi", "Kurtuluş mücadelesini hissedebileceğiniz, bu ülke uğruna ne kadar büyük fedakarlıklar yapıldığını anlayabileceğiniz en özel yerdir. "));
        featuredLocationsTarihiYer.add(new FeaturedHelperClass(R.drawable.saatkulesi, "Saat Kulesi", "20 metrelik yükseklikte ve 5 katlı olan Çanakkale Saat Kulesi, Çanakkale şehir merkezinde Vitalis G. Sancakbeyi Cemil Paşa tarafından 1896 yılında yaptırılmıştır."));
        featuredLocationsTarihiYer.add(new FeaturedHelperClass(R.drawable.truvaati, "Truva Atı", " Burası, Çanakkale’nin tarihi açıdan en zengin noktaları arasında bulunuyor ve ziyaretçilerin en fazla ilgi gösterdiği noktaların başında geliyor."));
        featuredLocationsTarihiYer.add(new FeaturedHelperClass(R.drawable.aynalicarsi, "Aynalı Çarşı", "Aynalı Çarşı isminin çatıdaki pencerelerden giren ışığı dağıtmak için girişte ve duvar boyunca yerleştirilmiş aynalardan geldiğini düşünülmektedir."));
        featuredLocationsTarihiYer.add(new FeaturedHelperClass(R.drawable.assosantikkenti, "Assos Antik Kenti", "Bölgede çıkarılan tarihi eserler arasında Athena Tapınağı burasını en cazip kılan detaylar arasında bulunuyor."));
        featuredLocationsTarihiYer.add(new FeaturedHelperClass(R.drawable.geliboluyarimadasi, "Gelibolu Milli Parkı", "Parkın kapladığı alan 33 bin hektarın üzerindedir. Milli park 1 ilçeyi ve 8 köyü kapsamaktadır."));
        featuredLocationsTarihiYer.add(new FeaturedHelperClass(R.drawable.kilitbahirkalesi, "Kilitbahir Kalesi", "Yedi katlı, yonca planlı iç kalesidir. Bu plan şeması başka hiçbir kalede kullanılmamıştır."));
        featuredLocationsTarihiYer.add(new FeaturedHelperClass(R.drawable.seyitonbasianiti, "Seyit Onbaşı Anıtı", "Göstermiş olduğu kahramanlık örneği ile Kurtuluş Savaşı’nın simge isimlerinden biri olmuştur."));


        adapter3 = new FeaturedAdapter(featuredLocationsTarihiYer);
        featuredRecycler3.setAdapter(adapter3);

        /// OTEL VERİLERİ
        featuredRecycler4.setHasFixedSize(true);
        featuredRecycler4.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<FeaturedHelperClass> featuredLocationsOtel = new ArrayList<>();

        featuredLocationsOtel.add(new FeaturedHelperClass(R.drawable.truvaotel4, "Büyük Truva Otel", "Şehir Merkezine 0.6 km uzaklıkta"));
        featuredLocationsOtel.add(new FeaturedHelperClass(R.drawable.avechotel4, "Avec Hotel", "Şehir Merkezine 4.3 km uzaklıkta"));
        featuredLocationsOtel.add(new FeaturedHelperClass(R.drawable.anzachotel3, "Hotel Anzac", "Şehir Merkezine 0.6 km uzaklıkta"));
        featuredLocationsOtel.add(new FeaturedHelperClass(R.drawable.kolinotel5, "Hotel Kolin", "Şehir Merkezine 3.8 km uzaklıkta"));
        featuredLocationsOtel.add(new FeaturedHelperClass(R.drawable.desetranges3, "Otel Des Etranges", "Şehir Merkezine 0.7 km uzaklıkta"));

        adapter4 = new FeaturedAdapter(featuredLocationsOtel);
        featuredRecycler4.setAdapter(adapter4);


    }
}