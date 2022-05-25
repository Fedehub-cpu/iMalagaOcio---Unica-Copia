package com.cdp.malaga_ocio;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class listaDiscotecas extends AppCompatActivity {

    ArrayList<LugaresVO> listaLugares;
    RecyclerView recyclerSitios;
    ImageView star;
    Button btnUbicaciones3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_discos);

        listaLugares= new ArrayList<>();
        recyclerSitios=(RecyclerView) findViewById(R.id.RecyclerId);
        recyclerSitios.setLayoutManager(new LinearLayoutManager(this));
        btnUbicaciones3 = (Button) findViewById(R.id.btnUbicaciones3);
        btnUbicaciones3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(listaDiscotecas.this, Maps_Discos.class);
                startActivity(i);

            }
        });

        llenarSitios();

        Adaptador_Ubicaciones adapter = new Adaptador_Ubicaciones(listaLugares, new Adaptador_Ubicaciones.OnItemClickListener() {
            @Override
            public void onItemClick(LugaresVO item) {


                Toast.makeText(getApplicationContext(), item.getNombre(), Toast.LENGTH_SHORT).show();

                Intent i = new Intent(listaDiscotecas.this, agregarFavorito.class);
                i.putExtra("nombre", item.getNombre());
                i.putExtra("ubicacion", item.getUbicacion());
                startActivity(i);
            }
        });
        recyclerSitios.setAdapter(adapter);
    }
    private void llenarSitios() {
        listaLugares.add(new LugaresVO("Sala Wengé", "<18 años", "10-30€", "C. Sta. Lucía, 11", "Discoteca del centro de Málaga de ambiente juvenil,espaciosa y con música actual.",R.drawable.wenge, 36.72209547829764, -4.42196569759701));
        listaLugares.add(new LugaresVO("Sala Bubbles", "<20 años", "10-50€", "C. Mártires, 14, 29008 Málaga", "Sesiones DJ y fiestas temáticas en moderna discoteca con amplia pista central, dos barras y dos reservados.",R.drawable.bubbles, 36.72215024883813, -4.422679653523334));
        listaLugares.add(new LugaresVO("Barsovia", "<18 años", "10-50€", "C/ Méndez Núñez, 3, 29008 Málaga", "Discoteca y bar de copas de decoración actual con música variada, incluidos éxitos de los 80 y 90.",R.drawable.barsovia, 36.72220067996817, -4.419804401895107));
        listaLugares.add(new LugaresVO("Malafama", "<18 años", "10-50€", "Pje. Mitjana, 1, 29008 Málaga", "Sesiones DJ y fiestas temáticas en un disco bar con moderna iluminación LED de colores y cuatro barras.",R.drawable.malafama, 36.722404280747355, -4.421004673059467));
        listaLugares.add(new LugaresVO("Ritual Vip Club", "<18 años", "10-50€", "Av. de Isaac Peral, 43, 29004 Málaga", "2da discoteca más grande de Málaga con múltiples sitios de reservado,variedad de copas y ambientación LED.",R.drawable.ritual, 36.69199007695951, -4.459790673060047));
        listaLugares.add(new LugaresVO("Teatro Club Málaga", "<18 años", "10-50€", "C. Lazcano, 5, 29008 Málaga", "Noches de temática reggae, house y retro en un animado club nocturno, con extravagantes espectáculos de drag queens.",R.drawable.teatroclub, 36.72253747956522, -4.421354373059464));
        listaLugares.add(new LugaresVO("El Andén", "<18 años", "10-50€", "Pl. de Uncibay, 8, 29008 Málaga", "Amplia discoteca de varias salas con láseres, zonas vip y 4 bares, que abre hasta el amanecer.",R.drawable.anden, 36.72274957911551, -4.420315030730741));
        listaLugares.add(new LugaresVO("Paris 15", "<18 años", "10-50€", "C. la Orotava, 27, 29006 Málaga", "Discoteca de amplio aforo con un gran escenario para conciertos de música indie, pop, rock y sesiones de DJ.",R.drawable.paris15, 36.70467117678075, -4.476439144224123));
        listaLugares.add(new LugaresVO("Akari Dance Club", "<18 años", "10-50€", "Av. de Isaac Peral, 43, 29004 Málaga", "Discoteca espaciosa y tematizada, con numerosas salas y una de ellas con terraza al aire libre, música actal y DJ.",R.drawable.akari, 36.692041695035556, -4.45976921538874));
        listaLugares.add(new LugaresVO("ZZ Pub", "<18 años", "10-50€", "C. Tejón y Rodríguez, 6, 29008 Málaga", "Recinto de conciertos sencillo, donde cada noche hay actuaciones de bandas de rock, soul, blues y música indie.",R.drawable.zzpub, 36.723974276598916, -4.421523044223797));
    }
}
