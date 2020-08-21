package com.example.hello_app

import com.google.gson.annotations.SerializedName
data class CoursesResponse(
    @SerializedName("courses") var courses: List<Courses>
)