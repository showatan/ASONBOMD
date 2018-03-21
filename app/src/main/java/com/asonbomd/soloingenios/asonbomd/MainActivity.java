package com.asonbomd.soloingenios.asonbomd;

import android.Manifest;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AlertDialog;
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
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import static android.Manifest.permission.ACCESS_FINE_LOCATION;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;
import static android.Manifest.permission_group.CAMERA;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private ImageButton boto1;
    private Uri output;
    private String foto;
    private File file;
    String timeStamp;
    String path;
    private final String CARPETA_RAIZ="imgprueba/";
    private final String RUTA_IMAGEN=CARPETA_RAIZ+"MisFotos";
    private static final int REQUEST_CODE_ASK_PERMISSIONS = 123;
    private static final int REQUEST_CODE_ASK_PERMISSIONSAL = 123;

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


       //Codigo del imagenview en donde se captura la foto de la emergencia

        boto1=(ImageButton)findViewById(R.id.captura);
        boto1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               checkPermissioncam();


            }
        });
       //se termina el codido del boton

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




    ////////////////////////////////


    private void checkPermissioncam() {

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {

            Toast.makeText(this, "This version is not Android 6 or later " + Build.VERSION.SDK_INT, Toast.LENGTH_LONG).show();

        } else {

            int hasWriteContactsPermission = checkSelfPermission(Manifest.permission.CAMERA);
            int almacenamiento = checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE);
            int ubicacion = checkCallingPermission(Manifest.permission.ACCESS_FINE_LOCATION);


            if ((hasWriteContactsPermission != PackageManager.PERMISSION_GRANTED)||
                    (almacenamiento != PackageManager.PERMISSION_GRANTED)||
                    (ubicacion != PackageManager.PERMISSION_GRANTED)) {

                requestPermissions(new String[] {Manifest.permission.CAMERA,WRITE_EXTERNAL_STORAGE,ACCESS_FINE_LOCATION},
                        REQUEST_CODE_ASK_PERMISSIONS);

                Toast.makeText(this, "Requesting permissions", Toast.LENGTH_LONG).show();

            }else if ((hasWriteContactsPermission == PackageManager.PERMISSION_GRANTED)&&
                    (almacenamiento == PackageManager.PERMISSION_GRANTED)&&
                    (ubicacion == PackageManager.PERMISSION_GRANTED)){

                Toast.makeText(this, "The permissions are already granted ", Toast.LENGTH_LONG).show();
                capturar();

            }

        }

        return;
    }
    private void checkPermissionalm(){


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if(REQUEST_CODE_ASK_PERMISSIONS == requestCode) {
            if ((grantResults[0] == PackageManager.PERMISSION_GRANTED)&&
                    (grantResults[1] == PackageManager.PERMISSION_GRANTED)
                    &&(grantResults[2] == PackageManager.PERMISSION_GRANTED)) {
                Toast.makeText(this, "OK Permissions granted ! :-) " + Build.VERSION.SDK_INT, Toast.LENGTH_LONG).show();
                capturar();
            } else {
                Toast.makeText(this, "Permissions are not granted ! :-( " + Build.VERSION.SDK_INT, Toast.LENGTH_LONG).show();
            }
        }else{
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }











    ///////////////////





    private void capturar() {


       File fileImagen = new File(Environment.getExternalStorageDirectory(),RUTA_IMAGEN);

        timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        path=Environment.getExternalStorageDirectory()+File.separator+RUTA_IMAGEN+File.separator+timeStamp+".jpg";
        File imagen = new File(path);


        Intent intent = null;
        intent= new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.N)
        {
            String authorities=getApplicationContext().getPackageName()+".provider";
            Uri imageUri= FileProvider.getUriForFile(this,authorities,imagen);
            intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
        }else
        {
            intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(imagen));
        }
        startActivityForResult(intent,20);


        //intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(imagen));
        //startActivityForResult(intent, 20);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {



       if (resultCode==RESULT_OK){
           MediaScannerConnection.scanFile(this, new String[]{path}, null,
                   new MediaScannerConnection.OnScanCompletedListener() {
                       @Override
                       public void onScanCompleted(String s, Uri uri) {
                           Log.i("Ruta de Almacenamineto","path: "+path);
                       }
                   });
           BitmapFactory.Options options = new BitmapFactory.Options();
           options.inSampleSize = 5;
           Bitmap bitmap = BitmapFactory.decodeFile(path, options);
           boto1.setImageBitmap(bitmap);


       }


    }

}
