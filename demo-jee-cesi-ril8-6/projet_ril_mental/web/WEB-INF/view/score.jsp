<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Calculator</title>


    <!--BOOSTRAP-->
    <link rel="stylesheet" type="text/css" href="vendors/bootstrap4.3.1.min.css" />
    <!-- CSS-->
    <link rel="stylesheet" href="css.css" media="screen" type="text/css" />
</head>
<body id="Paccueil">

<h1>Calculator</h1>
<img src="images/logo.png" id="logo" alt="logo">
<h2>Bienvenue (Nom utilisateur) !!!</h2>
<a  href="connexion.html"> <input id="deco" type="deco" value="Déconnexion"></a>
<jsp:useBean id="jeuBean" class="mental.model.JeuBean" scope="request"></jsp:useBean>
<h2> Score ${jeuBean.score} Bravo !!! </h2>
<div class="container-fluid">
    <div class="row">
        <div class="offset-2 col-md-3">
            <h3> TOP score (Nom utilisateur) !!! </h3>
            <ol>
                <li>10</li>
                <li>10</li>
                <li>9</li>
                <li>9</li>
                <li>8</li>
                <li>8</li>
                <li>7</li>
                <li>7</li>
                <li>7</li>
                <li>6</li>

            </ol>
        </div>





                <div class="col-md-3">
                    <a href="jeux.html"><input type="bouton"  id="jeux"   value="JOUER"></a>
            </div>

                <div class="col-md-3">
                    <a href="accueil.html"><input type="bouton" id="Baccueil"  value="Accueil"></a>
            </div>
            </div>


</div>
<!-- Footer -->
< <footer class="page-footer font-small pt-4" id="footer-entire">

    <div class="container-fluid text-center text-md-center">
        <div class="row">

            <div class="col-md mt-md-0 mt-6">
                <a href="">
                    <img src="images/logoms.png" id="cesi-logo" alt="Cesi"/>
                </a>
            </div>

            <div class="col-md mb-md-0 mb-6">
                <ul class="text-cesi list-unstyled">
                    <li class="addresse">Marina Séga and CO</li>
                    <li class="addresse">1 Avenue Augustin-Louis Cauchy</li>
                    <li class="addresse">44307 Nantes</li>
                </ul>
                <ul class="items-social-links list-unstyled">
                    <li><a href=""><img src="images/fb.png" alt="fb"/></a></li>
                    <li><a href=""><img src="images/in.png" alt="in"/></a></li>
                    <li><a href=""><img src="images/twitter.png" alt="twitter"/></a></li>
                    <li><a href=""><img src="images/yt.png" alt="youtube"/></a></li>
                </ul>
            </div>
        </div>
    </div>

    <!-- Copyright -->
    <div class="footer-copyright text-center py-3">
        <p>All rights reserved by Calculator. Copyright © 2020</p>
    </div>
</footer>
</body>


</html>