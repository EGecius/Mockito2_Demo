package mockitodemo

open class FlowerFilter {

    open fun filterNoOfFlowers(testNumberOfFlowers: Int): Int {
        return 0
    }

    open fun tellMeFlowerName(): String? {
        return null
    }

}
