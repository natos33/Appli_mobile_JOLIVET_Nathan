package com.adeneo.lab1.tp1_application.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.adeneo.lab1.tp1_application.R;
import com.adeneo.lab1.tp1_application.adapters.CellAdapter;
import com.adeneo.lab1.tp1_application.objects.Cell;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CellsActivity extends AppCompatActivity implements View.OnClickListener{

    private RecyclerView movies_recyclerView;
    private List<Cell> movies = new ArrayList<>();

    private ImageView btn_close;
    private LinearLayout btn_back;
    private LinearLayout buttonMovie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);

        btn_close = findViewById(R.id.btn_close);
        btn_close.setOnClickListener(this);

        btn_back = findViewById(R.id.btn_back);
        btn_back.setOnClickListener(this);
/*
        buttonMovie = findViewById(R.id.buttonMovie);
        buttonMovie.setOnClickListener(this);
*/
        movies_recyclerView = findViewById(R.id.movies_recyclerView);
        CellAdapter cellAdapter = new CellAdapter();
        movies_recyclerView.setAdapter(cellAdapter);
        movies_recyclerView.setLayoutManager(new LinearLayoutManager(this));

        movies.add(new Cell("Fast and furious 8", "petit film sympa, un peu d'action donc pas degueu", "fastandfurious8", Cell.CellType.MOVIE));
        movies.add(new Cell("Star wars 10", "petit film sympa, un peu d'action donc pas degueu", "fastandfurious8", Cell.CellType.MOVIE));
        movies.add(new Cell("Avengers, la guerre de l'infiny (lol)", "petit film sympa, un peu d'action donc pas degueu", "fastandfurious8", Cell.CellType.MOVIE));
        movies.add(new Cell("Babysitting", "petit film sympa, un peu d'action donc pas degueu", "fastandfurious8", Cell.CellType.MOVIE));
        movies.add(new Cell("Cringe", "petit film sympa, un peu d'action donc pas degueu", "fastandfurious8", Cell.CellType.MOVIE));
        movies.add(new Cell("Zoe la nerveuse", "petit film sympa, un peu d'action donc pas degueu", "fastandfurious8", Cell.CellType.MOVIE));
        movies.add(new Cell("Bananasplit", "petit film sympa, un peu d'action donc pas degueu", "fastandfurious8", Cell.CellType.MOVIE));

        this.triListFilm();



        cellAdapter.setCells(movies);
        cellAdapter.notifyDataSetChanged();





    }

    public void triListFilm(){
        movies = movies.stream().sorted(( Comparator.comparing(Cell::getTitre))).collect(Collectors.toList());
        int nbFilms = 0;

        Cell header = new Cell(movies.get(0).getTitre().substring(0,1), null, null, Cell.CellType.HEADER);
        movies.add(0,header);
        nbFilms++;

        for(int i = 2; i<movies.size(); i++){
            if(!movies.get(i).getTitre().substring(0,1).equals(header.getTitre())){

                Cell footer = new Cell(nbFilms + " films", null, null, Cell.CellType.FOOTER);
                nbFilms = 0;

                movies.add(i, footer);
                i++;

                header = new Cell(movies.get(i).getTitre().substring(0,1), null, null, Cell.CellType.HEADER);
                movies.add(i, header);
                i++;
            }
            nbFilms++;

        }
        Cell footer = new Cell(nbFilms + " films", null, null, Cell.CellType.FOOTER);
        movies.add(footer);
    }

    @Override
    public void onClick(View v) {
        if (v.equals(btn_close)) {
            CellsActivity.this.finish();
        }

        if(v.equals(btn_back)){
            Intent intent = new Intent(CellsActivity.this, CategoriesActivity.class);
            startActivity(intent);
        }
/*
        if(v.equals(buttonMovie)){
            Intent intent = new Intent(CellsActivity.this, MainActivity.class);
            startActivity(intent);
        }
*/
    }

}
