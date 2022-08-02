package com.nttdata.bankclientservice.model.document.type;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
/**
 * Phone Type Enum.
 *
 * @author jmacoele
 *
 */

public enum PhoneTypeEnum {
  HOME("H"),
  WORK("W"),
  OTHER("O");

  private String value;

  @JsonValue
  public String getValue() {
    return value;
  }
  /**
   * Function of that convert string into enum value.
   *
   * @param value Enum value string-converted.
   * @return PhoneTypeEnum.
   */
  
  @JsonCreator
  public static PhoneTypeEnum of(String value) {
    if (null == value) {
      return null;
    }

    for (PhoneTypeEnum item : PhoneTypeEnum.values()) {
      if (value.equals(item.getValue())) {
        return item;
      }
    }

    throw new RuntimeException("PhoneTypeEnum: unknown value: " + value);
  }

  PhoneTypeEnum(String value) {
    this.value = value;
  }

}