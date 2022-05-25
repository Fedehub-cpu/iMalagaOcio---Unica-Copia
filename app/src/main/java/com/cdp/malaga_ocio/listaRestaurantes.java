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

public class listaRestaurantes extends AppCompatActivity {

    ArrayList<LugaresVO> listaLugares;
    RecyclerView recyclerSitios;
    ImageView star;
    Button btnUbicaciones1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_restaurantes);

        listaLugares= new ArrayList<>();
        recyclerSitios=(RecyclerView) findViewById(R.id.RecyclerId);
        recyclerSitios.setLayoutManager(new LinearLayoutManager(this));
        btnUbicaciones1 = (Button) findViewById(R.id.btnUbicaciones1);

        btnUbicaciones1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(listaRestaurantes.this, Maps_Restaurantes.class);
                startActivity(i);
            }
        });

        llenarSitios();


        Adaptador_Ubicaciones adapter = new Adaptador_Ubicaciones(listaLugares, new Adaptador_Ubicaciones.OnItemClickListener() {
            @Override
            public void onItemClick(LugaresVO item) {
                Toast.makeText(getApplicationContext(), item.getNombre(), Toast.LENGTH_SHORT).show();

                Intent i = new Intent(listaRestaurantes.this, agregarFavorito.class);
                i.putExtra("nombre", item.getNombre());
                i.putExtra("ubicacion", item.getUbicacion());
                startActivity(i);
            }
        });
        recyclerSitios.setAdapter(adapter);
    }


    private void llenarSitios() {
        listaLugares.add(new LugaresVO("El Tintero", "<25 años", "30-60€", "Playa del Dedo", "Un sitio bonito donde comer todo tipo de pescado y marisco en Málaga con preciosas vistas al mar.",R.drawable.tintero, 36.716812, -4.348082));
        listaLugares.add(new LugaresVO("Los Hidalgos", "<20 años", "20-50€", "C. Duque de la Victoria, 8, 29015 Málaga", "Taberna malagueña con mucha variedad de tapas exquisitas.",R.drawable.hidalgos, 36.721333146781184, -4.419684664459294));
        listaLugares.add(new LugaresVO("La Venta del Túnel", "<10 años", "20-50€", "Carretera, MA-3101, km 2, 29014", "Restaurante de rica comida casera andaluza con uno de los mejores arroces de paella de Málaga.",R.drawable.ventadeltunel, 36.7811383338127, -4.435062086551398));
        listaLugares.add(new LugaresVO("Bar Los Fernández", "<10 años", "20-30€", "C. Rafael Fernández, 29014 Málaga", "Bar-restaurante de comida casera situado en ciudad jardín un lugar humilde donde relajarse con amplia disponibilidad de tapas.",R.drawable.barcasafernandez, 36.7440538809191, -4.421941182453985));
        listaLugares.add(new LugaresVO("Lacaliza", "<20 años", "20-70€", "Urb. Cueva del Tesoro, 16, 29720 Málaga", "Un restaurante cercano a la cala del moral con excelentes vistas y una comida deliciosa para disfrutar en compañía.",R.drawable.lacaliza, 36.71917651921393, -4.296607683678349));
        listaLugares.add(new LugaresVO("La Tranca", "<25 años", "20-40€", "C. Carretería, 92, 29008 Málaga", "Pequeña tasca andaluza donde disfrutar de diferentes raciones y bebidas con una calidad-precio razonable y buena música española",R.drawable.latranca, 36.72434407039864, -4.421138988402036));
        listaLugares.add(new LugaresVO("Hamburguesería Durán Durán", "<10 años", "5-30€", "Av de Sor Teresa Prat, 84, 29004 Málaga", "Uno de las hamburgueserías más ricas de Málaga donde probar un auténtico campero malagueño con una carta muy amplia y variedad de platos.",R.drawable.duranduran, 36.690518495887986, -4.445032528881798));
        listaLugares.add(new LugaresVO("Cha-Cha Café-Terraza", "<10 años", "5-30€", "C. Alcalde Nicolás Maroto, 6, Local, 29014 Málaga", "Una de las cafeterías más tradicionales y típicas de ciudad jardín donde se sirven además raciones y todo tipo de bebidas con un ambiente muy alegre y sencillo.",R.drawable.chacha, 36.74892537661007, -4.418920530726185));
        listaLugares.add(new LugaresVO("El Pimpi", "<20 años", "10-20€", "C. Granada, 62, 29015 Málaga", "Una de las tabernas más famosas de Málaga de tapas y vinos locales con ambiente flamenco y estética andaluza.",R.drawable.elpimpi, 36.72193536891017, -4.418129656774526));
        listaLugares.add(new LugaresVO("Kosei Ramen", "<20 años", "10-20€", " C. Carretería, 56, 29008 Málaga", "Restaurante japonés informal y acogedor, uno de los mejores sitios de Málaga para comer ramen con un servicio muy amable y hospitalario.",R.drawable.kosei, 36.72335505318268, -4.423514218460807));
    }

}