package com.example.projectmusic;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;

public class SearchViewActivity extends AppCompatActivity {
    private SearchView mSearchView =null;
    private ListView mListView = null;
    private String[] mDatas ={"aaa","bbb","ccc","android"};

    protected  void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSearchView = (SearchView) findViewById(R.id.searchView);
        mListView  =(ListView) findViewById(R.id.listview2);
        mListView.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,mDatas));
        mListView.setTextFilterEnabled(true);
        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (!TextUtils.isEmpty(newText)){
                    mListView.setFilterText(newText);
                }
                else{
                    mListView.clearTextFilter();
                }
                return false;
            }
        });

    }

}

