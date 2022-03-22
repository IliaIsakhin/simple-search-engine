package search.strategy.rules

object SearchNoneRule : SearchRule {
    override fun apply(tokens: List<String>, index: Map<String, List<Int>>): List<Int> {
        val anyResults = tokens.map { (index[it] ?: emptyList()) }.flatten()

        return index.values.flatten().filterNot { anyResults.contains(it) }
    }
}