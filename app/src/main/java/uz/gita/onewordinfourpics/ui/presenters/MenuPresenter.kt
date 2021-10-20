package uz.gita.onewordinfourpics.ui.presenters

import uz.gita.onewordinfourpics.contracts.MenuContract

class MenuPresenter(private val view : MenuContract.View, private val model : MenuContract.Model) : MenuContract.Presenter {
    override fun setGameLevel() {
        view.setGame(model.getLastLevelOfGame(), model.getCoin())
    }

    override fun clickPlayButton() {
        view.openGameActivity()
    }
}