package com.example.nanchen.commonadaperrecyclerdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private List<Data> list;
    private RecyclerView recyclerView;
    private BaseRecyclerAdapter<Data> adapter;
    private EditText text;

    @SuppressWarnings("unchecked")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = new ArrayList<>();

        initList();

        adapter = new BaseRecyclerAdapter<Data>(this,list,R.layout.list_item) {
            @Override
            public void convert(BaseRecyclerHolder holder, Data item, int position, boolean isScrolling) {
                holder.setText(R.id.item_text,item.getText());
                if (item.getImageUrl() != null){
                    holder.setImageByUrl(R.id.item_image,item.getImageUrl());
                }else {
                    holder.setImageResource(R.id.item_image,item.getImageId());
                }
            }

        };

        adapter.setOnItemClickListener(new BaseRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(RecyclerView parent, final View view, int position) {
                Toast.makeText(MainActivity.this, String.format(Locale.CHINA,"你点击了第%d项,长按会删除！",position),Toast.LENGTH_SHORT).show();
            }
        });

        adapter.setOnItemLongClickListener(new BaseRecyclerAdapter.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(RecyclerView parent, View view, int position) {
                adapter.delete(position);
                return true;
            }
        });

        text = (EditText) findViewById(R.id.main_text);
        recyclerView = (RecyclerView) findViewById(R.id.main_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(adapter);



    }

    public void initList(){
        for (int i = 0; i < 5; i++) {
            list.add(new Data("本地 "+i,R.mipmap.ic_launcher));
        }
        for (int i = 0; i < 5; i++) {
            list.add(new Data("网络 "+i,"http://pic.cnblogs.com/face/845964/20160301162812.png"));
        }
    }

    public void btnClick(View view) {
        String string = text.getText().toString().trim();
        Data data = new Data(string,R.mipmap.ic_launcher);
//        list.add(list.size()/2,data);
        adapter.insert(data,list.size()/2);

        Toast.makeText(MainActivity.this,list.size()+"",Toast.LENGTH_SHORT).show();
    }
}
