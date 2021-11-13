package Holders;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import com.example.girlslovetech.R;

public class CursoHolder extends RecyclerView.ViewHolder {

        public TextView txt_nome_curso;


        public CursoHolder(View view){
        super(view);

             txt_nome_curso = (TextView)view.findViewById(R.id.txt_nome_curso);

        }
}