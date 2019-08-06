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
            <th>Data reservation</th>
            <th>Edit</th>
            <td>Delete</td>
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