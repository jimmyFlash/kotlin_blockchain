package com.kotcoin.classes

object Blockchain {

    /*
    MutableList : A generic ordered collection of elements that supports adding and removing elements.
     */
    val chain: MutableList<Block> = mutableListOf(createGenesisBlock())

    /**
     * create a new block and add it to chain
     */
    fun addNewBlock(data: Any) {
        val block = Block(chain.size + 1, getLatestBlock().hash, data)
        chain.add(block)
    }

    fun getLatestBlock(): Block {

        // Returns the last element in chain list
        return chain.last()
    }

    /**
     * that the more blocks in the network, the harder the operation should be,
     * hence the optional difficulty parameter. In this case I’ve implemented
     * a simple algorithm which finds the next value divisible by >9 multiplied by difficulty level<
     */
    private fun generateProofOfWork(previousPow: Int, difficulty: Int = 1): Int {
        var proof = previousPow + 1
        val nonce = 19 * difficulty
        while ((proof + previousPow) % nonce != 0) {
            proof += 1
        }
        return proof
    }


    private fun isNewBlockValid(newBlock: Block): Boolean =
            ((newBlock.index == getLatestBlock().index + 1) && (newBlock.previousHash == getLatestBlock().hash))


    /**
     * hard code so-called genesis block which is just our usual block
     * taking place of 1st element in the chain
     */
    private fun createGenesisBlock(): Block {
        return Block(0, "0", "Genesis block")
    }
}