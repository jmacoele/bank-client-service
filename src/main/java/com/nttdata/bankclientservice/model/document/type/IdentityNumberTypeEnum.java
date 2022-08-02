package com.nttdata.bankclientservice.model.document.type;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
/**
 * Indentify Number Type Enum.
 *
 * @author jmacoele
 *
 */

public enum IdentityNumberTypeEnum {
  DNI("D"),
  PASSPORT("P"),
  RUC("R"),
  OTHER("O");

  private String value;

  @JsonValue
  public String getValue() {
    return value;
  }
  /** Function of that convert string into enum value.
   *
   * @param value Enum value string-converted.
   * @return IdentifyNumberTypeEnum.
   */
  
  @JsonCreator
  public static IdentityNumberTypeEnum of(String value) {
    if (null == value) {
      return null;
    }

    for (IdentityNumberTypeEnum item : IdentityNumberTypeEnum.values()) {
      if (value.equals(item.getValue())) {
        return item;
      }
    }

    throw new RuntimeException("IdentityNumberTypeEnum: unknown value: " + value);
  }

  IdentityNumberTypeEnum(String value) {
    this.value = value;
  }

}