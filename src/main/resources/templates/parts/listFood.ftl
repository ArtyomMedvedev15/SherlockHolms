<#macro list path edit>
    <table class="table">
        <thead class="thead-dark">
        <tr>
            <th scope="col">Name</th>
            <th scope="col">Cost</th>
            <th scope="col">Describe</th>
            <th scope="col">Photo</th>
            <th scope="col">Delete</th>
            <th scope="col">Edit</th>
        </tr>
        </thead>
        <tbody>
        <#list foods as food>
            <tr>
                <td>${food.name_food}</td>
                <td>${food.cost_food}</td>
                <td>${food.describe_food}</td>
                <td><img src="/img/${food.filename}" width="150" height="150"/></td>
                <td><a class="btn-oval" href="${path}/${food.id}">Delete</a></td>
                <td><a class="btn-oval" href="${edit}/${food.id}">Edit</a> </td>
            </tr>
        </#list>
        </tbody>
    </table>

</#macro>                                                             