package org.ekobis.warrantytracking.warranty.model.util.helper;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Helper class for checking the warranty status.
 */
public class CheckWarrantStatus {

    /**
     * Checks the warranty status based on the purchase date.
     *
     * @param purchaseDate the date of purchase
     * @return "Warranty Expired" if the warranty period is over, "Warranty Active" otherwise
     */
    public static String checkStatus(LocalDate purchaseDate){

        long monthsBetween = ChronoUnit.MONTHS.between(purchaseDate, LocalDate.now());

        return monthsBetween >= 24 ? "Garanti Süresi Dolmuş" : "Garanti Devam Ediyor";
    }

}
