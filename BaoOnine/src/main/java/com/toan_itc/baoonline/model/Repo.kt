package com.toan_itc.baoonline.model

import android.support.annotation.NonNull
import com.google.gson.annotations.SerializedName

/**
 * Created by ahmedrizwan on 9/9/17.
 * Model Class for Repo
 * TODO: Update/Change/Add model classes in this package
 */

class Repo(
        var id: Int = 0,
        @SerializedName("name")
        var name: String = "",
        @SerializedName("full_name")
        var fullName: String? = "",
        @SerializedName("description")
        var description: String? = "",
        @SerializedName("owner")
        @NonNull
        var owner: Owner = Owner(),
        @SerializedName("stargazers_count")
        var stars: Int = 0
) {
        class Owner(
                @NonNull
                @SerializedName("login")
                var login: String = "",
                @SerializedName("url")
                var url: String? = ""
        )
}