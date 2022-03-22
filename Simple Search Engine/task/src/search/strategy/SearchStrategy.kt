package search.strategy

import search.strategy.rules.SearchAllRule
import search.strategy.rules.SearchAnyRule
import search.strategy.rules.SearchNoneRule
import search.strategy.rules.SearchRule

enum class SearchStrategy(val rule: SearchRule) {
    ANY(SearchAnyRule),
    ALL(SearchAllRule),
    NONE(SearchNoneRule);
}