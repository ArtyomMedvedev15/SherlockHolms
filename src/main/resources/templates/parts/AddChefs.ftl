<#macro Chefs>
    <form method="post" enctype="multipart/form-data">
        <div class="form-group" id="fonty">
            <div class="col-sm-6">
                <input type="text" name="FullName" placeholder="Name food" class="form-control "/>
            </div>
        </div>
        <div class="form-group" id="fonty">
            <select typeof="text" name="position" class="form-control" id="exampleFormControlSelect1">
            <#list positions as pos>
                <option>${pos}</option>
            </#list>
            </select>
        </div>
        <div class="form-group">
            <div class="custom-file">
                <input type="file"  required name="file" id="customFile"/>
                <label class="custom-file-label" for="customFile">Choose file</label>
            </div>
        </div>
        <button id="fonty" type="submit" class="btn btn-oval">Add</button>
    </form>
</#macro>