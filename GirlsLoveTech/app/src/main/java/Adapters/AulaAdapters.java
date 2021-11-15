package Adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.girlslovetech.R;

import java.util.ArrayList;

import Holders.AulaHolder;
import Holders.CursoHolder;
import models.Aula;

public class AulaAdapters extends RecyclerView.Adapter<AulaHolder> {



    private final ArrayList<Aula> aulas;

    public AulaAdapters(ArrayList<Aula> aulas) {
        this.aulas = aulas;
    }


    @NonNull
    @Override
    public AulaHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AulaHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lista_aula,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull AulaHolder holder, int position) {
        holder.txt_nome_aula.setText(aulas.get(position).getNomeAula());
    }

    @Override
    public int getItemCount() {
        return aulas != null ? aulas.size() : 0;
    }
}
