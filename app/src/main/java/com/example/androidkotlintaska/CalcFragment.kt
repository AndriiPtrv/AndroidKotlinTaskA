package com.example.androidkotlintaska

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.core.widget.addTextChangedListener
import kotlinx.android.synthetic.main.fragment_calc.*

class CalcFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_calc, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        radio_group.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                sm_m.id -> input_field.addTextChangedListener { calcSmM() }
                grn_dol.id -> input_field.addTextChangedListener { calcGrnDol() }
                g_kg.id -> input_field.addTextChangedListener { calcGKg() }
                c_k.id -> input_field.addTextChangedListener { calcCK() }
            }
        }
    }

    private fun calcSmM() { result.text = (input_field.text.toString().ifEmpty { "0" }.toDouble() / 100).toString() }
    private fun calcGrnDol() { result.text = (input_field.text.toString().ifEmpty { "0" }.toDouble() / 27).toString() }
    private fun calcGKg()  { result.text = (input_field.text.toString().ifEmpty { "0" }.toDouble() / 1000).toString() }
    private fun calcCK()  { result.text = (input_field.text.toString().ifEmpty { "0" }.toDouble() + 273.15).toString() }
}
