package com.jobayer.coronainfo.extensions

import com.jobayer.coronainfo.model.District
import io.paperdb.Paper

fun String.replaceNumber(): String {
    return  ""
}

fun get() {
    Paper.book().read<District>("update")
}