package search.menu

import search.menu.actions.ExitMenuAction
import search.menu.actions.MenuAction

class MenuActionManager(private val menuActions: List<MenuAction>) {

    init {
        menuActions.forEachIndexed { index, action ->
            val currIndex = if (action is ExitMenuAction) 0 else index + 1

            action.index = currIndex
        }
    }

    fun print() {
        println("=== Menu ===")

        menuActions.forEach {
            println("${it.index}. ${it.name}")
        }
    }

    fun doAction(userInput: Int) {
        menuActions.find {
            it.index == userInput
        }?.execute() ?: println("Incorrect option! Try again.")
    }
}