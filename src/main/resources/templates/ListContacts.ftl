<#import "parts/commomForAdmin.ftl" as c>

<@c.page>
    <table class="table">
        <thead class="thead-dark">
        <tr>
            <th scope="col">Name</th>
            <th scope="col">Email</th>
            <th scope="col">Subject</th>
            <th scope="col">Message</th>
            <th scope="col">Delete</th>
        </tr>
        </thead>
        <tbody>
        <#list conts as cot>
            <tr>
                <td>${cot.name}</td>
                <td>${cot.email}</td>
                <td>${cot.subject}</td>
                <td>${cot.message}</td>
                <td><a class="btn-oval" href="/AdminPage/ListReservation/${cot.id}">Delete</a></td>
            </tr>
        </#list>
        </tbody>
    </table>
</@c.page>