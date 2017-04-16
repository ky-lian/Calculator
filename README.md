# Simple-Infix-Calculator
The simple infix calculator CLI program.

**Supported operands**: integer and decimal numbers (with the point "." as the decimal mark). Exponential form is not supported.

**Supported operators**: multiplying(*), division(/), addition(+) and subtraction(-). 
A change of the order of operations with parentheses is not supported. Decimal numbers starting with the decimal mark are interpreted as invalid numbers. Division scale is fixed and equal to 8. Rounding is half to even.

## Usage: 
```
  java -jar Calculator.jar "[EXPRESSION]"
```
## Example: 
```
  java -jar Calculator.jar "2 + 3 / 3.52 - 4"
  Result: -1.14772727
```

# Инфиксный калькулятор
Инфиксный калькулятор, запускаемый из командной строки.

**Поддерживаемые операнды**: целые и дробные числа (с символом точка "." в качестве десятичного разделителя). Экспоненциальная форма записи не поддерживается.

**Поддерживаемые операторы**: умножение(*), деление(/), сложение(+) и вычитание(-). 
Изменение приоритета операций с помощью скобок не поддерживается. Десятичные числа начинающиеся с десятичного разделителя интерпретируются как некорректные числа. Округление производится с точностью до 8 знаков после десятичного разделителя. Используется банковское округление (к ближайшему четному). 

## Использование: 
```
  java -jar Calculator.jar "[ВЫРАЖЕНИЕ]"
```

## Пример: 
```
  java -jar Calculator.jar "2 + 3 / 3.52 - 4"
  Result: -1.14772727
```
