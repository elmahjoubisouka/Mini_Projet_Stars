package com.example.tp_star;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.tp_star.adapter.StarAdapter;
import com.example.tp_star.beans.Star;
import com.example.tp_star.service.StarService;

public class ListActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private StarAdapter starAdapter;
    private StarService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        recyclerView = findViewById(R.id.recycle_view);
        service = StarService.getInstance();
        initStars();

        starAdapter = new StarAdapter(this, service.findAll());
        recyclerView.setAdapter(starAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        setSupportActionBar(findViewById(R.id.toolbar)); // Configure la toolbar
    }

    private void initStars() {
        service.create(new Star("Johny Deep", R.drawable.deep, 3.5f));
        service.create(new Star("Angelina Jolie", R.drawable.angelena, 4));
        service.create(new Star("Daniel Radcliffe", R.drawable.harry_potter, 5));
        service.create(new Star("Emma Watson", R.drawable.emma_w, 3.5f));
        service.create(new Star("Robert Pattinson", R.drawable.file, 4));
        service.create(new Star("Brad Pitt", R.drawable.pett, 5));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu); // Assurez-vous que le bon menu est chargé

        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) searchItem.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                starAdapter.filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                starAdapter.filter(newText);
                return false;
            }
        });

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_share) {
            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            shareIntent.putExtra(Intent.EXTRA_TEXT, "Découvrez notre liste de stars !");
            startActivity(Intent.createChooser(shareIntent, "Partager via"));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
