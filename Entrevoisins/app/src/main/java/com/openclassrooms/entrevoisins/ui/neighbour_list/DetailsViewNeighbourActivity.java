package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.service.NeighbourApiService;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailsViewNeighbourActivity extends AppCompatActivity {


    @BindView(R.id.textView_name)
    TextView nameTv;
    @BindView(R.id.adresse_tv)
    TextView adresseTv;
    @BindView(R.id.phone_tv)
    TextView phoneTv;
    @BindView(R.id.mail_tv)
    TextView mailTv;
    @BindView(R.id.apropos_tv)
    TextView aproposTv;
    @BindView(R.id.name_white)
    TextView nameWhite;

    @BindView(R.id.favoris_button)
    ImageButton favorisButton;

    /*@BindView(R.id.btn_retour)
    ImageButton buttonRetour;*/

    @BindView(R.id.photo_profil)
    ImageView photo_profil;

    private NeighbourApiService mApiService;
    private static final String KEY_NEIGHBOUR = "KEY_NEIGHBOUR";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_view_neighbour);
        ButterKnife.bind(this);

        Neighbour neighbour;
        neighbour = getIntent().getParcelableExtra(KEY_NEIGHBOUR);

        nameWhite.setText(neighbour.getName());
        nameTv.setText(neighbour.getName());
        adresseTv.setText(neighbour.getAddress());
        phoneTv.setText(neighbour.getPhoneNumber());
        mailTv.setText("www.facebook.fr/" + (neighbour.getName()));
        aproposTv.setText((neighbour.getAboutMe()));
        Glide.with(this).load(neighbour.getAvatarUrl()).into(photo_profil);



        favorisButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Neighbour neighour = new Neighbour();

                if( neighbour.getFavoris()==true){
                    neighbour.setFavoris(false);
                    favorisButton.setImageResource(R.drawable.ic_star_white_24dp);

                }
                else { neighbour.setFavoris(true);
                    favorisButton.setImageResource(R.drawable.ic_star_border_white_24dp);
                }

            }
        });

       /* buttonRetour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mApiService.addNeighbourToFavorite(neighbour);

            }
        });
        */

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home : {
                //mApiService.addNeighbourToFavorite(neighbour);

                finish();
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }


}
