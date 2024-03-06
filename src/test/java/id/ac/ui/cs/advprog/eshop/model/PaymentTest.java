package id.ac.ui.cs.advprog.eshop.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class PaymentTest {
    private List<Product> products;
    private List<Order> orders;

    @BeforeEach
    void setUp() {
        this.products = new ArrayList<>();
        Product product1 = new Product();
        product1.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(2);
        Product product2 = new Product();
        product2.setProductId("a2c62328-4a37-4664-83c7-f32db8620155");
        product2.setProductName("Sabun Cap Usep");
        product2.setProductQuantity(1);
        this.products.add(product1);
        this.products.add(product2);

        Order order1 = new Order("13652556-012a-4c07-b546-54eb1396d79b", this.products, 1708560000L, "Safira Sudrajat");
        Order order2 = new Order("12345678-012a-4c07-b546-54eb1396d79b", this.products, 1808560000L, "Sudrajat Safira");

        this.orders.add(order2);
        this.orders.add(order1);
    }

    @Test
    void testCreatePaymentEmptyMethod() {
        Map<String, String> paymentData = new HashMap<String, String>();

        assertThrows(IllegalArgumentException.class, () -> {
            Payment payment = new Payment("69696969-012a-4c07-b546-54eb1396d79b", "",paymentData, this.orders.getFirst());
        });
    }

    @Test
    void testCreatePaymentInvalidStatus() {
        Map<String, String> paymentData = new HashMap<String, String>();

        assertThrows(IllegalArgumentException.class, () -> {
            Payment payment = new Payment("69696969-012a-4c07-b546-54eb1396d79b", "","TES", paymentData, this.orders.getFirst());
        });
    }

    @Test
    void testCreatePaymentValidStatus() {
        Map<String, String> paymentData = new HashMap<String, String>();

        assertThrows(IllegalArgumentException.class, () -> {
            Payment payment = new Payment("69696969-012a-4c07-b546-54eb1396d79b", "","SUCCESS", paymentData, this.orders.getFirst());
        });
    }

    @Test
    void testCreatePaymentInvalidMethod() {
        Map<String, String> paymentData = new HashMap<String, String>();

        assertThrows(IllegalArgumentException.class, () -> {
            Payment payment = new Payment("69696969-012a-4c07-b546-54eb1396d79b", "Gopay", paymentData, this.orders.getFirst());
        });
    }

    @Test
    void testCreatePaymentValidMethod() {
        Map<String, String> paymentData = new HashMap<String, String>();

        assertThrows(IllegalArgumentException.class, () -> {
            Payment payment = new Payment("69696969-012a-4c07-b546-54eb1396d79b", "BANK_TRANSFER", paymentData, this.orders.getFirst());
        });
    }

    @Test
    void testCreatePaymentEmptyOrder() {
        Map<String, String> paymentData = new HashMap<String, String>();

        assertThrows(IllegalArgumentException.class, () -> {
            Payment payment = new Payment("69696969-012a-4c07-b546-54eb1396d79b", "BANK_TRANSFER", paymentData, null);
        });
    }

    @Test
    void testCreatePaymentVoucherCodeRejected() {
        Map<String, String> paymentData = new HashMap<String, String>();
        paymentData.put("voucherCode", "GOPAY1234ABC5678");
        Payment payment = new Payment("69696969-012a-4c07-b546-54eb1396d79b", "VOUCHER_CODE", paymentData, this.orders.getFirst());
        assertEquals("REJECTED", payment.getStatus());
    }

    @Test
    void testCreatePaymentVoucherCodeSuccess() {
        Map<String, String> paymentData = new HashMap<String, String>();
        paymentData.put("voucherCode", "ESHOP1234ABC5678");
        Payment payment = new Payment("69696969-012a-4c07-b546-54eb1396d79b", "VOUCHER_CODE", paymentData, this.orders.getFirst());
        assertEquals("", payment.getStatus());
    }

    @Test
    void testCreatePaymentBankTransferRejected() {
        Map<String, String> paymentData = new HashMap<String, String>();
        paymentData.put("bankName", "BRI");
        Payment payment = new Payment("69696969-012a-4c07-b546-54eb1396d79b", "BANK_TRANSFER", paymentData, this.orders.getFirst());
        assertEquals("", payment.getStatus());
    }

    @Test
    void testCreatePaymentBankTransferSuccess() {
        Map<String, String> paymentData = new HashMap<String, String>();
        paymentData.put("bankName", "BRI");
        paymentData.put("referenceCode", "0efa1f20");
        Payment payment = new Payment("69696969-012a-4c07-b546-54eb1396d79b", "BANK_TRANSFER", paymentData, this.orders.getFirst());
        assertEquals("", payment.getStatus());
    }
}