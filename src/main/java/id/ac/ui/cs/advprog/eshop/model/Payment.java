package id.ac.ui.cs.advprog.eshop.model;

import id.ac.ui.cs.advprog.eshop.enums.PaymentStatus;
import lombok.Builder;
import lombok.Getter;

import java.util.Map;

@Builder
@Getter
public class Payment {

    String id;
    String method;
    String status;
    Map<String, String> paymentData;
    Order order;

    public Payment(String id, String method, Map<String, String> paymentData, Order order) {
        this.id = id;
        this.order = order;
        this.method = method;
        this.paymentData = paymentData;

        if (!method.equals("VOUCHER_CODE") && !method.equals("BANK_TRANSFER")) {
            throw new IllegalArgumentException();
        }

        if (paymentData.isEmpty()) {
            throw new IllegalArgumentException();
        }

        if (order == null) {
            throw new IllegalArgumentException();
        }

        if (method.equals("VOUCHER_CODE")) {
            String voucherCode = paymentData.get("voucherCode");
            int numCharCount = 0;
            if (voucherCode.length() == 16) {
                for (int i = 5; i < voucherCode.length(); i++) {
                    if (Character.isDigit(voucherCode.charAt(i))) {
                        numCharCount++;
                    }
                }
            }
            if (voucherCode.startsWith("ESHOP") && numCharCount == 8) {
                setStatus("SUCCESS");
            } else {
                setStatus("REJECTED");
            }
        } else {
            String bankName = paymentData.get("bankName");
            String referenceCode = paymentData.get("referenceCode");

            if (bankName != null && !bankName.isEmpty()
                    && referenceCode != null && !referenceCode.isEmpty()) {
                setStatus("SUCCESS");
            }
            else {
                setStatus("REJECTED");
            }
        }
    }

    public Payment(String id, String method, String status, Map<String, String> paymentData, Order order) {
        this.id = id;
        this.method = method;
        setStatus(status);
        this.paymentData = paymentData;
        this.order = order;
    }

    public void setStatus(String status) {
        if (PaymentStatus.contains(status)) {
            if (status.equals("SUCCESS")) {
                this.status = status;
                order.setStatus("SUCCESS");
            } else if (status.equals("REJECTED")) {
                this.status = status;
                order.setStatus("FAILED");
            }
        }
        else {
            throw new IllegalArgumentException();
        }
    }
}