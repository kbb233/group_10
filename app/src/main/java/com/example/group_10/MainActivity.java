package com.example.group_10;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.group_10.Announcement.AnnouncementAdapter;
import com.example.group_10.Announcement.AnnouncementDataSource;
import com.example.group_10.Announcement.Announcement_Creation;
import com.example.group_10.Announcement.Announcement_Unit;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView mRecycleView;
    AnnouncementAdapter mAdapter;
    ArrayList<Announcement_Unit> announceList;
    private View.OnClickListener onItemClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            RecyclerView.ViewHolder viewHolder = (RecyclerView.ViewHolder) view.getTag();
            int position = viewHolder.getAdapterPosition();
            int announceId = announceList.get(position).getAnnounceId();
            Intent intent = new Intent(MainActivity.this, Announcement_Creation.class);
            intent.putExtra("announceId", announceId);
            startActivity(intent);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createAnnouncement();
    }

    public void onResume(){
        super.onResume();

        String sortBy = getSharedPreferences("MyAnnouncementListPreferences", Context.MODE_PRIVATE).getString("sortfield","time");
        String sortOrder = getSharedPreferences("MyAnnouncementListPreferences", Context.MODE_PRIVATE).getString("sortorder","DESC");
        AnnouncementDataSource ds = new AnnouncementDataSource(this);
        try{
            ds.open();
            announceList = ds.getAnnouncements(sortBy,sortOrder);
            ds.close();
            if(announceList.size()>0){
                mRecycleView = findViewById(R.id.announcement_recycle);
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
                mRecycleView.setLayoutManager(layoutManager);
                mAdapter = new AnnouncementAdapter(announceList,this);
                mAdapter.setOnItemClickListener(onItemClickListener);
                mRecycleView.setAdapter(mAdapter);
            }
        }
        catch (Exception e){

        }

    }

    public void createAnnouncement(){
        FloatingActionButton cre = findViewById(R.id.add_announcement_btn);
        cre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Announcement_Creation.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }
}