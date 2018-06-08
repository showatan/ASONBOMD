package com.asonbomd.soloingenios.asonbomd;

import android.Manifest;
import android.content.ClipData;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
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
import android.telephony.PhoneNumberUtils;
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
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static android.Manifest.permission.ACCESS_FINE_LOCATION;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;
import static android.Manifest.permission_group.CAMERA;


import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private ImageButton boto1;
    private Uri output;
    private String foto;
    private File file;
    String path2;
    String timeStamp;
    String path;
    private final String CARPETA_RAIZ = "asonbomd/";
    private final String RUTA_IMAGEN = CARPETA_RAIZ + "fotos";
    private static final int REQUEST_CODE_ASK_PERMISSIONS = 123;
    private static final int REQUEST_CODE_ASK_PERMISSIONSAL = 123;
    private String longitud1;
    private String latitud1;
    private LocationManager locManager;
    private Location loc;
    private String FIREBASE_URL = "https://asonbomd-ef380.firebaseio.com/";
    private String FIREBASE_CHILD = "ubication";
    FirebaseDatabase database;
    FirebaseStorage storage;
    private String tipoemergencia;
    private ImageButton op1, op2, op3, op4;
    private Button btn_enviar;
    private String validacion="pass";




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
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);





        database = FirebaseDatabase.getInstance();
        storage = FirebaseStorage.getInstance();

        ////////definicion de emergencia
        op1 = (ImageButton) findViewById(R.id.imageButton);
        op2 = (ImageButton) findViewById(R.id.imageButton2);
        op3 = (ImageButton) findViewById(R.id.imageButton3);
        op4 = (ImageButton) findViewById(R.id.imageButton5);

        op1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                op1.setBackgroundColor(Color.parseColor("#9AB5CF"));
                op2.setBackgroundColor(Color.parseColor("#1a237e"));
                op3.setBackgroundColor(Color.parseColor("#1a237e"));
                op4.setBackgroundColor(Color.parseColor("#1a237e"));
                tipoemergencia="Incendio";
            }
        });
        op2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                op1.setBackgroundColor(Color.parseColor("#1a237e"));
                op2.setBackgroundColor(Color.parseColor("#9AB5CF"));
                op3.setBackgroundColor(Color.parseColor("#1a237e"));
                op4.setBackgroundColor(Color.parseColor("#1a237e"));
                tipoemergencia="Accidente";
            }
        });
        op3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                op1.setBackgroundColor(Color.parseColor("#1a237e"));
                op2.setBackgroundColor(Color.parseColor("#1a237e"));
                op3.setBackgroundColor(Color.parseColor("#9AB5CF"));
                op4.setBackgroundColor(Color.parseColor("#1a237e"));
                tipoemergencia="Derrumbe";
            }
        });
        op4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                op1.setBackgroundColor(Color.parseColor("#1a237e"));
                op2.setBackgroundColor(Color.parseColor("#1a237e"));
                op3.setBackgroundColor(Color.parseColor("#1a237e"));
                op4.setBackgroundColor(Color.parseColor("#9AB5CF"));
                tipoemergencia="Primeros Auxilios";
            }
        });




        /////////fin definicion de emergencia


        //Codigo del imagenview en donde se captura la foto de la emergencia

        boto1 = (ImageButton) findViewById(R.id.captura);
        boto1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkPermissioncam();


            }
        });
        //se termina el codido del boton

        //Codigo de boton para enviar datos

        btn_enviar = (Button) findViewById(R.id.button);
        btn_enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((tipoemergencia == null)||(validacion.equals("pass"))){
                    Toast.makeText(getApplication(),"Porfavor seleccione un tipo de emergencia\n\n-Incendio\n-Accidente\n-Derrumbe\n-Primeros Auxilios\n\n y capture una Fotografia",Toast.LENGTH_LONG).show();
                }
                else {
                    enviardatos();
                }



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
            Intent intent = new Intent(MainActivity.this, Directorio.class);
            startActivity(intent);
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {
            Toast.makeText(getApplication(),"Estamos Trabajando en Esta seccion pronto estara disponible",Toast.LENGTH_LONG).show();

        } else if (id == R.id.nav_slideshow) {
            Intent intent = new Intent(MainActivity.this, Twitter.class);
            startActivity(intent);
        }  else if (id == R.id.nav_share) {


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
            capturar();

        } else {

            int hasWriteContactsPermission = checkSelfPermission(Manifest.permission.CAMERA);
            int almacenamiento = checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE);
            int ubicacion = checkCallingPermission(Manifest.permission.ACCESS_FINE_LOCATION);


            if ((hasWriteContactsPermission != PackageManager.PERMISSION_GRANTED) ||
                    (almacenamiento != PackageManager.PERMISSION_GRANTED) ||
                    (ubicacion != PackageManager.PERMISSION_GRANTED)) {

                requestPermissions(new String[]{Manifest.permission.CAMERA, WRITE_EXTERNAL_STORAGE, ACCESS_FINE_LOCATION},
                        REQUEST_CODE_ASK_PERMISSIONS);

                Toast.makeText(this, "Requesting permissions", Toast.LENGTH_LONG).show();

            } else if ((hasWriteContactsPermission == PackageManager.PERMISSION_GRANTED) &&
                    (almacenamiento == PackageManager.PERMISSION_GRANTED) &&
                    (ubicacion == PackageManager.PERMISSION_GRANTED)) {

                Toast.makeText(this, "The permissions are already granted ", Toast.LENGTH_LONG).show();
                capturar();

            }

        }

        return;
    }

    private void checkPermissionalm() {


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (REQUEST_CODE_ASK_PERMISSIONS == requestCode) {
            if ((grantResults[0] == PackageManager.PERMISSION_GRANTED) &&
                    (grantResults[1] == PackageManager.PERMISSION_GRANTED)
                    && (grantResults[2] == PackageManager.PERMISSION_GRANTED)) {
                Toast.makeText(this, "OK Permissions granted ! :-) " + Build.VERSION.SDK_INT, Toast.LENGTH_LONG).show();
                capturar();
            } else {
                Toast.makeText(this, "Permissions are not granted ! :-( " + Build.VERSION.SDK_INT, Toast.LENGTH_LONG).show();
            }
        } else {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }


    ///////////////////


    private void capturar() {


        File fileImagen2 = new File(Environment.getExternalStorageDirectory(), RUTA_IMAGEN);


        timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + RUTA_IMAGEN;
        File imagen = new File(path);
        if (!imagen.exists()) {
            imagen.mkdirs();
        }

        File fileimagen = new File(imagen, timeStamp + ".jpg");

        Intent intent = null;
        intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            String authorities = getApplicationContext().getPackageName() + ".provider";
            Uri imageUri = FileProvider.getUriForFile(this, authorities, fileimagen);
            intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
            intent.putExtra(MediaStore.EXTRA_SIZE_LIMIT,1024*1024);

        } else {
            intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(fileimagen));
        }
        startActivityForResult(intent, 20);


        //intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(imagen));
        //startActivityForResult(intent, 20);

        file = fileimagen;

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

