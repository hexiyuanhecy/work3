package com.example.closetome.work3;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class index extends AppCompatActivity {

    private List<Item> itemList= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.avtivity_index);

        ActionBar actionBar=getSupportActionBar();
        if(actionBar!=null){
            actionBar.hide();
        }

        initItems();    //初始化item数据
        ItemAdapter adapter = new ItemAdapter(index.this,R.layout.item,itemList);
        ListView listView = (ListView)findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
           @Override
            public void  onItemClick(AdapterView<?> parent,View view,int position,long id){
               Item item = itemList.get(position);
               Toast.makeText(index.this,"123456",Toast.LENGTH_SHORT).show();
           }
        });

        Button menu=(Button)findViewById(R.id.button_menu);
        Button plus=(Button)findViewById(R.id.button_edit);
        menu.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent=new Intent(index.this,LeftMenu.class);
                startActivity(intent);
            }
        });
        plus.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent=new Intent(index.this,Edit.class);
                startActivity(intent);
            }
        });


    }

    private void initItems() {
        for (int i=0;i<2;i++){
            Item item1=new Item("小说叙述者是个飞行员，他在故事一开始告诉读者，他在大人世界找不到一个说话投机的人，因为大人都太讲实际了。","小王子",R.drawable.first);
            itemList.add(item1);
            Item item2=new Item("接着，飞行员讲了六年前他因飞机故障迫降在撒哈拉沙漠遇见小王子故事。神秘的小王子来自另一个星球。飞行员讲了小王子和他的玫瑰的故事。小王子为什么离开自己的星球；在抵达地球之前，他又访问过哪些星球。他转述了小王子对六个星球的历险，他遇见了国王、爱虚荣的人、酒鬼、商人、点灯人、地理学家、蛇、三枚花瓣的沙漠花、玫瑰园、扳道工、商贩、狐狸以及我们的叙述者飞行员本人。","小王子2",R.drawable.second);
            itemList.add(item2);
        }
    }
}
