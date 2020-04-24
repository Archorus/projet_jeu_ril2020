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
<body id="Pconnexion">
<jsp:useBean id="contactBean" class="mental.model.JeuBean" scope="request"></jsp:useBean>
        <h1>Calculator</h1>
            <img src="images/logo.png" id="logo" alt="logo">
        <h2>${session.CURRENT_USER_SESSION_KEY}!!!</h2>
            <a  href="connexion.html"> <input id="deco" type="deco" value="Déconnexion" label="deco"></a>
    <div class="container">
    <!-- zone de connexion -->

    <form method="POST" action="jeu" id="connexion">
        <h2>Calculer</h2>

        <label><strong name="Expression">${jeuBean.uneExpression.getFullData()}</strong></label>
        <input type="text" placeholder="Entrer votre réponse"  name="providedValue" required label="réponse">


        <input type="hidden" name="difficulte" value="${jeuBean.difficulte}"/>
        <input type="hidden" name="uneGame" value="${jeuBean.uneGame}"/>
        <input type="hidden" name="from" value="jeux"/>
        <input type="hidden" name="score" value="${jeuBean.score}"/>
        <input type="submit" id='submit' value='Valider' >


    </form>
        <a id="Pnavigation" href="#" onclick = "">Précédent</a>
    <!-- reviens a la page d'avant -->
        <a id="Snavigation"  href="#" onclick = "">Suivant</a>
    <!-- reviens a la page d'Après -->
</div>
        <!-- Footer -->
        <footer class="page-footer font-small pt-4" id="footer-entire">

            <div class="container-fluid text-center text-md-center">
                <div class="row">

                    <div class="col-md mt-md-0 mt-3">
                        <a href="">
                            <img src="images/logoms.png" id="cesi-logo" alt="MSC"/>
                        </a>
                    </div>

                    <div class="col-md mb-md-0 mb-3">
                        <ul class="text-cesi list-unstyled">
                            <li class="addresse">Marina Séga and Co</li>
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

                    <div class="col-md mb-md-0 mb-3">

                        <img src="images/logo.png" id="Flogo" alt="Logo"/>

                    </div>
                </div>
            </div>

            <!-- Copyright -->
            <div class="footer-copyright text-center py-3">
                <p>All rights reserved by Calculator. Copyright © 2020</p>
            </div>
        </footer>
</body>
<!-- SCRIPTS -->
<script type="text/javascript" src="js.js"></script>
</html>