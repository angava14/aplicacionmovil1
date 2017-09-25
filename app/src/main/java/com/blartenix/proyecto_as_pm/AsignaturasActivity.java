package com.blartenix.proyecto_as_pm;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class AsignaturasActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    GridView gridview;

 String[] etiquetas = {

        "Categoria ",
        "Peso",
        "Elemento",
        "L1",
        "L2",
        "L3",
        "L4"
    };

    LinearLayout contentLayout;

    int contador = 1 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asignaturas);
        gridview = (GridView) findViewById(R.id.gridview);
        contentLayout = (LinearLayout)findViewById(R.id.content_asignaturas);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



GridAdapter gridAdapter = new GridAdapter( this , etiquetas);
        gridview.setAdapter(gridAdapter);






            FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
            fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();



                    Context c=AsignaturasActivity.this ;
                    TextView tvv=new TextView(c);
                    TextView cod=new TextView(c);
                    tvv.setText("Nombre de Asignatura: ");
                    Button boton = new Button(c);
                    cod.setText("Codigo: ");
                    boton.setText("Aceptar");
                    EditText text = new EditText(c);
                    EditText codigo = new EditText(c);
                    text.setId(Integer.valueOf(contador));
                    boton.setTag(contador);
                    contentLayout.addView(tvv);
                    contentLayout.addView(text);
                    contentLayout.addView(cod);
                    contentLayout.addView(codigo);
                    contentLayout.addView(boton);
                    contador = contador+1 ;
                    boton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String id = v.getTag().toString();
                            String texto = ((EditText)findViewById(Integer.valueOf(id))).getText().toString();
                            Log.d("Mensaje:",texto);

                        }
                    });









            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.asignaturas, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.

        int id = item.getItemId();

        Intent intent = null;

        if (id == R.id.nav_asignaturas) {
            Toast.makeText(AsignaturasActivity.this, "Asignaturas", Toast.LENGTH_SHORT).show();
            intent = new Intent(this, AsignaturasActivity.class);

        } else if (id == R.id.nav_evaluaciones) {
            Toast.makeText(AsignaturasActivity.this, "Evaluaciones", Toast.LENGTH_SHORT).show();
            intent = new Intent(this, EvaluacionesActivity.class);

        } else if (id == R.id.nav_rubricas) {
            Toast.makeText(AsignaturasActivity.this, "Rubricas", Toast.LENGTH_SHORT).show();
            intent = new Intent(this, RubricasActivity.class);

        } else if (id == R.id.nav_sign_out) {
            Toast.makeText(AsignaturasActivity.this, "Sign out", Toast.LENGTH_SHORT).show();

        }

        startActivity(intent);

        finish();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
