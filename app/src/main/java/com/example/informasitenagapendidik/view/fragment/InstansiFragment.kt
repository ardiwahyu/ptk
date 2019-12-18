package com.example.informasitenagapendidik.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.informasitenagapendidik.R
import com.example.informasitenagapendidik.model.Pendidik
import com.example.informasitenagapendidik.view.activity.DataActivity

class InstansiFragment : Fragment() {
    private lateinit var tvInstansi: TextView
    private lateinit var tvInstansiId:TextView
    private lateinit var tvAlamatSekolah:TextView
    private lateinit var tvPropinsi:TextView
    private lateinit var tvKota:TextView
    private lateinit var tvKecamatan:TextView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_instansi, container, false)
        initComponent(view)
        return view
    }

    private fun initComponent(view: View) {
        tvInstansi = view.findViewById(R.id.tv_instansi)
        tvInstansiId = view.findViewById(R.id.tv_instansi_id)
        tvAlamatSekolah = view.findViewById(R.id.tv_alamat_sekolah)
        tvPropinsi = view.findViewById(R.id.tv_propinsi)
        tvKota = view.findViewById(R.id.tv_kota)
        tvKecamatan = view.findViewById(R.id.tv_kecamatan)
        var pendidik: Pendidik? = null
        if (arguments != null) {
            pendidik = this.arguments!!.getParcelable(DataActivity().EXTRA_PENDIDIK)
        }
        if (pendidik != null) {
            display(pendidik)
        }
    }

    private fun display(pendidik: Pendidik) {
        tvInstansi.text = pendidik.getNamaIns()
        tvInstansiId.text = pendidik.getIdIns()
        tvAlamatSekolah.text = pendidik.getAlamatIns()
        tvPropinsi.text = pendidik.getProvinsiIns()
        tvKota.text = pendidik.getKotaIns()
        tvKecamatan.text = pendidik.getKecamatanIns()
    }
}