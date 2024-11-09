package com.bkticketing.bkTicketing_backend.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:3000")
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
