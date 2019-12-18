package com.example.informasitenagapendidik.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.informasitenagapendidik.R
import com.example.informasitenagapendidik.model.Pendidik
import com.example.informasitenagapendidik.view.activity.DataActivity

class KepegawaianFragment : Fragment() {
    private lateinit var tvNuptk: TextView
    private lateinit var tvPegId:TextView
    private lateinit var tvNrg:TextView
    private lateinit var tvTglTerbit:TextView
    private lateinit var tvStatusPeg:TextView
    private lateinit var tvFungsi: TextView
    private lateinit var tvJabatan: TextView
    private lateinit var tvProsesVer:TextView
    private lateinit var tvStatusAktif:TextView
    private lateinit var star1: ImageView
    private lateinit var star2:ImageView
    private lateinit var star3:ImageView
    private lateinit var star4:ImageView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_kepegawaian, container, false)
        initComponent(view)
        return view
    }

    private fun initComponent(view: View) {
        tvNuptk = view.findViewById(R.id.tv_nuptk)
        tvPegId = view.findViewById(R.id.tv_peg_id)
        tvNrg = view.findViewById(R.id.tv_nrg)
        tvTglTerbit = view.findViewById(R.id.tv_tgl_terbit)
        tvStatusPeg = view.findViewById(R.id.tv_status_peg)
        tvFungsi = view.findViewById(R.id.tv_fungsi)
        tvJabatan = view.findViewById(R.id.tv_jabatan)
        tvProsesVer = view.findViewById(R.id.proses_verval)
        tvStatusAktif = view.findViewById(R.id.tv_status_aktif)
        star1 = view.findViewById(R.id.star1)
        star2 = view.findViewById(R.id.star2)
        star3 = view.findViewById(R.id.star3)
        star4 = view.findViewById(R.id.star4)
        var pendidik: Pendidik? = null
        if (arguments != null) {
            pendidik = this.arguments!!.getParcelable(DataActivity().EXTRA_PENDIDIK)
        }
        if (pendidik != null) {
            display(pendidik)
        }
    }

    private fun display(pendidik: Pendidik) {
        tvNuptk.text = pendidik.getNuptk()
        tvPegId.text = pendidik.getPtkId()
        tvNrg.text = pendidik.getNrg()
        tvTglTerbit.text = pendidik.getTglTerbit()
        tvStatusPeg.text = pendidik.getStatus()
        tvFungsi.text = pendidik.getFungsi()
        tvJabatan.text = pendidik.getTugas()
        tvProsesVer.text = pendidik.getProses()
        tvStatusAktif.text = pendidik.getAktif()
        setStatusVerval(pendidik.getStatusVerval())
    }

    private fun setStatusVerval(statusVerval: Int) {
        star1.visibility = View.VISIBLE
        star2.visibility = View.VISIBLE
        star3.visibility = View.VISIBLE
        star4.visibility = View.VISIBLE
        if (statusVerval < 4)
            star4.setImageResource(R.drawable.ic_star_border)
        if (statusVerval < 3)
            star3.setImageResource(R.drawable.ic_star_border)
        if (statusVerval < 2)
            star2.setImageResource(R.drawable.ic_star_border)
        if (statusVerval < 1)
            star1.setImageResource(R.drawable.ic_star_border)
    }
}