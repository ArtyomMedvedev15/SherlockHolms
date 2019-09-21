<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#">Admin Page</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="/">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/AdminPage/Home">Home Admin Page</a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    List of something
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="/AdminPage/listBreakFast">List of breakfast</a>
                    <a class="dropdown-item" href="/AdminPage/listDrinksFood">List of drinks</a>
                    <a class="dropdown-item" href="/AdminPage/listDessertsFood">List of desserts</a>
                    <a class="dropdown-item" href="/AdminPage/listMealsFood">List of meals</a>
                    <a class="dropdown-item" href="/AdminPage/listSnacksFood">List of snaks</a>
                    <a class="dropdown-item" href="/AdminPage/listChefs">List of chefs</a>
                    <a class="dropdown-item" href="/AdminPage/ListReservation">List of reservation</a>
                    <a class="dropdown-item" href="/AdminPage/ListContacts">List of contact</a>
                    <a class="dropdown-item" href="/AdminPage/ListComment">List of comment</a>
                </div>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Add something
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="/AdminPage/addBreakFast">Add breakfast</a>
                    <a class="dropdown-item" href="/AdminPage/addDrinks">List drinks</a>
                    <a class="dropdown-item" href="/AdminPage/addDesserts">List desserts</a>
                    <a class="dropdown-item" href="/AdminPage/addMeals">List meals</a>
                    <a class="dropdown-item" href="/AdminPage/addSnacks">List snaks</a>
                    <a class="dropdown-item" href="/AdminPage/addChefs">List chefs</a>
                </div>
            </li>
            <li class="nav-item">
                <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>
            </li>
        </ul>
        <form class="form-inline my-2 my-lg-0" >
            <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
    </div>
</nav>