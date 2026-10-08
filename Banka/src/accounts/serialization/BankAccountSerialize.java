package accounts.serialization;

import java.io.InputStream;
import java.io.OutputStream;

public interface BankAccountSerialize {
    <T> void serialize(T object, OutputStream outputStream) throws Exception;
    <T> T deserialize(InputStream inputStream, Class<T> clazz) throws Exception;
}