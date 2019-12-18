package com.example.informasitenagapendidik.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import com.example.informasitenagapendidik.R
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var edPtk : TextInputEditText
    lateinit var tiPtk : TextInputLayout
    lateinit var btnSearch : MaterialButton
    var notError : Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.AppThemeNoActionBar)
        setContentView(R.layout.activity_main)
        initComponent()
    }

    override fun onClick(v: View?) {
        if (v != null) {
            if (v.id == R.id.btn_search && notError){
                val ptk = edPtk.text!!.toString()
                val intent = Intent(this@MainActivity, DataActivity::class.java)
                intent.putExtra(DataActivity().EXTRA_PTK, ptk)
                startActivity(intent)
            }
        }
    }

    private fun initComponent(){
        edPtk = findViewById(R.id.ed_ptk)
        tiPtk = findViewById(R.id.ti_ptk)

        edPtk.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                if (s != null) {
                    if (s.length != tiPtk.counterMaxLength){
                        tiPtk.error = "Nomor PTK harus "+tiPtk.counterMaxLength+" angka"
                        notError = false
                    }else{
                        tiPtk.error = null
                        notError = true
                    }
                }
            }
        })
        btnSearch = findViewById(R.id.btn_search)
        btnSearch.setOnClickListener(this)
    }
}
