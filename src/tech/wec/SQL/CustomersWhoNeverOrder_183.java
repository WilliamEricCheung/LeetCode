package tech.wec.SQL;

public class CustomersWhoNeverOrder_183 {
    /*
    select Customers.Name as 'Customers'
    from Customers
    where Customers.Id not in(
        select customerId from orders
    )

    select Name as 'Customers'
    from Customers left join Orders on Customers.Id = Orders.CustomerId
    where Orders.CustomerId is null
     */
}
