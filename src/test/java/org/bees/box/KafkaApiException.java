package org.bees.box;

import org.apache.kafka.common.errors.ApiException;

public class KafkaApiException extends ApiException {

    public KafkaApiException(String message, Throwable cause) {
        super(message, cause);
    }

    public KafkaApiException(String message) {
        super(message);
    }

    public KafkaApiException(Throwable cause) {
        super(cause);
    }

    public KafkaApiException() {
    }
}
