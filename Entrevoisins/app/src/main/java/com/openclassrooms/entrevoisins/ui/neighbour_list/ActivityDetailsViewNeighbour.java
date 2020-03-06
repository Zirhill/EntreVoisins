package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.openclassrooms.entrevoisins.R;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;

import butterknife.BindView;

public class ActivityDetailsViewNeighbour extends AppCompatActivity {

    //private String nom;
    private TextView nameTv, adresse_tv, phone_tv, mail_tv, apropos_tv;
    private ImageView photo_profil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_view_neighbour);


        nameTv = findViewById(R.id.textView_name);
        adresse_tv = findViewById(R.id.adresse_tv);
        phone_tv = findViewById(R.id.phone_tv);
        mail_tv = findViewById(R.id.mail_tv);
        apropos_tv = findViewById(R.id.apropos_tv);
        photo_profil = findViewById(R.id.photo_profil);


        String name = (String) getIntent().getExtras().get("passName");
        String adress = (String) getIntent().getExtras().get("passAdress");
        String phone = (String) getIntent().getExtras().get("passPhone");
        String mail = (String) getIntent().getExtras().get("passName");
        String apropos = (String) getIntent().getExtras().get("passApropos");
        String photo = (String) getIntent().getExtras().get("passPhoto");



        nameTv.setText(name);
        adresse_tv.setText(adress);
        phone_tv.setText(phone);
        mail_tv.setText("www.facebook.fr/" + name);
        apropos_tv.setText(apropos);
        //photo_profil.setImageURI(Uri.parse(photo));
        //photo_profil.setImageBitmap(getBitmapFromURL(photo));
    }

   /* public static Bitmap getBitmapFromURL(String src) {
        try {
            Log.e("src",src);
            URL url = new URL(src);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input = connection.getInputStream();
            Bitmap myBitmap = BitmapFactory.decodeStream(input);
            Log.e("Bitmap","returned");
            return myBitmap;
        } catch (IOException e) {
            e.printStackTrace();
            Log.e("Exception",e.getMessage());
            return null;
        }
    }*/
}
