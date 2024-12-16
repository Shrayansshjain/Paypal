package com.example.PayPalCustomerService;

import org.springframework.stereotype.Service;

@Service
public class ContactService {
    public String processContactMessage(String message) {
        // Logic for processing contact messages
        return "Processed: " + message;
    }
}
