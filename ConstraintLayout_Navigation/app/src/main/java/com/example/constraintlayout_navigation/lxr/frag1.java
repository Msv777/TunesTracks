package com.example.constraintlayout_navigation.lxr;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.constraintlayout_navigation.MainActivity;
import com.example.constraintlayout_navigation.R;

import java.util.stream.IntStream;

public class frag1 extends Fragment {
    private View view;
    public String[] name={"DOTA2", "Default Theme",
            "select in TI",
            "MEDIC",
            "reborn",
            "hero select",
            "Main Theme",
            "Spoils of wars",
            "starts up 2016",
            "More gun",
            "called to Arms",
            "prehorn"       };
    public static int[] icons={R.drawable.glist_dota2,R.drawable.glist_dota2,R.drawable.glist_dota2,R.drawable.glist_dota2,
            R.drawable.glist_dota2,R.drawable.glist_dota2,R.drawable.glist_dota2,R.drawable.glist_dota2,R.drawable.glist_dota2,R.drawable.glist_dota2,
            R.drawable.glist_dota2,R.drawable.glist_dota2,R.drawable.glist_dota2,R.drawable.glist_dota2,R.drawable.glist_dota2,R.drawable.glist_dota2};
    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        view=inflater.inflate(R.layout.music_list,null);
        final MainActivity mainActivity = (MainActivity ) getActivity();
        ListView listView=view.findViewById(R.id.lv);
        MyBaseAdapter adapter=new MyBaseAdapter();
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(frag1.this.getContext(), MusicActivity.class);
                intent.putExtra("name",name[position]);
                intent.putExtra("position",String.valueOf(position));
                startActivity(intent);
            }
        });
        return view;
    }

    class MyBaseAdapter extends BaseAdapter{
        @Override
        public int getCount(){return  name.length;}
        @Override
        public Object getItem(int i){return name[i];}
        @Override
        public long getItemId(int i){return i;}

        @Override
        public View getView(int i ,View convertView, ViewGroup parent) {

            String[] ids= new String[100];
            int[] arr=new int[100];//定义一个长度为100的数组
            for (int j =0; j < arr.length; j++) {//把1~100填充进arr数组中去
                arr[j]=j+1;//arr[0]=1、arr[1]=2
            }
            for(int j = 0 ;j<100;j++)
            {
                ids[j]=arr[j]+"";
            }
            View view=View.inflate(frag1.this.getContext(),R.layout.item_layout,null);
            TextView tv_name=view.findViewById(R.id.item_name);
            TextView musicids = view.findViewById((R.id.musicids));
            ImageView iv=view.findViewById(R.id.iv);
            tv_name.setText(name[i]);
            musicids.setText(ids[i]);
//            iv.setImageResource(icons[i]);
            return view;
        }
    }

}

