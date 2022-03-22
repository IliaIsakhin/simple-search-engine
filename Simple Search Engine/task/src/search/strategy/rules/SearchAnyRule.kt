package search.strategy.rules

object SearchAnyRule : SearchRule {
    override fun apply(tokens: List<String>, index: Map<String, List<Int>>): List<Int> {
        return tokens
            .map { (index[it] ?: emptyList()) }
            .flatten()
    }
}