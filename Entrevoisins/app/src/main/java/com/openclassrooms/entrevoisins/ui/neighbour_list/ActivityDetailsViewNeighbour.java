package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.openclassrooms.entrevoisins.R;

import butterknife.BindView;

public class activity_details_view_neighbour extends AppCompatActivity {

    private String nom;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_details_view_neighbour);

        Intent intent = new Intent(this, activity_details_view_neighbour.class);
                TextView nom = findViewById(R.id.textView_name);

                String nameTv = nom.getText().toString();
                intent.putExtra(Intent.EXTRA_COMPONENT_NAME, nameTv);


    }
}
