package com.example.ticktask.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ticktask.R;
import com.example.ticktask.Ticket;

import java.util.List;

public class TicketAdapter extends RecyclerView.Adapter<TicketAdapter.TicketViewHolder> {
    private List<Ticket> tickets;  // Los datos de los tickets
    private Context context;

    public TicketAdapter(List<Ticket>tickets, Context context){
        this.tickets= tickets;
        this.context = context;
    }

    @NonNull
    @Override
    public TicketViewHolder onCreateViewHolder(@NonNull ViewGroup parent,int viewType){
        View view = LayoutInflater.from(context).inflate(R.layout.item_ticket, parent, false);
        return new TicketViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TicketViewHolder holder, int position){
        Ticket ticket = tickets.get(position);
        holder.tvTitulo.setText(context.getString(R.string.nombre_ticket, ticket.getTitulo()));
        holder.tvPrioridad.setText(context.getString(R.string.tipo_solicitud, ticket.getPrioridad()));
        holder.tvTipo.setText(context.getString(R.string.Prioridad,ticket.getTipoIncidencia()));
        holder.tvFechaCreacion.setText(context.getString(R.string.date,ticket.getFechaCreacion()));
     //   holder.tvPersonaCreadora.setText(context.getString(R.string.departamento,ticket.getPersonaCreadora()));
        holder.tvDepartamento.setText(context.getString(R.string.departamento,ticket.getDepartamento()));
        holder.tvPersonaAsignada.setText(context.getString(R.string.Usuario_Asignado,ticket.getPersonaAsignada()));
        holder.tvDescripcion.setText(context.getString(R.string.descriptionText,ticket.getDescripcion()));
    }

    @Override
    public int getItemCount() {
        Log.d("TicketAdapter", "Número total de tickets: " + tickets.size());
        return tickets.size();
    }

    public class TicketViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitulo, tvPrioridad, tvTipo, tvFechaCreacion, tvPersonaCreadora,
                tvDepartamento, tvPersonaAsignada, tvDescripcion;

        public TicketViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitulo = itemView.findViewById(R.id.TVtitulo);
            tvPrioridad = itemView.findViewById(R.id.TVprioridad);
            tvTipo = itemView.findViewById(R.id.TVtipo);
            tvFechaCreacion = itemView.findViewById(R.id.TVfecha_creacion);
            tvPersonaCreadora = itemView.findViewById(R.id.TVpersona_creadora);
            tvDepartamento = itemView.findViewById(R.id.TVdepartamento);
            tvPersonaAsignada = itemView.findViewById(R.id.TVpersona_asignada);
            tvDescripcion = itemView.findViewById(R.id.TVdescripcion);
        }
    }


}
