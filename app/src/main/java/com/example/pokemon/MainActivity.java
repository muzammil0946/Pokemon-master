package com.example.pokemon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {


    Mylistadapter adapt;

    ListView lst;
    ArrayList<Pokemon> pokelst;
    ProgressBar progs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lst = findViewById(R.id.poke_lst);
        progs = findViewById(R.id.progs);

        pokelst = new ArrayList<>();
           //String link = "https://api.myjson.com/bins/8aje7";
           String link = "// https://www.superheroapi.com/api.php/2595629903847437/6";
        try {


           // progs.setVisibility(View.VISIBLE);
            String data = new Asycdata(MainActivity.this).execute(link).get();
            System.out.println("This is from Main Activity :"+data);


            JSONObject mainobj = new JSONObject(data);
            JSONArray pokearray = mainobj.getJSONArray("Pokemon");

            for (int i=0;i<pokearray.length();i++)
            {
                JSONObject child = pokearray.getJSONObject(i);

                String img = child.getString("image");
                String name = child.getString("name");
                String type = child.getString("type");
                String ability = child.getString("ability");
                String height = child.getString("height");
                String weight = child.getString("weight");
                String desc = child.getString("description");

                String keyname = child.toString();


                pokelst.add(new Pokemon(name,img,type,ability,height,weight,desc));
            }

            adapt = new Mylistadapter(getApplication(),pokelst);

            lst.setAdapter(adapt);

            lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    Intent i = new Intent(MainActivity.this,Pkemondesc.class);
                    i.putExtra("data",pokelst.get(position));
                    startActivity(i);

                }
            });


        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }
}
