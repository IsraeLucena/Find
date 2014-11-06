
package com.example.findmovie;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class AdapterMovie extends BaseAdapter {
    private final LayoutInflater mInflater;
    private final int valor;

    public AdapterMovie(final Context context, final int value) {
        valor = value;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {

        return valor;
    }

    @Override
    public Object getItem(final int position) {

        return null;
    }

    @Override
    public long getItemId(final int position) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {
        convertView = mInflater.inflate(R.layout.aluno_adapter_item, null);
        final TextView tvValor = (TextView) convertView.findViewById(R.id.valor);
        tvValor.setText(valor);

        return convertView;
    }

}
