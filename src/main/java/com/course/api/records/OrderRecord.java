package com.course.api.records;

public record OrderRecord(
    String customerName,
    String productName,
    int quantity
){

}
