package com.borjagrace.proyecto_coopvagh

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_credito.view.*

class CreditosAdapter (private var lista1: ArrayList<Credito>, private var contexto: Context): RecyclerView.Adapter<CreditosAdapter.ViewHolder1>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder1 {
        return  ViewHolder1(LayoutInflater.from(parent.context).inflate(R.layout.item_credito, parent, false), contexto)
    }

    override fun onBindViewHolder(holder: CreditosAdapter.ViewHolder1, position: Int) {
        holder.bind(lista1[position])
    }

    override fun getItemCount(): Int {
        return lista1.size
    }

    class ViewHolder1 (var vista: View, contexto: Context ): RecyclerView.ViewHolder(vista){
        fun  bind(credito: Credito){
            vista.dato1.text = credito.dato1
            vista.dato2.text = credito.dato2
        }
    }


}