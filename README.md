# Cache Calculator
Cache mapping size refers to the organization and structure of a cache memory system. It determines how the main memory addresses are mapped to cache memory locations. There are several cache mapping techniques commonly used, including Direct Mapping, Fully Associative Mapping and Set-Associative Mapping. The cache mapping size is typically represented by the tag, line and word sizes.

## Getting Started
To run this code, you will need to have the Java Development Kit (JDK) a Java Integrated Development Environment (IDE) and JavaFX installed on your machine.

### Prerequisites
JDK: You can download the latest version of the JDK [here](https://www.oracle.com/java/technologies/downloads/).

IDE: Some popular Java IDEs include [Eclipse](https://www.eclipse.org/downloads/), [IntelliJ IDEA](https://www.jetbrains.com/idea/download/#section=windows), and [Netbeans](https://netbeans.apache.org/download/index.html).

JavaFX: The Cache Calculator relies on JavaFX for the graphical user interface. Since JDK 11 and latest version does not include JavaFX, you need to install JavaFX seperately [here](https://gluonhq.com/products/javafx/).

### Running the code
1. Clone or download the code to your local machine.
2. Open the code in your chosen IDE.
3. Make sure you already set up the JavaFX libraries in your project. You can refer the documentation to configure JavaFX to your IDE [here](https://openjfx.io/openjfx-docs/).
4. Compile and run the code.

   `javac CacheCalculator.java`

   `java --module-path /path/to/javafx-sdk-16/lib --add-modules javafx.controls,javafx.fxml CacheCalculator`
   Make sure to replace `/path/to/javafx-sdk-16` with the actual path to your JavaFX SDK installation directory.

4. The Cache Calculator window will open, allowing you to enter parameters and calculate the cache mapping sizes.

## How to use the Cache Calculator

1. Compile and run the `CacheCalculator` class in your Java IDE.
2. Enter the following parameters in the corresponding input fields: 
    * Main Memory Address Size (Gb)
    * Cache Memory Size (Mb)
    * Word Size (byte)
    * k-way (set associative cache)
3. Click on one of the mapping technique buttons: "Direct Mapping", "Fully/Associative Mapping", or "Set-Associative Mapping".
4. The application will calculate and display the corresponding cache mapping sizes, including the tag, line, and word sizes.
5. You can modify the input parameters and click on a different mapping technique button to recalculate the cache mapping sizes.
6. Close the application window when finished.

##### Sample Run
![Sample Run](https://media.discordapp.net/attachments/954699219485212712/1058198956380794941/Capture.PNG)



### Remarks

