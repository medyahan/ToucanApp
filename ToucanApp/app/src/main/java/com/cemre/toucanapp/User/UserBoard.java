package com.cemre.toucanapp.User;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.WindowManager;

import com.cemre.toucanapp.HelperClasses.HomeAdapter.FeaturedAdapter;
import com.cemre.toucanapp.HelperClasses.HomeAdapter.FeaturedHelperClass;
import com.cemre.toucanapp.R;

import java.util.ArrayList;

public class UserBoard extends AppCompatActivity {

    RecyclerView featuredRecycler, featuredRecycler2, featuredRecycler3, featuredRecycler4, mostViewedRecycler, categoriesRecycler;
    RecyclerView.Adapter adapter, adapter2, adapter3, adapter4;
    private GradientDrawable gradient1, gradient2, gradient3, gradient4;

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
        //mostViewedRecycler = findViewById(R.id.most_viewed_recycler);
        //categoriesRecycler = findViewById(R.id.categories_recycler);
        //Functions will be executed automatically when this activity will be created
        featuredRecycler();
        //mostViewedRecycler();
        //categoriesRecycler();

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
    private void featuredRecycler() {

        featuredRecycler.setHasFixedSize(true);
        featuredRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<FeaturedHelperClass> featuredLocationsMekan = new ArrayList<>();

        featuredLocationsMekan.add(new FeaturedHelperClass(R.drawable.sardalyemekan, "Sardalye", "Ekmek arası sardalya dedin mi adres belli. Yanında acılı turşu suyu ile Çanakkale'ye her yolu düşenin tatması gereken bir lezzet."));
        featuredLocationsMekan.add(new FeaturedHelperClass(R.drawable.doganpastamekan, "Doğan Pastanesi", "Dondurmaya adini veren, birbirinden güzel pasta ve tatlı çeşitleriyle damağınızda unutulmaz tatlar bırakıyor."));
        featuredLocationsMekan.add(new FeaturedHelperClass(R.drawable.burgermekan, "Altı Üstü Burger", "Günlük hazırlanan zerdeçallı ekmeği ve köftesiyle şehrin en lezzetli hamburgerleri"));
        featuredLocationsMekan.add(new FeaturedHelperClass(R.drawable.oncumekan, "Öncü Döner", "Et İskenderden, Tavuk Dönere uzanan çeşitlerle etin en lezzetli versiyonlarının bulunduğu mekan"));
        featuredLocationsMekan.add(new FeaturedHelperClass(R.drawable.yalovarestoranimekan, "Yalova Restaurant", "Çanakkale'de en iyi balık yapan restoran. Mezeleri , çorbası ve  manzarası ile  her zaman tercih sebebi."));
        featuredLocationsMekan.add(new FeaturedHelperClass(R.drawable.verandamekan, "Veranda Cafe", "Dünya kahveleri, sandviçler, özel el yapımı cheesecake ve pastalarla hizmetinizde."));

        adapter = new FeaturedAdapter(featuredLocationsMekan);
        featuredRecycler.setAdapter(adapter);


        featuredRecycler2.setHasFixedSize(true);
        featuredRecycler2.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<FeaturedHelperClass> featuredLocationsMuze = new ArrayList<>();

        featuredLocationsMuze.add(new FeaturedHelperClass(R.drawable.troyamuzesi, "Troya Müzesi", "Troya antik kentini anlamak ve ören yeri gezisini de anlamlandırmak için mükemmel bir mekan."));
        featuredLocationsMuze.add(new FeaturedHelperClass(R.drawable.kentmuzesi, "Kent Müzesi", "Şehrin tarihçesi ve sosyal yaşamı anlatılan, bağışlanan eşyaların da sunulduğu müze."));
        featuredLocationsMuze.add(new FeaturedHelperClass(R.drawable.denizmuzesi, "Deniz Müzesi", "1915 Çanakkale Deniz ve Kara Savaşları hakkında bilgilendirmek için kurulmuş askeri müze."));
        featuredLocationsMuze.add(new FeaturedHelperClass(R.drawable.rhapdosmozaikmuze, "Rhapdos Mozaik", "Mozaik betimlemeleri üzerinden Troya mitoliji'sinin baştan sona anlatıldığı, Troya harabelerini görmeden önce mutlaka görülmesi gereken bir yer."));

        adapter2 = new FeaturedAdapter(featuredLocationsMuze);
        featuredRecycler2.setAdapter(adapter2);
////////////////////////
        featuredRecycler3.setHasFixedSize(true);
        featuredRecycler3.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<FeaturedHelperClass> featuredLocationsTarihiYer = new ArrayList<>();

        featuredLocationsTarihiYer.add(new FeaturedHelperClass(R.drawable.sardalyemekan, "Sardalye", "Ekmek arası sardalya dedin mi adres belli. Yanında acılı turşu suyu ile Çanakkale'ye her yolu düşenin tatması gereken bir lezzet."));
        featuredLocationsTarihiYer.add(new FeaturedHelperClass(R.drawable.doganpastamekan, "Doğan Pastanesi", "Çanakkale'de Dondurmaya adini veren Doğan Pastanesi, birbirinden güzel pasta ve tatlı çeşitleriyle damağınızda unutulmaz tatlar bırakıyor."));
        featuredLocationsTarihiYer.add(new FeaturedHelperClass(R.drawable.burgermekan, "Altı Üstü Burger", "Günlük hazırlanan zerdeçallı ekmeği ve köftesiyle şehrin en lezzetli hamburgerleri"));
        featuredLocationsTarihiYer.add(new FeaturedHelperClass(R.drawable.oncumekan, "Öncü Döner", "Et İskenderden, Tavuk Dönere uzanan çeşitlerle etin en lezzetli versiyonlarının bulunduğu mekan"));
        featuredLocationsTarihiYer.add(new FeaturedHelperClass(R.drawable.yalovarestoranimekan, "Yalova Restaurant", "Çanakkale'de en iyi balık yapan restoran. Mezeleri , çorbası ve  manzarası ile  her zaman tercih sebebi."));
        featuredLocationsTarihiYer.add(new FeaturedHelperClass(R.drawable.verandamekan, "Veranda Cafe", "Dünya kahveleri, sandviçler, özel el yapımı cheesecake ve pastalarla hizmetinizde."));

        adapter3 = new FeaturedAdapter(featuredLocationsTarihiYer);
        featuredRecycler3.setAdapter(adapter3);

        /////////////
        featuredRecycler4.setHasFixedSize(true);
        featuredRecycler4.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<FeaturedHelperClass> featuredLocationsOtel = new ArrayList<>();

        featuredLocationsOtel.add(new FeaturedHelperClass(R.drawable.sardalyemekan, "Sardalye", "Ekmek arası sardalya dedin mi adres belli. Yanında acılı turşu suyu ile Çanakkale'ye her yolu düşenin tatması gereken bir lezzet."));
        featuredLocationsOtel.add(new FeaturedHelperClass(R.drawable.doganpastamekan, "Doğan Pastanesi", "Çanakkale'de Dondurmaya adini veren Doğan Pastanesi, birbirinden güzel pasta ve tatlı çeşitleriyle damağınızda unutulmaz tatlar bırakıyor."));
        featuredLocationsOtel.add(new FeaturedHelperClass(R.drawable.burgermekan, "Altı Üstü Burger", "Günlük hazırlanan zerdeçallı ekmeği ve köftesiyle şehrin en lezzetli hamburgerleri"));
        featuredLocationsOtel.add(new FeaturedHelperClass(R.drawable.oncumekan, "Öncü Döner", "Et İskenderden, Tavuk Dönere uzanan çeşitlerle etin en lezzetli versiyonlarının bulunduğu mekan"));
        featuredLocationsOtel.add(new FeaturedHelperClass(R.drawable.yalovarestoranimekan, "Yalova Restaurant", "Çanakkale'de en iyi balık yapan restoran. Mezeleri , çorbası ve  manzarası ile  her zaman tercih sebebi."));
        featuredLocationsOtel.add(new FeaturedHelperClass(R.drawable.verandamekan, "Veranda Cafe", "Dünya kahveleri, sandviçler, özel el yapımı cheesecake ve pastalarla hizmetinizde."));

        adapter4 = new FeaturedAdapter(featuredLocationsOtel);
        featuredRecycler4.setAdapter(adapter4);


    }
}