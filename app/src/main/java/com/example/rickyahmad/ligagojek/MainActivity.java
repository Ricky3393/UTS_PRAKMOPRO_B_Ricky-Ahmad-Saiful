package com.example.rickyahmad.ligagojek;

import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.rickyahmad.ligagojek.adapter.MainAdapter;
import com.example.rickyahmad.ligagojek.model.MainModel;

import java.util.LinkedList;

import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private final LinkedList<MainModel> listTim = new LinkedList<>();
    private RecyclerView recyclerView;
    private MainAdapter mainAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        changeLanguage();

        String Persib = "Persatuan Sepakbola Indonesia Bandung or commonly known as Persib, is a professional football club in Bandung, West Java, Indonesia, that competes in Liga 1, the top tier of Indonesian football. The club was founded in June 1933 from a merger of three clubs. It has not been relegated from the top flight since the foundation of the Liga Indonesia in 1994. Persib's home stadium is the Gelora Bandung Lautan Api Stadium which has a capacity of 38,000. The club's nicknames are Maung Bandung (The Bandung Tigers) and Pangeran Biru (The Blue Prince).\n" +
                "The club won their first Indonesia Super League (now known as Liga 1) title in 2014, the first title of the Liga Indonesia in 1995, and 5 Perserikatan titles.";
        String Persipura = "Persipura Jayapura, or Persipura, is an Indonesian football club based in Jayapura, Papua. The club was founded in 1963 and currently competes in the Liga 1. Persipura plays their home matches in Mandala Stadium. Persipura is one of the giants of modern football in Indonesia with various league and tournament titles. Persipura is also known as the producer of great footballers from the land of Papua such as Rully Nere, Jack Komboy, Eduard Ivakdalam, Boaz Solossa, Ian Louis Kabes and Imanuel Wanggai. They are known for playing style relying on the abilities of individual players.";
        String Psm = "PSM Makassar, or PSM, is an Indonesian professional football club based in Makassar, South Sulawesi. The club was founded in 1915 (as Makassar Voetbal Bond) and currently competes in the Liga 1. Locally, it is known primarily by the nickname Juku Eja, which translates to The Red Fish.PSM plays their home matches in Andi Mattalatta Stadium.\n" +
                "PSM is the oldest team in the history of Indonesian football. They are also considered as one of the most successful clubs in Indonesia. In the 2001 season, they became the second Indonesia club side to reach quarter-final in the Asian Club Championship.";
        String Psms = "Persatuan Sepakbola Medan dan Sekitarnya, commonly known as PSMS Medan, or PSMS, is an Indonesian football club based in Medan, North Sumatra, Indonesia It is one of Indonesia's most successful clubs. PSMS now plays in Liga 1, the highest level in Indonesian football tier.";
        String Bali = "Bali United Football Club is a professional football club based in Gianyar Regency, Bali, Indonesia that competes in Liga 1, an official competition that replaced Indonesia Super League.[3] Nicknamed Serdadu Tridatu (Tridatu Warriors),[4] the club was founded as Putra Samarinda in 1989, changed its name to Bali United in 2015, and moved its current stadium to Kapten I Wayan Dipta Stadium in the same year.";
        String Persebaya = "Persebaya (abbreviation for Persatuan Sepakbola Surabaya, literally translated to Football Association of Surabaya), is an Indonesian professional football club based in Surabaya, East Java. It plays in Liga 1.";

        listTim.addLast(new MainModel("Persib Bandung", "Bandung, Jawa Barat", Persib, R.drawable.persib));
        listTim.addLast(new MainModel("Persipura Jayapura","Papua, Jayapura ", Persipura, R.drawable.persipura));
        listTim.addLast(new MainModel("Psm Makasar","Makasar, Sulawesi Selatan", Psm, R.drawable.psm));
        listTim.addLast(new MainModel("Psms Medan","Medan, Sumatra Utara", Psms, R.drawable.psms));
        listTim.addLast(new MainModel("Bali United","Bali, Denpasar", Bali, R.drawable.bali));
        listTim.addLast(new MainModel("Persebaya Surabaya","Surabaya, Jawa Timur", Persebaya, R.drawable.persebaya));

        recyclerView = findViewById(R.id.rvList_tim);
        mainAdapter = new MainAdapter(MainActivity.this,listTim);
        recyclerView.setAdapter(mainAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void changeLanguage() {
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.item, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.profile:
                startActivity(new Intent(MainActivity.this, ProfileActivity.class));
                return true;
            case R.id.gantiBahasa:
                Intent mIntent = new Intent(Settings.ACTION_LOCALE_SETTINGS);
                startActivity(mIntent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
