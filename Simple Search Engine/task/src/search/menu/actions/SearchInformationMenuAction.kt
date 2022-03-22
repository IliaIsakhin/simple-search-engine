package search.menu.actions

import search.index.InvertedIndex
import search.strategy.SearchStrategy

class SearchInformationMenuAction(
    private val invertedIndex: InvertedIndex,
) : MenuAction() {
    override val name: String = "Search information."

    override fun execute() {
        println("Select a matching strategy: ALL, ANY, NONE")
        val inputStrategy = SearchStrategy.valueOf(readln())

        println("Enter a name or email to search all suitable people.")
        val userInput = readln()

        invertedIndex.search(userInput, inputStrategy)
            .forEach(::println)
    }
}