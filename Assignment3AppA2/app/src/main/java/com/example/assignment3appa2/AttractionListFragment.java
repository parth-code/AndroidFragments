package com.example.assignment3appa2;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.fragment.app.ListFragment;

import java.util.Arrays;

public class AttractionListFragment extends ListFragment {
    private ListSelectionListener listSelectionListener = null;
    static final String OLD_POS = "old_position";
    Integer old_position_index = null;
    String[] attractionTitlesArray = Arrays.copyOf(DataMap.attractionWebMap.keySet().toArray(), DataMap.attractionWebMap.size(), String[].class);

    public interface ListSelectionListener {
        public void onListSelection(int index);
    }

    /*
        User selects item from list
         */
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        getListView().setItemChecked(position, true);
        listSelectionListener.onListSelection(position);
    }
    /*
    When attached to the activity
     */
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            listSelectionListener = (ListSelectionListener) context;
        } catch (ClassCastException cce){
            throw new ClassCastException();
        }
    }
    /*
    When created. Comes after onAttach
     */
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        setListAdapter(new ArrayAdapter<String>(getActivity(), R.layout.list_item_single, attractionTitlesArray));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View previous_view = super.onCreateView(inflater, container, savedInstanceState);
        if(savedInstanceState != null){
            old_position_index = savedInstanceState.getInt(OLD_POS);
        } else {
            old_position_index = null;
        }
        return previous_view;
    }

    @Override
    public void onStart() {
        super.onStart();
        if(old_position_index != null){
            int get_old_index = old_position_index;
            getListView().setSelection(get_old_index);
            listSelectionListener.onListSelection(get_old_index);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    public void onSaveInstanceState(Bundle bundle){
        int position = 1;
        position = getListView().getSelectedItemPosition();
        if(position == AdapterView.INVALID_POSITION) return;
        bundle.putInt(OLD_POS, position);
    }
}
