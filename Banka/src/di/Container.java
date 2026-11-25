package di;
/*
import accounts.decorators.AccountLoggingService;
import accounts.decorators.AccountLoggingWithTimeService;
import accounts.factories.BankAccountFactory;
import accounts.serialization.BankAccountSerialization;
import accounts.serialization.BankAccountSerializeFactory;
import accounts.serialization.BankAccountXmlJacksonSerializationService;
import accounts.services.AccountNumberGenerator;
import accounts.services.AccountService;
import accounts.services.IAccountService;
import notifiers.EmailNotifier;
import notifiers.Notifier;
import transfers.TransferService;
*/
public class Container {
    /*
    Notifier notifier = new EmailNotifier();

    AccountNumberGenerator accountNumberGenerator
            =  new AccountNumberGenerator();

    public OwnerFactory ownerFactory = new OwnerFactory();
    public OwnerService ownerService = new OwnerService(ownerFactory);

    public BankAccountFactory bankAccountFactory
            = new BankAccountFactory(notifier, accountNumberGenerator);

    public CreditCardFactory creditCardFactory = new CreditCardFactory();

    public TransferService transferService = new TransferService(notifier);

    public IAccountService accountService = new AccountService(bankAccountFactory);

    public IAccountService accountServiceWithLogin
            = new AccountLoggingService(accountService);
    public IAccountService accountServiceWithTimeLogin
            = new AccountLoggingWithTimeService(accountService);
    public IAccountService accountServiceWithLoginAndTimeLogin
            = new AccountLoggingService(accountServiceWithTimeLogin);

    BankAccountSerializeFactory bankAccountSerializeFactory = new BankAccountSerializeFactory();

    //public BankAccountSerialization bankAccountJsonSerializationService = new BankAccountGsonSerializationService(bankAccountSerializeFactory);
    public BankAccountSerialization bankAccountXmlSerializationService = new BankAccountXmlJacksonSerializationService(bankAccountSerializeFactory);
*/
}
