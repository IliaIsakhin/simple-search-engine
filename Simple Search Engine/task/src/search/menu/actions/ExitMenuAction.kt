package search.menu.actions

import kotlin.system.exitProcess

object ExitMenuAction: MenuAction() {
    override val name: String = "Exit."

    override fun execute() {
        println("Bye")
        exitProcess(0)
    }
}