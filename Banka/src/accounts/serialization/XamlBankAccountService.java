package accounts.serialization;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.InputStream;
import java.io.OutputStream;

public class XamlBankAccountService implements BankAccountSerialize {

    @Override
    public <T> void serialize(T object, OutputStream outputStream) throws Exception {
        try (XMLEncoder encoder = new XMLEncoder(outputStream)) {
            encoder.writeObject(object);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> T deserialize(InputStream inputStream, Class<T> clazz) throws Exception {
        try (XMLDecoder decoder = new XMLDecoder(inputStream)) {
            return (T) decoder.readObject();
        }
    }
}