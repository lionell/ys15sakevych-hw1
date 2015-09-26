# Yandex School 2015: Java Homework #1

## Methods overview

```java
double average()
```
Evaluates average temperature in list.

---
```java
double deviation()
```
Evaluates standard deviation of temperature.

---
```java
double min()
```
Returns minimal temperature in list.

---
```java
double max()
```
Returns maximal temperature in list.

---
```java
double findTempClosestToZero()
```
Returns closest to zero temperature from list.
If there are two temperatures with equal distances, returns **positive** one.

---
```java
double findTempClosestToValue(double tempValue)
```
Returns closest to `tempValue` temperature from list.
If there are two temperatures with equal distances, returns **positive** one.

---
```java
double[] findTempsLessThan(double tempValue)
```
Returns array of temperatures which are less than `tempValue`.

---
```java
double[] findTempsGreaterThan(double tempValue)
```
Returns array of temperatures which are greater than `tempValue`.

---
```java
TempSummaryStatistics summaryStatistics()
```
Returns **immutable** instance of `TempSummaryStatistics` class, which contains information about:
 - `double avgTemp` - Average temperature 
 - `double devTemp` - Deviation 
 - `double minTemp` - Minimal temperature 
 - `double maxTemp` - Maximal temperature

---
```java
int addTemps(double[] temps)
```
Append to list new temperatures from `temps` array.
Returns sum of temperatures in new list.

Structure(array-like) used in class TemperatureSeriesAnalysis for storing temperatures will increase its length in 2 times, if needed.

 - class TemperatureSeriesAnalysis have default constructor and constructor with parameter `temps`.
 - if `temps` has value less than **-273C**, than changes will be discarded and `InputMismatchException` will be thrown.
 - standard `ArrayList<T>` and `LinkedList<T>` is not used.

---
**NOTE.** All methods throws `IllegalArgumentException` if the list is empty.

**NOTE.** All comparisons of `double` values uses epsilon `EPS = 5e-7`.

#### Deadline October 5th, 2015
