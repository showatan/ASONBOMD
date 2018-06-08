package com.asonbomd.soloingenios.asonbomd;

import android.*;
import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import static android.Manifest.permission.ACCESS_FINE_LOCATION;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

public class Directorio extends AppCompatActivity {
    private ImageButton llamarcen, llamarest;
    private static final int REQUEST_CODE_ASK_PERMISSIONS = 123;
    private Spinner depart, estacion;
    private String depart1;
    private String stacion1;
    private TextView datos;
    private String telefono;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_directorio);
        llamarcen = (ImageButton) findViewById(R.id.imageButton4);
        llamarcen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Llamando a Central de Bomberos", Toast.LENGTH_SHORT).show();
                llamar("1554");
            }
        });


        llamarest=(ImageButton)findViewById(R.id.imageButton6);
        llamarest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (telefono==null){
                    Toast.makeText(getApplication(),"Seleccione Una Estacion",Toast.LENGTH_SHORT).show();
                }
                else {
                    llamar(telefono);
                    Toast.makeText(getApplication(), "llamando a Estacion de " + stacion1, Toast.LENGTH_SHORT).show();
                }
            }
        });




        depart=(Spinner)findViewById(R.id.spinner);
        estacion=(Spinner)findViewById(R.id.spinner2);
        depart.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                estacion.setEnabled(true);
                depart1=depart.getSelectedItem().toString();
                switch(depart1){
                    case "Guatemala":
                        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(
                                Directorio.this, R.array.Guatemala1, android.R.layout.simple_spinner_item);
                        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        estacion.setAdapter(adapter1);
                        break;
                    case "Quetzaltenango":
                        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(
                                Directorio.this, R.array.Quetzaltenango1, android.R.layout.simple_spinner_item);
                        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        estacion.setAdapter(adapter2);
                        break;
                    case "Peten":
                        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(
                                Directorio.this, R.array.Peten1, android.R.layout.simple_spinner_item);
                        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        estacion.setAdapter(adapter3);
                        break;
                    case "Huehuetenango":
                        ArrayAdapter<CharSequence> adapter4 = ArrayAdapter.createFromResource(
                                Directorio.this, R.array.Huhuetenango1, android.R.layout.simple_spinner_item);
                        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        estacion.setAdapter(adapter4);
                        break;
                    case "Quiche":
                        ArrayAdapter<CharSequence> adapter5 = ArrayAdapter.createFromResource(
                                Directorio.this, R.array.Quiche1, android.R.layout.simple_spinner_item);
                        adapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        estacion.setAdapter(adapter5);
                        break;
                    case "Alta Verapaz":
                        ArrayAdapter<CharSequence> adapter6 = ArrayAdapter.createFromResource(
                                Directorio.this, R.array.AltaVerapaz1, android.R.layout.simple_spinner_item);
                        adapter6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        estacion.setAdapter(adapter6);
                        break;
                    case "San Marcos":
                        ArrayAdapter<CharSequence> adapter8 = ArrayAdapter.createFromResource(
                                Directorio.this, R.array.SanMarcos1, android.R.layout.simple_spinner_item);
                        adapter8.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        estacion.setAdapter(adapter8);
                        break;
                    case "Totonicapan":
                        ArrayAdapter<CharSequence> adapter9 = ArrayAdapter.createFromResource(
                                Directorio.this, R.array.Totonicapan1, android.R.layout.simple_spinner_item);
                        adapter9.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        estacion.setAdapter(adapter9);
                        break;
                    case "Solola":
                        ArrayAdapter<CharSequence> adapter10 = ArrayAdapter.createFromResource(
                                Directorio.this, R.array.Solola1, android.R.layout.simple_spinner_item);
                        adapter10.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        estacion.setAdapter(adapter10);
                        break;
                    case "Retahuleu":
                        ArrayAdapter<CharSequence> adapter11 = ArrayAdapter.createFromResource(
                                Directorio.this, R.array.Retalhuleu1, android.R.layout.simple_spinner_item);
                        adapter11.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        estacion.setAdapter(adapter11);
                        break;
                    case "Suchitepequez":
                        ArrayAdapter<CharSequence> adapter12 = ArrayAdapter.createFromResource(
                                Directorio.this, R.array.Suchitepequez1, android.R.layout.simple_spinner_item);
                        adapter12.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        estacion.setAdapter(adapter12);
                        break;
                    case "Chimaltenango":
                        ArrayAdapter<CharSequence> adapter13 = ArrayAdapter.createFromResource(
                                Directorio.this, R.array.Chimaltenango1, android.R.layout.simple_spinner_item);
                        adapter13.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        estacion.setAdapter(adapter13);
                        break;
                    case "Sacatepequez":
                        ArrayAdapter<CharSequence> adapter14 = ArrayAdapter.createFromResource(
                                Directorio.this, R.array.Sacatepequez1, android.R.layout.simple_spinner_item);
                        adapter14.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        estacion.setAdapter(adapter14);
                        break;
                    case "Escuintla":
                        ArrayAdapter<CharSequence> adapter15 = ArrayAdapter.createFromResource(
                                Directorio.this, R.array.Escuintla1, android.R.layout.simple_spinner_item);
                        adapter15.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        estacion.setAdapter(adapter15);
                        break;
                    case "Santa Rosa":
                        ArrayAdapter<CharSequence> adapter16 = ArrayAdapter.createFromResource(
                                Directorio.this, R.array.SantaRosa1, android.R.layout.simple_spinner_item);
                        adapter16.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        estacion.setAdapter(adapter16);
                        break;
                    case "Jutiapa":
                        ArrayAdapter<CharSequence> adapter17 = ArrayAdapter.createFromResource(
                                Directorio.this, R.array.Jutiapa1, android.R.layout.simple_spinner_item);
                        adapter17.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        estacion.setAdapter(adapter17);
                        break;
                    case "Jalapa":
                        ArrayAdapter<CharSequence> adapter18 = ArrayAdapter.createFromResource(
                                Directorio.this, R.array.Jalapa1, android.R.layout.simple_spinner_item);
                        adapter18.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        estacion.setAdapter(adapter18);
                        break;
                    case "Chiquimula":
                        ArrayAdapter<CharSequence> adapter19 = ArrayAdapter.createFromResource(
                                Directorio.this, R.array.Chiquimula1, android.R.layout.simple_spinner_item);
                        adapter19.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        estacion.setAdapter(adapter19);
                        break;
                    case "El Progreso":
                        ArrayAdapter<CharSequence> adapter20 = ArrayAdapter.createFromResource(
                                Directorio.this, R.array.ElProgreso1, android.R.layout.simple_spinner_item);
                        adapter20.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        estacion.setAdapter(adapter20);
                        break;
                    case "Zacapa":
                        ArrayAdapter<CharSequence> adapter21 = ArrayAdapter.createFromResource(
                                Directorio.this, R.array.Zacapa1, android.R.layout.simple_spinner_item);
                        adapter21.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        estacion.setAdapter(adapter21);
                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        estacion.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                stacion1=estacion.getSelectedItem().toString();
                datos=(TextView)findViewById(R.id.textView5);
                switch(stacion1) {
                    case "Villa Hermosa":
                        datos.setText("Guatemala, Villa Hermosa Estación #24 \nTel: 24483933 - 40214316 - 4768 7509 \nDireccion: 28 Av. 19-81 zona 7, Villa Hermosa");
                        telefono="40214316";
                        break;
                    case "San Miguel Petapa":
                        datos.setText("Guatemala, San Miguel Petapa Estación # 26" +
                                "\nTel: 40273598 - 66317402" +
                                "\n Direccion: 2° calle 1-97 zona 2, San Miguel Petapa");
                        telefono="40273598";
                        break;
                    case "Palencia":
                        datos.setText("Guatemala, Palencia Estación # 46" +
                                "\nTel: 40268608 - 56559060" +
                                "" +
                                "\nDireccion: Salón Municipal de Palencia");
                        telefono="40268680";
                        break;
                    case "Fraijanes":
                        datos.setText("Guatemala, Fraijanes Estación # 48" +
                                "\nTel: 40268792  -  50275911" +
                                "\nDireccion: 1a. Avenida 1-15, zona 1");
                        telefono="40268792";
                        break;
                    case "Barcenas":
                        datos.setText("Guatemala, Barcenas Estación # 58" +
                                "\nTel: 40256228  -  59232029  -  66295032" +
                                "\nDireccion: 11 Av. A 7-29 zona 3, Barcenas, Villa Nueva");
                        telefono="40256228";
                        break;
                    case "Santa Ines Petapa":
                        datos.setText("Guatemala, Santa Ines Petapa Estación # 68" +
                                "\nTel: 6631 8156" +
                                "\nDireccion: 3° calle A 2-20 zona 4, Santa Ines Petapa");
                        telefono="66318156";
                        break;
                    case "Ciudad Peronia":
                        datos.setText("Guatemala, Ciudad Peronia  Estación # 69" +
                                "\nTel: 40332386 - 45327788" +
                                "\nDireccion: Salon Comnunal, Colonia el Gran Mirador, Villa Nueva " +
                                "esquina 6° calle y Av. Principal / Zona 8 Ciudad Peronia");
                        telefono="40332386";
                        break;
                    case "Aldea El Fiscal":
                        datos.setText("Guatemala, Aldea El Fiscal Estación # 83" +
                                "\nTel: 32252275" +
                                "\nDireccion: 0 Ave. 31-134 Aldea El Fiscal, interior puesto de salud," +
                                " Palencia Guatemala");
                        telefono="32252275";
                        break;
                    case "Antigua Guatemala":
                        datos.setText("Guatemala, La Antigua Guatemala # 91" +
                                "\nTel: 41442323  -  43103443" +
                                "\nDireccion: Calle de Chipilapa No. 2B La Antigua Guatemala");
                        telefono="41442323";
                        break;
                    case "Monte Rico":
                        datos.setText("Guatemala, Monte Rico # 98" +
                                "\nTel: 42410826" +
                                "\nDireccion: Frente a Cementerio General de Monterrico, dentro del Hotel la Sirena");
                        telefono="42410826";
                        break;
                    case "Santa Isabel Villa Nueva":
                        datos.setText("Guatemala, Santa Isabel Villa Nueva #104" +
                                "\nTel: 41447726 - 6631-3222" +
                                "\nDireccion: 13 Av. 0-00 Zona 3, Villa Nueva, Km. 19 Carretera al Pacifico");
                        telefono="41447726";
                        break;
                    case "San Juan Chamelco":
                        datos.setText("Alta Verapaz, San Juan Chamelco Estación #31" +
                                "\nTel: 44601118  -  40228858" +
                                "\nDireccion: 1a. Calle 0-69 zona 1");
                        telefono="40228858";
                        break;
                    case "Rio Hondo":
                        datos.setText("Zacapa, Rio Hondo Estación #11" +
                                "\nTel: 79340443  -  40220840" +
                                "\nDireccion: Km. 136 ruta al Atlántico");
                        telefono="79340443";
                        break;
                    case "La Union":
                        datos.setText("Zacapa\t\t\t\n" +
                                "La Unión Estación # 32\t\n" +
                                "Tel: 40299257  -  44212439\t\t\t\n" +
                                "Direccion: Aldea Chicipate, Calle principal frente a Escuela Rural Mixta\n");
                        telefono="40299257";
                        break;
                    case "Usumatlan":
                        datos.setText("Zacapa\t\n" +
                                "Usumatlán Estación # 38\t\n" +
                                "Tel: 40300497  -  59291101\n" +
                                "Direccion: Km. 111.5 carretera al atlanico, Usumatlán, Km. 111.5\t\n");
                        telefono="40300497";
                        break;
                    case "Huite":
                        datos.setText("Zacapa\t\n" +
                                "Huite Estación # 86\t\n" +
                                "Tel: 50633975\t\n" +
                                "Direccion: Barrio los Llanitos 1-03 Huite, Zacapa\n");
                        telefono="50633975";
                        break;
                    case "El Rancho":
                        datos.setText("El Progreso\n" +
                                "El Rancho Estación # 17\t \n" +
                                "Tel: 4020 8877         4766 4231\t\t\n" +
                                "Direccion: Carretera Al Atlántico Km 85  \n");
                        telefono="40208877";
                        break;
                    case "Sanarate":
                        datos.setText("El Progreso\n" +
                                "Sansare # 90\t\n" +
                                "Tel: 58999515  -  42166884\t\t\n" +
                                "Direccion: Camino a Buena Vista , en la planta de tratamientos en los campitos\t");
                        telefono="58999515";
                        break;
                    case "Ipala":
                        datos.setText("Chiquimula\t\n" +
                                "Ipala  #103\t\n" +
                                "Tel: 44921022  -  42456835\t\t\n" +
                                "Direccion: 2da. Calle 3-96 Zona 1 Sector el Cementerio Ipala, Chiquimula\t");
                        telefono="44921022";
                        break;
                    case "Taxisco":
                        datos.setText("Taxisco, Santa Rosa Estación # 73\t\t\n" +
                                "Tel: 54505179   -   40253728\n" +
                                "Direccion: Colonia Petén, detrás de Rastro Municipal \n");
                        telefono="40253728";
                        break;
                    case "San Rafael, Las Flores":
                        datos.setText("Santa Rosa\t\t\n" +
                                "San Rafael, Las Flores  Estación # 74\t\n" +
                                "Tel: 51929551"+
                                "3° Av. y 2° Calle, enfrente de la Escuela de Parvulos\t");
                        telefono="51929551";
                        break;
                    case "Casillas":
                        datos.setText("Santa Rosa\t\n" +
                                "Casillas Estación # 75\t\n" +
                                "Tel: 43643844\t\n" +
                                "Direccion: A un costado del Mercado municipal, en segundo nivel");
                        telefono="43643844";
                        break;
                    case "Santa Rosa":
                        datos.setText("Santa Rosa\t\n" +
                                "Estación # 96\t\n" +
                                "Tel: 41357058  -  41724822\t\t\n" +
                                "Direccion: Aldea Casas Viejas, Calle Principila hacia el Chapeton");
                        telefono="41357058";
                        break;
                    case "Santa Rosa de Lima":
                        datos.setText("Santa Rosa \t\t\n" +
                                "Santa Rosa de Lima #105\t\n" +
                                "Tel: 3343-3045\t\n");
                        telefono="33433045";
                        break;
                    case "Monjas":
                        datos.setText("Jalapa\n" +
                                "Monjas # 62\t\n" +
                                "Tel: 40292688\t\n" +
                                "Direccion: Barrio La Reforma\t\n");
                        telefono="40292688";
                        break;
                    case "Ciudad Pedro de Alvarado":
                        datos.setText("Jutiapa\t\n" +
                                "Ciudad Pedro de Alvarado Estación # 35\t\n" +
                                "Tel: 45170991  -  53415497  -  45364011\t\n" +
                                "Direccion: Ruta al Salvador, Esquina Comedor \"Yoli\", a mano derecha\t");
                        telefono="45170991";
                        break;
                    case "Moyuta":
                        datos.setText("Jutiapa\t\t\n" +
                                "Moyuta Estación # 55\t\nTel: 40230622  -  42694149\t\n" +
                                "Direccion: Barrio La  Reforma a un costado del Instituto de Educación Básica, frete al Juzgado de Paz\n");
                        telefono="45170991";
                        break;
                    case "Jalpatagua":
                        datos.setText("Jutiapa\t\t\n" +
                                "Jalpatagua  Estación # 60\t\t\t\n" +
                                "Direccion: 5 av. Entre 3ra. Y 2da. Calle zona 1, a un costado de la Municipalidad");
                        telefono="40277045";
                        break;
                    case "Conguaco":
                        datos.setText("Jutiapa\t\n" +
                                "Conguaco  Estación # 79\t\n" +
                                "Direccion: Barrio El Centro, a un costado de Mecanografía Victoria\t");
                        telefono="40254494";
                        break;
                    case "Pasaco":
                        datos.setText("Jutiapa\t\n" +
                                "Pasaco # 89\n" +
                                "Tel: 41434418  -  40841303\t\t\n" +
                                "Direccion: 1era. Ave. A dos cuadras, arriba del destacamento militar, Jutiapa\t");
                        telefono="40841303";
                        break;
                    case "Agua Blanca":
                        datos.setText("Jutiapa\t\t\n" +
                                "Agua Blanca    Estación # 94\t\n" +
                                "Tel: 30357719\t\t\n" +
                                "Direccion: Salon Poli Deportivo, Barrio Tecuan Agua Blanca, Jutiapa\t\n");
                        telefono="30357719";
                        break;
                    case "Jocotenango":
                        datos.setText("Sacatepéquez\t\n" +
                                "Jocotenango Estación # 2\t\n" +
                                "Tel: 79221961   -   40279096\t\t\n" +
                                "Direccion: 1a. Avenida y 7a. Calle esquina,  Colonia Los Llanos\t\n");
                        telefono="79221961";
                        break;
                    case "San Miguel Dueñas":
                        datos.setText("Sacatepéquez\t\n" +
                                "San Miguel Dueñas Estación # 8\t  \n" +
                                "Tel: 40303889   -   53782802   -   43898803\t\t\n" +
                                "Direccion: 4a. Avenida \"A\" 0-41, zona 1\t\n");
                        telefono="40303889";
                        break;
                    case "Santiago Sacatepequez":
                        datos.setText("Sacatepéquez\t\n" +
                                "Santiago Sacatepéquez Estación # 23\t\n" +
                                "Tel: 40201915   -   51501971\t\n" +
                                "Direccion: 5° Av. zona 4, Santiago Sac., a la par del Puesto de Salud");
                        telefono="40201915";
                        break;
                    case "Santo Domingo Xenacoj":
                        datos.setText("Sacatepéquez\n" +
                                "Santo Domingo Xenacoj Estación # 29\t\n" +
                                "Tel: 4022 6651   -   4122 1317\t\t\n" +
                                "Direccion: 2° Av. Final 4-56, zona 4\t\n");
                        telefono="40226651";
                        break;
                    case "Santa Lucia Milpas Altas":
                        datos.setText("Sacatepéquez\t\n" +
                                "Santa Lucia Milpas Altas Estación # 33\t\n" +
                                "Tel: 40227118  -  44217138  -  54808254\t\n" +
                                "Direccion: Calle Principal, a un costado de la Municipalidad.\n");
                        telefono="40227118";
                        break;
                    case "Pastores":
                        datos.setText("Sacatepéquez\n" +
                                "Pastores # 34\t\n" +
                                "Tel: 40289576  -  55401918  -  43751199\t\t\n" +
                                "Direccion: Calle Real de Pastores, entrada principal\t\n");
                        telefono="40289576";
                        break;
                    case "Ciudad Vieja":
                        datos.setText("Sacatepéquez\t\t\n" +
                                "Ciudad Vieja Estación # 50\t\n" +
                                "Tel: 40249034  -  52871772\t\n" +
                                "Direccion: 4° calle y 5° Av, zona 5, Ciudad Vieja\n");
                        telefono="40249034";
                        break;
                    case "San Antonio Aguas Calientes":
                        datos.setText("Sacatepéquez\t\n" +
                                "San Antonio Aguas Calientes Estación # 52\t\n" +
                                "Tel: 4025 0868   -   3049 9974\t\t\n" +
                                "Direccion: 3° Av. Frente a la casa Parroquial\n");
                        telefono="40250868";
                        break;
                    case "Sumpango Sacatepequez":
                        datos.setText("Sacatepéquez\t\n" +
                                "Sumpango, Sacatepéquez  Estación # 76\t\n" +
                                "Tel: 52947748   -  47570751\t\n" +
                                "Direccion: 3ra. Ave. Final Zona 1 sector La Morera, sumpango sac.");
                        telefono="47570751";
                        break;
                    case "San Bartolome Milpas Altas":
                        datos.setText("Sacatepéquez\n" +
                                "San Bartolomé Milpas Altas # 81\n" +
                                "Direccion: 0 Ave, 2-04 san Bartolome Milpas Altas, antiguo puesto de salud\n" +
                                "Tel: 44675781\t\n");
                        telefono="44675781";
                        break;
                    case "San Juan Sacatepequez":
                        datos.setText("Sacatepéquez \t\n" +
                                "San Juan Sacatepéquez - Ciudad Quetzal #82\t\n" +
                                "Tel: 5855 9773\t\n" +
                                "Direccion: Sector C1, lote#7 manzana U, Ciudad Quetzal, San Juan Sac.,\n" +
                                "sobre bulevar principal a dos cuadras de la Despensa Familiar\n");
                        telefono="58559773";
                        break;
                    case "Magdalena Milpas Altas":
                        datos.setText("Sacatepéquez\n" +
                                "Magdalena Milpas Altas     Estación # 95\t\n" +
                                "Tel: 34188081  -  59394212\t\t\n" +
                                "Direccion: Zotano Municipal de Magdalena Milpas Altas\t\n");
                        telefono="34188081";
                        break;
                    case "Masagua":
                        datos.setText("Escuintla\t\n" +
                                "Masagua Estación # 36\t\n" +
                                "Tel: 40229749  -  52431952\t\t\t\n" +
                                "Direccion: Centro de Masagua, Lote 11 3-11 frente al Parque\n");
                        telefono="40229749";
                        break;
                    case "La Democracia":
                        datos.setText("Escuintla\t\n" +
                                "La Democracia Estación # 80\t\n" +
                                "Tel: 54199703\t\n" +
                                "Direccion: 2da.Calle esquina, a media cuadra del centro de Salud");
                        telefono="54199703";
                        break;
                    case "San Andres Itzapa":
                        datos.setText("Chimaltenango\t\n" +
                                "San Andres Itzapa Estación # 09\t \n" +
                                "Tel: 41471617   -   40337203\t\t\n" +
                                "Direccion: Zona 4, 0-4 Av. Canton Santisima Trinidad 2.\n");
                        telefono="41471617";
                        break;
                    case "El Tejar":
                        datos.setText("Chimaltenango\t\n" +
                                "El Tejar Estación # 10\t\n" +
                                "Tel: 40334707  -  78491045  -  59257768\t\t\n" +
                                "Direccion: Km. 51, carretera interamericana\t\n");
                        telefono="40334707";
                        break;
                    case "Tecpan":
                        datos.setText("Chimaltenango\t\n" +
                                "Tecpán Guatemala Estación # 16\t\n" +
                                "Tel: 78403144 - 41446661 - 40283313\t\t\n" +
                                "Direccion: 2° Av. 4-63 zona 2, Tecpán\n");
                        telefono="78403144";
                        break;
                    case "Patzicia":
                        datos.setText("Chimaltenango\t\t\n" +
                                "Patzicía Estación # 19\t\n" +
                                "Tel: 52196486  -  40220887  -  41623913\t\t\n" +
                                "Direccion: 2a. Calle 0-56, zona 3, Km. 70\n");
                        telefono="40220887";
                        break;
                    case "Patzun":
                        datos.setText("Chimaltenango\t\t\n" +
                                "Patzún  Estación # 22\t\n" +
                                "Tel: 78399042  -  40224687  -  55519616\t\t\t\n" +
                                "Direccion: Canton oriente, manzana 11 a la par del cementerio 1");
                        telefono="78399042";
                        break;
                    case "Acatenango":
                        datos.setText("Chimaltenango\n" +
                                "Acatenango Estación # 40\t\n" +
                                "Tel: 40204681  -  31087512  -  4230 - 7350\t\t\n" +
                                "Direccion: Tribuna Municipal, frente al parque, a un " +
                                "costado de la Municipalidad y del Colegio Nuestra Señora de Fátima\n");
                        telefono="40204681";
                        break;
                    case "Santa Cruz Balanya":
                        datos.setText("Chimaltenango\t\n" +
                                "Santa Cruz Balanyá Estación # 43\t\n" +
                                "Tel: 41473105   -   46334246   -   4020817\t\n" +
                                "Direccion: Cantón El Progreso\t\n");
                        telefono="41473105";
                        break;
                    case "San Juan Comalapa":
                        datos.setText("Chimaltenango\t\n" +
                                "San Juan Comalapa Estación # 45\t\n" +
                                "Tel: 78499000   -   56290179   -   40208658   \n" +
                                "Direccion: Barrio San Antonio, zona 3\n");
                        telefono="78499000";
                        break;
                    case "Zaragoza":
                        datos.setText("Chimaltenango\t\n" +
                                "Zaragoza, Chimaltenango  # 71\t\n" +
                                "Tel: 40301457  -  47223046\t\n" +
                                "Direccion: Casa de la Cultura, Frente a la Iglecia Católica\t");
                        telefono="40301457";
                        break;
                    case "San Jose Calderas":
                        datos.setText("Chimaltenango\n" +
                                "San José Calderas Estación # 88\n" +
                                "Chimaltenango\n" +
                                "Tel: 56704605\n");
                        telefono="56704605";
                        break;
                    case "Santa Isabel":
                        datos.setText("Chimaltenango\t\n" +
                                "Santa Isabel #102\t\n" +
                                "Tel: 43128308  -  30021269  -  43050852\t\t\n" +
                                "Direccion: Ruta San Martin Jilotepeque Km.55.5\n");
                        telefono="43128308";
                        break;
                    case "San Antonio":
                        datos.setText("Suchitepéquez\t\n" +
                                "San Antonio Such. Estación # 13\t\n" +
                                "Tel: 78704423   -   40346237\t\t\n" +
                                "Direccion: Km. 148 ruta la Pacifico, colonia Antigua Beneficio, San Antonio, Such.");
                        telefono="40346237";
                        break;
                    case "Cuyotenango":
                        datos.setText("Suchitepéquez\t\t\n" +
                                "Cuyotenango Estación # 18\t\n" +
                                "Tel: 78684444  -  40226041\t\n" +
                                "Direccion: Km 168 carretera al pacifico\t\n");
                        telefono="40226041";
                        break;
                    case "Chicacao":
                        datos.setText("Suchitepéquez\t\n" +
                                "Chicacao Estación # 27\t\t\t\t\n" +
                                "Direccion: frente a la muni complejo deportivo a un costado del estadio municipal de Chicacao\t\n" +
                                "Tel: 40338716   -   42239233\t\t\n");
                        telefono="40338716";
                        break;
                    case "San Miguel Panan":
                        datos.setText("Suchitepéquez\n" +
                                "San Miguel Panán Estación # 39\t\n" +
                                "Tel: 40216987   -   57586501\t\n" +
                                "Direccion: A la par de la Municipalidad\t\n");
                        telefono="40216987";
                        break;
                    case "San Lorenzo":
                        datos.setText("Suchitepéquez\n" +
                                "San Lorenzo Estación # 64\t\n" +
                                "Tel: 40307135\t\n" +
                                "Direccion: Cantón la Flores, San Lorenzo\t\n");
                        telefono="40307135";
                        break;
                    case "Santa Barbara":
                        datos.setText("Suchitepéquez\n" +
                                "Santa Barbara Estación # 66\t\n" +
                                "Tel: 4030 6511\t\n" +
                                "Direccion: Camino a la Colonia Romex, Santa Bárbara\n");
                        telefono="40306511";
                        break;
                    case "Santo Tomas":
                        datos.setText("Suchitepéquez\t\n" +
                                "Santo Tomás, La Unión Estación # 77\t\n" +
                                "" +
                                "Tel: 4147 0850    -   4025 0264\t\t\n" +
                                "Direccion: Canton San Antonio, a la par del Juzgado de Paz\t\n");
                        telefono="41470850";
                        break;
                    case "Zunilito":
                        datos.setText("Suchitepéquez\t\t\t\n" +
                                "Zunilito Estación # 78\t\n" +
                                "Tel: 59368185 -  58569095\n" +
                                "Direccion: Aldea mi Tierra, Camino al Rastro Municipal\t\n");
                        telefono="59368185";
                        break;
                    case "Patulul":
                        datos.setText("Suchitepéquez\t\t\n" +
                                "Patulul #100\t\n" +
                                "Tel: 3001 7351\t\t\n" +
                                "Direccion: Km. 113 ruta CA2 Sur a una costado de Gasolinera Shell Cocales\t");
                        telefono="30017351";
                        break;
                    case "Totonicapan":
                        datos.setText("Totonicapán\t\t\n" +
                                "Totonicapan Estación # 7\t\n" +
                                "Tel: 40261783 - 56613849\t\t\n" +
                                "Direccion: 12 Av. Entre 5° y 6° calle zona 3\t\t\n");
                        telefono="40261783";
                        break;
                    case "Argueta":
                        datos.setText("Sololá\t\n" +
                                "Aldea Argueta  Estación # 85\n" +
                                "Tel: 49024381\t\n" +
                                "Direccion: Km. 139 Carretera Interamericana, Sololá\t\n");
                        telefono="49024381";
                        break;
                    case "San Pedro":
                        datos.setText("San Marcos\t\n" +
                                "San Pedro Sacatepéquez,  Estación # 6\t\n" +
                                "Tel: 4023 0150   /   7760 2176\t\t\n" +
                                "Direccion: 3° calle y 7° Av. 3-24 zona 1\n");
                        telefono="40230150";
                        break;
                    case "Pajapita":
                        datos.setText("San Marcos\n" +
                                "Pajapita Estación # 12\t\n" +
                                "Tel: 40350836   -   77680323  -  77680439\t\t\n" +
                                "Direccion: Calle Real del Comercio, esquina del antiguo parque viejo\n");
                        telefono="40350836";
                        break;
                    case "Concepcion Tutuapa":
                        datos.setText("San Marcos\t\n" +
                                "Concepcion Tutuapa Estación # 21\t\n" +
                                "Tel: 4022 6973\t\t\n" +
                                "Direccion: Calle principal, salida antigua  Tutuapa\n");
                        telefono="40226973";
                        break;
                    case "Nuevo Progreso":
                        datos.setText("San Marcos\n" +
                                "Nuevo Progreso Estación # 25\t\n" +
                                "Tel: 40233130   -   45459765\t\n" +
                                "Direccion: Finca el Panorama, Km. 256 antes de llegar a la gasolinera\t");
                        telefono="40226973";
                        break;
                    case "Tacana":
                        datos.setText("San Marcos\t\n" +
                                "Tacaná Estación # 28\t\n" +
                                "Tel: 40336112  -  77718043  -  53507336\t\n" +
                                "Direccion: Barrio El Trebol, junto a Estadio Municipal\n");
                        telefono="40336112";
                        break;
                    case "San Pablo":
                        datos.setText("San Marcos\t\n" +
                                "San Pablo, San Marcos Estación # 42\t\n" +
                                "Tel: 54617171   -   45725565   -   40222060\t\n" +
                                "Direccion: A un costado del Estadio municipal\t\n");
                        telefono="40222060";
                        break;
                    case "San Miguel Ixtahucan":
                        datos.setText("San Marcos\t\n" +
                                "San Miguel Ixtahuacán Estación # 47\t\n" +
                                "Tel: 40204363  -  58826706\t\t\n" +
                                "Direccion: A un costado del Mercado Municipal\n");
                        telefono="40204363";
                        break;
                    case "San Antonio SM":
                        datos.setText("San Marcos\t\n" +
                                "San Antonio Sacatepéquez, San Marcos Estación # 51 \t\n" +
                                "Tel: 77773821    -   40230499\t\n" +
                                "Direccion: Parque Central San Antonio, Sac. San Marcos\t\n");
                        telefono="40230499";
                        break;
                    case "San Jose El Rodeo":
                        datos.setText("San Marcos\t\t\t\n" +
                                "San José El Rodeo, San Marcos Estación # 59\t\n" +
                                "Tel: 40325719  -  5777 9752\t\t\n" +
                                "Direccion: Frente Salon Municipal\t\n");
                        telefono="40325719";
                        break;
                    case "La Blanca Ocos":
                        datos.setText("San Marcos\t\n" +
                                "La Blanca, Ocós , San Marcos # 70\t\n" +
                                "Tel: 40336878  -  59307084  -  49332949\t\t\n" +
                                "Direccion: Frente Salon Municipal\t\t\n");
                        telefono="40336878";
                        break;
                    case "El Porvenir":
                        datos.setText("San Marcos\n" +
                                "El Porvenir, San Marcos Estación  # 72\t\n" +
                                "Tel: 40260387\t\t\t\n" +
                                "Direccion: Colonia el Centro, a la par de la Cooperativa La Florida\n");
                        telefono="40260387";
                        break;
                    case "Tejutla":
                        datos.setText("San Marcos\t\t\n" +
                                "Tejutla Estación # 84\t\n" +
                                "Tel: 49398627   -   54000500\t\n" +
                                "Direccion: 4ta. Ave. 0-18 Zona 1, Tejutla. San Marcos");
                        telefono="49398627";
                        break;
                    case "Sibinal":
                        datos.setText("San Marcos\t\n" +
                                "Sibinal Estación # 87\t\n" +
                                "Direccion: Zona 1, a un costado de la Municipalidad, San Marcos, Guatemala\t\n" +
                                "Tel: 52499870  -  47785015\t\n");
                        telefono="47785015";
                        break;
                    case "Tumbador":
                        datos.setText("San Marcos\n" +
                                "Tumbador # 92\t\n" +
                                "Tel: 54614944\t\t\n" +
                                "Direccion: Barrio San francisco, El Tumbador San Marcos");
                        telefono="54614944";
                        break;
                    case "Catarina":
                        datos.setText("San Marcos\n" +
                                "Catarina   Estación # 93\t\n" +
                                "Tel: 4117 1378   -   48916385\t\n" +
                                "Direccion: 3era. Ave. A media cuadra arriba de la Iglesia Catolica, Frente a la entrada del Canton Barrios\t\n");
                        telefono="41171378";
                        break;
                    case "Aldea El Chaye":
                        datos.setText("San Marcos\t\t\t\t\n" +
                                "Aldea El Chayen #101\t\n" +
                                "Tel: 4073-5249\n");
                        telefono="40735249";
                        break;
                    case "Santa Cruz Mulua":
                        datos.setText("Santa Cruz Mulua #99\t\n" +
                                "Tel: 4742 7604\n");
                        telefono="47427604";
                        break;
                    case "Coatepeque":
                        datos.setText("Quetzaltenango\t\n" +
                                "Coatepeque Estación # 04\n" +
                                "Tel: 79799384  -  77750638  -  77751122\t\t\n" +
                                "Direccion: 2a. Ave. 1-12, zona 3. Barrio San Francisco Coatepeque\n");
                        telefono="79799384";
                        break;
                    case "Las Delicias C.C":
                        datos.setText("Quetzaltenango\n" +
                                "Las Delicias, Colomba C. Cuca Estación # 37\t\n" +
                                "Tel: 4029 9230   -   4144 3883\t\t\n" +
                                "Direccion: Km 212.5 Cantón Las Delicias, carretera al pacífico Colomba Cuca.");
                        telefono="40299230";
                        break;
                    case "Salcaja":
                        datos.setText("Quetzaltenango\t\n" +
                                "Salcajá Estación # 54\t\n" +
                                "Tel: 52711249   -   41469353   -   40250037\t\t\n" +
                                "Direccion: Colonia San Luis, zona 2.\t\t\n");
                        telefono="40250037";
                        break;
                    case "Genova C.C":
                        datos.setText("Quetzaltenango\t\t\n" +
                                "Genova, Colomba Costa Cuca Estación # 56\t\n" +
                                "Tel: 4023 0406   /   5698 7933\t\n" +
                                "Direccion: Barrio 30 de Junio a un costado del Estadio Municipal, Campo de la Feria");
                        telefono="40230406";
                        break;
                    case "San Miguel Siguila":
                        datos.setText("Quetzaltenango\t\n" +
                                "San Miguel Siguilá Estación # 61\t\n" +
                                "Tel: 40286388  -  41465415 \t\t\n" +
                                "Direccion: A la par de la Policia Nacional, frente a la Municipalidad, Km. 218\t");
                        telefono="40286388";
                        break;
                    case "Chichicastenango":
                        datos.setText("Quiché\t\n" +
                                "Chichicastenango Estación # 3\t\n" +
                                "Tel: 4035 0823   -   41441530\t\t\n" +
                                "Direccion: 2a. Calle entre 4a. Y 5a. Avenida zona única, Km 220\n");
                        telefono="40350823";
                        break;
                    case "Camanchaj":
                        datos.setText("Quiché\t\n" +
                                "Camanchaj Estación # 5 \t\n" +
                                "Tel: 40308567  -  77411583\t\t\n" +
                                "Direccion: Km 131.5 Carretera  de Los Encuentros a Chichicastenango");
                        telefono="40308567";
                        break;
                    case "Cunen":
                        datos.setText("Quiché\t\n" +
                                "Cunén Estación # 14\t\n" +
                                "4032 9503\t\t\n" +
                                "Barrio San Francisco, frente a la iglesia católica del parque central\t");
                        telefono="40329503";
                        break;
                    case "Chicaman":
                        datos.setText("Quiché\t\n" +
                                "Chicamán Estación # 30 \t\n" +
                                "Tel: 4033 3073\t\t\n" +
                                "Direccion: En el puesto de salud frente al parque de Chicaman\t\n");
                        telefono="40333073";
                        break;
                    case "Santa Cruz":
                        datos.setText("Quiché\t\n" +
                                "Santa Cruz del Quiché Estación # 44\t\n" +
                                "Tel: 40271676  -  77563246\t\n" +
                                "Direccion: 10° Calle Interior Terminal de Buses zona 5, Santa  Cruz del Quiché");
                        telefono="40271676";
                        break;
                    case "San Pedro Jocopila":
                        datos.setText("Quiché\n" +
                                "San Pedro Jocopilas  Estación # 49\t\n" +
                                "Tel: 40233467\t\n" +
                                "Direccion: Última Cuadra yendo a Zacapulas, antes de llegar a la Gasolinera, a dos cuadreas de RENAP\n");
                        telefono="40233467";
                        break;
                    case "San Andres Sajcabaja":
                        datos.setText("Quiché\t\n" +
                                "San Andres Sajcabajá Estación # 53\t\n" +
                                "Tel: 4023 9307\t\t\n" +
                                "Direccion: Frente al Salon Municipal\t\n");
                        telefono="40239307";
                        break;
                    case "Santo Tomas QC":
                        datos.setText("Quiché\t\n" +
                                "Santo Tomas Chiché  Estación # 57\t\n" +
                                "Tel: 40232130  -  77555749\t\n" +
                                "Direccion: Frente de la Plaza Central, a la par del Centro de Salud");
                        telefono="40232130";
                        break;
                    case "Chiul":
                        datos.setText("Quiché\n" +
                                "Chiul Estación # 67\t\n" +
                                "Tel: 40311071   -   40308931\t\n" +
                                "Direccion: A la par del Parque Central de Chiul\t\n");
                        telefono="40311071";
                        break;
                    case "Huhuetenango":
                        datos.setText("Huehuetenango\t\t\t\t\t\t\t\n" +
                                "Huehuetenango    Estación # 97\n" +
                                "Tel: 41706006   -   77690007\t\t\n" +
                                "Direccion: Antiguo Hospital Nacional Zona 1, Huehuetenango\t\n");
                        telefono="41706006";
                        break;

                    case "Melchor De Mencos":
                        datos.setText("Petén\t\t\t\t\t\t\t\n" +
                                "Melchor De Mencos Estación # 41\t\n" +
                                "Tel: 53458424\t\n" +
                                "Direccion: Barrio Suchitan a un costado de Colonia Nueva Judhá");
                        telefono="53458424";
                        break;

                    case "Sayaxche":
                        datos.setText("Petén \t\t\t\t\t\t\t\t\n" +
                                "Sayaxché Estación # 63\t\n" +
                                "Tel: 40270837  -  57007824\t\t\n" +
                                "Direccion: Barrio la Esperanza Km. 65 Ruta a Cobán Sayaxché, Peten ");
                        telefono="40270837";
                        break;

                    case "Dolores":
                        datos.setText("Petén \t\t\t\t\t\t\t\t\n" +
                                "Dolores Estación Estación # 65\t\n" +
                                "Tel: 40340292   -   43350605   -   49080673\t \n" +
                                "Direccion: Barrio El Mirador, Dolores, Petén.\t\n");
                        telefono="40340292";
                        break;



                    case "Olintepeque":
                        datos.setText("Quetzaltenango, Olintepeque Guatemala Estación # 15" +
                                "\nTel: 40301948" +
                                "\nDireccion: 1° calle y 2° Av. Esquina, zona 2.");
                        telefono="40301948";
                        break;




                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void llamar(String tel) {
        Intent in = new Intent(Intent.ACTION_CALL);
        in.setData(Uri.parse("tel:" + tel));
        try {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                requestPermissions(new String[]{Manifest.permission.CALL_PHONE},
                        REQUEST_CODE_ASK_PERMISSIONS);
                return;
            }
            startActivity(in);

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
