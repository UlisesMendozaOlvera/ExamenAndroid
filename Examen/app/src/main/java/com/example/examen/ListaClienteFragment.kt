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
import com.example.examen.databinding.FragmentListaClientesBinding
import com.example.examen.databinding.FragmentListaVehiculosBinding


class ListaClienteFragment : Fragment() {
    private var _binding: FragmentListaClientesBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentListaClientesBinding.inflate(inflater, container, false)
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
                    R.id.menu_fragment_to_fragment_lista_vehiculos -> {
                        findNavController().navigate(R.id.action_listaClienteFragment_to_listaVehiculoFragment2)
                        true
                    }


                    else -> false
                }
            }
        }, viewLifecycleOwner)

        ActualizarRecyclerView()
    }

    fun MostrarCliente(cliente: Cliente){

        Toast.makeText(context, "Clic a ${cliente.Nombre}", Toast.LENGTH_LONG).show()
    }

    fun EliminarCliente(cliente: Cliente){
        val dialog = EliminarClientesDialogFragment(cliente, {ActualizarRecyclerView()})
        activity?.let{dialog.show(it.supportFragmentManager, "Eliminar Vehiculo")}

    }

    fun ActualizarRecyclerView(){
        binding.recyclerView.adapter = ListaClientesAdapter(
            //{MostrarCliente(it)}
            { EliminarCliente(it) }
        )
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}