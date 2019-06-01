<!doctype html>
<html lang="en">
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>OsteriaX | Home</title>

    <!-- Favicon -->
    <link rel="shortcut icon" href="/static/image/favicon.ico" type="image/x-icon">

    <!-- Font awesome -->
    <link href="/static/css/font-awesome.css" rel="stylesheet">
    <!-- Bootstrap -->
    <link href="/static/css/bootstrap.css" rel="stylesheet">
    <!-- Slick slider -->
    <link rel="stylesheet" type="text/css" href="/static/css/slick.css">
    <!-- Date Picker -->
    <link rel="stylesheet" type="text/css" href="/static/css/bootstrap-datepicker.css">
    <!-- Gallery Lightbox -->
    <link href="/static/css/magnific-popup.css" rel="stylesheet">
    <!-- Theme color -->
    <link id="switcher" href="/static/css/theme-color/default-theme.css" rel="stylesheet">

    <!-- Main style sheet -->
    <link href="/static/style.css" rel="stylesheet">


    <!-- Google Fonts -->

    <!-- Prata for body  -->
    <link href='https://fonts.googleapis.com/css?family=Prata' rel='stylesheet' type='text/css'>
    <!-- Tangerine for small title -->
    <link href='https://fonts.googleapis.com/css?family=Tangerine' rel='stylesheet' type='text/css'>
    <!-- Open Sans for title -->
    <link href='https://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>



    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>
<body>
<!--START SCROLL TOP BUTTON -->
<a class="scrollToTop" href="#">
    <i class="fa fa-angle-up"></i>
</a>
<!-- END SCROLL TOP BUTTON -->

<!-- Start header section -->
<header id="mu-header">
    <nav class="navbar navbar-default mu-main-navbar" role="navigation">
        <div class="container">
            <div class="navbar-header">
                <!-- FOR MOBILE VIEW COLLAPSED BUTTON -->
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>

                <!-- LOGO -->

                <!--  Text based logo  -->
                <a class="navbar-brand" href="/">
                    Sherlock<span>H</span></a>

                <!--  Image based logo  -->
                <!-- <a class="navbar-brand" href="index.html"><img src="assets/img/logo.png" alt="Logo img"></a>  -->
            </div>
            <div id="navbar" class="navbar-collapse collapse">
                <ul id="top-menu" class="nav navbar-nav navbar-right mu-main-nav">
                    <li><a href="/">HOME</a></li>
                </ul>
            </div><!--/.nav-collapse -->
        </div>
    </nav>
</header>
<!-- End header section -->
<section id="mu-contact">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="mu-contact-area">

                    <div class="mu-title">
                        <span class="mu-subtitle">Get In Touch</span>
                        <h2>Write a review</h2>
                    </div>

                    <div class="mu-contact-content">
                        <div class="row">

                            <div class="col-md-6">
                                <div class="mu-contact-left">
                                    <!-- Email message div -->
                                    <div id="form-messages"></div>
                                    <!-- Start contact form -->
                                    <form method="post" action="/Comment" class="mu-contact-form">
                                        <div class="form-group">
                                            <label for="name">Your Name</label>
                                            <input type="text" class="form-control" id="name" name="name" placeholder="Name" required>
                                        </div>
                                        <div class="form-group">
                                            <label for="email">Email address</label>
                                            <input type="email" class="form-control" id="email" name="email" placeholder="Email" required>
                                        </div>
                                        <div class="form-group">
                                            <label for="message">Comment</label>
                                            <textarea class="form-control" typeof="text" id="message" name="message"  cols="30" rows="10" placeholder="Type Your Message" required></textarea>
                                        </div>
                                        <input type="hidden" name="_csrf" value="${_csrf.token}" />
                                        <button type="submit"  class="mu-send-btn">Send comment</button>
                                    </form>
                                </div>
                            </div>

                            <div class="col-md-6">
                                <div class="mu-contact-right">
                                    <div class="mu-contact-widget">
                                        <h3>Office Address</h3>
                                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Mollitia temporibus corporis ea non consequatur porro corrupti hic voluptatibus assumenda, doloribus.</p>
                                        <address>
                                            <p><i class="fa fa-phone"></i> (850) 457 6688</p>
                                            <p><i class="fa fa-envelope-o"></i>contact@markups.io</p>
                                            <p><i class="fa fa-map-marker"></i>368 St. Panama City, Florida, USA</p>
                                        </address>
                                    </div>
                                    <div class="mu-contact-widget">
                                        <h3>Open Hours</h3>
                                        <address>
                                            <p><span>Monday - Friday</span> 9.00 am to 12 pm</p>
                                            <p><span>Saturday</span> 9.00 am to 10 pm</p>
                                            <p><span>Sunday</span> 10.00 am to 12 pm</p>
                                        </address>
                                    </div>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<!-- Start Footer -->
<footer id="mu-footer">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="mu-footer-area">
                    <div class="mu-footer-social">
                        <a href="#"><span class="fa fa-facebook"></span></a>
                        <a href="#"><span class="fa fa-twitter"></span></a>
                        <a href="#"><span class="fa fa-google-plus"></span></a>
                        <a href="#"><span class="fa fa-linkedin"></span></a>
                        <a href="#"><span class="fa fa-youtube"></span></a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</footer>
<!-- End Footer -->

<!-- jQuery library -->
<script src="/static/js/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="/static/js/bootstrap.js"></script>
<!-- Slick slider -->

<script type="text/javascript" src="/static/js/jquery.magnific-popup.min.js"></script>
<!-- Date Picker -->
<script type="text/javascript" src="/static/js/bootstrap-datepicker.js"></script>
<!-- Ajax contact form  -->
<script type="text/javascript" src="/static/js/app.js"></script>

</body>
</html>

