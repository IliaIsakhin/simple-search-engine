package search.strategy.rules

interface SearchRule {

    fun apply(tokens: List<String>, index: Map<String, List<Int>>): List<Int>
}