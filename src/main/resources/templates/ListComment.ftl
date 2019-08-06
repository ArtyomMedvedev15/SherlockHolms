<#import "parts/commomForAdmin.ftl" as c>
<@c.page>
<table id="blackText">
    <thead>
    <tr>
        <th>id</th>
        <th>Name</th>
        <th>Email</th>
        <th>Comment</th>
        <th>Rating</th>
     </tr>
    </thead>
    <tbody>
    <#list ListComment as com>
    <tr>
        <td>${com.id}</td>
        <td>${com.nameVisitor}</td>
        <td>${com.emailVisitor}</td>
        <td>${com.commentVisitor}</td>
        <#if com.ratingVisitor??>
        <td>${com.ratingVisitor}</td>
        </#if>
    </tr>
    </#list>
    </tbody>
</table>
</@c.page>
