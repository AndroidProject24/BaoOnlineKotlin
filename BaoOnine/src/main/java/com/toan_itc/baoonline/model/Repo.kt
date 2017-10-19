package com.toan_itc.baoonline.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

/**
 * Created by ahmedrizwan on 9/9/17.
 * Model Class for Repo
 * TODO: Update/Change/Add model classes in this package
 */

open class Repo : RealmObject() {

        @PrimaryKey
        var id: Int = 0

        var name: String? = null

        @SerializedName("full_name")
        var fullName: String? = ""

        @SerializedName("description")
        var description: String? = ""

        var owner: Owner? = null

        @SerializedName("stargazers_count")
        var stars: Int = 0

}

open class Owner : RealmObject() {
        @Expose
        @PrimaryKey
        @SerializedName("login")
        open var login: String? = null

        @Expose
        @SerializedName("url")
        open var url: String? = null
}
