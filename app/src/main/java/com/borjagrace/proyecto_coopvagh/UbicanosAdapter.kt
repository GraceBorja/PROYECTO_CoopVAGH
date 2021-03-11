package com.borjagrace.proyecto_coopvagh

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_contacto.view.*

class UbicanosAdapter (private var lista1: ArrayList<Contacto>, private var contexto: Context): RecyclerView.Adapter<UbicanosAdapter.ViewHolder1>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder1 {
        return  ViewHolder1(LayoutInflater.from(parent.context).inflate(R.layout.item_contacto, parent, false), contexto)
    }

    override fun onBindViewHolder(holder: UbicanosAdapter.ViewHolder1, position: Int) {
        holder.bind(lista1[position])
    }

    override fun getItemCount(): Int {
        return lista1.size
    }

    class ViewHolder1 (var vista: View, contexto: Context ): RecyclerView.ViewHolder(vista){
        fun  bind(contacto: Contacto){
            vista.imageIcono2.setImageResource(contacto.icono)
            vista.textTexto1.text = contacto.texto1
            vista.textTexto2.text = contacto.texto2
        }
    }
}