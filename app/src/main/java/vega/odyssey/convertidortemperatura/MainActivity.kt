package vega.odyssey.convertidortemperatura

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private var conversion : Int = 0
    private var value : String = ""
    private var result: Double = 0.0
    private lateinit var total: TextView
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnConvert = findViewById<Button>(R.id.btnConvert)
        btnConvert.setOnClickListener{
        }

        val options = resources.getStringArray(R.array.convert_options)
        val spinner =findViewById<Spinner>(R.id.spinTemp)
        val button = findViewById<Button>(R.id.btnConvert)
        var temp = findViewById<EditText>(R.id.editTemperature)
        total = findViewById(R.id.txtResult)

        if(spinner != null){
            val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, options)
            spinner.adapter = adapter
            spinner.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener{
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?, position: Int, id: Long
                ){
                    conversion = position
                    Toast.makeText(
                        this@MainActivity,
                        "Opción seleccionada "+position,
                        Toast.LENGTH_SHORT
                    ).show()

                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }
            }

            button.setOnClickListener{
                value = temp.text.toString()
                converter(conversion)
            }
        }
    }



    public fun converter(convert: Int){
        //TODO Add When statement to process conversions.

        when(convert){
            0 -> {
                //ºC to ºF
                Toast.makeText(this, "ºC to ºF",Toast.LENGTH_SHORT).show()
                result = ((value.toDouble()*9/5+32))
                total.text = result.toString()
            }
            1 -> {
                //ºC to ºK
                Toast.makeText(this, "ºC to ºK",Toast.LENGTH_SHORT).show()
                result = (value.toDouble()+273.15)
                total.text = result.toString()

            }
            2 -> {
                //ºF to ºC
                Toast.makeText(this, "ºF to ºC",Toast.LENGTH_SHORT).show()
                result = ((value.toDouble()-32)/1.8)
                total.text = result.toString()

            }
            3 -> {
                //ºF to ºK
                Toast.makeText(this, "ºF to ºK",Toast.LENGTH_SHORT).show()
                result = ((value.toDouble()-32)*5/9+273.15)
                total.text = result.toString()

            }
            4 -> {
                //ºK to ºC
                Toast.makeText(this, "ºK to ºC",Toast.LENGTH_SHORT).show()
                result = (value.toDouble()-273.15)
                total.text = result.toString()

            }
            5 -> {
                //ºK to ºF
                Toast.makeText(this, "ºK to ºF",Toast.LENGTH_SHORT).show()
                result = ((value.toDouble()-273.15)*9/5+32)
                total.text = result.toString()

            }
        }
    }


}