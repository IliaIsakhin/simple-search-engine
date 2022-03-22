package search.index

import search.strategy.SearchStrategy
import java.util.TreeMap

class InvertedIndex(private val initialList: List<String>) {

    private val index: MutableMap<String, MutableList<Int>> = TreeMap(String.CASE_INSENSITIVE_ORDER)

    init {
        initialList.forEachIndexed { idx, str ->
            val words = str.split(" ")

            words.forEach {
                index.compute(it) { _, oldVal ->
                    oldVal?.apply { add(idx)  } ?: mutableListOf(idx)
                }
            }
        }
    }

    fun search(string: String, strategy: SearchStrategy): List<String> {
        val tokens = string.split(" ")
        return strategy.rule.apply(tokens, index).map { initialList[it] }.distinct()
    }
}
