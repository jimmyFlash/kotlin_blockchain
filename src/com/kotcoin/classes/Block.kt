package com.kotcoin.classes

import org.apache.commons.codec.digest.DigestUtils
import java.util.*

/**
 * index : block index in chain
 * previousHash : previous block hash
 * data : block data
 */
class Block(val index: Int,
            val previousHash: String,
            val data: Any) {

    val hash = calculateHash() // calculate block has
    val timestamp: Long = Date().time // get current time in milliseconds

    /**
     * Each block in the chain should obligatory consist of timestamp,
     * data that’s stored, hash of previous block and its own hash.
     * A hash is basically a digital signature. Optionally we can add index.
     * Note that every property is not nullable so each block will always know about the hash of the previous one.
     * That’s what chains the blocks.
     */
    fun calculateHash(): String {
        // create  byte array unique to this block using index, previous block hash, timestamp and block data
        val input = (index.toString() + previousHash + timestamp + data).toByteArray()
        /*
         calculate hash using SHA-256. The SHA-256 crypthographic function is used in the implementation of Bitcoin
         */
        return DigestUtils.sha256Hex(input)
    }


}