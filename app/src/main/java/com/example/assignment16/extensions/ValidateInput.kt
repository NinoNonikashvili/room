package com.example.assignment16.extensions

import com.google.android.material.textfield.TextInputLayout

    fun TextInputLayout.checkLength(min:Int, max:Int){
        val etString = this.editText?.text.toString()
        this.error = null
        if(etString.length<min||etString.length>max){
            this.error = "please enter min $min and max $max characters"
            this.editText?.requestFocus()
            this.editText?.text = null
            return
        }
    }
    fun TextInputLayout.checkIfEmpty(){
        val etString = this.editText?.text.toString()
        this.error = null
        if(etString.isNullOrEmpty()){
            this.error = "please enter the image Uri"
            this.editText?.requestFocus()
            this.editText?.text = null
            return

    }


}