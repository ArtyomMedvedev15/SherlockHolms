<#import "parts/commomForAdmin.ftl" as c>
<@c.page>
<table id="blackText">
        <thead>
        <tr>
            <th>Name</th>
            <th>Describe</th>
            <th>Photo</th>
            <th>Edit</th>
        </tr>
        </thead>
        <tbody>
        <#list chefs as chef>
            <tr>
                <td>${chef.fullName}</td>
                <td><#list position as pos ><#sep >${pos}</#list></td>
                <td><img src="/img/${chef.filenameAvatarChefs}"/> </td>
                <td>Edit</td>
            </tr>
        </#list>
        </tbody>
    </table>
</@c.page>
