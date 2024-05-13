DROP TRIGGER IF EXISTS min_client_age_trigger ON client;
CREATE OR REPLACE FUNCTION min_client_age() RETURNS TRIGGER AS $$
BEGIN
   IF (EXTRACT(YEAR FROM AGE(NEW.hb_data)) < 18) THEN
      RAISE EXCEPTION 'Клиент не может быть младше 18 лет!';
   END IF;
   RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER min_client_age_trigger
BEFORE INSERT ON client
FOR EACH ROW
EXECUTE FUNCTION min_client_age();


DROP TRIGGER IF EXISTS max_client_age_trigger ON client;
CREATE OR REPLACE FUNCTION max_client_age() RETURNS TRIGGER AS $$
BEGIN
   IF (EXTRACT(YEAR FROM AGE(NEW.hb_data)) > 75) THEN
      RAISE EXCEPTION 'Клиент не может быть старше 75 лет!';
   END IF;
   RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER max_client_age_trigger
BEFORE INSERT ON client
FOR EACH ROW
EXECUTE FUNCTION max_client_age();


DROP TRIGGER IF EXISTS min_deposit_sum_trigger ON deposit;
CREATE OR REPLACE FUNCTION min_deposit_sum() RETURNS TRIGGER AS $$
DECLARE
    min_dep_sum INTEGER;
BEGIN
   SELECT min_summ INTO min_dep_sum FROM deposit_type WHERE deposit_name = NEW.deposit_name;
   IF (NEW.deposit_summ < min_dep_sum) THEN
      RAISE EXCEPTION 'Неверная минимальная сумма вклада!';
   END IF;
   RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER min_deposit_sum_trigger
BEFORE INSERT ON deposit
FOR EACH ROW
EXECUTE FUNCTION min_deposit_sum();