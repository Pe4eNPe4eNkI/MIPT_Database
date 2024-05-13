CREATE INDEX idx_client_id ON client(client_id);
CREATE INDEX idx_credit_id ON credit(credit_id);
CREATE INDEX idx_deposit_id On deposit(deposit_id);
CREATE INDEX idx_client_credit_id ON credit(credit_id);
CREATE INDEX idx_client_deposit_id On deposit(deposit_id);
CREATE INDEX idx_credit_type_id ON credit(credit_id);
CREATE INDEX idx_deposit_type_id On deposit(deposit_id);