package com.example.localbroadcastmanager;



import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

import com.actionbarsherlock.app.ActionBar.Tab;
import com.actionbarsherlock.app.ActionBar.TabListener;
import com.actionbarsherlock.app.SherlockFragmentActivity;



public class TabFragmentListener implements TabListener
{
	private Fragment fragment;
    private SherlockFragmentActivity activity;

    public TabFragmentListener(SherlockFragmentActivity activity, Fragment fragment) 
    {
            this.activity = activity;
            this.fragment = fragment;
    }

    @Override
    public void onTabSelected(Tab tab, FragmentTransaction ft) 
    {
        if(activity.getSupportFragmentManager().findFragmentByTag(fragment.getClass().getName())==null){
            ft.add(R.id.content_frame,fragment, fragment.getClass().getName());             
	    }else{
	            
	            fragment = activity.getSupportFragmentManager().findFragmentByTag(fragment.getClass().getName());
	            ft.attach(fragment);
	    }
    }

    @Override
    public void onTabUnselected(Tab tab, FragmentTransaction ft) 
    {
    	if(activity.getSupportFragmentManager().findFragmentByTag(fragment.getClass().getName())!=null) 
        {
                ft.remove(fragment);
        }
    }

    @Override
    public void onTabReselected(Tab tab, FragmentTransaction ft) {

    }
}
