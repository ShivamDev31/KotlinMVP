package com.shivamdev.kotlinmvp.data.model

import android.annotation.SuppressLint
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 * Created by shivam on 09/02/18.
 */

@SuppressLint("ParcelCreator")
@Parcelize
data class GithubRepo(@SerializedName("id") val id: Int,
                      @SerializedName("name") val repoName: String) : Parcelable