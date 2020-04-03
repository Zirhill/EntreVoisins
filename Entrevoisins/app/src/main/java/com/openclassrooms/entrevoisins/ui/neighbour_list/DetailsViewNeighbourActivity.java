package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.model.Neighbour;

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
    FloatingActionButton favorisButton;

    @BindView(R.id.photo_profil)
    ImageView photo_profil;

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
                if( neighbour.getFavoris()==true){
                    neighbour.setFavoris(false);

                }
                else { neighbour.setFavoris(true);

                }






            }
        });
    }




}
