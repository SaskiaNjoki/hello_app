package com.example.hello_app

data class RegistrationResponse(
    @SerializedName("message") var message: String,
    @SerializedName("student") var student: Student
)