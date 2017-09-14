import java.math.BigInteger;

public class JavaEnumToBits {

  enum orderedEnum {
    ONE,
    TWO,
    THREE,
    FOUR,
    FIVE,
    SIX,
    SEVEN,
    EIGHT
  }


  public static void main(String[] args) {
    long testBits = BigInteger.ZERO.longValue();
    BigInteger testInteger = BigInteger.valueOf(testBits);

    testInteger = testInteger.setBit(orderedEnum.ONE.ordinal());
    testInteger = testInteger.setBit(orderedEnum.FIVE.ordinal());
    testInteger = testInteger.setBit(orderedEnum.TWO.ordinal());
    testInteger = testInteger.setBit(orderedEnum.EIGHT.ordinal());
    testInteger = testInteger.setBit(orderedEnum.THREE.ordinal());

    testBits |= 1 << orderedEnum.ONE.ordinal();
    testBits |= 1 << orderedEnum.FIVE.ordinal();
    testBits |= 1 << orderedEnum.TWO.ordinal();
    testBits |= 1 << orderedEnum.EIGHT.ordinal();
    testBits |= 1 << orderedEnum.THREE.ordinal();

    System.out.println("JavaEnumToBits: testInteger = " + testInteger);

    int counter = 1;
    for (orderedEnum val : orderedEnum.values()) {
      System.out.println("JavaEnumToBits: testBit(val) " + counter++ + " = " +
          testInteger.testBit(val.ordinal()));
    }

    System.out.println("=====");

    int bitIndex = 1;
    for (orderedEnum index : orderedEnum.values()) {
      System.out.println("java long to bits: testBit(val) = " + bitIndex++ + " = " +
          (((testBits >> index.ordinal()) & 1) != 0));
    }

  }
}
