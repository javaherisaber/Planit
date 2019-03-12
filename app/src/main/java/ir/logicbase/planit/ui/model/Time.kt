package ir.logicbase.planit.ui.model

class Time(val hour: Int, val minute: Int) {

    override fun toString(): String {
        return "$hour:$minute"
    }
}