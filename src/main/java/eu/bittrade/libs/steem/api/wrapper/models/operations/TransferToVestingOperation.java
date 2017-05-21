package eu.bittrade.libs.steem.api.wrapper.models.operations;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.InvalidParameterException;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonProperty;

import eu.bittrade.libs.steem.api.wrapper.enums.AssetSymbolType;
import eu.bittrade.libs.steem.api.wrapper.enums.OperationType;
import eu.bittrade.libs.steem.api.wrapper.enums.PrivateKeyType;
import eu.bittrade.libs.steem.api.wrapper.exceptions.SteemInvalidTransactionException;
import eu.bittrade.libs.steem.api.wrapper.models.AccountName;
import eu.bittrade.libs.steem.api.wrapper.models.Asset;
import eu.bittrade.libs.steem.api.wrapper.util.SteemJUtils;

/**
 * This class represents the Steem "transfer_to_vesting_operation" object.
 * 
 * @author <a href="http://steemit.com/@dez1337">dez1337</a>
 */
public class TransferToVestingOperation extends Operation {
    @JsonProperty("from")
    private AccountName from;
    @JsonProperty("to")
    private AccountName to;
    @JsonProperty("amount")
    private Asset amount;

    /**
     * Create a new transfer to vesting operation to transfer Steem Power to
     * other users.
     * 
     * This operation converts STEEM into VFS (Vesting Fund Shares) at the
     * current exchange rate. With this operation it is possible to give another
     * account vesting shares so that faucets can pre-fund new accounts with
     * vesting shares.
     */
    public TransferToVestingOperation() {
        // Define the required key type for this operation.
        super(PrivateKeyType.ACTIVE);
    }

    /**
     * Get the account name of the user who send the VFS.
     * 
     * @return The user that send the VFS.
     */
    public AccountName getFrom() {
        return from;
    }

    /**
     * Set the account name of the user who will send the VFS.
     * 
     * @param from
     *            The account name of the user who will send the VFS.
     */
    public void setFrom(AccountName from) {
        this.from = from;
    }

    /**
     * Get the account name of the user who received the VFS.
     * 
     * @return The account name of the user who received the VFS.
     */
    public AccountName getTo() {
        return to;
    }

    /**
     * Set the account name of the user who will received the VFS.
     * 
     * @param to
     *            The account name of the user who will received the VFS.
     */
    public void setTo(AccountName to) {
        this.to = to;
    }

    /**
     * Get the amount of Steem that has been send.
     * 
     * @return The amount of Steem that has been send.
     */
    public Asset getAmount() {
        return amount;
    }

    /**
     * Set the amount of Steem that will be send.
     * 
     * @param amount
     *            The amount of Steem that will be send.
     */
    public void setAmount(Asset amount) {
        if (!amount.getSymbol().equals(AssetSymbolType.STEEM)) {
            throw new InvalidParameterException("The Symbol needs to be STEEM.");
        }

        this.amount = amount;
    }

    @Override
    public byte[] toByteArray() throws SteemInvalidTransactionException {
        try (ByteArrayOutputStream serializedTransferToVestingOperation = new ByteArrayOutputStream()) {
            serializedTransferToVestingOperation.write(
                    SteemJUtils.transformIntToVarIntByteArray(OperationType.TRANSFER_TO_VESTING_OPERATION.ordinal()));
            serializedTransferToVestingOperation.write(this.getFrom().toByteArray());
            serializedTransferToVestingOperation.write(this.getTo().toByteArray());
            serializedTransferToVestingOperation.write(this.getAmount().toByteArray());

            return serializedTransferToVestingOperation.toByteArray();
        } catch (IOException e) {
            throw new SteemInvalidTransactionException(
                    "A problem occured while transforming the operation into a byte array.", e);
        }
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
