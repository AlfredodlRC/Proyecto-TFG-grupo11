package com.example.ticktask.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.ticktask.R;
import com.example.ticktask.Ticket;

import java.util.List;

public class TicketAdapter extends RecyclerView.Adapter<TicketAdapter.TicketViewHolder> {
    private List<Ticket> tickets;  // Los datos de tus tickets

    // Proporciona una referencia a las vistas para cada elemento de datos
    public static class TicketViewHolder extends RecyclerView.ViewHolder {
        public TextView ticketName;
        public TextView ticketDescription;
        public TextView ticketPerson;
        public TextView ticketDepartment;
        // Añade referencias para departamentoAsignado y personaAsignada

        public TicketViewHolder(View v) {
            super(v);
            ticketName = v.findViewById(R.id.ticket_name);
            ticketDescription = v.findViewById(R.id.ticket_department);
            ticketPerson = v.findViewById(R.id.ticket_person);
            // Inicializa departamentoAsignado y personaAsignada aquí...
        }
    }

    // Constructor
    public TicketAdapter(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    // Crea nuevas vistas (invocado por el layout manager)
    @Override
    public TicketAdapter.TicketViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // infla la vista del ítem
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_ticket, parent, false);
        TicketViewHolder vh = new TicketViewHolder(v);
        return vh;
    }

    // Reemplaza el contenido de la vista (invocado por el layout manager)
    @Override
    public void onBindViewHolder(TicketViewHolder holder, int position) {
        // Obtiene el ticket de esta posición y rellena las vistas con sus datos
        Ticket ticket = tickets.get(position);
        holder.ticketName.setText(ticket.getNombre());
        holder.ticketDescription.setText(ticket.getDescripcion());
        holder.ticketDepartment.setText(ticket.getDepartamentoAsignado());
        holder.ticketPerson.setText(ticket.getPersonaAsignada());
        // Rellena departamentoAsignado y personaAsignada aquí...
    }

    // Devuelve el tamaño del dataset (invocado por el layout manager)
    @Override
    public int getItemCount() {
        return tickets.size();
    }

}
