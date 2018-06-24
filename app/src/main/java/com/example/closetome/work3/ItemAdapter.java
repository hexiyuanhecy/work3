package com.example.closetome.work3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Close to me on 2018/6/22.
 */

public class ItemAdapter extends ArrayAdapter<Item>{

    private  int resourceId;
    public  ItemAdapter(Context context, int textViewResourceId, List<Item> objects){
        super(context,textViewResourceId,objects);
        resourceId = textViewResourceId;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Item item=getItem(position);    //获取当前item实例
        View view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);

        TextView data = (TextView)view.findViewById(R.id.content_text);
        TextView tag = (TextView)view.findViewById(R.id.tag_1);
        ImageView image1 = (ImageView)view.findViewById(R.id.pic_1);

        data.setText(item.getData());
        tag.setText(item.getTag());
        image1.setImageResource(item.getItemID());
        return view;

    }
}
