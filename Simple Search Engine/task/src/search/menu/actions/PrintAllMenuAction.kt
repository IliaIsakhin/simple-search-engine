package search.menu.actions

class PrintAllMenuAction(private val people: List<String>) : MenuAction() {

    override val name: String = "Print all data."

    override fun execute() {
         people.forEach(::println)
    }
}