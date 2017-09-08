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


    System.out.println("JavaEnumToBits: testInteger = " + testInteger);

    for (orderedEnum val : orderedEnum.values()) {
      System.out.println("JavaEnumToBits: testBit(val) = " +
          testInteger.testBit(val.ordinal()));
    }

  }
}
