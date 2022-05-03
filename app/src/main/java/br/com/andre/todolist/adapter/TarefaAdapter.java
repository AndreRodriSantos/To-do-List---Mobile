package br.com.andre.todolist.adapter;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import br.com.andre.todolist.R;
import br.com.andre.todolist.model.Tarefa;

public class TarefaAdapter extends RecyclerView.Adapter<TarefaAdapter.TarefaViewHolder> {
    //Lista de tarefas
    private List<Tarefa> tarefas;
    //varaivel para o Context
    private Context context;

    //construtor pra receber os valores da lista
    public TarefaAdapter(List<Tarefa> lista, Context contexto){
        this.tarefas = lista;
        this.context = contexto;
    }

    @NonNull
    @Override
    public TarefaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //infla o layout do adapter
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_tarefa,parent, false);
        //retorna um novo view Holder com a view
        return new TarefaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TarefaViewHolder holder, int position) {
        //obtem a tarefa pela position
        Tarefa t = tarefas.get(position);
        holder.titulo_item.setText(t.getTitulo());
        if (t.isFinalizada()){
            holder.status_item.setText(R.string.concluida);
            holder.status_item.setBackgroundColor(context.getResources().getColor(R.color.green));
        }else{
            holder.status_item.setText(R.string.aberta);
            holder.status_item.setBackgroundColor(context.getResources().getColor(R.color.light_orange));
        }
        //formata a data de long para string
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyy");
        holder.data_item.setText(formatador.format(t.getDataPrevista()));

        Calendar.getInstance().getTimeInMillis();

    }

    @Override
    //retorna a quantidade de elementos a serem exibidos
    public int getItemCount() {
        if(tarefas != null){
            return tarefas.size();
        }
        return  0;
    }

    //Classe ViewHolder pra mapear aos components do xml
    class TarefaViewHolder extends RecyclerView.ViewHolder {
        //variaveis para acessar os componentes do XML
        TextView titulo_item, data_item, status_item;

        public TarefaViewHolder(View view) {
            //chama o construtor da superclasse
            super(view);
            //passar para as variaveis, os componentes do XML
            titulo_item = view.findViewById(R.id.titulo_item);
            data_item = view.findViewById(R.id.data_item);
            status_item = view.findViewById(R.id.status_item);
        }
    }
}
