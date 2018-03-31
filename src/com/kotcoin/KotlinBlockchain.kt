package com.kotcoin

import com.kotcoin.classes.Blockchain

fun main (args: Array<String>){


    val kotcoin = Blockchain

    // for loop from range 1 -  15
    for (i in 1..15) {
        Blockchain.addNewBlock("kotlin.Block $i")
    }


    for (block in Blockchain.chain) {
        println("""Data: ${block.data}
            |Previous hash: ${block.previousHash}
            |Current hash: ${block.hash}
        |""".trimMargin())
    }

}
