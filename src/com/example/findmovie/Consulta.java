
package com.example.findmovie;

import android.os.AsyncTask;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;

public class Consulta extends AsyncTask<String, Void, Boolean> {
    HttpResponse resposta = null;
    BufferedReader br = null;
    StringBuffer sb = null;
    String URL = "";

    @Override
    protected Boolean doInBackground(final String... params) {
        String linha = "";
        Boolean Erro = true;

        if (params.length > 0) {
            try {

                final HttpClient client = new DefaultHttpClient();
                final HttpGet requisicao = new HttpGet();
                requisicao.setHeader("Content-Type",
                        "text/plain; charset=utf-8");
                requisicao.setURI(new URI(URL));
                resposta = client.execute(requisicao);
                br = new BufferedReader(new InputStreamReader(
                        resposta.getEntity().getContent()));
                sb = new StringBuffer("");

                while ((linha = br.readLine()) != null) {
                    sb.append(linha);
                }

                br.close();

                linha = sb.toString();
                Erro = false;

            } catch (final Exception e) {
                Erro = true;
            }
        }

        return Erro;
    }

    public StringBuffer getResponse() {
        return sb;
    }

    public void setURL(final String url) {
        URL = url;
    }
}
