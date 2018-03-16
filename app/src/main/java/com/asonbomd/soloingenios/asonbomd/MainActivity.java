package com.asonbomd.soloingenios.asonbomd;

import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
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
import android.widget.ImageButton;
import android.widget.Spinner;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private ImageButton boto1;
    private Uri output;
    private String foto;
    private File file;
    String timeStamp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

       /* NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        Spinner spinner1 = (Spinner) findViewById(R.id.sp_tipoem);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.datos, R.layout.support_simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter); parte para el manejo de spinner*/

       //Codigo del imagenview en donde se captura la foto de la emergencia
        boto1=(ImageButton)findViewById(R.id.captura);
        boto1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                capturar();


            }
        });
       //se termina el codido del boton
        //Intent ListSong = new Intent(getApplicationContext(),Directorio.class);
        //startActivity(ListSong);
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
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }



    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    private void capturar() {
        timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        foto = Environment.getExternalStorageDirectory() + "/"+timeStamp+".jpg";
        file=new File(foto);
        Intent in =new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        output = Uri.fromFile(file);
        in.putExtra(MediaStore.EXTRA_OUTPUT, output);
        in.putExtra(MediaStore.EXTRA_SIZE_LIMIT,102*20);
        startActivityForResult(in, 1);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
       /* ContentResolver cr = this.getContentResolver();
        //imag =(ImageView) findViewById(R.id.imageView2);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 5;
        Bitmap bm = BitmapFactory.decodeFile(foto, options);
        Bitmap bit = null;
        try {
            bit = bm;
            int rotate = 0;
            ExifInterface exif = new ExifInterface((file.getAbsolutePath()));
            int orientation = exif.getAttributeInt(
                    ExifInterface.TAG_ORIENTATION,
                    ExifInterface.ORIENTATION_NORMAL);
            switch (orientation) {
                case ExifInterface.ORIENTATION_ROTATE_270:
                    rotate = 270;
                    break;
                case ExifInterface.ORIENTATION_ROTATE_180:
                    rotate = 180;
                    break;
                case ExifInterface.ORIENTATION_ROTATE_90:
                    rotate = 90;
                    break;
            }

            Matrix matrix = new Matrix();
            matrix.postRotate(rotate);
            matrix.preScale(150, 150);
            bit = Bitmap.createBitmap(bm, 0, 0, bit.getWidth(),bit.getHeight(), matrix, true);


        }
        catch (Exception e) {
            e.printStackTrace();
        }

        //BitmapFactory.Options options = new BitmapFactory.Options();
        //options.inSampleSize = 2; Bitmap bm = BitmapFactory.decodeFile(foto, options);
        boto1.setImageBitmap(bit);*/
        if (requestCode == 1 && resultCode == RESULT_OK) {
            //Creamos un bitmap con la imagen recientemente
            //almacenada en la memoria
            Bitmap bMap = BitmapFactory.decodeFile(foto);
            //Añadimos el bitmap al imageView para
            //mostrarlo por pantalla
            boto1.setImageBitmap(bMap);
        }
    }
}
