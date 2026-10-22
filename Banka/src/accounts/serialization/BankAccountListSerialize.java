package accounts.serialization;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.ArrayList;
import java.util.List;

public class BankAccountListSerialize {

    @JacksonXmlElementWrapper(localName = "accountList")
    @JacksonXmlProperty(localName = "bankAccount")
    public List<BankAccountSerialize> accounts = new ArrayList<>(); // Správně BankAccountSerialize

}