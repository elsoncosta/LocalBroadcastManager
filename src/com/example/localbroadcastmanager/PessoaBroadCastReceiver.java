package com.example.localbroadcastmanager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;

import com.example.bean.PessoaBean;
import com.example.interfaces.Pessoa;
import com.example.interfaces.PessoaSelecionadaContextDelegate;
import com.example.interfaces.PessoaSelecionadaDelegate;

public class PessoaBroadCastReceiver extends BroadcastReceiver implements Pessoa {
	
	private static String PESSOABEAN = "pessoa_bean";
	private static String PESSOA = "pessoa";

	public static Pessoa registraObservador(PessoaSelecionadaDelegate delegate,	Context context) 
	{
		PessoaBroadCastReceiver receiver = new PessoaBroadCastReceiver();
		receiver.delegate = delegate;

		LocalBroadcastManager.getInstance(context).registerReceiver(receiver, new IntentFilter(PESSOABEAN));

		return receiver;
	}

	public static Pessoa registraObservador(PessoaSelecionadaContextDelegate delegate) 
	{
		return registraObservador(delegate, delegate.getContext());
	}

	public static void notifica(Context context, PessoaBean pessoaBean) 
	{
		Intent intent = new Intent(PESSOABEAN);
		
		intent.putExtra(PESSOA, pessoaBean);
		
		LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
	}

	private PessoaSelecionadaDelegate delegate;

	@Override
	public void onReceive(Context context, Intent intent) 
	{
		delegate.PessoaBeanSelected((PessoaBean) intent.getSerializableExtra(PESSOA));
	}

	@Override
	public void unregister(Context context) {
		LocalBroadcastManager.getInstance(context).unregisterReceiver(this);
	}
}