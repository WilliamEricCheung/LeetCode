package tech.wec.SQL;

public class DuplicateEmails_182 {
    /*
        select Email
        from Person
        group by Email
        having count(Email) > 1

        select distinct(a.Email)
        from Person as a join Person as b
        where a.Id <> b.Id and a.Email = b.Email
     */
}
