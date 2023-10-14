package com.example.examen

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.examen.databinding.FragmentAgregarClienteBinding
import com.example.examen.databinding.FragmentAgregarVehiculoBinding
import com.google.android.material.snackbar.Snackbar

class AgregarClienteFragment : Fragment() {
    private var _binding: FragmentAgregarClienteBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentAgregarClienteBinding.inflate(inflater, container, false)
        return binding.root



    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.btnGuardarCliente.setOnClickListener {
            val cliente = Cliente(
                Nombre = binding.edtNombre.text.toString(),
                ApellidoP = binding.edtAP.text.toString(),
                ApellidoM = binding.edtAM.text.toString(),
                Domicilio = binding.edtDomicilio.text.toString(),
                FechaN = binding.edtFN.text.toString(),
                Estado = binding.edtEstado.text.toString(),
                Municipio = binding.edtMunicipio.text.toString())

            Singleton.listaCliente.add(cliente)
            Snackbar.make(it, "stored Client", Snackbar.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_agregarClienteFragment_to_listaClienteFragment)
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}