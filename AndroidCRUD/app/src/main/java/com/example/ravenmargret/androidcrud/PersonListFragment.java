package com.example.ravenmargret.androidcrud;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ravenmargret.androidcrud.dummy.DummyContent;
import com.example.ravenmargret.androidcrud.dummy.DummyContent.DummyItem;

import java.util.List;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class PersonListFragment extends Fragment {

    private OnListFragmentInteractionListener mListener;
    private DatabaseReference androidFormDatabase;

    public PersonListFragment()
    {

    }

    @Override
    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        androidFormDatabase = FirebaseDatabase.getInstance().getReference();

        try
        {
            mListener = (OnListFragmentInteractionListener) activity;
        }
        catch (ClassCastException e)
        {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

//    @Override
//    public void onActivityCreated(Bundle savedInstanceState)
//    {
//        super.onActivityCreated(savedInstanceState);
//
//        if(formObject == null)
//        {
//            loadData();
//        }
//        else
//        {
//            Toast.makeText(getActivity(), "The list is empty", Toast.LENGTH_LONG).show();
//        }
//    }
//
//    @Override
//    public void onResume()
//    {
//        loadData();
//        super.onResume();
//    }
//
//    @Override
//    public void onListItemClick(ListView l, View v, int position, long id)
//    {
//        super.onListItemClick(l, v, position, id);
//        Form f = (Form) l.getAdapter().getItem(position);
//        mListener.onFragmentInteraction(f);
//    }
//
//    public void loadData()
//    {
//        formObject = FormUtil.load(getActivity());
//        ArrayAdapter<Form> formArrayAdapter = new ArrayAdapter<Form>(getActivity(), android.R.layout.simple_list_item_1, formObject);
//        setListAdapter(formArrayAdapter);
//    }

    public interface OnListFragmentInteractionListener
    {
        // TODO: Update argument type and name
        //void onListFragmentInteraction(DummyItem item);
    }
}
