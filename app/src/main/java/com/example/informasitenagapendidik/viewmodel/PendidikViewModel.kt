package com.example.informasitenagapendidik.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.informasitenagapendidik.model.Pendidik
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.AsyncHttpResponseHandler
import cz.msebera.android.httpclient.Header
import org.json.JSONException
import org.json.JSONObject

class PendidikViewModel : ViewModel() {
    private val pendidik = MutableLiveData<Pendidik>()
    private val responseCode = MutableLiveData<Int>()

    fun setPendidik(ptkId: String) {
        val client = AsyncHttpClient()
        val url = "http://cari.padamu.siap.web.id/cari/detail?ptk_id=$ptkId"
        client.get(url, object : AsyncHttpResponseHandler() {
            override fun onSuccess(statusCode: Int, headers: Array<Header>, responseBody: ByteArray) {
                try {
                    val cekResult = String(responseBody)
                    val cekResultObject = JSONObject(cekResult)
                    if (cekResultObject.has("code")) {
                        responseCode.postValue(cekResultObject.getInt("code"))
                    } else {
                        val result = String(responseBody)
                        val responseObject = JSONObject(result)
                        val objPendidik = Pendidik(responseObject)
                        pendidik.postValue(objPendidik)
                        responseCode.postValue(100)
                    }
                } catch (e: JSONException) {
                    e.printStackTrace()
                }

            }

            override fun onFailure(statusCode: Int, headers: Array<Header>, responseBody: ByteArray, error: Throwable) {
                responseCode.postValue(statusCode)
            }
        })
    }

    fun getPendidik(): LiveData<Pendidik> {
        return pendidik
    }

    fun getResponseCode(): LiveData<Int> {
        return responseCode
    }
}