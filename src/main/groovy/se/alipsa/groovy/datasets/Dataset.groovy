package se.alipsa.groovy.datasets

import se.alipsa.groovy.matrix.Matrix
import se.alipsa.groovy.datasets.util.FileUtil

class Dataset {

    static Matrix iris() {
        Matrix table = Matrix.create(url('/data/Iris.csv')).convert(
            Id: Integer,
            'Sepal Length': BigDecimal,
            'Sepal Width': BigDecimal,
            'Petal Length': BigDecimal,
            'Petal Width': BigDecimal,
            Species: String
        )
        table.setName('Iris')
        return table
    }

    static Matrix mtcars() {
        Matrix table = Matrix.create(url('/data/mtcars.csv')).convert(
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
        table.setName('mtcars')
        return table
    }

    static Matrix plantGrowth() {
        Matrix table = Matrix.create(url('/data/PlantGrowth.csv'), ',', '"').convert(
                id: Integer,
                weight: BigDecimal
        )
        table.setName('PlantGrowth')
        return table
    }

    static Matrix toothGrowth() {
        Matrix table = Matrix.create(url('/data/ToothGrowth.csv'), ',', '"').convert(
                id: Integer,
                len: BigDecimal,
                dose: BigDecimal
        )
        table.setName('ToothGrowth')
        return table
    }

    static Matrix usArrests() {
        Matrix table = Matrix.create(url('/data/USArrests.csv'), ',', '"').convert(
                "Murder": BigDecimal,
                "Assault": Integer,
                "UrbanPop": Integer,
                "Rape": BigDecimal
        )
        table.setName('USArrests')
        return table
    }

    Matrix fromUrl(String url, String delimiter = ',') {
        URL u = new URL(url)
        return Matrix.create(u, delimiter)
    }

    private static URL url(String path) {
        FileUtil.getResource(path)
    }

    static String describe(Matrix table) {
        describe(table.name)
    }

    static String describe(String tableName) {
        def name = tableName.toLowerCase()
        if (name == 'mtcars') return descMtcars()
        if (name == 'iris') return descIris()
        if (name == 'plantgrowth') return descPlantGrowth()
        if (name == 'toothgrowth') return descToothGrowth()
        if (name == 'usarrests') return descUsArrests()
        return "Unknown table: ${tableName}"
    }



    static String descMtcars() {
        return '''
        The mtcars (Motor Trend Car Road Tests) dataset was extracted from the 1974 Motor Trend US magazine, 
        and comprises fuel consumption and 10 aspects of automobile design and performance for 32 automobiles 
        (1973–1974 models)

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
        '''.stripIndent()
    }


    static String descIris() {
        return '''
        The iris dataset gives the measurements in centimeters of the variables sepal length, sepal width, 
        petal length and petal width, respectively, for 50 flowers from each of 3 species of iris. 
        The species are Iris setosa, versicolor, and virginica.
        
        Variables:
        Id: an integer corresponding to a unique observation,
        Sepal Length: length of the sepal in cm,
        Sepal Width: width of the sepal in cm,
        Petal Length: length of the petal in cm,
        Petal Width: width of the petal in cm,
        Species: The species of iris i.e. setosa, versicolor, and virginica
        '''.stripIndent()
    }

    static String descPlantGrowth() {
        return '''
        The plant growth dataset contains results obtained from an experiment to compare yields 
        (as measured by dried weight of plants) 
        obtained under a control and two different treatment condition.
        
        Variables:
        "": an integer corresponding to a unique observation,
        weight: the dried weight,
        group: ctrl, trt1 or trt2
        '''.stripIndent()
    }

    static String descToothGrowth() {
        return '''
        The ToothGrowth data set contains the result from an experiment studying the effect of 
        vitamin C on tooth growth in 60 Guinea pigs. Each animal received one of three dose levels of 
        vitamin C (0.5, 1, and 2 mg/day) by one of two delivery methods, 
        orange juice or ascorbic acid (a form of vitamin C and coded as VC).
        
        Variables:
        '': an integer corresponding to a unique observation,
        len: Tooth length
        supp: Supplement type (VC or OJ).
        dose: numeric Dose in milligrams/day
        '''.stripIndent()
    }

    static  String descUsArrests() {
        return '''
        The US arrests data set contains statistics in arrests per 100,000 residents for assault, murder, and rape 
        in each of the 50 US states in 1973.
        
        Variables:
        State: The US state
        Murder: Murder arrests (per 100,000)
        Assault: Assault arrests (per 100,000)
        UrbanPop: Percent urban population
        Rape: Rape arrests (per 100,000)
        '''.stripIndent()
    }
}