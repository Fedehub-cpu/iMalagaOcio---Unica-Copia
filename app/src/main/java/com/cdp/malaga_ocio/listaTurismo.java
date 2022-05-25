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

public class listaTurismo extends AppCompatActivity {


    ArrayList<LugaresVO> listaLugares;
    RecyclerView recyclerSitios;
    ImageView star;
    Button btnUbicaciones4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_turismo);

        listaLugares= new ArrayList<>();
        recyclerSitios=(RecyclerView) findViewById(R.id.RecyclerId);
        recyclerSitios.setLayoutManager(new LinearLayoutManager(this));
        btnUbicaciones4 = (Button) findViewById(R.id.btnUbicaciones4);
        btnUbicaciones4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(listaTurismo.this, Maps_turismo.class);
                startActivity(i);
            }
        });

        llenarSitios();

        Adaptador_Ubicaciones adapter = new Adaptador_Ubicaciones(listaLugares, new Adaptador_Ubicaciones.OnItemClickListener() {
            @Override
            public void onItemClick(LugaresVO item) {

                Toast.makeText(getApplicationContext(), item.getNombre(), Toast.LENGTH_SHORT).show();

                Intent i = new Intent(listaTurismo.this, agregarFavorito.class);
                i.putExtra("nombre", item.getNombre());
                i.putExtra("ubicacion", item.getUbicacion());
                startActivity(i);
            }
        });
        recyclerSitios.setAdapter(adapter);
    }
    private void llenarSitios() {
        listaLugares.add(new LugaresVO("Alcazaba", "Apto para todos los públicos.", "3'50€", "C/ Alcazabilla, 2, 29012 Málaga", "Fortaleza medieval de estilo árabe con jardines frondosos y fuentes en un monte con vistas al mar.",R.drawable.alcazaba, 36.72114337972158, -4.4158451442238285));
        listaLugares.add(new LugaresVO("Museo Picasso", "Apto para todos los públicos.", "9€", "Palacio de Buenavista, C. San Agustín, 8, 29015 Málaga", "Palacio remodelado del siglo XVI que alberga una colección de más de 200 obras del artista Pablo Picasso.",R.drawable.museopicaso, 36.721744879654004, -4.418407644223806));
        listaLugares.add(new LugaresVO("Museo Carmen Thyssen", "Apto para todos los públicos.", "10€", "Plaza Carmen Thyssen, 29008 Málaga", "Museo de arte en palacio renacentista del s. XVI con obras maestras de artistas españoles y de otros países.",R.drawable.thyssen, 36.721400880244964, -4.422966415388178));
        listaLugares.add(new LugaresVO("Frigiliana", "Apto para todos los públicos.", "10-50€", "nº, Av. Carlos Cano, 29788 Frigiliana, Málaga", "Frigiliana es un municipio de la provincia de Málaga, en la comunidad autónoma de Andalucía, España. Se encuentra situado en la comarca de la Axarquía, la más oriental de la provincia, e integrado en el partido judicial de Torrox.",R.drawable.frigiliana, 36.79402362608128, -3.8969737267239846));
        listaLugares.add(new LugaresVO("Catedral de la Encarnación", "Apto para todos los públicos.", "0€", "C. Molina Lario, 9, 29015 Málaga", "Catedral emblemática del s. XVI con fachada de estilo barroco, espectacular sillería del coro y museo. También llamada la 'manquita'",R.drawable.catedralencarnacion, 36.720167779968776, -4.419256957716884));
        listaLugares.add(new LugaresVO("Cuevas de Nerja", "Apto para todos los públicos.", "12€", "Carr. de Bajada a Playa de Maro, 29787, Málaga", "Extenso complejo de galerías subterráneas naturales con visitas guiadas y festival de danza y música clásica.",R.drawable.cuevasdenerja, 36.76206528481483, -3.844922817783007));
        listaLugares.add(new LugaresVO("Cementerio Inglés", "Apto para todos los públicos.", "4€", "Av. Príes, 1, 29016 Málaga", "El cementerio protestante más antiguo de España, que incluye una iglesia anglicana y una puerta de entrada.",R.drawable.cementerioingles, 36.72119318047644, -4.407130915388158));
        listaLugares.add(new LugaresVO("Jardines de Pedro Luis Alonso", "Apto para todos los públicos.", "0€", "C. Guillén Sotelo, 31, 29016 Málaga", "Jardín paisajístico conocido por sus rosas y ambiente tranquilo, con un estanque de lirios y bancos..",R.drawable.jardinespedroluis, 36.7206799782479, -4.414291388402097));
        listaLugares.add(new LugaresVO("El Caminito del Rey", "Apto para todos los públicos.", "10€", "El Caminito del Rey, 29550 Ardales, Málaga", "Ruta que lleva hasta un puente peatonal que atraviesa el desfiladero de los Gaitanes con abundante naturaleza y maravillosas vistas paisajísticas.",R.drawable.caminitodelrey, 36.93016475105151, -4.800582530726754));
        listaLugares.add(new LugaresVO("Parque Natural Torcal", "Apto para todos los públicos.", "0€", "Calle el Torcal de Antequera, 70, 75, 29200 Antequera, Málaga", "Extenso parque natural con torres de piedra caliza, una flora exuberante y rutas de senderismo.",R.drawable.torcal, 36.95212495846101, -4.5422786018906915));
    }
}
