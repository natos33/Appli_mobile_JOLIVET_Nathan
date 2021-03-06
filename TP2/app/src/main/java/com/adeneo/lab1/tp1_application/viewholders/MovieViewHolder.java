package com.adeneo.lab1.tp1_application.viewholders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.adeneo.lab1.tp1_application.R;
import com.adeneo.lab1.tp1_application.objects.Cell;

public class MovieViewHolder extends CellViewHolder{

    private ImageView imageMovie;
    private TextView titleMovie;
    private TextView descriptionMovie;

    public MovieViewHolder(@NonNull View itemView) {
        super(itemView);
        imageMovie = itemView.findViewById(R.id.imageMovie);
        titleMovie = itemView.findViewById(R.id.titleMovie);
        descriptionMovie = itemView.findViewById(R.id.descriptionMovie);
    }

    @Override
    public void layoutForCell(Cell cell) {
        if(imageMovie != null){
            imageMovie.setImageResource(R.drawable.fastandfurious8);
        }
        if(titleMovie != null){
            titleMovie.setText(cell.getTitre());
        }
        if(descriptionMovie != null){
            descriptionMovie.setText(cell.getDescription());
        }
    }


}
