package org.ekobis.warrantytracking.device.model.util.helper;

import java.util.UUID;

/**
 * Helper class for generating serial numbers.
 */
public class GeneratedSerialNumber {

    /**
     * Generates a unique serial number using the brand name and model name.
     *
     * @param brandName the brand name
     * @param modelName the model name
     * @return the generated serial number
     */
    public static String generateSerialNumber(String brandName,String modelName) {

        String randomId = UUID.randomUUID().toString();

        return
                randomId.substring(randomId.length() - 3)+"-"+

                brandName.replaceAll("\\s+", "")+

                "-"+modelName.replaceAll("\\s+", "")+"-"

                + randomId.substring(randomId.length() - 12);
    }

}
