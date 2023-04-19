package matrixdata

import static org.junit.jupiter.api.Assertions.*

import org.junit.jupiter.api.Test
import se.alipsa.groovy.matrixdata.*
import se.alipsa.groovy.matrix.*

class DatasetTest {

    @Test
    void testIris() {
        def iris = Dataset.iris()
        assertEquals(150, iris.rowCount(), 'number of rows')
        assertEquals(6, iris.columnCount(), 'number of columns')
        assertEquals(876.5, Stat.sum(iris['Sepal Length']))
    }


    @Test
    void testMtcars() {
        def mtcars = Dataset.mtcars()
        assertEquals(32, mtcars.rowCount(), 'number of rows')
        assertEquals(12, mtcars.columnCount(), 'number of columns')
    }
}
