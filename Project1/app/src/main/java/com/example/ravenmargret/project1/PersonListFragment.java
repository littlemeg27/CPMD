/**
 * Created by Brenna Pavlinchak on 08/02/16.
 */

package com.example.ravenmargret.project1;

import android.app.Activity;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class PersonListFragment extends ListFragment
{
    private OnFragmentInteractionListener mListener;
    ArrayList<Form> formObject;

    public PersonListFragment()
    {

    }

    @Override
    public void onAttach(Activity activity)
    {
        super.onAttach(activity);

        try
        {
            mListener = (OnFragmentInteractionListener) activity;
        }
        catch (ClassCastException e)
        {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
        
        if(formObject == null)
        {
            Toast.makeText(getActivity(), "The list is empty", Toast.LENGTH_LONG).show();
        }
        else
        {
            loadData();
        }

    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id)
    {
        super.onListItemClick(l, v, position, id);
        Form f = (Form) getListAdapter().getItem(position);
        mListener.onFragmentInteraction(f);
    }

    public void loadData()
    {
        formObject = FormUtil.load(getActivity());
        ArrayAdapter<Form> formArrayAdapter = new ArrayAdapter<Form>(getActivity(), android.R.layout.simple_list_item_1, formObject);
        setListAdapter(formArrayAdapter);
    }

    public interface OnFragmentInteractionListener //This method transfers data to the other fragment
    {
        // TODO: Update argument type and name
        void onFragmentInteraction(Form formObject);
    }
}
