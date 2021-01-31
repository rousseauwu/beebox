package org.bees.box;

import org.apache.kafka.common.errors.ApiException;

import java.util.function.Function;

public class FunctionApiTest {


    public static void main(String[] args) {



    }

    enum Exc{

        Error1("hello world",KafkaApiException::new);

        private String message;
        private ApiException apiException;

        Exc(String message, Function<String,ApiException> build) {
            this.message = message;
            this.apiException = build.apply(this.message);
        }
    }


}
