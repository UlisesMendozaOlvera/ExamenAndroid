package com.example.examen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.examen.databinding.FragmentListaVehiculosBinding


class ListaVehiculoFragment : Fragment() {
    private var _binding: FragmentListaVehiculosBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentListaVehiculosBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().addMenuProvider(object : MenuProvider{
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.menu_fragment,menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return when (menuItem.itemId){
                    R.id.menu_fragment_to_fragment_agregar_vehiculo -> {
                        findNavController().navigate(R.id.action_listaVehiculoFragment_to_agregarVehiculoFragment)
                        true
                    }
                    R.id.menu_fragment_to_fragment_agregar_cliente -> {
                        findNavController().navigate(R.id.action_listaVehiculoFragment_to_agregarClienteFragment)
                        true
                    }
                    R.id.menu_fragment_to_fragment_lista_cliente -> {
                        findNavController().navigate(R.id.action_listaVehiculoFragment_to_listaClienteFragment)
                        true
                    }



                    else -> false
                }
            }
        }, viewLifecycleOwner)

        ActualizarRecyclerView()
    }

    fun MostrarVehiculo(vehiculo: Vehiculo){

        Toast.makeText(context, "Clic a ${vehiculo.nombre}", Toast.LENGTH_LONG).show()
    }

    fun EliminarVehiculo(vehiculo: Vehiculo){
        val dialog = EliminarVehiculosDialogFragment(vehiculo, {ActualizarRecyclerView()})
        activity?.let{dialog.show(it.supportFragmentManager, "Eliminar Vehiculo")}

    }

    fun ActualizarRecyclerView(){
        binding.recyclerView.adapter = ListaVehiculosAdapter(
            //{MostrarVehiculo(it)}
            { EliminarVehiculo(it) }
        )
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}