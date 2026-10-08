# Jan Cach


## Typy transakci:
- prevod mezi ucty
- vklad na ucet
- vyber z uctu

## Co chceme u kazde transakce evidovat

Trida `TransactionLog` obsahuje, jak vypada JEDEN zaznam o transakci.

Ma tyto vlastnosti:
- `id`
- `type` (prevod, vyber, vklad)
- `from` (z jakeho uctu, u vkladu = null)
- `to` (na jaky ucet, u vyberu = null)
- `amount` (kolik Kc)
- `date` (kdy byla transakce provedena)

## Factory

Trida v souboru `TransactionLogFactory`, ktera nam zjednodusuje
vytvareni zaznamu o transakci.

Ma metody:
- `createWithdraw`, ktera vytvori zaznam o vyberu
- `createDeposit`, ktera vytvori zaznam o vkladu
- `createTransfer`, ktera vytvori zaznam o prevodu

## Service

Trida v souboru `TransferLoggerService` je sluzba, ktera se stara
o uchovavani cele historie v poli/listu.

Sluzba ma metody:
- `logWithdraw` zaznamena do historie vyber
- `logDeposit` zaznamena do historie vklad
- `logTransfer` zaznamena do historie prevod

Vsechny tyto metody pouzivaji factory na vytvoreni zaznamu,
ktery pak ulozi do pole/listu.

Plus je tam metoda `printLogs`, ktera vypise vsechny zaznamy
v historii do konzole.


## Package
- package/slozka `log` obsahuju vse pro zaznam transakci