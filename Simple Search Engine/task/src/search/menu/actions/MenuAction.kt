package search.menu.actions

abstract class MenuAction {
    open var index: Int = 0
    abstract val name: String

    abstract fun execute()
}
