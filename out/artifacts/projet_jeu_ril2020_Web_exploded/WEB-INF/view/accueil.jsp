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
    <h2>Bienvenue ${loginBean.FORM_FIELD_LOGIN} !!!</h2>
        <a  href="connexion.html"> <input id="deco" type="deco" value="Déconnexion"></a>
    <div class="container-fluid">
        <jsp:useBean id="jeuBean" class="mental.model.JeuBean" scope="request"></jsp:useBean>
        <div class="row">

            <div class="offset-2 col-md-4">
                <h3> TOP 10 </h3>
                <ol>
                    <c:forEach var="unScore" items="${jeuBean.gameBestScore}">
                    <li>${unScore.utilisateurId} / ${unScore.score}</li>
                    </c:forEach>
                </ol>
            </div>

            <div class="col-md-3">
                <form method="POST" action="jeu" id="accueil">
                    <input type="text" name="difficulte" placeholder="la difficulté que vous voulez? Entre 1 et 3"/>
                    <input type="hidden" name="uneGame" value=""/>
                    <input type="hidden" name="from" value="accueil"/>
                    <input type="submit" class="jeux"  value="JEU">
                </form>
            </div>

        </div>
    </div>
    <!-- Footer -->
    <footer class="page-footer font-small pt-4" id="footer-entire">

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