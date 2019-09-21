<#import "parts/commomForAdmin.ftl" as c>
<@c.page>
<table class="table">
    <thead class="thead-dark">
    <tr>
        <th scope="col">id</th>
        <th scope="col">Name</th>
        <th scope="col">Email</th>
        <th scope="col">Comment</th>
        <th scope="col">Rating</th>
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
