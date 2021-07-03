package com.cemre.toucanapp.User;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.cemre.toucanapp.HelperClasses.HomeAdapter.FeaturedAdapter;
import com.cemre.toucanapp.HelperClasses.HomeAdapter.FeaturedHelperClass;
import com.cemre.toucanapp.R;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class UserBoard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    static final float END_SCALE = 0.7f;

    RecyclerView featuredRecycler, featuredRecycler2, featuredRecycler3, featuredRecycler4, mostViewedRecycler, categoriesRecycler;
    RecyclerView.Adapter adapter, adapter2, adapter3, adapter4;
    private GradientDrawable gradient1, gradient2, gradient3, gradient4;


    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ImageView menuIcon;
    LinearLayout contentView, content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_user_board);

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

    private void navigationDrawer(){

        //Naviagtion Drawer
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
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

    /////////////////////burada kaldık
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



    /*
    private void categoriesRecycler() {

        //All Gradients
        gradient2 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffd4cbe5, 0xffd4cbe5});
        gradient1 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xff7adccf, 0xff7adccf});
        gradient3 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xfff7c59f, 0xFFf7c59f});
        gradient4 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffb8d7f5, 0xffb8d7f5});


        ArrayList<CategoriesHelperClass> categoriesHelperClasses = new ArrayList<>();
        categoriesHelperClasses.add(new CategoriesHelperClass(gradient1, R.drawable.school_image, "Education"));
        categoriesHelperClasses.add(new CategoriesHelperClass(gradient2, R.drawable.hospital_image, "HOSPITAL"));
        categoriesHelperClasses.add(new CategoriesHelperClass(gradient3, R.drawable.restaurant_image, "Restaurant"));
        categoriesHelperClasses.add(new CategoriesHelperClass(gradient4, R.drawable.shopping_image, "Shopping"));
        categoriesHelperClasses.add(new CategoriesHelperClass(gradient1, R.drawable.transport_image, "Transport"));


        categoriesRecycler.setHasFixedSize(true);
        adapter = new CategoriesAdapter(categoriesHelperClasses);
        categoriesRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        categoriesRecycler.setAdapter(adapter);

    }

    private void mostViewedRecycler() {

        mostViewedRecycler.setHasFixedSize(true);
        mostViewedRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<MostViewedHelperClass> mostViewedLocations = new ArrayList<>();
        mostViewedLocations.add(new MostViewedHelperClass(R.drawable.mcdonald_img, "McDonald's"));
        mostViewedLocations.add(new MostViewedHelperClass(R.drawable.city_2, "Edenrobe"));
        mostViewedLocations.add(new MostViewedHelperClass(R.drawable.city_1, "J."));
        mostViewedLocations.add(new MostViewedHelperClass(R.drawable.mcdonald_img, "Walmart"));

        adapter = new MostViewedAdpater(mostViewedLocations);
        mostViewedRecycler.setAdapter(adapter);

    }
*/
}