package com.company;

import java.math.BigDecimal;
import java.text.StringCharacterIterator;

/**
 * The class  {@code SimpleInfixCalculator} contains methods for calculation of mathematical infix expressions.
 * It supports calculation of integer and decimal numbers and four operations:
 * multiplying, division, addition and subtraction. A change of the order of operations with parentheses
 * is not supported.
 */
public final class SimpleInfixCalculator {

    /**
     * Don't let anyone instantiate this class.
     */
    private SimpleInfixCalculator() {
    }

    /**
     * Returns the result of calculation of the given {@code expr} expression. Supported operators are:
     * <ul>
     * <li>multiplying (*)</li>
     * <li>division (/)</li>
     * <li>addition (+)</li>
     * <li>subtraction (-)</li>
     * </ul>
     * Note, that a change of the order of operations with
     * parentheses is not supported.
     * <br>
     * Supported numbers are:
     * <ul>
     * <li>integer</li>
     * <li>decimal numbers with the point (.) as the decimal mark. </li>
     * </ul>
     * Decimal numbers starting with the decimal mark are interpreted as invalid numbers.
     * Division scale is fixed and equal to 8. Rounding is half to even.
     *
     * @param expr the expression to calculate
     * @return the result
     * @throws IllegalArgumentException if {@code expr} contains invalid symbol or is invalid.
     */
    public static BigDecimal evaluate(String expr) throws IllegalArgumentException {

        if (expr == null) {
            throw new NullPointerException("Expression string is null");
        }

        StringCharacterIterator characterIterator = new StringCharacterIterator(expr);

        BigDecimal result = new BigDecimal(0);
        BigDecimal multiplier = readDecimalOperand(characterIterator);

        while (characterIterator.current() != StringCharacterIterator.DONE) {

            Character c = characterIterator.current();

            if (Character.isWhitespace(c)) {
                characterIterator.next();
                continue;
            }


            characterIterator.next();
            switch (c) {
                case '+':
                    result = result.add(multiplier);
                    multiplier = readDecimalOperand(characterIterator);
                    break;
                case '-':
                    result = result.add(multiplier);
                    multiplier = readDecimalOperand(characterIterator).negate();
                    break;
                case '*':
                    multiplier = multiplier.multiply(readDecimalOperand(characterIterator));
                    break;
                case '/':
                    multiplier = multiplier.divide(readDecimalOperand(characterIterator), 8,
                            BigDecimal.ROUND_HALF_EVEN);
                    break;
                default:
                    if (Character.isDigit(c)) {
                        throw new IllegalArgumentException(String.join(" ",
                                "Missing operator at the position",
                                String.valueOf(characterIterator.getIndex() + 1), "(two consecutive numbers)"));
                    } else {
                        throw new IllegalArgumentException(String.join(" ", "Wrong symbol",
                                c.toString(), "at the position", String.valueOf(characterIterator.getIndex() + 1)));
                    }
            }
        }

        return result.add(multiplier).stripTrailingZeros();

    }

    /**
     * Reads the integer or decimal number from character, pointed by {@code charIterator}, until the symbol,
     * different from digit or decimal mark.
     * The point (.) is interpreted as the decimal mark. Decimal numbers starting with the decimal mark
     * are interpreted as invalid numbers. Exponential form is not supported.
     *
     * @param charIterator the string character iterator pointing at the beginning of the number
     * @return the number
     * @throws NumberFormatException if not a digit and not the decimal mark symbol is found
     */
    public static BigDecimal readDecimalOperand(StringCharacterIterator charIterator)
            throws NumberFormatException {

        if (charIterator == null) {
            throw new NullPointerException("String character iterator is null");
        }

        Character c = charIterator.current();

        while (Character.isWhitespace(c)) {
            c = charIterator.next();
        }

        boolean decimalMarkUsed = false;
        StringBuilder operandBuffer = new StringBuilder();
        if (Character.isDigit(c)) {
            do {
                if (c == '.') {
                    if (!decimalMarkUsed) {
                        decimalMarkUsed = true;
                    } else {
                        throw new NumberFormatException("Decimal mark used more than once at the position " +
                                Integer.toString(charIterator.getIndex() + 1));
                    }
                }
                operandBuffer.append(c);
                c = charIterator.next();
            }
            while (c != StringCharacterIterator.DONE && (Character.isDigit(c) || c == '.'));
        } else {

            if (c == StringCharacterIterator.DONE) {
                throw new NumberFormatException("Missing operand at the end of the expression ");
            }

            throw new NumberFormatException(String.join(" ", "Wrong symbol",
                    c.toString(), "at the position", String.valueOf(charIterator.getIndex() + 1)));
        }
        return new BigDecimal(operandBuffer.toString());
    }

}
