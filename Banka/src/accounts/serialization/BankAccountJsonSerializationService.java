package accounts.serialization;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.jsontype.BasicPolymorphicTypeValidator;
import com.fasterxml.jackson.databind.jsontype.PolymorphicTypeValidator;

import java.io.InputStream;
import java.io.OutputStream;

public class BankAccountJsonSerializationService implements BankAccountSerialize {

    private final ObjectMapper objectMapper;

    public BankAccountJsonSerializationService() {
        this.objectMapper = new ObjectMapper();
        this.objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        PolymorphicTypeValidator ptv = BasicPolymorphicTypeValidator.builder()
                .allowIfBaseType("accounts.BankAccount")
                .allowIfBaseType("people.Owner")
                .build();

        this.objectMapper.activateDefaultTyping(
                ptv,
                ObjectMapper.DefaultTyping.NON_FINAL,
                JsonTypeInfo.As.PROPERTY
        );
    }

    @Override
    public <T> void serialize(T object, OutputStream outputStream) throws Exception {
        objectMapper.writeValue(outputStream, object);
    }

    @Override
    public <T> T deserialize(InputStream inputStream, Class<T> clazz) throws Exception {
        return objectMapper.readValue(inputStream, clazz);
    }
}