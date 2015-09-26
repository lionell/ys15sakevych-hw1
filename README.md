# Yandex School 2015: Java Homework #1

## Methods overview

```java
double average()
```
Evaluates average temperature in list.

**Exceptions:** 
 - If list is empty throws `IllegalArgumentException`.

```java
double deviation()
```
Evaluates standard deviation of temperature.

**Exceptions:**
 - if list is empty throws `IllegalArgumentException`.

```java
double min()
```
Returns minimal temperature in list.

**Exceptions:**
 - if list is empty throws `IllegalArgumentException`.

```java
double max()
```
Returns maximal temperature in list.

**Exceptions:**
 - if list is empty throws `IllegalArgumentException`.

```java
double findTempClosestToZero()
```
Returns closest to zero temperature from list.
> If there are two temperatures with equal distances, returns positive.

**Exceptions:**
 - if list is empty throws `IllegalArgumentException`.

```java
double findTempClosestToValue(double tempValue)
```

```java
double[] findTempsLessThan(double tempValue)
```

```java
double[] findTempsGreaterThan(double tempValue)
```

```java
TempSummaryStatistics summaryStatistics()
```

```java
int addTemps(double ... temps)
```

### Deadline October 5th, 2015
