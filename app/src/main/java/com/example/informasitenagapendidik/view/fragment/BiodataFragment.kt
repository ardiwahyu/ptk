package com.example.informasitenagapendidik.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.informasitenagapendidik.R
import com.example.informasitenagapendidik.model.Pendidik
import com.example.informasitenagapendidik.view.activity.DataActivity

class BiodataFragment : Fragment() {
    private lateinit var tvNama: TextView
    private lateinit var tvKelamin:TextView
    private lateinit var tvKualifikasi:TextView
    private lateinit var imgProfil: ImageView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_biodata, container, false)
        initComponent(view)
        return view
    }

    private fun initComponent(view: View) {
        tvNama = view.findViewById(R.id.tv_nama)
        tvKelamin = view.findViewById(R.id.tv_kelamin)
        tvKualifikasi = view.findViewById(R.id.tv_kualifikasi)
        imgProfil = view.findViewById(R.id.img_profil)
        var pendidik: Pendidik? = null
        if (arguments != null) {
            pendidik = this.arguments!!.getParcelable(DataActivity().EXTRA_PENDIDIK)
        }
        if (pendidik != null) {
            display(pendidik)
        }
    }

    private fun display(pendidik: Pendidik) {
        tvNama!!.setText(pendidik.getNama())
        if (pendidik.getKelamin().equalsIgnoreCase("L"))
            tvKelamin!!.setText(resources.getString(R.string.laki_laki))
        else if (pendidik.getKelamin().equalsIgnoreCase("P"))
            tvKelamin!!.setText(resources.getString(R.string.perempuan))
        tvKualifikasi!!.setText(pendidik.getKualifikasi())
        Glide.with(imgProfil!!.context).load(pendidik.getFoto())
            .placeholder(R.drawable.load).into(imgProfil!!)
    }
}