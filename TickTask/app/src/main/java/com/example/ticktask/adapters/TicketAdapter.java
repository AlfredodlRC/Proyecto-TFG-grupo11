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
        holder.tvTitulo.setText(ticket.getTitulo());
        holder.tvPrioridad.setText(ticket.getPrioridad());
        holder.tvTipo.setText(ticket.getTipoIncidencia());
        holder.tvFechaCreacion.setText(ticket.getFechaCreacion());
        holder.tvPersonaCreadora.setText(ticket.getPersonaCreadora());
        holder.tvDepartamento.setText(ticket.getDepartamento());
        holder.tvPersonaAsignada.setText(ticket.getPersonaAsignada());
        holder.tvDescripcion.setText(ticket.getDescripcion());
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
