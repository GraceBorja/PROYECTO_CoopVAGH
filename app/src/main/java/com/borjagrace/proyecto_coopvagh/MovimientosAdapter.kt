package com.borjagrace.proyecto_coopvagh

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_movimiento.view.*


class MovimientosAdapter (private var lista: ArrayList<Movimiento>, private var contexto: Context):RecyclerView.Adapter<MovimientosAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return  ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_movimiento, parent, false), contexto)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(lista[position])
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    class ViewHolder (var vista: View, contexto: Context ): RecyclerView.ViewHolder(vista){
        fun  bind(movimiento: Movimiento){
            vista.imFecha.text = movimiento.fecha
            vista.imDetalle.text = movimiento.detalle
            vista.imOperacion.text =  "+$${movimiento.operacion}"
            vista.imSaldo.text = "$${movimiento.saldo}"
        }
    }
}

//        val inflater = context.layoutInflater
//        val rowView = inflater.inflate(R.layout.item_movimiento, null, true)
//
//
//
//
//        val textViewFecha = rowView.findViewById<TextView>(R.id.imFecha)
//        val textViewDetalle = rowView.findViewById<TextView>(R.id.imDetalle)
//        val textViewOperacion = rowView.findViewById<TextView>(R.id.imOperacion)
//        val textViewSaldo = rowView.findViewById<TextView>(R.id.imSaldo)
//
//
//        textViewFecha.text = movimientos[position].fecha
//        textViewDetalle.text = movimientos[position].detalle
//        textViewOperacion.text = "${movimientos[position].operacion}"
//        textViewSaldo.text = "$${movimientos[position].saldo}"
//
//
//        return rowView
//    }
//
//    override fun getItem(position: Int): Any? {
//        return movimientos.get(position)
//    }
//
//    override fun getItemId(position: Int): Long {
//        return position.toLong()
//    }
//
//    override fun getCount(): Int {
//        return movimientos.size
//    }




//}