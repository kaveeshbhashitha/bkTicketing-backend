package com.bkticketing.bkTicketing_backend.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bkticketing.bkTicketing_backend.Model.Payment;
import com.bkticketing.bkTicketing_backend.Service.PaymentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/process") // add method
    public Payment processPayment(@RequestBody Payment payment) {
        return paymentService.processPayment(payment);
    }

    @GetMapping("/getPaymentByUserId/{id}")
    public List<Payment> getPaymentByUserId(@PathVariable("id") String userId) {
        return paymentService.getPaymentByUserId(userId);
    }

    @GetMapping("/getPaymentByReservationId/{id}")
    public List<Payment> getPaymentByReservationId(@PathVariable("id") String reservationId) {
        return paymentService.getPaymentByReservationId(reservationId);
    }

    @GetMapping("/getAllPayment")
    public List<Payment> getAllPayment() {
        return paymentService.getAllPayment();
    }

    @GetMapping("/getPaymentById/{id}")
    public Optional<Payment> getPaymentById(@PathVariable("id") String paymentId) {
        return paymentService.getPaymentById(paymentId);
    }

    @DeleteMapping("/deletePayment/{id}")
    public String deletePayment(@PathVariable("id") String paymentId) {
        paymentService.deletePayment(paymentId);
        return "Payment deleted with id " + paymentId;
    }
}