/*
        if (resultCode == RESULT_OK) {
            MediaScannerConnection.scanFile(this, new String[]{"asonbomd/fotos/"+timeStamp+".jpg"}, null,
                    new MediaScannerConnection.OnScanCompletedListener() {
                        @Override
                        public void onScanCompleted(String s, Uri uri) {
                            Log.i("Ruta de Almacenamineto", "path: " + "asonbomd/fotos/"+timeStamp+".jpg");
                        }
                    });*/
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = 5;

            Bitmap bitmap = BitmapFactory.decodeFile( path+"/"+timeStamp+".jpg", options);
            Save savefile = new Save();
            savefile.SaveImage(this, bitmap);
            boto1.setImageBitmap(bitmap);
            validacion = "";







        //}


    }
    //////////////comprecion de foto

    public class Save {

        private Context TheThis;
        private String NameOfFolder = "/asonbomd/comprimido";
        private String NameOfFile = "imagen";

        public void SaveImage(Context context, Bitmap ImageToSave) {

            TheThis = context;
            String file_path = Environment.getExternalStorageDirectory().getAbsolutePath() + NameOfFolder;
            String CurrentDateAndTime = getCurrentDateAndTime();
            File dir = new File(file_path);

            if (!dir.exists()) {
                dir.mkdirs();
            }

            File file = new File(dir, timeStamp + ".jpg");

            try {
                FileOutputStream fOut = new FileOutputStream(file);

                ImageToSave.compress(Bitmap.CompressFormat.JPEG, 85, fOut);
                fOut.flush();
                fOut.close();
                MakeSureFileWasCreatedThenMakeAvabile(file);
                AbleToSave();
            }

            catch(FileNotFoundException e) {
                UnableToSave();
            }
            catch(IOException e) {
                UnableToSave();
            }

        }

        private void MakeSureFileWasCreatedThenMakeAvabile(File file){
            MediaScannerConnection.scanFile(TheThis,
                    new String[] { file.toString() } , null,
                    new MediaScannerConnection.OnScanCompletedListener() {

                        public void onScanCompleted(String path, Uri uri) {
                        }
                    });
        }

        private String getCurrentDateAndTime() {
            Calendar c = Calendar.getInstance();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd-HH-mm-­ss");
            String formattedDate = df.format(c.getTime());
            return formattedDate;
        }

        private void UnableToSave() {
            Toast.makeText(TheThis, "¡No se ha podido guardar la imagen!", Toast.LENGTH_SHORT).show();
        }

        private void AbleToSave() {
            Toast.makeText(TheThis, "Imagen guardada en la galería.", Toast.LENGTH_SHORT).show();
        }
    }

    //////////////foto comprimida

    /////obtencion de datos de gps
    private void ubicacion(){
        locManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        loc = locManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        longitud1 =String.valueOf(loc.getLatitude());
        latitud1=String.valueOf(loc.getLongitude());



    }

    ///////////////-----fin obtencion de gps


    ////////definicion de emergencia


    /////////fin definicion de emergencia


    ////////proceso de enviar datos
    private void enviardatos(){
        ubicacion();
        //parte de enviar datos a firebase
        DatabaseReference messageReference = database.getReference().child("emergencias").child(timeStamp).child("ubicacion");
        DatabaseReference messageReferencet = database.getReference().child("emergencias").child(timeStamp).child("tipoemegencia");
        DatabaseReference messageimagen = database.getReference().child("emergencias").child(timeStamp).child("rutaimagen");

        File fileImagen2 = new File(Environment.getExternalStorageDirectory(), "asonbomd/comprimido/");
        messageReference.setValue("https://www.google.com/maps?q="+longitud1+","+latitud1+"&z=17&hl=es");
        messageReferencet.setValue(tipoemergencia);
        messageimagen.setValue("https://firebasestorage.googleapis.com/v0/b/asonbomd-ef380.appspot.com/o/imagenes%2F"+timeStamp+".jpg?alt=media");

        Uri filess = Uri.fromFile(new File(fileImagen2+"/"+timeStamp+".jpg"));

        StorageReference storageref = storage.getReference().child("imagenes").child(timeStamp+".jpg");
        storageref.putFile(filess);




        //parte para enviar datos por whatsapp

        Uri uri = Uri.parse("https://api.whatsapp.com/send?phone=502 40258828&text="+tipoemergencia+" https://www.google.com/maps?q="+longitud1+","+latitud1+"&z=17&hl=es");
        Intent inte = new Intent(Intent.ACTION_VIEW, uri);



        startActivity(inte);

    }

    ///////////

}
