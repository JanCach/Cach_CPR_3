package accounts.serialization;

import accounts.BankAccount;
import accounts.serialization.BankAccountSerializeFactory; // Opravený import
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.util.ArrayList;
import java.util.List;

public class BankAccountXmlJacksonSerializationService implements BankAccountSerialization {

    // Opraveno: Používáme správnou továrnu pro serializaci (BankAccountSerializeFactory)
    BankAccountSerializeFactory bankAccountSerializeFactory = new BankAccountSerializeFactory();
    XmlMapper xmlMapper = new XmlMapper();


    public BankAccountXmlJacksonSerializationService() {
        // zapnout zalamovani radku a odsazeni v vyslednem XML
        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
    }


    @Override
    public String serializeAll(List<BankAccount> bankAccounts) {

        BankAccountListSerialize bankAccountListSerialize = new BankAccountListSerialize();


        for (BankAccount bankAccount: bankAccounts) {
            bankAccountListSerialize.accounts.add( bankAccountSerializeFactory.createBankAccountSerialize(bankAccount) );
        }

        try {
            return xmlMapper
                    .writer()
                    .withRootName("root")
                    .writeValueAsString(bankAccountListSerialize);
        } catch (Exception e) {
            throw new RuntimeException("XML serializace se nepovedla", e);
        }

    }

    @Override
    public String serialize(BankAccount bankAccount) {

        BankAccountSerialize bankAccountSerialize = bankAccountSerializeFactory.createBankAccountSerialize(bankAccount);

        try {
            return xmlMapper
                    .writer()
                    .withRootName("bankAccount")
                    .writeValueAsString(bankAccountSerialize);
        } catch (Exception e) {
            throw new RuntimeException("XML serializace se nepovedla", e);
        }
    }

}