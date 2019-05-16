<#import "parts/commomForAdmin.ftl" as c>
<#import "parts/listFood.ftl" as l>
<@c.page>
    <@l.list "/AdminPage/listMealsFood" "/AdminPage/listMealsFood/Edit"/>
</@c.page>