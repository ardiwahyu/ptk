package com.example.informasitenagapendidik.model

import org.json.JSONException
import org.json.JSONObject

class Verval(jsonObject: JSONObject) {
    private var tahun : Int = 0
    private var periode : Int = 0

    init {
        try {
            this.tahun = jsonObject.getInt("thn_verval")
            this.periode = jsonObject.getInt("periode_verval")
        }catch (e: JSONException){
            e.printStackTrace()
        }
    }

    fun getTahun() : Int {
        return tahun
    }

    fun getPeriode() : Int {
        return periode
    }
}