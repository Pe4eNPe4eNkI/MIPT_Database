# 1. получаем минимальный возраст клиента, взявшего кредит

SELECT MIN(EXTRACT(YEAR FROM AGE(hb_data))) AS min_age 
FROM client 
WHERE client_id IN (SELECT client_id FROM credit);

# 2. получаем максимальный размер вклада 

SELECT MAX(deposit_summ) AS max_deposit FROM deposit;

# 3. получаем кол-во клиентов, оформивших вклад под процент больше 10

SELECT COUNT(DISTINCT client_id) 
FROM deposit JOIN deposit_type ON deposit.deposit_name = deposit_type.deposit_name 
WHERE percent > 10;

# 4. получаем кол-во клиентов, взявших кредит с минимальным процентом

SELECT COUNT(DISTINCT client_id) 
FROM credit JOIN credit_type ON credit.credit_name = credit_type.credit_name 
WHERE percent = (SELECT MIN(percent) FROM credit_type);

# 5. получаем кол-во клиентов, имеющих несколько кредитов

SELECT COUNT(*) FROM (SELECT client_id FROM credit GROUP BY client_id HAVING COUNT(credit_id) > 1) AS multiple_credits;

# 6. получаем клиентов, взявших кредит в рублях

SELECT client.* FROM client 
JOIN credit ON client.client_id = credit.client_id 
JOIN credit_type ON credit.credit_name = credit_type.credit_name 
JOIN currency_type ON credit_type.currency_id = currency_type.currency_id 
WHERE currency_name = 'ruble';

# 7. получаем название вкладов, которые были оформлены больше 1 раза

SELECT deposit_name FROM deposit GROUP BY deposit_name HAVING COUNT(deposit_id) > 1;

# 8. получаем клиентов, не оформивших кредит 

SELECT * FROM client WHERE client_id NOT IN (SELECT DISTINCT client_id FROM credit);

# 9. получаем информацию о типе кредита по ID

SELECT * FROM credit_type WHERE credit_id = 5;

# 10.получить общую сумму всех кредитов и депозитов для клиента с определенным ID

SELECT  (SELECT SUM(credit_summ)FROM credit WHERE client_id = 1) AS total_credits,
        (SELECT SUM(deposit_summ) FROM deposit WHERE client_id = 1) AS total_deposits;