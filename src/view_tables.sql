DROP VIEW IF EXISTS client_view;
CREATE VIEW client_view AS
SELECT * FROM client;
SELECT * FROM client_view;

DROP VIEW IF EXISTS deposit_view;
CREATE VIEW deposit_view AS
SELECT * FROM deposit;
SELECT * FROM deposit_view;

DROP VIEW IF EXISTS credit_view;
CREATE VIEW credit_view AS
SELECT * FROM credit;
SELECT * FROM credit_view;

DROP VIEW IF EXISTS deposit_type_view;
CREATE VIEW deposit_type_view AS
SELECT * FROM deposit_type;
SELECT * FROM deposit_type_view;

DROP VIEW IF EXISTS credit_type_view;
CREATE VIEW credit_type_view AS
SELECT * FROM credit_type;
SELECT * FROM credit_type_view;