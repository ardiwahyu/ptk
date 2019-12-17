package com.example.informasitenagapendidik.view.activity

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.viewpager.widget.ViewPager
import com.example.informasitenagapendidik.R
import com.example.informasitenagapendidik.model.Pendidik
import com.example.informasitenagapendidik.view.fragment.BiodataFragment
import com.google.android.material.tabs.TabLayout

class DataActivity : AppCompatActivity() {
    val EXTRA_PENDIDIK = "extra_pendidik"
    val EXTRA_PTK = "extra_ptk"
    private var progressBar: ProgressBar? = null
    private var pendidikViewModel: PendidikViewModel? = null
    private var ptk: String? = null
    private var success: Boolean? = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.AppThemeNoActionBar)
        setContentView(R.layout.activity_data)
        val toolbar : Toolbar = findViewById(R.id.htab_toolbar)
        setSupportActionBar(toolbar)
        supportActionBar!!.setTitle("")
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setHomeAsUpIndicator(R.drawable.ic_arrow_back)
        initComponent()
    }

    private fun setUpViewPager(viewPager: ViewPager, bundle: Bundle) {
        val adapter = ViewPagerAdapter(supportFragmentManager)
        val biodataFragment = BiodataFragment()
        biodataFragment.arguments = bundle
        val instansiFragment = InstansiFragment()
        instansiFragment.setArguments(bundle)
        val kepegawaianFragment = KepegawaianFragment()
        kepegawaianFragment.setArguments(bundle)
        val vervalFragment = VervalFragment()
        vervalFragment.setArguments(bundle)
        adapter.addFragment(biodataFragment, "Biodata")
        adapter.addFragment(kepegawaianFragment, "Pegawai")
        adapter.addFragment(instansiFragment, "Instansi")
        adapter.addFragment(vervalFragment, "Verval")
        viewPager.adapter = adapter
    }

    private fun initComponent() {
        progressBar = findViewById(R.id.progressbar)
        progressBar!!.visibility = View.VISIBLE
        ptk = intent.getStringExtra(EXTRA_PTK)
        pendidikViewModel = ViewModelProviders.of(this)
            .get(PendidikViewModel::class.java)
        pendidikViewModel!!.getPendidik().observe(this, getPendidik)
        pendidikViewModel!!.setPendidik(ptk)
        if ((!success)!!) {
            pendidikViewModel!!.getResponseCode().observe(this, getResponseCode)
        }

    }

    private val getPendidik =
        Observer<Pendidik> { pendidik ->
            if (pendidik != null) {
                val bundle = Bundle()
                bundle.putParcelable(EXTRA_PENDIDIK, pendidik)
                val viewPager : ViewPager = findViewById(R.id.htab_viewpager)
                setUpViewPager(viewPager, bundle)
                val tabLayout : TabLayout = findViewById(R.id.htab_tabs)
                tabLayout.setupWithViewPager(viewPager)
                progressBar!!.visibility = View.GONE
            }
        }

    private val getResponseCode = Observer<Int> { integer ->
        if (integer == 0) {
            showAlertDialog(
                resources.getString(R.string.con_fail),
                resources.getString(R.string.message_con_fail)
            )
        } else if (integer == 99999) {
            showAlertDialog(
                resources.getString(R.string.not_data),
                resources.getString(R.string.message_not_data)
            )
        } else if (integer == 100) {
            success = true
        }
    }

    private fun showAlertDialog(title: String, message: String) {
        val alertDialog = AlertDialog.Builder(this).create()
        alertDialog.setTitle(title)
        alertDialog.setMessage(message)
        alertDialog.setCanceledOnTouchOutside(false)
        alertDialog.setButton(
            DialogInterface.BUTTON_POSITIVE, "TRY AGAIN"
        ) { dialog, _ ->
            dialog.dismiss()
            progressBar!!.visibility = View.VISIBLE
            pendidikViewModel!!.setPendidik(ptk)
        }
        alertDialog.setButton(
            DialogInterface.BUTTON_NEGATIVE,
            "EXIT"
        ) { _, _ -> finish() }
        progressBar!!.visibility = View.GONE
        alertDialog.show()
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}
