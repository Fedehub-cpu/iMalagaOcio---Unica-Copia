package com.cdp.malaga_ocio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class listaPubs extends AppCompatActivity {

    ArrayList<LugaresVO> listaLugares;
    RecyclerView recyclerSitios;
    ImageView star;
    Button btnUbicaciones2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pubs);

        listaLugares= new ArrayList<>();
        recyclerSitios=(RecyclerView) findViewById(R.id.RecyclerId);
        recyclerSitios.setLayoutManager(new LinearLayoutManager(this));
        btnUbicaciones2 = (Button) findViewById(R.id.btnUbicaciones3);

        btnUbicaciones2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(listaPubs.this, Maps_Pubs.class);
                startActivity(i);
            }
        });

        llenarSitios();

        Adaptador_Ubicaciones adapter = new Adaptador_Ubicaciones(listaLugares, new Adaptador_Ubicaciones.OnItemClickListener() {
            @Override
            public void onItemClick(LugaresVO item) {

                Toast.makeText(getApplicationContext(), item.getNombre(), Toast.LENGTH_SHORT).show();

                Intent i = new Intent(listaPubs.this, agregarFavorito.class);
                i.putExtra("nombre", item.getNombre());
                i.putExtra("ubicacion", item.getUbicacion());
                startActivity(i);

            }
        });
        recyclerSitios.setAdapter(adapter);
    }
    private void llenarSitios() {
        listaLugares.add(new LugaresVO("Irish pub", "<18 años", "10-30€", "Pl. de Uncibay, 6, 29008 Málaga", "Un pub con gran variedad de cervezas, incluidas sin gluten, atención rápida al cliente y numerosos grifos de cerveza con acompañamientos.",R.drawable.irishpub, 36.72260735115874, -4.420624485845706));
        listaLugares.add(new LugaresVO("El Muro Bar Independiente", "<20 años", "10-30€", "C. Muro de San Julián, 1, 29008", "Pub con decoración mix bar british, un ambiente agradable y tranquilo con mucha variedad de bebidas y combinados.",R.drawable.elmurobarindependiente, 36.72357357789759, -4.422599073059439));
        listaLugares.add(new LugaresVO("Classic Rock Bar", "<18 años", "20-50€", "Av de Sor Teresa Prat, 82, 29004 Málaga", "Pub con decoración, temática y música rockera donde se dan actuaciones en directo y contiene una amplia gama de bebidas con raciones y juegos en su interior.",R.drawable.classicrockmalaga, 36.69094946745444, -4.444866557717432));
        listaLugares.add(new LugaresVO("Morrisey's", "<18 años", "20-30€", "C/ Méndez Núñez, 5, 29008 Málaga", "Acogedor pub de aire irlandés con guinness, deportes en pantalla grande y en general un buen sitio para conocer gente de múltiples idiomas",R.drawable.morriseys, 36.72287867908658, -4.420665866312901));
        listaLugares.add(new LugaresVO("Sala Premier", "<22 años", "10-40€", "C. Molina Lario, 2, 29015 Málaga", "Juegos de mesa, cócteles y variedad de cervezas en original pub de dos plantas decorado con motivos de cine.",R.drawable.premier, 36.72132945589846, -4.420274379927808));
        listaLugares.add(new LugaresVO("Chester & Punk", "<25 años", "20-40€", "C/ Méndez Núñez, 4, 29008 Málaga", "Coctelería moderna y animada, con una vistosa decoración, que ofrece combinados creativos y conciertos en directo con regularidad.",R.drawable.chester, 36.72221167887135, -4.419636488402064));
        listaLugares.add(new LugaresVO("El Colmao", "<18 años", "5-30€", "C. dos Aceras, 18, 29012 Málaga", "Pub de ambiente animado, espacioso, con buenos precios y numerosos juegos dentro.",R.drawable.colmao, 36.72503047860437, -4.4206214730594136));
        listaLugares.add(new LugaresVO("Le Grand Cafe", "<18 años", "5-30€", "Av. Jenofonte, 20, 29010 Málaga", "Comida española informal en un bar de estilo desenfadado con obras de arte y un patio amplio.",R.drawable.legrandcafe, 36.71807907977973, -4.485374073059551));
        listaLugares.add(new LugaresVO("Alquimia", "<25 años", "10-20€", "C. Nosquera, 2, 29008 Málaga", "Pub de gran diversidad musical, numerosos tipos de chupitos originales y precios justos",R.drawable.alquimia, 6.72289009519961, -4.421922676278806));
        listaLugares.add(new LugaresVO("Amsterdam Café", "<20 años", "10-30€", "C/ Alcazabilla, 12, 29015 Málaga", "Pub localizado en pleno corazón de la ciudad, con terraza, buenas bebidas y cercano a numerosos sitios turísticos.",R.drawable.amsterdam, 36.72230177977987, -4.417019866312937));
    }

}
