package com.example.examen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListaClientesAdapter(val funcion: (Cliente) -> Unit) : RecyclerView.Adapter<ListaClientesAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvNombre: TextView
        val tvDirreccion: TextView
        val tvFN: TextView
        val tvEstado: TextView
        val tvMunicipio: TextView



        init {
            // Define click listener for the ViewHolder's View.
            tvNombre = view.findViewById(R.id.tvName)
            tvDirreccion = view.findViewById(R.id.tvDireccion)
            tvFN = view.findViewById(R.id.tvFN)
            tvEstado = view.findViewById(R.id.tvEstado)
            tvMunicipio = view.findViewById(R.id.tvMunicipio)


        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.list_view_item_clientes, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.tvNombre.text = Singleton.listaCliente[position].Nombre
        viewHolder.tvDirreccion.text = Singleton.listaCliente[position].Domicilio
        viewHolder.tvFN.text = Singleton.listaCliente[position].FechaN
        viewHolder.tvEstado.text = Singleton.listaCliente[position].Estado
        viewHolder.tvMunicipio.text = Singleton.listaCliente[position].Municipio


        //Falta codigo

        viewHolder.itemView.setOnClickListener {
            funcion(Singleton.listaCliente[position])
        }

    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = Singleton.listaCliente.size
}