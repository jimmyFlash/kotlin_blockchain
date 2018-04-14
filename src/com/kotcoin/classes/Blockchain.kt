package com.kotcoin.classes

object Blockchain {

    /*
    MutableList : A generic ordered collection of elements that supports adding and removing elements.
     */
    val chain: MutableList<Block> = mutableListOf()

    val latestBlock: Block
        get() = chain.last()


    init {
        chain.add(Block(0, "0", "Genesis block", 0))
    }

    /**
     * create a new block and add it to chain
     */
    fun addNewBlock(block: Block) {
        if (isNewBlockValid(block)) chain.add(block)
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


    /**
     *  takes a Block as the argument and checks if it’s in the correct position in the chain and
     *  if the previous block’s hash is equal to the property previousHash in new block.
     */
    private fun isNewBlockValid(newBlock: Block): Boolean =
            ((newBlock.index == latestBlock.index + 1) || (newBlock.previousHash == latestBlock.hash))


}