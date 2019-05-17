<#import "parts/commomForAdmin.ftl" as c>
 <@c.page>
    <div class="mu-reservation-content">
    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ratione quidem autem iusto, perspiciatis, amet, quaerat blanditiis ducimus eius recusandae nisi aut totam alias consectetur et.</p>

    <div class="col-md-6">
        <div class="mu-reservation-left">
            <form class="mu-reservation-form" method="post">
                <div class="row">
                    <div class="col-md-12">
                        <div class="form-group">
                            <input type="text" name="Name" class="form-control" placeholder="Full Name">
                        </div>
                    </div>
                    <div class="col-md-12">
                        <div class="form-group">
                            <input type="email" name="email" class="form-control" placeholder="Email">
                        </div>
                    </div>
                    <div class="col-md-12">
                        <div class="form-group">
                            <input type="text" name="PhoneNumber" class="form-control" placeholder="Phone Number">
                        </div>
                    </div>
                    <div class="col-md-12">
                        <div class="form-group">
                            <select name="countofPeople" typeof="text" class="form-control">
                                <option value="0">How Many?</option>
                                <#list counts as cos >
                                    <option>${cos}</option>
                                </#list>
                            </select>
                        </div>
                    </div>
                    <div class="col-md-12">
                        <div class="form-group">
                            <input name="dateReservation" type="text" class="form-control" id="datepicker" placeholder="Date">
                        </div>
                    </div>
                    <div class="col-md-12">
                        <div class="form-group">
                            <textarea name="message" typeof="text" class="form-control" cols="30" rows="10" placeholder="Your Message"></textarea>
                        </div>
                    </div>
                    <button type="submit" >Make Reservation</button>
                </div>
            </form>
        </div>
    </div>

</@c.page>