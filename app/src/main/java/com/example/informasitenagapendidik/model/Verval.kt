package com.example.informasitenagapendidik.model

import org.json.JSONException
import org.json.JSONObject

class Verval(jsonObject: JSONObject) {
    var tahun : Int = 0
    var periode : Int = 0

    fun Verval(jsonObject: JSONObject){
        try {
            this.tahun = jsonObject.getInt("tahun_verval")
            this.periode = jsonObject.getInt("periode_verval")
        }catch (e: JSONException){
            e.printStackTrace()
        }
    }
}