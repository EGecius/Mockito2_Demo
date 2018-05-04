package mockitodemo

class Toolbox(private val plantWaterer: PlantWaterer) {

    val waterPressure: Int
        get() = plantWaterer.waterSource.waterPressure
}
