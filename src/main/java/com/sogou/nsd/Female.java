/**
 * Autogenerated by Thrift Compiler (0.9.1)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.sogou.nsd;


import java.util.Map;
import java.util.HashMap;
import org.apache.thrift.TEnum;

public enum Female implements org.apache.thrift.TEnum {
  MALE(0),
  FEAMLE(1);

  private final int value;

  private Female(int value) {
    this.value = value;
  }

  /**
   * Get the integer value of this enum value, as defined in the Thrift IDL.
   */
  public int getValue() {
    return value;
  }

  /**
   * Find a the enum type by its integer value, as defined in the Thrift IDL.
   * @return null if the value is not found.
   */
  public static Female findByValue(int value) { 
    switch (value) {
      case 0:
        return MALE;
      case 1:
        return FEAMLE;
      default:
        return null;
    }
  }
}
