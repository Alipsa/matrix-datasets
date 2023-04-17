package se.alipsa.groovy.matrixdata

import se.alipsa.groovy.matrix.Matrix
import se.alipsa.groovy.matrixdata.util.FileUtil

class Dataset {

    static Matrix iris() {
        Matrix.create(getFile('/data/Iris.csv'))
    }

    private static File getFile(String path) {
        URI uri = FileUtil.getResource(path).toURI()
        return new File(uri)
    }
}