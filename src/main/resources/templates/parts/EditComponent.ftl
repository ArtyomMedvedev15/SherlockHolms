<#macro Edit path>
    <form method="post" action="${path}" enctype="multipart/form-data">
        <div class="form-group" id="fonty">
            <div class="col-sm-6">
                <input type="text" value="${edit.name_food}" name="name_food" placeholder="Name food" class="form-control "/>
            </div>
        </div>
        <div class="form-group" id="fonty">
            <div class="col-sm-6">
                <input type="number" value="${edit.cost_food}" class="form-control " name="cost_food"/>
            </div>
        </div>
        <div class="form-group" id="fonty">
            <div class="col-sm-6">
                <input type="text" name="describe_food"  value="${edit.describe_food}" placeholder="Describe" class="form-control "/>
            </div>
        </div>
        <div class="form-group">
            <div class="custom-file">
                <input type="file"  required name="file" id="customFile"/>
                <label class="custom-file-label" for="customFile">Choose file</label>
            </div>
        </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <button id="fonty" type="submit" class="btn btn-oval">Save</button>
    </form>
</#macro>