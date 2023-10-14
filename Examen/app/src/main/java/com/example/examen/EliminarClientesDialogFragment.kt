package com.example.examen

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class EliminarClientesDialogFragment(val cliente: Cliente, val function: (Cliente) -> Unit): DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            // Use the Builder class for convenient dialog construction.
            val builder = AlertDialog.Builder(it)
            builder.setMessage("Remove Client ${cliente.Nombre}")
                .setPositiveButton("Yes") { dialog, id ->
                    // START THE GAME!
                    Singleton.listaCliente.remove(cliente)
                    function(cliente)
                }
                .setNegativeButton("No") { dialog, id ->
                    // User cancelled the dialog.
                }
            // Create the AlertDialog object and return it.
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}
