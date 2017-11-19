package com.kenjin.hotelapp.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.ListView;

import com.kenjin.hotelapp.PreviewActivity;
import com.kenjin.hotelapp.R;

import java.util.Comparator;

/**
 * A simple {@link Fragment} subclass.
 */
public class tab3Fragment extends Fragment {
    private ListView lvItem;
    private String[] kelengkapan = new String[]{"Bantal", "Kasur Double", "TV", "Kulkas", "Almari",
            "Shower", "Internet" };/**/

    public tab3Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_tab3, container, false);
        lvItem = (ListView) view.findViewById(R.id.lv_item);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(((PreviewActivity) getActivity()), android.R.layout.simple_list_item_checked, kelengkapan);
        adapter1.sort(new Comparator<String>() {
            @Override
            public int compare(String lhs, String rhs) {
                return lhs.compareTo(rhs);
            }
        });
        lvItem.setAdapter(adapter1);
        lvItem.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);//khusus item cheked
        lvItem.setItemChecked(0,true);
        lvItem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Toast.makeText(getApplicationContext(), typeMObil[position], Toast.LENGTH_SHORT).show();
                CheckedTextView item = (CheckedTextView) view;//khusus item checked
            }
        });
        return  view;

    }

}
