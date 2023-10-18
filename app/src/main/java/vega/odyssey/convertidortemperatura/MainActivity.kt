package vega.odyssey.convertidortemperatura

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private var conversion : Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnConvert = findViewById<Button>(R.id.btnConvert)
        btnConvert.setOnClickListener{
        }

        val options = resources.getStringArray(R.array.convert_options)
        val spinner =findViewById<Spinner>(R.id.spinTemp)
        val button = findViewById<Button>(R.id.btnConvert)

        if(spinner != null){
            val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, options)
            spinner.adapter = adapter
            spinner.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener{
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?, position: Int, id: Long
                ){
                    Toast.makeText(
                        this@MainActivity,
                        "Opción seleccionada",
                        Toast.LENGTH_SHORT
                    ).show()

                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }
            }

            button.setOnClickListener{
                converter(conversion)
            }
        }
    }



    public fun converter(convert: Int){
        //TODO Add When statement to process conversions.

        when(convert){
            0 -> {
                //ºC to ºF
            }
            1 -> {
                //ºC to ºK
            }
            2 -> {
                //ºF to ºC
            }
            3 -> {
                //ºF to ºK
            }
            4 -> {
                //ºK to ºC
            }
            5 -> {
                //ºK to ºF
            }
        }
    }


}