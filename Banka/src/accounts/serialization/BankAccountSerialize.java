package accounts.serialization;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class BankAccountSerialize {

    @JacksonXmlProperty(localName = "number")
    public String bankAccountNumber;

}