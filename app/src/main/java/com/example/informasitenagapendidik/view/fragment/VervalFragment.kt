package com.example.informasitenagapendidik.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.informasitenagapendidik.R
import com.example.informasitenagapendidik.model.Pendidik
import com.example.informasitenagapendidik.model.Verval
import com.example.informasitenagapendidik.view.activity.DataActivity

class VervalFragment : Fragment() {
    private lateinit var tv20141: TextView
    private lateinit var tv20142: TextView
    private lateinit var tv20151: TextView
    private lateinit var tv20152: TextView
    private lateinit var tv20161: TextView
    private lateinit var tv20162: TextView
    private lateinit var tv20171: TextView
    private lateinit var tv20172: TextView
    private lateinit var tv20181: TextView
    private lateinit var tv20182: TextView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_verval, container, false)
        initComponent(view)
        return view
    }

    private fun initComponent(view: View) {
        tv20141 = view.findViewById(R.id.tv_ver20141)
        tv20142 = view.findViewById(R.id.tv_ver20142)
        tv20151 = view.findViewById(R.id.tv_ver20151)
        tv20152 = view.findViewById(R.id.tv_ver20152)
        tv20161 = view.findViewById(R.id.tv_ver20161)
        tv20162 = view.findViewById(R.id.tv_ver20162)
        tv20171 = view.findViewById(R.id.tv_ver20171)
        tv20172 = view.findViewById(R.id.tv_ver20172)
        tv20181 = view.findViewById(R.id.tv_ver20181)
        tv20182 = view.findViewById(R.id.tv_ver20182)
        var pendidik: Pendidik? = null
        if (arguments != null) {
            pendidik = this.arguments!!.getParcelable(DataActivity().EXTRA_PENDIDIK)
        }
        if (pendidik != null) {
            display(pendidik)
        }
    }

    private fun display(pendidik: Pendidik) {
        setVerval(pendidik.getVervals())
    }

    private fun setVerval(vervals: List<Verval>) {
        for (i in vervals.indices) {
            if (vervals[i].getTahun() == 2014 && vervals[i].getPeriode() == 1) {
                tv20141.text = resources.getString(R.string.aktif)
                tv20141.setTextColor(resources.getColor(R.color.colorAktif))
            } else if (vervals[i].getTahun() == 2014 && vervals[i].getPeriode() == 2) {
                tv20142.text = resources.getString(R.string.aktif)
                tv20142.setTextColor(resources.getColor(R.color.colorAktif))
            } else if (vervals[i].getTahun() == 2015 && vervals[i].getPeriode() == 1) {
                tv20151.text = resources.getString(R.string.aktif)
                tv20151.setTextColor(resources.getColor(R.color.colorAktif))
            } else if (vervals[i].getTahun() == 2015 && vervals[i].getPeriode() == 2) {
                tv20152.text = resources.getString(R.string.aktif)
                tv20152.setTextColor(resources.getColor(R.color.colorAktif))
            } else if (vervals[i].getTahun() == 2016 && vervals[i].getPeriode() == 1) {
                tv20161.text = resources.getString(R.string.aktif)
                tv20161.setTextColor(resources.getColor(R.color.colorAktif))
            } else if (vervals[i].getTahun() == 2016 && vervals[i].getPeriode() == 2) {
                tv20162.text = resources.getString(R.string.aktif)
                tv20162.setTextColor(resources.getColor(R.color.colorAktif))
            } else if (vervals[i].getTahun() == 2017 && vervals[i].getPeriode() == 1) {
                tv20171.text = resources.getString(R.string.aktif)
                tv20171.setTextColor(resources.getColor(R.color.colorAktif))
            } else if (vervals[i].getTahun() == 2017 && vervals[i].getPeriode() == 2) {
                tv20172.text = resources.getString(R.string.aktif)
                tv20172.setTextColor(resources.getColor(R.color.colorAktif))
            } else if (vervals[i].getTahun() == 2018 && vervals[i].getPeriode() == 1) {
                tv20181.text = resources.getString(R.string.aktif)
                tv20181.setTextColor(resources.getColor(R.color.colorAktif))
            } else if (vervals[i].getTahun() == 2018 && vervals[i].getPeriode() == 2) {
                tv20182.text = resources.getString(R.string.aktif)
                tv20182.setTextColor(resources.getColor(R.color.colorAktif))
            }
        }
    }
}