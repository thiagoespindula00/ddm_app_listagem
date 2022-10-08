package ifsc.espindula.applistagemfrutas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class FrutaAdapter extends ArrayAdapter {

    private Context m_Contexto;
    private int m_idLayout;

    public FrutaAdapter(@NonNull Context context, int resource, @NonNull Object[] objects) {
        super(context, resource, objects);

        this.m_Contexto = context;
        this.m_idLayout = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(m_Contexto);
        convertView = layoutInflater.inflate(m_idLayout, parent, false);
        ImageView ivImagemFruta     = convertView.findViewById(R.id.ivImagemFruta);
        TextView  tvCodigoFruta     = convertView.findViewById(R.id.tvCodigoFruta);
        TextView  tvNomeFruta       = convertView.findViewById(R.id.tvNomeFruta);
        TextView  tvDescricaoFruta  = convertView.findViewById(R.id.tvDescricaoFruta);
        TextView  tvPrecoFruta      = convertView.findViewById(R.id.tvPrecoFruta);
        TextView  tvPrecoVendaFruta = convertView.findViewById(R.id.tvPrecoVendaFruta);
        Fruta     fruta             = (Fruta) getItem(position);

        ivImagemFruta    .setImageResource(fruta.getImagem());
        tvCodigoFruta    .setText(String.valueOf(fruta.getCodigo()));
        tvNomeFruta      .setText(fruta.getNome());
        tvDescricaoFruta .setText(fruta.getDescricao());
        tvPrecoFruta     .setText(String.valueOf(fruta.getPreco()      .setScale(2, RoundingMode.HALF_DOWN).doubleValue()));
        tvPrecoVendaFruta.setText(String.valueOf(fruta.getPreco_venda().setScale(2, RoundingMode.HALF_DOWN).doubleValue()));

        return convertView;
    }
}
