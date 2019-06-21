<#macro addFood path>
    <form method="post" action="${path}" enctype="multipart/form-data">
    <div class="form-group" id="fonty">
         <div class="col-sm-6">
             <label>
                Name food:<input type="text" name="name_food" placeholder="Name food" class="form-control "/>
             </label>
         </div>
    </div>
    <div class="form-group" id="fonty">
        <div class="col-sm-6">
            <label>
                Cost food:<input type="number" class="form-control " name="cost_food"/>
            </label>
        </div>
    </div>
    <div class="form-group" id="fonty">
             <div class="col-sm-6">
                 <label>
                     Describe Food:<input type="text" name="describe_food" placeholder="Describe" class="form-control "/>
                 </label>
             </div>
    </div>
        <div class="form-group">
        <div class="custom-file">
            <input type="file"  required name="file" id="customFile"/>
            <label class="custom-file-label" for="customFile">Choose file</label>
        </div>
        </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <button id="fonty" type="submit" class="btn btn-oval">Add</button>
</form>
</#macro>