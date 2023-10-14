package com.example.examen

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class EliminarVehiculosDialogFragment(val vehiculo: Vehiculo, val function: (Vehiculo) -> Unit): DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            // Use the Builder class for convenient dialog construction.
            val builder = AlertDialog.Builder(it)
            builder.setMessage("Remove Vehiculo ${vehiculo.nombre}")
                .setPositiveButton("Yes") { dialog, id ->
                    // START THE GAME!
                    Singleton.listaVehiculos.remove(vehiculo)
                    function(vehiculo)
                }
                .setNegativeButton("No") { dialog, id ->
                    // User cancelled the dialog.
                }
            // Create the AlertDialog object and return it.
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}
