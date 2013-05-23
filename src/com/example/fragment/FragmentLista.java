package com.example.fragment;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.actionbarsherlock.app.SherlockFragment;
import com.example.adapter.PessoaAdapter;
import com.example.bean.PessoaBean;
import com.example.localbroadcastmanager.PessoaBroadCastReceiver;
import com.example.localbroadcastmanager.R;

public class FragmentLista extends SherlockFragment 
{

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) 
	{
		View view = inflater.inflate(R.layout.lista, container, false);
		
		ListView listview = (ListView) view.findViewById(R.id.listView1);
		
		
		listview.setAdapter(new PessoaAdapter(getActivity(), dadosPessoaBean()));
		
		listview.setOnItemClickListener(new OnItemClickListener() 
		{
			@Override
			public void onItemClick(AdapterView<?> adapter, View arg1, int posicao, long arg3) 
			{
				PessoaBean pessoaBean = (PessoaBean) adapter.getItemAtPosition(posicao);
				
				PessoaBroadCastReceiver.notifica(getActivity(), pessoaBean);
				
				getSherlockActivity().getSupportActionBar().setSelectedNavigationItem(1);
			}
		});
		
		
		return view;
	}
	
	private List<PessoaBean> dadosPessoaBean()
	{
		List<PessoaBean>beans = new ArrayList<PessoaBean>();
		
		PessoaBean bean1 = new PessoaBean();		
		bean1.setNome("Fulano de tal");
		bean1.setEndereco("Rua numero 1");
		bean1.setTelefone(123);
		
		PessoaBean bean2 = new PessoaBean();		
		bean2.setNome("Beutrano de tal");
		bean2.setEndereco("Rua numero 2");
		bean2.setTelefone(1234);
		
		PessoaBean bean3 = new PessoaBean();		
		bean3.setNome("Ultrano de tal");
		bean3.setEndereco("Rua numero 3");
		bean3.setTelefone(12345);
		
		PessoaBean bean4 = new PessoaBean();		
		bean4.setNome("Franciscano de tal");
		bean4.setEndereco("Rua numero 3");
		bean4.setTelefone(123456);
		
		beans.add(bean1);
		beans.add(bean2);
		beans.add(bean3);
		beans.add(bean4);	
		
		return beans;
	}

}
