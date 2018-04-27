import org.nd4j.linalg.factory.Nd4j

// The Nd4j class provides lots of useful static methods to create vectors.

// Let's create a single column vector of 10 elements
val zerosColumn = Nd4j.zeros(10)

// What about a matrix?
val zerosMatrix = Nd4j.zeros(3, 4)

// In fact, we can create a tensor of any shape
val zerosTensor = Nd4j.zeros(6, 10, 3)

// If we want to initialize a tensor with another number different than zero, we can just add it after it has been created
val fortyTwosTensor = Nd4j.zeros(3, 4).addi(42)  // Here i stands for in-place. Then, add() creates a copy.


// If we want to initialize with random numbers:
val randomMatrix = Nd4j.rand(1, 2)

// A random tensor:
val randomTensor = Nd4j.rand(Array(16, 16, 3))  // Random tensor of 16x16x3

// If we want to generate a random a tensor from a Gaussian distribution
val randomGaussianTensor = Nd4j.randn(Array(8, 8, 3))

////// ARRAY BASICS ////////

// Let's create an INDArray given an array of elements and a shape
val a = Nd4j.create(Array(1, 2, 3, 4, 5, 6), Array(2, 3))

// Let's say we have a Scala array and we want to create an INDArray from it
val aFromScalaArray = Nd4j.create(Array(1d, 3d, 50d, 2d))

val matrixFromScalaArray = Nd4j.create(Array(Array(2d, 3d), Array(33d, 49d)))
matrixFromScalaArray.shape()

val myMatrix = Nd4j.rand(3, 5)

// Getting a row.
myMatrix.getColumn(0)

// Getting a column
myMatrix.getColumn(1)

// Getting multiple rows
myMatrix.getRows(0, 2)

// Getting multiple columns
myMatrix.getColumns(1, 4)

// Getting a single value
myMatrix.getDouble(0, 3)

// Modifying a single value in a row (each obtained row is a view of the tensor, so any change in this view WILL AFFECT
// the TENSOR)
myMatrix.getRow(0).putScalar(2, 0.5)  // Put 0.5 in element at 2

// Modifying a single value in a column
myMatrix.getColumn(1).putScalar(2, 3.1416)

// Modifying a single value in a cell
myMatrix.putScalar(Array(1, 2), 42.56)

// Replace a row
myMatrix.putRow(2, Nd4j.zeros(5).addi(21))

// Basic math
val myRow = Nd4j.randn(Array(1, 10))

// With scalars
myRow.addi(23)
myRow.divi(7)
myRow.subi(10)
myRow.muli(-1)

// With other INDArrays
val shape = Array(3, 4)
val matrix1 = Nd4j.randn(shape)

matrix1.addi(Nd4j.randn(shape))
matrix1.subi(Nd4j.randn(shape))
matrix1.muli(Nd4j.randn(shape))
matrix1.divi(Nd4j.ones(shape:_*).addi(10))

