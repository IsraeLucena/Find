
package com.example.findmovie;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        searchButton();
        detailsButton();
        final AdapterMovie adapter = new AdapterMovie(getApplicationContext(),
                5);

    }

    String seuparametro = "http://www.omdbapi.com/?t=";
    String seuparametro2 = "http://www.omdbapi.com/?s=";

    private void detailsButton() {
        final Button btn2 = (Button) findViewById(R.id.button2);
        btn2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(final View v) {
                try {
                    //criar nova consulta com o texto da busca
                    final Consulta consulta = new Consulta();
                    final EditText textSearch = (EditText) findViewById(R.id.editText2);
                    final String search = textSearch.getText().toString().replace(" ", "+");
                    consulta.setURL(seuparametro + search);
                    //executar a busca em asyncTask
                    consulta.execute(seuparametro);
                    //verifica se a consulta ocorreu bem
                    final Boolean Resultado = consulta.get();
                    //~~~~~//
                    final String result = consulta.getResponse().toString();
                    //printa o resultado da busca
                    System.out.println(consulta.getResponse());
                    //enviando dados para a segundaView
                    final int init = result.indexOf("Title");
                    final int fine = result.indexOf("Year");
                    final String titleValue = result.substring(init + 8, fine - 3);
                    final int init2 = result.indexOf("Poster");
                    final int fine2 = result.indexOf("Metascore");
                    final String imageValue = result.substring(init2 + 9, fine2 - 3);
                    //System.out.println("POSTER:");
                    final Intent intent = new Intent(MainActivity.this, Result.class);
                    intent.putExtra("Image", imageValue);
                    intent.putExtra("Title", titleValue);
                    startActivity(intent);

                } catch (final Exception ex) {
                    System.out.println("error details" + ex);
                }

            }

        });
    }

    private void searchButton() {
        final Button btn1 = (Button) findViewById(R.id.button1);
        btn1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(final View v) {
                try {
                    final Consulta consulta = new Consulta();
                    final EditText textSearch = (EditText) findViewById(R.id.editText1);
                    final String search = textSearch.getText().toString().replace(" ", "+");
                    consulta.setURL(seuparametro2 + search);
                    //executar a busca em asyncTask
                    consulta.execute(seuparametro);
                    //verifica se a consulta ocorreu bem
                    final Boolean Resultado = consulta.get();
                    //~~~~~//
                    //mostra o texto da busca no app
                    final TextView view1 = (TextView) findViewById(R.id.textView2);
                    view1.setMovementMethod(new ScrollingMovementMethod());
                    //                    final LayoutParams params = new TableRow.LayoutParams(10,
                    //                            10, 1f);
                    //                    view1.setLayoutParams(params);
                    final String result = consulta.getResponse().toString();
                    view1.setText(result);
                } catch (final Exception e) {
                    System.out.println("error search" + e);
                }

            }
        });
    }

}
