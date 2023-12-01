<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html lang="zxx">

<head>
    <meta charset="UTF-8">
    <meta name="description" content="Ogani Template">
    <meta name="keywords" content="Ogani, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Update Admin</title>

    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap" rel="stylesheet">

    <!-- Css Styles -->
    <link rel="stylesheet" href="../../css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="../../css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="../../css/elegant-icons.css" type="text/css">
    <link rel="stylesheet" href="../../css/nice-select.css" type="text/css">
    <link rel="stylesheet" href="../../css/jquery-ui.min.css" type="text/css">
    <link rel="stylesheet" href="../../css/owl.carousel.min.css" type="text/css">
    <link rel="stylesheet" href="../../css/slicknav.min.css" type="text/css">
    <link rel="stylesheet" href="../../css/style.css" type="text/css">
</head>

<body>
    <!-- Page Preloder -->
    <div id="preloder">
        <div class="loader"></div>
    </div>

    <!-- Humberger Begin -->
    <div class="humberger__menu__overlay"></div>
    <div class="humberger__menu__wrapper">
        <div class="humberger__menu__logo">
            <a href="../admin.html"><img src="../../../img/logo.png" alt=""></a>
        </div>
        <div class="humberger__menu__widget">
            <div class="header__top__right__auth">
                <a href="../../index.html"><i class="fa fa-user"></i> Logout</a>
            </div>
        </div>
        <nav class="humberger__menu__nav mobile-menu">
            <ul>
                <li class="active"><a href="./admin.html">Home</a></li>
                <li><a href="#">Admin</a>
                    <ul class="header__menu__dropdown">
                        <li><a href="../admin/addadmin">Add Admin</a></li>
                        <li><a href="../admin/updateadmin">Update Admin</a></li>
                        <li><a href="../admin/deleteadmin">Delete Admin</a></li>
                        <li><a href="../admin/searchadmin">Search Admin</a></li>
                        <li><a href="../admin/viewadmin">View All Admins</a></li>
                    </ul>
                </li>
                <li><a href="#">Customers</a>
                    <ul class="header__menu__dropdown">
                        <li><a href="./searchcust">Search Customer</a></li>
                        <li><a href="./viewcust">View All Customers</a></li>
                    </ul>
                </li>
                <li><a href="#">Vegetables</a>
                    <ul class="header__menu__dropdown">
                        <li><a href="../vegetable/addvegetable">Add Vegetable</a></li>
                        <li><a href="../vegetable/updatevege">Update Vegetable</a></li>
                        <li><a href="../vegetable/deletavege">Delete Vegetable</a></li>
                        <li><a href="../vegetable/searchtavege">Search Vegetable</a></li>
                        <li><a href="../vegetable/searchcat">Search by Category</a></li>
                        <li><a href="../vegetable/viewvege">View All Vegetables</a></li>
                    </ul>
                </li>
                <li><a href="#">Orders</a>
                    <ul class="header__menu__dropdown">
                        <li><a href="./shoping-cart.html">Update Order</a></li>
                        <li><a href="./checkout.html">Cancel Order</a></li>
                        <li><a href="./blog-details.html">Search Order</a></li>
                        <li><a href="./blog-details.html">Search by Customer</a></li>
                        <li><a href="./blog-details.html">View All Orders</a></li>
                    </ul>
                </li>
                <li><a href="#">Feedback</a>
                    <ul class="header__menu__dropdown">
                        <li><a href="../admin/viewfeedcust">View By Customer</a></li>
                        <li><a href="../admin/viewfeedveg">View By Vegetable</a></li>
                    </ul>
                </li>
            </ul>
        </nav>
        <div id="mobile-menu-wrap"></div>
        <div class="header__top__right__social">
            <a href="#"><i class="fa fa-facebook"></i></a>
            <a href="#"><i class="fa fa-twitter"></i></a>
            <a href="#"><i class="fa fa-linkedin"></i></a>
            <a href="#"><i class="fa fa-pinterest-p"></i></a>
        </div>
    </div>
    <!-- Humberger End -->

    <!-- Header Section Begin -->
    <header class="header">
        <div class="header__top">
            <div class="container">
                <div class="row">
                    <div class="col-lg-6 col-md-6">
                        <div class="header__top__left">
                            <ul>
                                <li><i class="fa fa-envelope"></i> hello@colorlib.com</li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-lg-6 col-md-6">
                        <div class="header__top__right">
                            <div class="header__top__right__social">
                                <a href="#"><i class="fa fa-facebook"></i></a>
                                <a href="#"><i class="fa fa-twitter"></i></a>
                                <a href="#"><i class="fa fa-linkedin"></i></a>
                                <a href="#"><i class="fa fa-pinterest-p"></i></a>
                            </div>
                            <div class="header__top__right__auth">
                                <a href="../../../../index.html"><i class="fa fa-user"></i> Logout</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-lg-3">
                    <div class="header__logo">
                        <a href="../../../../admin.html"><img src="../../../img/logo.png" alt=""></a>
                    </div>
                </div>
                <div class="col-lg-6">
                    <nav class="header__menu">
                        <ul>
                            <li class="active"><a href="../../../../admin.html">Home</a></li>
                            <li><a href="#">Admin</a>
                                <ul class="header__menu__dropdown">
                                    <li><a href="../admin/addadmin">Add Admin</a></li>
                                    <li><a href="../admin/updateadmin">Update Admin</a></li>
                                    <li><a href="../admin/deleteadmin">Delete Admin</a></li>
                                    <li><a href="../admin/searchadmin">Search Admin</a></li>
                                    <li><a href="../admin/viewadmin">View All Admins</a></li>
                                </ul>
                            </li>
                            <li><a href="#">Customers</a>
                                <ul class="header__menu__dropdown">
                                    <li><a href="./searchcust">Search Customer</a></li>
                                    <li><a href="./viewcust">View All Customers</a></li>
                                </ul>
                            </li>
                            <li><a href="#">Vegetables</a>
                                <ul class="header__menu__dropdown">
                                    <li><a href="../vegetable/addvegetable">Add Vegetable</a></li>
                                    <li><a href="../vegetable/updatevege">Update Vegetable</a></li>
                                    <li><a href="../vegetable/deletevege">Delete Vegetable</a></li>
                                    <li><a href="../vegetable/searchvege">Search Vegetable</a></li>
                                    <li><a href="../vegetable/searchcat">Search by Category</a></li>
                                    <li><a href="../vegetable/viewvege">View All Vegetables</a></li>
                                </ul>
                            </li>
                            <li><a href="#">Orders</a>
                                <ul class="header__menu__dropdown">
                                    <li><a href="./shoping-cart.html">Update Order</a></li>
                                    <li><a href="./checkout.html">Cancel Order</a></li>
                                    <li><a href="./blog-details.html">Search Order</a></li>
                                    <li><a href="./blog-details.html">Search by Customer</a></li>
                                    <li><a href="./blog-details.html">View All Orders</a></li>
                                </ul>
                            </li>
                            <li><a href="#">Feedback</a>
                                <ul class="header__menu__dropdown">
                                    <li><a href="./viewfeedcust">View By Customer</a></li>
                                    <li><a href="./viewfeedveg">View By Vegetable</a></li>
                                </ul>
                            </li>
                        </ul>
                    </nav>
                </div>
            </div>
            <div class="humberger__open">
                <i class="fa fa-bars"></i>
            </div>
        </div>
    </header>
    <!-- Header Section End -->
    <div class="container" >
        <form:form action="updateadminprocess" modelAttribute="admin" method="post">
         <div class="form-group">
           <label for="adminId"></label>
           <form:hidden path="adminId" value="${admin.adminId}" class="form-control" id="adminId"/>
         </div>

         <div class="form-group">
            <label for="name">Admin Name :</label>
            <form:input path="name" value="${admin.name}" class="form-control" id="name"/>
          </div>

          <div class="form-group">
            <label for="contactNumber">Contact Number :</label>
            <form:input path="contactNumber" value="${admin.contactNumber}" class="form-control" id="contactNumber"/>
          </div>

          <div class="form-group">
            <label for="emailid">Email ID :</label>
            <form:input path="emailid" value="${admin.emailid}" class="form-control" id="emailid"/>
          </div>
          
          <div class="form-group">
            <label for="password">Password :</label>
            <form:input path="password" value="${admin.password}" class="form-control" id="password"/>
          </div>
          
          <div class="form-group">
            <button type="submit" class="btn btn-primary">Update</button>
          </div>
        </form:form>
     </div>
    <!-- Banner Begin -->

    <!-- Banner End -->

  
    <!-- Footer Section Begin -->
    <footer class="footer spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-3 col-md-6 col-sm-6">
                    <div class="footer__about">
                        <div class="footer__about__logo">
                            <a href="./admin.html"><img src="img/logo.png" alt=""></a>
                        </div>
                        <ul>
                            <li>Address: 60-49 Road 11378 New York</li>
                            <li>Phone: +65 11.188.888</li>
                            <li>Email: hello@colorlib.com</li>
                        </ul>
                    </div>
                </div>
                <div class="col-lg-4 col-md-6 col-sm-6 offset-lg-1">
                    <div class="footer__widget">
                        <h6>Useful Links</h6>
                        <ul>
                            <li><a href="#">About Us</a></li>
                            <li><a href="#">About Our Shop</a></li>
                            <li><a href="#">Secure Shopping</a></li>
                            <li><a href="#">Delivery infomation</a></li>
                            <li><a href="#">Privacy Policy</a></li>
                            <li><a href="#">Our Sitemap</a></li>
                        </ul>
                        <ul>
                            <li><a href="#">Who We Are</a></li>
                            <li><a href="#">Our Services</a></li>
                            <li><a href="#">Projects</a></li>
                            <li><a href="#">Contact</a></li>
                            <li><a href="#">Innovation</a></li>
                            <li><a href="#">Testimonials</a></li>
                        </ul>
                    </div>
                </div>
                <div class="col-lg-4 col-md-12">
                    <div class="footer__widget">
                        <h6>Join Our Newsletter Now</h6>
                        <p>Get E-mail updates about our latest shop and special offers.</p>
                        <form action="#">
                            <input type="text" placeholder="Enter your mail">
                            <button type="submit" class="site-btn">Subscribe</button>
                        </form>
                        <div class="footer__widget__social">
                            <a href="#"><i class="fa fa-facebook"></i></a>
                            <a href="#"><i class="fa fa-instagram"></i></a>
                            <a href="#"><i class="fa fa-twitter"></i></a>
                            <a href="#"><i class="fa fa-pinterest"></i></a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <div class="footer__copyright">
                        <div class="footer__copyright__text"><p><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
  Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="fa fa-heart" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
  <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. --></p></div>
                        <div class="footer__copyright__payment"><img src="img/payment-item.png" alt=""></div>
                    </div>
                </div>
            </div>
        </div>
    </footer>
    <!-- Footer Section End -->

    <!-- Js Plugins -->
    <script src="../../js/jquery-3.3.1.min.js"></script>
    <script src="../../js/bootstrap.min.js"></script>
    <script src="../../js/jquery.nice-select.min.js"></script>
    <script src="../../js/jquery-ui.min.js"></script>
    <script src="../../js/jquery.slicknav.js"></script>
    <script src="../../js/mixitup.min.js"></script>
    <script src="../../js/owl.carousel.min.js"></script>
    <script src="../../js/main.js"></script>



</body>

</html>