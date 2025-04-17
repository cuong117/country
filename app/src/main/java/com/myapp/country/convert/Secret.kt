package com.myapp.country.convert

import android.util.Base64
import javax.crypto.Cipher
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.SecretKeySpec

object Secret {

    init {
        System.loadLibrary("secure")
    }

    fun decrypt(value: String): String {
        val key = gk()
        val iv = iv()
        val ivParameterSpec = IvParameterSpec(iv.toByteArray())
        val secretKeySpec = SecretKeySpec(key.toByteArray(), "AES")
        val cipher = Cipher.getInstance("AES/CBC/PKCS5Padding")
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, ivParameterSpec)
        val decodeBase64 = Base64.decode(value, Base64.DEFAULT)
        val decrypted = cipher.doFinal(decodeBase64)
        return String(decrypted)
    }

    private external fun gk(): String
    private external fun iv(): String
}