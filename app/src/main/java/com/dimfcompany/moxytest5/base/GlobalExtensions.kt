package com.dimfcompany.moxytest5.base

import android.app.AlertDialog
import android.content.res.Resources
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.text.TextUtils
import android.text.format.DateFormat
import android.util.Log
import android.util.TypedValue
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat
import com.dimfcompany.moxytest5.R
import com.squareup.picasso.Picasso
import java.io.File
import java.text.DecimalFormat
import java.util.*


private val TAG: String = "Global_Extension"

//EditText
fun EditText.getNullableText(): String?
{
    if (TextUtils.isEmpty(this.text.toString().trim()))
    {
        return null
    }

    return this.text.toString().trim()
}

//Alert Dialog
fun AlertDialog.makeTransparentBg()
{
    this.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
}

//CheckBox
fun CheckBox.getSelectionInt(): Int
{
    if (this.isChecked)
    {
        return 1
    }

    return 0
}

//Date extensions
public fun Date?.formatToString(format: String): String?
{
    if (this == null)
    {
        return null
    }
    return DateFormat.format(format, this).toString()
}


//Image Views
fun ImageView.setImageFile(file: File)
{
    if (file.length() < 5000)
    {
        Log.e(TAG, "Error file is too small " + file.length());
        return
    }

    Picasso.get().load(file).fit().centerCrop().into(this)
}

fun ImageView.setImageUrl(url: String)
{
    Picasso.get().load(url).fit().centerCrop().into(this)
}

//Radio Group
fun RadioGroup.setTripleRg(yesNo: Boolean)
{
    val rb0 = this.getChildAt(0) as RadioButton
    val rb1 = this.getChildAt(1) as RadioButton
    val rb2 = this.getChildAt(2) as RadioButton

    if (yesNo)
    {
        rb0.setText("Нет")
        rb1.setText("Н/А")
        rb2.setText("Да")
    }
    else
    {
        rb0.setText("Рискованно")
        rb1.setText("Н/А")
        rb2.setText("Безопасно")
    }
}

fun RadioGroup.setCheckedAtPosition(position: Int)
{
    (this.getChildAt(position) as RadioButton).isChecked = true
}

fun RadioGroup.getCheckedPosition(): Int?
{
    Log.e(TAG, "Rg child count is : ${this.childCount}")

    if (this.childCount == 0)
    {
        return null
    }

    for (a in 0 until this.childCount)
    {
        val rb = this.getChildAt(a) as RadioButton
        if (rb.isChecked)
        {
            return a
        }
    }

    return null
}

//File
fun File?.isPdf(): Boolean
{
    if (this == null || !this.exists())
    {
        return false
    }

    return this.absolutePath.isPdf()
}

fun File.getFileSizeString(): String
{
    val df = DecimalFormat("0.00")
    val sizeKb = 1024.0f
    val sizeMb = sizeKb * sizeKb
    val sizeGb = sizeMb * sizeKb
    val sizeTb = sizeGb * sizeKb

    val size = this.length()

    var sizeStr = ""

    if (size < sizeMb)
    {
        sizeStr = "${df.format(size / sizeKb)} Kb"
    }
    else if (size < sizeGb)
    {
        sizeStr = "${df.format(size / sizeMb)} Mb"
    }
    else if (size < sizeTb)
    {
        sizeStr = "${df.format(size / sizeGb)} Gb"
    }

    return sizeStr
}

fun File?.isImage(): Boolean
{
    if (this == null || !this.exists())
    {
        return false
    }

    val path = this.absolutePath
    return path.isImage()
}


fun String?.isImage(): Boolean
{
    if (this == null)
    {
        return false
    }

    return (this.toLowerCase().endsWith(".png")
            || this.toLowerCase().endsWith(".jpg")
            || this.toLowerCase().endsWith(".jpeg"));
}

fun String?.isPdf(): Boolean
{
    if (this == null)
    {
        return false
    }

    return this.toLowerCase().endsWith(".pdf")
}

fun File?.isFileOk(): Boolean
{
    return this != null && this.exists() && this.length() > 5000
}

fun File.getExtension(): String
{
    val path = this.path
    return path.substring(path.lastIndexOf(".") + 1, path.length);
}


fun getColor(id: Int): Int
{
    return ContextCompat.getColor(AppClass.getApp(), id)
}

fun Double.getPercentColor(): Int
{
    if (this >= 95 && this < 101)
    {
        return getColor(R.color.green)
    }

    if (this >= 85)
    {
        return getColor(R.color.el_yellow)
    }

    return getColor(R.color.redLight)
}



fun dp2pxInt(dp: Float): Int
{
    return dp2px(dp).toInt()
}

fun dp2px(dp: Float): Float
{
    val r = Resources.getSystem()
    return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.displayMetrics)
}




