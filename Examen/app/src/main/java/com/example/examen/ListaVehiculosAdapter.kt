package com.example.examen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListaVehiculosAdapter(val funcion: (Vehiculo) -> Unit) : RecyclerView.Adapter<ListaVehiculosAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvName: TextView
        val tvMotor: TextView
        val tvTrasmision: TextView
        val tvTipo: TextView
        val tvAC: CheckBox
        val tvModelo: TextView
        val tvABS: CheckBox
        val tvAB: CheckBox
        val tvCp: TextView
        val tvFp: TextView


        init {
            // Define click listener for the ViewHolder's View.
            tvName = view.findViewById(R.id.tvName)
            tvMotor = view.findViewById(R.id.tvDireccion)
            tvTrasmision = view.findViewById(R.id.tvFN)
            tvTipo = view.findViewById(R.id.tvTipo)
            tvAC = view.findViewById(R.id.tvAC)
            tvModelo = view.findViewById(R.id.tvAP)
            tvABS = view.findViewById(R.id.tvABS)
            tvAB = view.findViewById(R.id.tvAB)
            tvCp = view.findViewById(R.id.tvEstado)
            tvFp = view.findViewById(R.id.tvMunicipio)

        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.list_view_item, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.tvName.text = Singleton.listaVehiculos[position].nombre
        viewHolder.tvMotor.text = Singleton.listaVehiculos[position].motor
        viewHolder.tvTrasmision.text = Singleton.listaVehiculos[position].trasmision
        viewHolder.tvTipo.text = Singleton.listaVehiculos[position].tipo
        viewHolder.tvAC.isChecked = Singleton.listaVehiculos[position].aireAcondicionado
        viewHolder.tvModelo.text = Singleton.listaVehiculos[position].modelo
        viewHolder.tvABS.isChecked = Singleton.listaVehiculos[position].frenosABS
        viewHolder.tvAB.isChecked = Singleton.listaVehiculos[position].bolsasAire
        viewHolder.tvCp.text = Singleton.listaVehiculos[position].precioContado.toString()
        viewHolder.tvFp.text = Singleton.listaVehiculos[position].precioFinanciado.toString()

        //Falta codigo
        if(Singleton.listaVehiculos[position].aireAcondicionado == false){

        }
        viewHolder.itemView.setOnClickListener {
            funcion(Singleton.listaVehiculos[position])
        }

    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = Singleton.listaVehiculos.size
}