package search

import search.index.InvertedIndex
import search.menu.actions.ExitMenuAction
import search.menu.MenuActionManager
import search.menu.actions.PrintAllMenuAction
import search.menu.actions.SearchInformationMenuAction
import java.io.FileReader


fun main(vararg args: String) {
    val fileName = args[args.indexOf("--data") + 1]
    val peopleInfo = mutableListOf<String>()

    FileReader(fileName).useLines {
        it.forEach(peopleInfo::add)
    }

    val invertedIndex = InvertedIndex(peopleInfo)

    val menuActions = listOf(
        SearchInformationMenuAction(invertedIndex),
        PrintAllMenuAction(peopleInfo),
        ExitMenuAction
    )
    val menuActionManager = MenuActionManager(menuActions)
    var userInput: Int?

    do {
        menuActionManager.print()
        userInput = readln().toInt()
        menuActionManager.doAction(userInput)
    } while (true)
}
