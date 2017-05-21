package eu.bittrade.libs.steem.api.wrapper.models.operations;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonProperty;

import eu.bittrade.libs.steem.api.wrapper.enums.OperationType;
import eu.bittrade.libs.steem.api.wrapper.enums.PrivateKeyType;
import eu.bittrade.libs.steem.api.wrapper.exceptions.SteemInvalidTransactionException;
import eu.bittrade.libs.steem.api.wrapper.models.AccountName;
import eu.bittrade.libs.steem.api.wrapper.models.Asset;
import eu.bittrade.libs.steem.api.wrapper.util.SteemJUtils;

/**
 * This class represents the Steem "convert_operation" object.
 * 
 * @author <a href="http://steemit.com/@dez1337">dez1337</a>
 */
public class ConvertOperation extends Operation {
    @JsonProperty("owner")
    private AccountName owner;
    // Original type is uint32_t so we have to use long here.
    @JsonProperty("requestid")
    private long requestId;
    @JsonProperty("amount")
    private Asset amount;

    /**
     * Create a new convert operation. This operation instructs the blockchain
     * to start a conversion between STEEM and SBD, The funds are deposited
     * after STEEMIT_CONVERSION_DELAY.
     */
    public ConvertOperation() {
        // Define the required key type for this operation.
        super(PrivateKeyType.ACTIVE);
        // Set default values.
        this.setRequestId(0);
    }

    /**
     * Get the account which performed the conversion.
     * 
     * @return The account which performed the conversion.
     */
    public AccountName getOwner() {
        return owner;
    }

    /**
     * Set the account for which the operation should be performed.
     * 
     * @param owner
     *            The account for which the operation should be performed.
     */
    public void setOwner(AccountName owner) {
        this.owner = owner;
    }

    /**
     * Get the id of this conversion request.
     * 
     * @return The id of this conversion request.
     */
    public long getRequestId() {
        return requestId;
    }

    /**
     * Set the id of this conversion request. The id has to be unique.
     * 
     * @param requestId
     *            The id of this conversion request.
     */
    public void setRequestId(long requestId) {
        this.requestId = requestId;
    }

    /**
     * Get the SBD or STEEM amount that has been converted.
     * 
     * @return The SBD or STEEM amount that has been converted.
     */
    public Asset getAmount() {
        return amount;
    }

    /**
     * Set the amount of SBD or STEEM that should be converted.
     * 
     * @param amount
     *            The amount of SBD or STEEM that should be converted.
     */
    public void setAmount(Asset amount) {
        this.amount = amount;
    }

    @Override
    public byte[] toByteArray() throws SteemInvalidTransactionException {
        try (ByteArrayOutputStream serializedConvertOperation = new ByteArrayOutputStream()) {
            serializedConvertOperation
                    .write(SteemJUtils.transformIntToVarIntByteArray(OperationType.CONVERT_OPERATION.ordinal()));
            serializedConvertOperation.write(this.getOwner().toByteArray());
            serializedConvertOperation.write(SteemJUtils.transformIntToByteArray((int) this.getRequestId()));
            serializedConvertOperation.write(this.getAmount().toByteArray());

            return serializedConvertOperation.toByteArray();
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
