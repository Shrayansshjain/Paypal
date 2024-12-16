package com.example.PayPalCustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class PaypalController {

    private final ContactService contactService;

    @Autowired
    public PaypalController(ContactService contactService) {
        this.contactService = contactService;
    }
        @GetMapping("/")
        public String homePage(Model model) {
            model.addAttribute("features", getFeatures());
            return "index"; // Render the homepage
        }

        // Customer support page
        @GetMapping("/support")
        public String support() {
            return "support";
        }
        @PostMapping("/contact")
        public String handleContactForm(
                @RequestParam String name,
                @RequestParam String email,
                @RequestParam String phone,
                @RequestParam String message,
                Model model) {
                // Save customer data to the database
//                Customer customer = new Customer(name, email, phone);
//                customerRepository.save(customer);
//
//                // Add success message
//                model.addAttribute("success", "Your message has been sent successfully!");
//                model.addAttribute("name", name);
//                model.addAttribute("message", message);
//                model.addAttribute("email", email);
//
//                return "success"; // Render the success page
                String result = contactService.processContactMessage(message);
                model.addAttribute("success", result);
                return "index"; // Return the success message
        }

        private String[] getFeatures() {
            return new String[]{
                    "Effortlessly shop and pay online with enhanced security and speed.",
                    "Send and receive money instantly to anyone around the globe.",
                    "Make purchases directly within the app for a seamless shopping experience.",
                    "Stay secure with cutting-edge fraud detection technology."
            };
        }
    }


