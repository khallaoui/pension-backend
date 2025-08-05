-- Insert sample pensioners
INSERT INTO pensioners (name, city, monthly_payment, payment_method, last_payment_date, birth_date, phone_number) VALUES
('Ahmed Hassan', 'Rabat', 2500.00, 'BANK_TRANSFER', '2024-01-15', '1955-03-20', '0612345678'),
('Fatima Zahra', 'Casablanca', 2800.00, 'CHECK', '2024-01-15', '1952-07-10', '0623456789'),
('Mohamed Ali', 'Fes', 2200.00, 'CASH', '2024-01-15', '1958-11-05', '0634567890'),
('Aicha Benali', 'Marrakech', 2600.00, 'DIGITAL_WALLET', '2024-01-15', '1954-09-15', '0645678901');

-- Insert sample operations
INSERT INTO operations (pensioner_id, amount, type, timestamp, description) VALUES
(1, 2500.00, 'PAYMENT', '2024-01-15 10:00:00', 'Monthly pension payment'),
(2, 2800.00, 'PAYMENT', '2024-01-15 11:00:00', 'Monthly pension payment'),
(3, 2200.00, 'PAYMENT', '2024-01-15 12:00:00', 'Monthly pension payment'),
(1, 200.00, 'BONUS', '2024-01-20 14:00:00', 'Holiday bonus');