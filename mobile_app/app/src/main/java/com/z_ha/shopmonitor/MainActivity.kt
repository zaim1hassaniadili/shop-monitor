package com.z_ha.shopmonitor

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.z_ha.shopmonitor.model.RetrofitSingleton
import com.z_ha.shopmonitor.model.Tick
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.Date

class MainActivity : ComponentActivity() {
    var b :Boolean = false
    fun UpdateShopStatus(view : View){
        val button : Button = findViewById(R.id.button)
        var success : Toast = Toast.makeText(view.context, "Succesfully reach the server", Toast.LENGTH_LONG)
        success.show()
        var error : Toast = Toast.makeText(view.context, "Connection Failed", Toast.LENGTH_LONG)

        var toSend : String = if(b) "true" else "false"
        if(toSend.toBoolean()) button.setText("Shop Open") else button.setText("Shop Closed")
        b = !b
        var tick : Tick = Tick(toSend.toBoolean(), LocalDateTime.now())
        val TickApi = RetrofitSingleton.getInstance().create(TickApi::class.java)
        val body =  Tick(true, LocalDateTime.now())
        GlobalScope.launch {
            try {
                val result = TickApi.sendTick(tick)
                Log.d("WSEND", tick.toString())
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
        val tickApi = RetrofitSingleton.getInstance().create(TickApi::class.java)
        val button : Button = findViewById(R.id.button)
        Log.d("DEBUG ME", "Hello here")

        GlobalScope.launch {
            try {
                val currentTick : Tick = tickApi.getLastTick()
                b = currentTick.isOpen.toString().toBoolean()
                Log.d("DEBUG ME", currentTick.toString())
            }catch(e: Exception){
                Log.e("ERROR", e.stackTraceToString())
            }

        }
        if(b) button.setText("Shop Open") else button.setText("Shop Closed")
    }
}
