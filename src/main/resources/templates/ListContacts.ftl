<#import "parts/commomForAdmin.ftl" as c>

<@c.page>
    <table id="blackText">
        <thead>
        <tr>
            <th>Name</th>
            <th>Email</th>
            <th>Subject</th>
            <th>Message</th>
            <td>Delete</td>
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