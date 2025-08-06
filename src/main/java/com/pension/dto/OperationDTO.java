package com.pension.dto;

import java.time.LocalDateTime;

public class OperationDTO {
    private Long pensionerId;
    private Double amount;
    private String type;
    private LocalDateTime timestamp;
    private String description;

    // Getters and setters
    public Long getPensionerId() { return pensionerId; }
    public void setPensionerId(Long pensionerId) { this.pensionerId = pensionerId; }

    public Double getAmount() { return amount; }
    public void setAmount(Double amount) { this.amount = amount; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}
