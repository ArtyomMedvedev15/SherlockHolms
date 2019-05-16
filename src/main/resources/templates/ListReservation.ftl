<#import "parts/commomForAdmin.ftl" as c>

<@c.page>
    <table id="blackText">
        <thead>
        <tr>
            <th>Name</th>
            <th>Email</th>
            <th>Number</th>
            <th>Message</th>
            <th>Count of people</th>
            <th>Edit</th>
        </tr>
        </thead>
        <tbody>
        <#list reservs as res>
            <tr>
                <td>${res.name}</td>
                <td>${res.email}</td>
                <td>${res.phoneNumber}</td>
                <td>${res.message}</td>
                <td><#list countP as cos ><#sep >${cos}</#list></td>
                <td>${res.dateReservation}</td>
                <td><a href="/AdminPage/ListReservation/${res.id}">Delete</a></td>
            </tr>
        </#list>
        </tbody>
    </table>
</@c.page>