package com.example.informasitenagapendidik.model

import android.os.Parcel
import android.os.Parcelable
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

class Pendidik() : Parcelable {
    private lateinit var foto : String
    private lateinit var nama : String
    private lateinit var kelamin : String
    private lateinit var kualifikasi : String

    private lateinit var nuptk : String
    private lateinit var ptkId : String
    private lateinit var nrg : String
    private lateinit var tglTerbit : String
    private lateinit var status : String
    private lateinit var fungsi : String
    private lateinit var tugas : String
    private lateinit var proses : String
    private lateinit var aktif : String

    private lateinit var namaIns : String
    private lateinit var idIns : String
    private lateinit var alamatIns : String
    private lateinit var provinsiIns : String
    private lateinit var kotaIns : String
    private lateinit var kecamatanIns : String

    private var statusVerval : Int = 0
    private lateinit var vervals : List<Verval>

    constructor(jsonObject: JSONObject) : this() {
        try{
            val ptk : JSONObject = jsonObject.getJSONObject("ptk")
            this.foto = ptk.getString("foto")
            this.nama = ptk.getString("nama")
            this.kelamin = ptk.getString("kelamin")
            this.kualifikasi = ptk.getJSONArray("kualifikasi").get(1).toString()
            this.nuptk = ptk.getString("nuptk")
            this.ptkId = ptk.getString("ptk_id")
            this.nrg = ptk.getString("nrg")
            this.tglTerbit = ptk.getString("tgl_terbit")
            this.status = ptk.getJSONArray("status").get(1).toString()
            this.fungsi = ptk.getJSONArray("fungsi").get(1).toString()
            this.tugas = ptk.getJSONArray("tugas").get(1).toString()
            this.proses = ptk.getJSONArray("proses").get(1).toString()
            this.aktif = ptk.getJSONArray("aktif").get(1).toString()
            val instansi = jsonObject.getJSONObject("instansi")
            this.namaIns = instansi.getString("nama")
            this.idIns = instansi.getInt("instansi_id").toString()
            this.alamatIns = instansi.getString("alamat")
            this.provinsiIns = instansi.getJSONArray("propinsi").get(1).toString()
            this.kotaIns = instansi.getJSONArray("kota").get(1).toString()
            this.kecamatanIns = instansi.getString("kecamatan")
            this.statusVerval = 4
            this.vervals = setVerval(jsonObject.getJSONArray("ptk_verval"))
        }catch (e : JSONException){
            e.printStackTrace()
        }
    }

    fun getFoto() : String{
        return foto
    }

    fun getNama() : String{
        return if (nama == "null")  "-" else nama
    }

    fun getKelamin(): String {
        return if (kelamin == "null") "-" else kelamin
    }

    fun getKualifikasi(): String {
        return if (kualifikasi == "null") "-" else kualifikasi
    }

    fun getNuptk(): String {
        return if (nuptk == "null") "-" else nuptk
    }

    fun getPtkId(): String {
        return if (ptkId == "null") "-" else ptkId
    }

    fun getNrg(): String {
        return if (nrg == "null") "-" else nrg
    }

    fun getTglTerbit(): String {
        return if (tglTerbit == "null") "-" else tglTerbit
    }

    fun getStatus(): String {
        return if (status == "null") "-" else status
    }

    fun getFungsi(): String {
        return if (fungsi == "null") "-" else fungsi
    }

    fun getTugas(): String {
        return if (tugas == "null") "-" else tugas
    }

    fun getProses(): String {
        return if (proses == "null") "-" else proses
    }

    fun getAktif(): String {
        return if (aktif == "null") "-" else aktif
    }

    fun getNamaIns(): String {
        return if (namaIns == "null") "-" else namaIns
    }

    fun getIdIns(): String {
        return if (idIns == "null") "-" else idIns
    }

    fun getAlamatIns(): String {
        return if (alamatIns == "null") "-" else alamatIns
    }

    fun getProvinsiIns(): String {
        return if (provinsiIns == "null") "-" else provinsiIns
    }

    fun getKotaIns(): String {
        return if (kotaIns == "null") "-" else kotaIns
    }

    fun getKecamatanIns(): String {
        return if (kecamatanIns == "null") "-" else kecamatanIns
    }

    fun getStatusVerval(): Int {
        return statusVerval
    }

    fun getVervals(): List<Verval> {
        return vervals
    }

    private fun setVerval(jsonArray: JSONArray) : List<Verval>{
        val vervalList : MutableList<Verval> = mutableListOf()
        for (i in 0..jsonArray.length()){
            try{
                val verval = Verval(jsonArray.getJSONObject(i))
                vervalList.add(verval)
            }catch (e : JSONException){
                e.printStackTrace()
            }
        }
        return vervalList
    }

    constructor(parcel: Parcel) : this() {
        foto = parcel.readString()
        nama = parcel.readString()
        kelamin = parcel.readString()
        kualifikasi = parcel.readString()
        nuptk = parcel.readString()
        ptkId = parcel.readString()
        nrg = parcel.readString()
        tglTerbit = parcel.readString()
        status = parcel.readString()
        fungsi = parcel.readString()
        tugas = parcel.readString()
        proses = parcel.readString()
        aktif = parcel.readString()
        namaIns = parcel.readString()
        idIns = parcel.readString()
        alamatIns = parcel.readString()
        provinsiIns = parcel.readString()
        kotaIns = parcel.readString()
        kecamatanIns = parcel.readString()
        statusVerval = parcel.readInt()
    }

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun describeContents(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    companion object CREATOR : Parcelable.Creator<Pendidik> {
        override fun createFromParcel(parcel: Parcel): Pendidik {
            return Pendidik(parcel)
        }

        override fun newArray(size: Int): Array<Pendidik?> {
            return arrayOfNulls(size)
        }
    }

}