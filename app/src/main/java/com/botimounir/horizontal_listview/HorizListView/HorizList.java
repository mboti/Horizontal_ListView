package com.botimounir.horizontal_listview.HorizListView;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.botimounir.horizontal_listview.R;

import java.util.ArrayList;
import java.util.List;

public class HorizList {

    //attributs
    private Context _context;
    private RecyclerView _recyclerView;
    private HorizListAdapter _horizListAdapter;
    private List<String> _data = new ArrayList<>();


    //constructeur
    public HorizList(Context context){
        _context = context;
        init();
    }


    private void init(){
        _recyclerView = ((Activity)_context).findViewById(R.id.recycler_view);
        _horizListAdapter = new HorizListAdapter(_data,_context);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(_context, LinearLayoutManager.HORIZONTAL, false);
        _recyclerView.setLayoutManager(manager);
        _recyclerView.setAdapter(_horizListAdapter);
    }

    public void initData() {
        _data.clear();
        _data.add(" > root");
        _data.add(" > data");
        _data.add(" > folder");
        _data.add(" > mounir");
        _data.add(" > long text just for enjoy");
    }


    //getter & setter
    public RecyclerView getRecyclerView() {
        return _recyclerView;
    }
    public void setRecyclerView(RecyclerView recyclerView) {
        this._recyclerView = recyclerView;
    }

    public HorizListAdapter getHorizListAdapter() {
        return _horizListAdapter;
    }
    public void setHorizListAdapter(HorizListAdapter horizListAdapter) {
        this._horizListAdapter = horizListAdapter;
    }

    public List<String> getData() {
        return _data;
    }
    public void setData(List<String> data) {
        this._data = data;
    }
}
