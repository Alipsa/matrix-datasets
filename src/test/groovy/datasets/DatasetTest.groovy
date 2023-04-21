package datasets

import static org.junit.jupiter.api.Assertions.*

import org.junit.jupiter.api.Test
import se.alipsa.groovy.datasets.*
import se.alipsa.groovy.matrix.*

class DatasetTest {

    @Test
    void testIris() {
        Matrix iris = Dataset.iris()
        assertEquals(150, iris.rowCount(), 'number of rows')
        assertEquals(6, iris.columnCount(), 'number of columns')
        assertEquals(876.5, Stat.sum(iris['Sepal Length']))
        assertEquals(Dataset.descIris(), Dataset.describe(iris))
        assertEquals(Dataset.descIris(), Dataset.describe('iris'))
    }


    @Test
    void testMtcars() {
        def mtcars = Dataset.mtcars()
        assertEquals(32, mtcars.rowCount(), 'number of rows')
        assertEquals(12, mtcars.columnCount(), 'number of columns')
        assertEquals(642.9, Stat.sum(mtcars['mpg']), 'sum of mpg')
        assertEquals(Dataset.descMtcars(), Dataset.describe(mtcars))
        assertEquals(Dataset.descMtcars(), Dataset.describe('mtcars'))
    }

    @Test
    void testPlantGrowth() {
        def plantGrowth = Dataset.plantGrowth()
        assertEquals(30, plantGrowth.rowCount())
        assertEquals(3, plantGrowth.columnCount())
        assertEquals(152.19, Stat.sum(plantGrowth['weight']), 'sum of weight')
        assertEquals(Dataset.descPlantGrowth(), Dataset.describe(plantGrowth))
        assertEquals(Dataset.descPlantGrowth(), Dataset.describe('plantGrowth'))
    }

    @Test
    void testToothGrowth() {
        def toothGrowth = Dataset.toothGrowth()
        assertEquals(60, toothGrowth.rowCount())
        assertEquals(4, toothGrowth.columnCount())
        assertEquals(1128.8, Stat.sum(toothGrowth['len']), 'sum of len')
        assertEquals(Dataset.descToothGrowth(), Dataset.describe(toothGrowth))
        assertEquals(Dataset.descToothGrowth(), Dataset.describe('toothGrowth'))
    }

    @Test
    void testUsArrests() {
        def usArrests = Dataset.usArrests()
        assertEquals(50, usArrests.rowCount())
        assertEquals(5, usArrests.columnCount())
        assertEquals(389.4, Stat.sum(usArrests['Murder']), 'sum of Murder')
        assertEquals(Dataset.descUsArrests(), Dataset.describe(usArrests))
        assertEquals(Dataset.descUsArrests(), Dataset.describe('usArrests'))
    }

    @Test
    void testMpg() {
        def mpg = Dataset.mpg()
        assertEquals(234, mpg.rowCount())
        assertEquals(11, mpg.columnCount())
        assertEquals(812.4, Stat.sum(mpg['displ']), 'sum of displ')
        assertEquals(Dataset.descMpg(), Dataset.describe(mpg))
        assertEquals(Dataset.descMpg(), Dataset.describe('mpg'))
    }
}
