package com.nttdata.bankclientservice.model.document.type;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
/**
 * Client Type Enum.
 *
 * @author jmacoele
 *
 */

public enum ClientTypeEnum {
  PERSONAL("P"),
  ENTERPRISE("E");

  private String value;

  @JsonValue
  public String getValue() {
    return value;
  }

  /**
   * Function of that convert string into Enum value.
   *
   * @param value Enum value string-converted.
   * @return ClienTypeEnum
   */
  @JsonCreator
  public static ClientTypeEnum of(String value) {
    if (null == value) {
      return null;
    }

    for (ClientTypeEnum item : ClientTypeEnum.values()) {
      if (value.equals(item.getValue())) {
        return item;
      }
    }

    throw new RuntimeException("ClientTypeEnum: unknown value: " + value);
  }

  ClientTypeEnum(String value) {
    this.value = value;
  }

}