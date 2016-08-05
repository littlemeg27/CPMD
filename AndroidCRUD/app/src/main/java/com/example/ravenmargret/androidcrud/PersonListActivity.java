package com.example.ravenmargret.androidcrud;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class PersonListActivity extends AppCompatActivity implements PersonListFragment.OnListFragmentInteractionListener
{
    FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_list);

//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        manager = getFragmentManager();

        PersonListFragment personListFragment = new PersonListFragment();
        showFragment(personListFragment);
    }

    private void showFragment(Fragment personFrag)
    {
        manager.beginTransaction().replace(R.id.container, personFrag, "personFrag").commit();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        PersonListFragment personListFragment = (PersonListFragment)getFragmentManager().findFragmentById(R.id.container);
    }

//    @Override
//    public void onFragmentInteraction(Form formObject)
//    {
//        Bundle extras = new Bundle();
//        extras.putSerializable(DetailActivity.PERSONKEY, formObject);
//        Intent intent = new Intent(this, DetailActivity.class);
//        intent.putExtras(extras);
//        startActivityForResult(intent, 45454545);
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_personlist, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_add)
        {
            Intent nextActivity = new Intent(this, FormActivity.class);
            startActivityForResult(nextActivity, 2727);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
