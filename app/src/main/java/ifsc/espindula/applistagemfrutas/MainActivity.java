package ifsc.espindula.applistagemfrutas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private ListView m_lvListagemFruta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        m_lvListagemFruta = findViewById(R.id.lvListagemFrutas);
        m_lvListagemFruta.setAdapter(new FrutaAdapter(getApplicationContext(), R.layout.layout_listagem_frutas, new FrutaController().FRUTAS));
    }
}