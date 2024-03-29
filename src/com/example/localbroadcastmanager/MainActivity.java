package com.example.localbroadcastmanager;

import android.os.Bundle;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.ActionBar.Tab;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.example.fragment.FragmentDetalhes;
import com.example.fragment.FragmentLista;
import com.example.fragment.TabFragmentListener;

public class MainActivity extends SherlockFragmentActivity {

	int tabIdx = 0;
	
    @Override
	public boolean onCreateOptionsMenu(com.actionbarsherlock.view.Menu menu) {
    	getSupportMenuInflater().inflate(R.menu.activity_main, menu);    	
		return super.onCreateOptionsMenu(menu);
	}

	@Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        actionBar.setDisplayShowTitleEnabled(false);
        
        Tab tabLista = actionBar.newTab().setText("Lista");
        tabLista.setTabListener(new TabFragmentListener(this, new FragmentLista()));
        
        
        Tab tabDetalhes = actionBar.newTab().setText("Detalhes");
        tabDetalhes.setTabListener(new TabFragmentListener(this, new FragmentDetalhes()));
        
        actionBar.addTab(tabLista);
        actionBar.addTab(tabDetalhes);
        
        if (savedInstanceState != null) 
        {
	        tabIdx = savedInstanceState.getInt("tabIdx");
	        actionBar.setSelectedNavigationItem(tabIdx);
        }
        else
        {
            actionBar.setSelectedNavigationItem(tabIdx);
        }
    } 
	
	@Override
    protected void onSaveInstanceState(Bundle outState) 
	{
        super.onSaveInstanceState(outState);    
        tabIdx = getSupportActionBar().getSelectedNavigationIndex();
        outState.putInt("tabIdx", tabIdx);
	}   
}
