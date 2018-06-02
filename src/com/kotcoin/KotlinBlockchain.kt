package com.kotcoin

import com.kotcoin.classes.Blockchain
import io.javalin.Javalin

val kotcoin = Blockchain

fun main (args: Array<String>){


    // returns a running application instance
    val app = Javalin.start(7000)
    //  first endpoint allows to obtain every existing block in the chain
    app.get("/blocks") { ctx ->
        ctx.json(kotcoin.chain)
    }

    /*
    POST HTTP method which mines a block. It takes the request body and puts it as the data of mined block.
    After mining, it returns the details of block
     */
    app.post("/blocks/mine") { ctx ->
        val minedBlock = kotcoin.mineBlock(ctx.body())
        ctx.json(minedBlock)
    }

}
