package com.example.hello_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.hello_app.R.layout.activity_main
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_main)
                btnLogin+-.setOnClickListener {
            var userName = etUsername.text.toString()
            var password = etPasswor.text.toString()

                    var UserName = ""
                    var requestBody = MultipartBody.Builder()
                        .setType(MultipartBody.FORM)
                        .addFormDataPart("UserName", UserName)
                        .addFormDataPart("password", password)

                        .build()

                    registerUser(requestBody)
                    var lastName = null
                    Toast.makeText(baseContext, lastName, Toast.LENGTH_SHORT).show()
                }
    }


    fun registerUser(requestBody: RequestBody) {
        var apiClient = ApiClient.buildService(ApiInterface::class.java)
        var registrationCall = apiClient.registerStudent(requestBody)
        registrationCall.enqueue(object : Callback<RegistrationResponse>,
            retrofit2.Callback<RegistrationResponse> {
            fun onFailure(call: Call<RegistrationResponse>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
            }

            fun onResponse(
                call: Call<RegistrationResponse>,
                response: Response<RegistrationResponse>
            ) {
                if (response.isSuccessful) {
                    Toast.makeText(baseContext, response.body()?.message, Toast.LENGTH_LONG).show()
                    startActivity(Intent(baseContext, MainActivity::class.java))
                } else {
                    Toast.makeText(baseContext, response.errorBody().toString(), Toast.LENGTH_LONG)
                        .show()
                }
            }
        })
    }
}


}
}
}