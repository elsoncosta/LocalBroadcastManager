package com.example.adapter;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.bean.PessoaBean;
import com.example.localbroadcastmanager.R;


public class PessoaAdapter extends BaseAdapter {

	Activity activity;
	List<PessoaBean> Lista;
	LayoutInflater inflater;
	TextView textViewNome, textViewEnd, textViewTelefone;
	
	public PessoaAdapter(Activity activity, List<PessoaBean> Lista) 
	{
		this.Lista = Lista;
		this.activity = activity;
		this.inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public int getCount() 
	{
		return Lista.size();
	}

	@Override
	public Object getItem(int arg0) 
	{
		return Lista.get(arg0);
	}

	@Override
	public long getItemId(int arg0) 
	{
		return arg0;
	}

	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) 
	{
		View view = inflater.inflate(R.layout.rown_detalhes, null);
		
		PessoaBean bean = Lista.get(arg0);
		
		carregaComponetes(view);
		
		textViewEnd.setText(bean.getEndereco().toString());
		textViewNome.setText(bean.getNome().toString());
		textViewTelefone.setText(Integer.toString(bean.getTelefone()));
		
		return view;
	}

	private void carregaComponetes(View view) 
	{
		textViewEnd = (TextView) view.findViewById(R.id.textViewEnd);
		textViewTelefone = (TextView) view.findViewById(R.id.textViewTelef);
		textViewNome = (TextView) view.findViewById(R.id.textViewNome);
	}

}
