package com.borjagrace.proyecto_coopvagh

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView


class MovimientosAdapter (private val context: Activity, private val movimientos: ArrayList<Movimiento>)   : BaseAdapter() {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater = context.layoutInflater
        val rowView = inflater.inflate(R.layout.item_movimiento, null, true)




        val textViewFecha = rowView.findViewById<TextView>(R.id.imFecha)
        val textViewDetalle = rowView.findViewById<TextView>(R.id.imDetalle)
        val textViewOperacion = rowView.findViewById<TextView>(R.id.imOperacion)
        val textViewSaldo = rowView.findViewById<TextView>(R.id.imSaldo)


        textViewFecha.text = movimientos[position].fecha
        textViewDetalle.text = movimientos[position].detalle
        textViewOperacion.text = "${movimientos[position].operacion}"
        textViewSaldo.text = "$${movimientos[position].saldo}"


        return rowView
    }

    override fun getItem(position: Int): Any? {
        return movimientos.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return movimientos.size
    }




}