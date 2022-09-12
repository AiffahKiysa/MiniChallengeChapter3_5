package com.example.minichallengechapter3_5

object ItemData {
    private val itemNames = arrayOf(
        "Apple Iphone 13", "shoes dr kevin", "erigo pullover",
        "erigo wind breaker", "shoes fila", "macbook air", "razer earbuds",
        "razer headset", "samsung tab s7", "samsung z flip" )

    private val itemDetails = arrayOf(
        "Rp17.499.000",
        "Rp149.900", "Rp799.920", "Rp21.999.000",
        "Rp9.499.000", "Rp599.900", "Rp14.999.000",
        "Rp159.900", "Rp699.000", "Rp1.199.000"
    )

    private val itemImages = intArrayOf(R.drawable.apple_iphone_13_midnight,
        R.drawable.erigo_pullover,
        R.drawable.fila,
        R.drawable.macbook,
        R.drawable.samsung_tab_s7_mysticblack,
        R.drawable.dr_kevin,
        R.drawable.z_flip,
        R.drawable.erigo_windbreaker,
        R.drawable.razer_headset,
        R.drawable.razer_earbuds)

    val listData: ArrayList<Item>
        get(){
            val list = arrayListOf<Item>()
            for (position in itemNames.indices) {
                val item = Item()
                item.name = itemNames[position]
                item.detail = itemDetails[position]
                item.photo = itemImages[position]
                list.add(item)
            }
            return list
        }
}