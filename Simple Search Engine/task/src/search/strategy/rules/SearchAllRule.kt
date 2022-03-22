package search.strategy.rules

object SearchAllRule : SearchRule {
    override fun apply(tokens: List<String>, index: Map<String, List<Int>>): List<Int> {
        val map = tokens.map { (index[it] ?: emptyList()) }

        if (map.isEmpty()) return emptyList()
        var result = map.first().toSet()
        map.forEach {
            result = result.intersect(it.toSet())
        }

        return result.toList()
    }
}