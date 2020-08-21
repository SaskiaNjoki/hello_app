package layout

import com.example.hello_app.Student
import com.google.gson.annotations.SerializedName
data class LoginResponse (
    @SerializedName("message") var message: String,
    @SerializedName("student") var student: Student
)