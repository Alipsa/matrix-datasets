package se.alipsa.groovy.matrixdata

import se.alipsa.groovy.matrix.Matrix
import se.alipsa.groovy.matrixdata.util.FileUtil

class Dataset {

    static Matrix iris() {
        def iris = Matrix.create(url('/data/Iris.csv'))
        iris = iris.convert(
            Id: Integer,
            'Sepal Length': BigDecimal,
            'Sepal Width': BigDecimal,
            'Petal Length': BigDecimal,
            'Petal Width': BigDecimal,
            Species: String
        )
        iris.setName('iris')
        return iris
    }

    static Matrix mtcars() {
        def mtcars = Matrix.create(url('/data/mtcars.csv'))
        mtcars = mtcars.convert(
                model: String,
                mpg: BigDecimal,
                cyl: Integer,
                disp: BigDecimal,
                hp: BigDecimal,
                drat: BigDecimal,
                wt: BigDecimal,
                qsec: BigDecimal,
                vs: BigDecimal,
                am: Integer,
                gear: Integer,
                carb: Integer
        )
        mtcars.setName('mtcars')
        return mtcars
    }

    static Matrix plantGrowth() {
        Matrix.create(url('/data/PlantGrowth.csv'))
    }

    static Matrix toothGrowth() {
        Matrix.create(url('/data/ToothGrowth.csv'))
    }

    static Matrix usArrests() {
        Matrix.create(url('/data/USArrests.csv'))
    }

    Matrix fromUrl(String url, String delimiter = ',') {
        URL u = new URL(url)
        return Matrix.create(u, delimiter)
    }

    private static URL url(String path) {
        FileUtil.getResource(path)
    }

    String describe(Matrix table) {
        def name = table.name
        if (name == 'mtcars') return descMtcars()
        if (name == 'iris') return descIris()
        if (name == 'PlantGrowth') return descPlanthGrowth()
        if (name == 'ToothGrowth') return descToothGrowth()
        if (name == 'USArrests') return descUsArrests()
        return "Unknown table: $name: ${table.toString()}"
    }



    String descMtcars() {
        return '''
        mtcars: Motor Trend Car Road Tests
        The data was extracted from the 1974 Motor Trend US magazine, 
        and comprises fuel consumption and 10 aspects of automobile design 
        and performance for 32 automobiles (1973–74 models)

        Variables:
        mpg: Miles/(US) gallon
        cyl: Number of cylinders
        disp: Displacement (cu.in.)
        hp: Gross horsepower
        drat: Rear axle ratio
        wt: Weight (1000 lbs)
        qsec: 1/4 mile time
        vs: V/S
        am: Transmission (0 = automatic, 1 = manual)
        gear: Number of forward gears
        carb: Number of carburetors
        '''
    }


    String descIris() {
        return '''
        The iris data set gives the measurements in centimeters of the variables sepal length, sepal width, 
        petal length and petal width, respectively, for 50 flowers from each of 3 species of iris. 
        The species are Iris setosa, versicolor, and virginica.
        
        Variables:
        Id: an integer corresponding to a unique observation,
        Sepal Length: length of the sepal in cm,
        Sepal Width: width of the sepal in cm,
        Petal Length: length of the petal in cm,
        Petal Width: width of the petal in cm,
        Species: The species of iris i.e. setosa, versicolor, and virginica
        '''
    }

    String descPlanthGrowth() {
        return '''
        Results obtained from an experiment to compare yields (as measured by dried weight of plants) 
        obtained under a control and two different treatment condition.
        
        Variables:
        "": an integer corresponding to a unique observation,
        weight: the dried weight,
        group: ctrl, trt1 or trt2
        '''
    }

    String descToothGrowth() {
        return '''
        ToothGrowth data set contains the result from an experiment studying the effect of 
        vitamin C on tooth growth in 60 Guinea pigs. Each animal received one of three dose levels of 
        vitamin C (0.5, 1, and 2 mg/day) by one of two delivery methods, 
        orange juice or ascorbic acid (a form of vitamin C and coded as VC).
        
        Variables:
        '': an integer corresponding to a unique observation,
        len: Tooth length
        supp: Supplement type (VC or OJ).
        dose: numeric Dose in milligrams/day
        '''
    }

    String descUsArrests() {
        return '''
        This data set contains statistics about violent crime rates by us state.
        
        Variables:
        State: The US state
        Murder: Murder arrests (per 100,000)
        Assault: Assault arrests (per 100,000)
        UrbanPop: Percent urban population
        Rape: Rape arrests (per 100,000)
        '''
    }
}