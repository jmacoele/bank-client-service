package com.nttdata.bankclientservice.model.document;

import com.nttdata.bankclientservice.model.document.type.PhoneTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;
/**
 * Client Phone Class.
 *
 * @author jmacoele
 *
 */

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(value = "clientphones")
public class ClientPhone {

  private PhoneTypeEnum phoneType;

  private String phoneNumber;

}
