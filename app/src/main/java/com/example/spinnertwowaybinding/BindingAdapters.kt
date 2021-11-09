package com.example.spinnertwowaybinding

import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import androidx.databinding.InverseBindingListener


/**
 * fill the Spinner with all available accounts.
 * Set the Spinner selection to selectedItem.
 * If the selection changes, call the InverseBindingAdapter
 */
@BindingAdapter(value = ["spinnerList", "selectedItem", "selectedItemAttrChanged"], requireAll = false)
fun setSpinnerRimList(spinner: Spinner, spinnerList: ArrayList<String>, selectedItem: String, listener: InverseBindingListener?) {
    spinner.adapter = ArrayAdapter(spinner.context, android.R.layout.simple_spinner_item, spinnerList)
    setCurrentSelection(spinner, selectedItem)
    listener?.let {
        setSpinnerListener(spinner, listener)
    }
}

@InverseBindingAdapter(attribute = "selectedItem")
fun getSelectedProject(spinner: Spinner): String {
    return spinner.selectedItem as String
}

/**
 * Method to select listener for spinner
 */
private fun setSpinnerListener(spinner: Spinner, listener: InverseBindingListener) {
    spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) = listener.onChange()
        override fun onNothingSelected(adapterView: AdapterView<*>) = listener.onChange()
    }
}

/**
 * Method to select current selection from spinner
 */
private fun setCurrentSelection(spinner: Spinner, selectedItem: String): Boolean {
    for (index in 0 until spinner.adapter.count) {
        if (spinner.getItemAtPosition(index) == selectedItem) {
            spinner.setSelection(index)
            return true
        }
    }
    return false
}