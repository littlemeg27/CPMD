/**
 * Created by Brenna Pavlinchak on 11/11/15.
 */

package com.example.ravenmargret.project1;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class DetailActivity extends Activity
{
    FragmentManager manager;
    public static final String PERSONKEY = "thePersonKey";

    String cid;
    String first;
    String last;
    Double age;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        manager = getFragmentManager();

        DetailFragment detailFragment = new DetailFragment();
        showDetailFragment(detailFragment);

        Intent callingIntent = getIntent();
        Form object = (Form)callingIntent.getSerializableExtra(PERSONKEY);
//        Log.e("Intent open:", Form.object);

        Bundle args = new Bundle();
        args.putSerializable(DetailFragment.KEY, object);
        detailFragment.setArguments(args);

    }

    private void showDetailFragment(Fragment detailFrag)
    {
        manager.beginTransaction().replace(R.id.container, detailFrag).commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_detail, menu);
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
        if (id == R.id.actio2n_delete)
        {
            FormFragment fragment = (FormFragment) getFragmentManager().findFragmentById(R.id.container);
            fragment.writeNewUser(cid, first, last, age);

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
