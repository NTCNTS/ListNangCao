package com.example.linh2050531200221_listnangcao;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvGame;
    ArrayList<Game> arrayGame;
    GameAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();

        adapter=new GameAdapter(this, R.layout.dong_game, arrayGame);
        lvGame.setAdapter(adapter);

        lvGame.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==0){
                    startActivity(new Intent(MainActivity.this,pubg.class));
                }else if(i==1){
                    startActivity(new Intent(MainActivity.this,csgo.class));
                }else if(i==2) {
                    startActivity(new Intent(MainActivity.this, lol.class));
                }else if(i==3) {
                    startActivity(new Intent(MainActivity.this, gta5.class));
                }else if(i==4) {
                    startActivity(new Intent(MainActivity.this, dota2.class));
                } else{

                }
            }
        });
        lvGame.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                XacNhanXoa(i);

                return false;
            }
        });

    }
    private void XacNhanXoa(final int position){
        AlertDialog.Builder alertDialog= new AlertDialog.Builder(this);
        alertDialog.setMessage("Ban co chac muon xoa khong");

        alertDialog.setPositiveButton("Co", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            arrayGame.remove(position);
            adapter.notifyDataSetChanged();
            }
        });

        alertDialog.setNegativeButton("Khong", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        alertDialog.show();
    }
    private void AnhXa(){
        lvGame=(ListView) findViewById(R.id.listviewGame);
        arrayGame= new ArrayList<>();
        arrayGame.add(new Game("Pubg", "Game Sinh Ton","15$",R.drawable.pubg));
        arrayGame.add(new Game("Csgo", "Game ban sung","7$",R.drawable.csgo));
        arrayGame.add(new Game("LOL", "Game Moba","Free",R.drawable.lol));
        arrayGame.add(new Game("Gta V", "Game Role Play","25$",R.drawable.gta5));
        arrayGame.add(new Game("Dota2", "Game Moba","Free",R.drawable.dota2));
    }

}