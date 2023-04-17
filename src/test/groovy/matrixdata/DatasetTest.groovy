package matrixdata

import static org.junit.jupiter.api.Assertions.*

import org.junit.jupiter.api.Test
import se.alipsa.groovy.matrixdata.*

class DatasetTest {

    @Test
    void testIris() {
        def iris = Dataset.iris()
        assertEquals(150, iris.rowCount(), 'number of rows')
        assertEquals(6, iris.columnCount(), 'number of columns')
    }
}
