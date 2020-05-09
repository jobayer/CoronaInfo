package com.jobayer.coronainfo.extensions

import io.paperdb.Paper

fun String.toBangla(): String {
    return this.replace("0", "০")
        .replace("1", "১")
        .replace("2", "২")
        .replace("3", "৩")
        .replace("3", "৩")
        .replace("4", "৪")
        .replace("5", "৫")
        .replace("6", "৬")
        .replace("7", "৭")
        .replace("8", "৮")
        .replace("9", "৯")
        .replace("Saturday", "শনিবার")
        .replace("Sunday", "রবিবার")
        .replace("Monday", "সোমবার")
        .replace("Tuesday", "মঙ্গলবার")
        .replace("Wednesday", "বুধবার")
        .replace("Thursday", "বৃহস্পতিবার")
        .replace("Friday", "শুক্রবার")
        .replace("January", "জানুযারি")
        .replace("February", "ফেব্রুয়ারি")
        .replace("March", "মার্চ")
        .replace("April", "এপ্রিল")
        .replace("May", "মে")
        .replace("June", "জুন")
        .replace("July", "জুলাই")
        .replace("August", "আগস্ট")
        .replace("September", "সেপ্টেম্বর")
        .replace("October", "অক্টোবর")
        .replace("November", "নভেম্বর")
        .replace("December", "ডিসেম্বর")
        .replace("AM", "এএম")
        .replace("PM", "পিএম")
}

fun get(key: String): Any? {
    return Paper.book().read<Any>(key)
}

fun write(key: String, data: Any) {
    Paper.book().write(key, data)
}