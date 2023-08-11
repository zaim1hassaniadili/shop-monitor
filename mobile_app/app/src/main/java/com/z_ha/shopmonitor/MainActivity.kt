package com.z_ha.shopmonitor

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.z_ha.shopmonitor.model.RetrofitSingleton
import com.z_ha.shopmonitor.model.Tick
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.time.LocalDate

class MainActivity : ComponentActivity() {
    var b :Boolean = false
    fun UpdateShopStatus(view : View){
        var success : Toast = Toast.makeText(view.context, "Succesfully reach the server", Toast.LENGTH_LONG)
        success.show()
        var error : Toast = Toast.makeText(view.context, "Connection Failed", Toast.LENGTH_LONG)

        var toSend : String = if(b) "true" else "false"
        b = !b

        val TickApi = RetrofitSingleton.getInstance().create(TickApi::class.java)
        val body =  Tick(true, LocalDate.now())
        GlobalScope.launch {
            try {
                val result = TickApi.sendTick(toSend)
                success.show()
            }catch(e: Exception){
                Log.e("ERROR", e.stackTraceToString())
                error.show()
            }

        }

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
