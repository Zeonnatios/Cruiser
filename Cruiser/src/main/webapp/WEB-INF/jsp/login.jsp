<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>TADES - LOGIN</title>

        <!-- Icon Logo-->
        <link rel="icon" href="imagens/LOGO_CRUISER.png">

        <!-- Bootstrap -->
        <link rel="stylesheet" href="libs/bootstrap/css/bootstrap.min.css">
        <!-- Font Awesome-->
        <link rel="stylesheet" href="libs/fontawesome-free-5.13.0-web/css/all.min.css">
        <!-- CSS -->
        <link rel="stylesheet" href="css/all.css">

    </head>

    <body class="bg-login">

        <section>


            <div class="container">

                <div class="row">
                    <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">

                        <div class="card card-signin my-5">

                            <div class="logo-img">
                                <img src="imagens/LOGO_CRUISER.png" alt="TADES_logo" width="190" height="170">
                            </div>


                            <div class="card-body" id="form-login">

                                <form class="form-signin" action="LoginServlet">

                                    <div class="form-label-group">

                                        <label for="inputEmail">Email:</label>
                                        <input type="email" id="inputEmail" name="inputEmail" class="form-control" placeholder="Email" required autofocus>

                                    </div>

                                    <div class="form-label-group">

                                        <label for="inputPassword">Senha:</label>
                                        <input type="password" id="inputPassword" name="inputPassword" class="form-control input_pass" placeholder="Senha" required>

                                    </div>
                                    <hr>
                                    <button class="btn btn-lg btn-outline-light btn-block" type="submit">Acessar</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </section>

        <footer class="text-center">
            <div class="container">
                <p class="text-white">DIREITOS RESERVADOS CRUISER 2020</p>
            </div>
        </footer>

    </body>

    <script src="libs/jquery/jquery.min.js"></script>
    <script src="libs/bootstrap/js/bootstrap.bundle.min.js"></script>

</html>