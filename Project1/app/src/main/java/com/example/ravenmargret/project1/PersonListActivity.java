/**
 * Created by Brenna Pavlinchak on 08/02/16.
 */

package com.example.ravenmargret.project1;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class PersonListActivity extends Activity implements View.OnClickListener, PersonListFragment.OnFragmentInteractionListener
{
    FragmentManager manager;
    String cid;
    String first;
    String last;
    Double age;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_list);

        manager = getFragmentManager();

        PersonListFragment listFragment = new PersonListFragment();
        showListFragment(listFragment);

        findViewById(R.id.addPersonButton).setOnClickListener(this);
    }

    private void showListFragment(Fragment listFrag)
    {
        manager.beginTransaction().replace(R.id.container, listFrag).commit();
    }


    @Override
    public void onClick(View v)
    {
        Intent nextActivity = new Intent(this, FormActivity.class);
        startActivityForResult(nextActivity, 27272727);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        PersonListFragment fragment = (PersonListFragment) getFragmentManager().findFragmentById(R.id.container);
        fragment.loadData();
    }

    @Override
    public void onFragmentInteraction(Form formObject)
    {
        Bundle extras = new Bundle();
        extras.putSerializable(DetailActivity.PERSONKEY, formObject);
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtras(extras);
        startActivityForResult(intent, 45454545);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_form, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_save_finished)
        {
            FormFragment fragment = (FormFragment) getFragmentManager().findFragmentById(R.id.container);
            fragment.writeNewUser(cid, first, last, age);

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
