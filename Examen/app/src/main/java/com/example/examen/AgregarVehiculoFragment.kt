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
import com.example.examen.databinding.FragmentAgregarVehiculoBinding
import com.google.android.material.snackbar.Snackbar

class AgregarVehiculoFragment : Fragment() {
    private var _binding: FragmentAgregarVehiculoBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentAgregarVehiculoBinding.inflate(inflater, container, false)
        return binding.root



    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.btnGuardarVehiculo.setOnClickListener {
            val vehiculo = Vehiculo(nombre = binding.edtName.text.toString(),
                tipo = binding.aCTtipo.text.toString(),
                modelo = binding.edtModelo.text.toString(),
                motor = binding.aCTmotor.text.toString(),
                trasmision = binding.aCTtrasmision.text.toString(),
                aireAcondicionado = binding.swAireAcondiccionado.isChecked,
                bolsasAire = binding.swBolsasAire.isChecked,
                frenosABS = binding.swFrenosABS.isChecked,
                precioContado = binding.edtPrecioContado.text.toString().toDouble(),
                precioFinanciado = binding.edtPrecioFinanciado.text.toString().toDouble(),)

            Singleton.listaVehiculos.add(vehiculo)
            Snackbar.make(it, "stored vehicle", Snackbar.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_agregarVehiculoFragment_to_listaVehiculoFragment)
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}