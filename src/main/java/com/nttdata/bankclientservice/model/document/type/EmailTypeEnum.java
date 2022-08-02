package com.nttdata.bankclientservice.model.document.type;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
/**
 * Email Type Enum.
 *
 * @author jmacoele
 *
 */

public enum EmailTypeEnum {
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
   * @return EmailTypeEnum.
   */
  @JsonCreator
  public static EmailTypeEnum of(String value) {
    if (null == value) {
      return null;
    }

    for (EmailTypeEnum item : EmailTypeEnum.values()) {
      if (value.equals(item.getValue())) {
        return item;
      }
    }

    throw new RuntimeException("EmailTypeEnum: unknown value: " + value);
  }

  EmailTypeEnum(String value) {
    this.value = value;
  }

}