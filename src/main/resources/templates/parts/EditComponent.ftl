<#macro Edit path namepage>
    <h1>${namepage}</h1>
    <div id="BlackBorderWitmml">
        <form method="post" action="${path}" enctype="multipart/form-data">
            <div class="container-fluid">
                <div class="row justify-content-start">
                    <div class="col">
                        <div class="form-group">
                            <label for="exampleInputEmail1">Name food:</label>
                            <input type="text" value="${edit.name_food}" name="name_food" placeholder="Name food" class="form-control "/>
                        </div>


                        <div class="form-group">
                            <label for="exampleInputPassword1">Cost of food:</label>
                            <input type="number" value="${edit.cost_food}" class="form-control " name="cost_food"/>
                        </div>


                        <div class="form-group">
                            <label>
                                <input type="text" name="describe_food"  value="${edit.describe_food}" placeholder="Describe" class="form-control "/>
                            </label>
                        </div>

                        <div class="form-group">
                            <h3>Old photo:</h3>
                            <img width="55" href="65" src="/img/${edit.filename}" alt=""/>
                        </div>


                        <div class="form-group">
                            <div class="custom-file">
                                <label>Choose image:</label>
                                <input type="file" placeholder="Choose image" required name="file" id="customFile"/>
                                <label class="custom-file-label" for="customFile">Choose file</label>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row justify-content-start">
                    <input type="hidden" name="_csrf" value="${_csrf.token}" />
                    <button type="submit" class="btn btn-dark">Submit</button>
                </div>
            </div>
        </form>
    </div>

</#macro>

