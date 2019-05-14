<#macro list path>
    <table cellspacing="0" id="blackText">
        <thead>
        <tr>
            <th>Name</th>
            <th>Cost</th>
            <th>Describe</th>
            <th>Photo</th>
            <th>Edit</th>
        </tr>
        </thead>
        <tbody>
        <#list foods as food>
            <tr>
                <td>${food.name_food}</td>
                <td>${food.cost_food}</td>
                <td>${food.describe_food}</td>
                <td></td>

            </tr>
        </#list>
        </tbody>
    </table>

</#macro>