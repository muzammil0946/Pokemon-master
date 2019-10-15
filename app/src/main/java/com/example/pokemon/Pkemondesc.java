package com.example.pokemon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class Pkemondesc extends AppCompatActivity {

    ImageView img_poke;
    TextView txt_name,txt_type,txt_ability,txt_h,txt_w,txt_desc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pkemondesc);
        img_poke = findViewById(R.id.desc_img);
        txt_name = findViewById(R.id.txt_name);
        txt_type = findViewById(R.id.txt_type);
        txt_ability = findViewById(R.id.txt_ability);
        txt_h = findViewById(R.id.txt_height);
        txt_w = findViewById(R.id.txt_weight);
        txt_desc = findViewById(R.id.txt_desc);

        Intent i = getIntent();
        Pokemon p = i.getParcelableExtra("data");

        Picasso.get().load(p.getImage()).into(img_poke);

        txt_name.setText(p.getName());
        txt_type.setText(p.getType());
        txt_ability.setText(p.getAbility());
        txt_h.setText(p.getHeight());
        txt_w.setText(p.getWeight());
        txt_desc.setText(p.getDesc());


        txt_desc.setMovementMethod(new ScrollingMovementMethod());


    }
}
