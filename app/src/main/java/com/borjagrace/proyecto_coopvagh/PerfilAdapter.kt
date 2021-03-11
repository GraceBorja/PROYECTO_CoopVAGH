package com.borjagrace.proyecto_coopvagh

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_perfil.view.*

class PerfilAdapter(private var lista1: ArrayList<Perfil>, private var contexto: Context): RecyclerView.Adapter<PerfilAdapter.ViewHolder1>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder1 {
        return  ViewHolder1(LayoutInflater.from(parent.context).inflate(R.layout.item_perfil, parent, false), contexto)
    }

    override fun onBindViewHolder(holder: PerfilAdapter.ViewHolder1, position: Int) {
        holder.bind(lista1[position])
    }

    override fun getItemCount(): Int {
        return lista1.size
    }

    class ViewHolder1 (var vista: View, contexto: Context ): RecyclerView.ViewHolder(vista){
        fun  bind(perfil: Perfil){
            vista.imagenIcono.setImageResource(perfil.icono)
            vista.textTexto.text = perfil.texto
            vista.imageBoton.setImageResource(perfil.boton)
        }
    }
}