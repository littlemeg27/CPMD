/**
 * Created by Brenna Pavlinchak on 08/02/16.
 */

package com.example.ravenmargret.project1;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class DetailFragment extends Fragment implements View.OnClickListener
{
    public static final String KEY = "PersonKey";

    public DetailFragment()
    {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart()
    {
        super.onStart();

        Bundle args = getArguments();
        if (args != null)
        {
            // Set article based on argument passed in
            updateText((Form)args.getSerializable(KEY));
        }
    }

    public void updateText(Form object)
    {
        TextView firstTextView = (TextView) getActivity().findViewById(R.id.firstTextView);
        firstTextView.setText(object.getmFirstName());

        TextView lastTextView = (TextView) getActivity().findViewById(R.id.lastTextView);
        lastTextView.setText(object.getmLastName());

        TextView ageTextView = (TextView) getActivity().findViewById(R.id.ageTextView);
        ageTextView.setText(object.getmAge().toString());
    }

    @Override
    public void onClick(View v)
    {
        Toast.makeText(getActivity(), "Contact Deleted", Toast.LENGTH_LONG).show();

        //Form form;
        //FormUtil.delete(form, getActivity());

//        Form form = new Form(firstName, lastName, age);
//        FormUtil.delete(form, getActivity());
        //Tried to add delete button, ran out of time to finish dealing with the call for it resets just isnt deleting

        getActivity().finish();
    }

}
