package com.example.closetome.work3;

/**
 * Created by Close to me on 2018/6/22.
 */

public class Item {
    private  String data;
    private  String tag;
    private  int itemID;

    public Item(String data,String tag,int itemID){
        this.data=data;
        this.tag=tag;
        this.itemID=itemID;
    }

    public  String getTag(){
        return tag;
    }

    public  int getItemID(){
        return itemID;
    }

    public  String getData(){
        return data;
    }
}
