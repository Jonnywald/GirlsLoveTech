package Adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import Holders.CursoHolder;
import models.Curso;

import com.example.girlslovetech.R;

public class CursoAdapters extends RecyclerView.Adapter<CursoHolder> {



        private final ArrayList<Curso> cursos;

        public CursoAdapters(ArrayList<Curso> cursos) {
            this.cursos = cursos;
        }


        @Override
        public CursoHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new CursoHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lista_curso,parent,false));
        }

        @Override
        public void onBindViewHolder(CursoHolder holder, int position) {
            holder.txt_nome_curso.setText(cursos.get(position).getNomeCurso());

        }

        @Override
        public int getItemCount() {
            return cursos != null ? cursos.size() : 0;
        }
    }


