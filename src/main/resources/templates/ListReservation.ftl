<#import "parts/commomForAdmin.ftl" as c>

<@c.page>
    <table class="table">
        <thead class="thead-dark">
        <tr>
            <th scope="col">Name</th>
            <th scope="col">Email</th>
            <th scope="col">Number</th>
            <th scope="col">Message</th>
            <th scope="col">Count of people</th>
            <th scope="col">Data reservation</th>
            <th scope="col">Edit</th>
            <td scope="col">Delete</td>
         </tr>
        </thead>
        <tbody>
        <#list reservs as res>
            <tr>
                <td>${res.name}</td>
                <td>${res.email}</td>
                <td>${res.phoneNumber}</td>
                <td>${res.message}</td>
                <td><#list res.countofPeople as cos >${cos}</#list></td>
                <#if res.dateReservation??>
                <td>${res.dateReservation}</td>
                <#else><td></td>
                </#if>
                <td><a class="btn-oval" href="/AdminPage/ListReservation/Edit/${res.id}">Edit</a></td>
                <td><a class="btn-oval" href="/AdminPage/ListReservation/${res.id}">Delete</a></td>

              </tr>
        </#list>
        </tbody>
    </table>
</@c.page>