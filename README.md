# Matrix Datasets
Common, public domain and oss datasets in Matrix format for Groovy applications running on JDK 17 or later.

Includes mtcars, iris, PlantGrowth, ToothGrowth, USArrests, and mpg

## Setup
Gradle:
```groovy
implementation 'se.alipsa.groovy:matrix-datasets:1.0.0'
```
Maven:
```xml
<dependency>
    <groupId>se.alipsa.groovy</groupId>
    <artifactId>matrix-datasets</artifactId>
    <version>1.0.0</version>
</dependency>
```

## Usage:
```groovy
import se.alipsa.groovy.datasets.*
import se.alipsa.groovy.matrix.*

Matrix iris = Dataset.iris()
Matrix speciesMeans = Stat.meanBy(iris, 'Sepal Length','Species')
println speciesMeans.content()
```
| Species         | Sepal Length |
|-----------------|--------------|
| Iris-versicolor | 5.936        |
| Iris-virginica	 | 6.588        |
| Iris-setosa	    | 5.006        |
```
