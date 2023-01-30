package com.uygulamalarim.e_ticaret.Model

import android.os.Parcel
import android.os.Parcelable

data class CartModel(
    var Added_By: String? = null,
    var ProductDesc: String? = null,
    var ProductName: String? = null,
    var ProductPrice: String? = null,
    var image: String? = null,
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString())

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(Added_By)
        parcel.writeString(ProductDesc)
        parcel.writeString(ProductName)
        parcel.writeString(ProductPrice)
        parcel.writeString(image)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<CartModel> {
        override fun createFromParcel(parcel: Parcel): CartModel {
            return CartModel(parcel)
        }

        override fun newArray(size: Int): Array<CartModel?> {
            return arrayOfNulls(size)
        }
    }
}