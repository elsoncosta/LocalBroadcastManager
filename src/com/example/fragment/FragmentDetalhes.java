package com.example.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockFragment;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.example.bean.PessoaBean;
import com.example.interfaces.Pessoa;
import com.example.interfaces.PessoaSelecionadaContextDelegate;
import com.example.localbroadcastmanager.PessoaBroadCastReceiver;
import com.example.localbroadcastmanager.R;

public class FragmentDetalhes extends SherlockFragment implements PessoaSelecionadaContextDelegate
{
	Pessoa pessoaBroadCastReceiver;	
	SherlockFragmentActivity activity;
	TextView textViewNome, textViewEnd, textViewTelefone;
	PessoaBean bean;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) 
	{
		View view = inflater.inflate(R.layout.rown_detalhes, container, false);
		
		carregaComponetes(view);
		
		if (bean != null) 
		{
			textViewEnd.setText(bean.getEndereco().toString());
			textViewNome.setText(bean.getNome().toString());
			textViewTelefone.setText(Integer.toString(bean.getTelefone()));
		}		
		
		pessoaBroadCastReceiver = (PessoaBroadCastReceiver) PessoaBroadCastReceiver.registraObservador(this);
		
		activity = getSherlockActivity();
		
		return view;
	}

	@Override
	public void PessoaBeanSelected(PessoaBean valor) 
	{
		Toast.makeText(activity, valor.getNome(),Toast.LENGTH_SHORT).show();
		pessoaBroadCastReceiver.unregister(activity);
		bean = valor;
	}
	
	
	
	@Override
	public void onDestroyView() 
	{
		super.onDestroyView();
//		pessoaBroadCastReceiver.unregister(getActivity());
	}

	@Override
	public Context getContext() 
	{
		return getSherlockActivity();
	}
	
	private void carregaComponetes(View view) 
	{
		textViewEnd = (TextView) view.findViewById(R.id.textViewEnd);
		textViewTelefone = (TextView) view.findViewById(R.id.textViewTelef);
		textViewNome = (TextView) view.findViewById(R.id.textViewNome);
	}
}
